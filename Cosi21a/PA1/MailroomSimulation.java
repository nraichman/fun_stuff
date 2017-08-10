import java.util.*;
import java.io.*;
public class MailroomSimulation {
	public static void main(String[] args) throws Exception {
		Queue<Integer> waitLine = new Queue<>(10);
		System.out.print("Usdan Mailroom Simulation: \n	Please specify the input file: ");
		File f = fileHandle();
		Scanner read = new Scanner(f);
		int averageTime = avarageTimeWait(waitLine, read);
		System.out.println("Here are the results of the simulation:");
		System.out.println("    Average waiting time: " + averageTime);
	}
	public static int avarageTimeWait(Queue<Integer> waitLine, Scanner read) throws Exception{
		int totalTimeWaited = 0;
		int totalTimeElapsed = 0;
		int studentsServed = 0;
		int studentArrivalTime = 0;
		studentArrivalTime  = enqueueStudents(waitLine, read, totalTimeElapsed, read.nextInt());
			//System.out.println("*Inside averageTimewait* Does read has another Int? " + read.hasNextInt());

			while(!waitLine.isEmpty()){
				studentArrivalTime = enqueueStudents(waitLine, read, totalTimeElapsed, studentArrivalTime);
				int studentBuffer = waitLine.dequeue();
				System.out.println("State of the line at time " + totalTimeElapsed + " is:");
				System.out.println(waitLine.toString());
				System.out.println("Student with arrival time " + studentBuffer + " has been served.");
				studentsServed++;
				totalTimeWaited = totalTimeElapsed-studentBuffer + totalTimeWaited;
				totalTimeElapsed = totalTimeElapsed + 5;
				System.out.println("Number of students served: " + studentsServed);
				System.out.println("Time this student waited: " + (totalTimeElapsed - studentBuffer));
			}

		return totalTimeWaited/studentsServed;

	}
	public static int enqueueStudents(Queue<Integer> waitLine, Scanner read, int totalTimeElapsed, int studentArrivalTime) throws Exception{
			//System.out.println("*inside enqueueStudents* Does read has another read? " + read.hasNextInt());
		if(read.hasNextInt()){
			while (read.hasNextInt()&&studentArrivalTime <= totalTimeElapsed){
				if(studentArrivalTime == totalTimeElapsed && !waitLine.isFull()){
					waitLine.enqueue(studentArrivalTime);
					System.out.println("Student with arrival time " + studentArrivalTime + " was enqued");
				}
				studentArrivalTime = read.nextInt();
			}
		}
		return studentArrivalTime;
	}


	public static File fileHandle(){
		Scanner console = new Scanner(System.in);
		File f = new File(console.nextLine());
		while(!f.exists()){
			System.out.println("File not found. Try again: ");
			f = new File(console.nextLine());
		}
		return f;
	}
}
