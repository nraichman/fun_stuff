import java.io.*;
import java.util.*;
public class EntryCount{
  public static void main(String[] args) throws FileNotFoundException{
    File f = new File("MailroomTest.txt");
    Scanner fileInput = new Scanner(f);
    int num = 0;
    while(fileInput.hasNextInt()){
      System.out.println(fileInput.nextInt());
      num++;
    }
    System.out.println("There are " + num + " entries in file " + f.getName());
  }
}
