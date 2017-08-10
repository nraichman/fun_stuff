import java.io.*;
import java.util.*;
public class MailroomSimulation2{
  public static void main(String[] args)throws FileNotFoundException, Exception{
    File f = new File("MailroomTest.txt");
    Scanner fileInput = new Scanner(f);
    Queue<Integer> line = new Queue<>(10);

    int totalTimeElapsed = 0;
    int studentsServed = 0;
    int totalTimeWaited = 0;

    int studentBuffer = enqueueStudents(line, fileInput, fileInput.nextInt(), totalTimeElapsed);

    while(!line.isEmpty()){
      if(fileInput.hasNextInt()){
        studentBuffer = enqueueStudents(line, fileInput, studentBuffer, totalTimeElapsed);
      }
      else{
        System.out.println("File is empty!");
      }
      System.out.println("The state of the queue at time " + totalTimeElapsed + " is:");
      System.out.println(line.toString());
      totalTimeWaited = serveStudents(line, totalTimeWaited, totalTimeElapsed, studentsServed);
      totalTimeElapsed = totalTimeElapsed + 5;
      studentsServed++;
      System.out.println("The state of the queue at time " + totalTimeElapsed + " is:");
      System.out.println(line.toString());
    }
    int averageTime = calculateTime(totalTimeWaited, studentsServed);
    System.out.println("The results of the analysis show that the average wait time is: " + averageTime);
  }
  public static int enqueueStudents(Queue<Integer> line, Scanner fileInput, int studentBuffer, int totalTimeElapsed)throws Exception{
      while(fileInput.hasNextInt()&&studentBuffer <= totalTimeElapsed){
        if(studentBuffer == totalTimeElapsed&&!line.isFull()){
          line.enqueue(studentBuffer);
          System.out.println("Student with an arrival time of " + studentBuffer + " was enqued.");
        }else{
          System.out.println("Line is full! Student with arrival time of " + studentBuffer + " was skipped");
        }
        studentBuffer = fileInput.nextInt();
      }
    return studentBuffer;

  }
  public static int serveStudents(Queue<Integer> line, int totalTimeWaited, int totalTimeElapsed, int studentsServed){
    if(!line.isEmpty()){
      int studentArrivalTime = line.dequeue();
      System.out.println("Student numbe " + (studentsServed+1) + " was served.");
      return totalTimeElapsed - studentArrivalTime + totalTimeWaited;
    }
    else{
      return totalTimeWaited;
    }
  }
  public static int calculateTime(int totalTimeWaited, int studentsServed){
    return totalTimeWaited/studentsServed;
  }
}
