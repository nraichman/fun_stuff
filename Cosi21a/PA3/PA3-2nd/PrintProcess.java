import java.io.*;
import java.util.*;
public class PrintProcess {
	public static void main(String[] args) throws Exception{
		File fileHandle = fileHandler();
		Scanner read = new Scanner(fileHandle);
		MinPriorityQueue<Process,Integer> processQueue = loadQueue(read);
		print(processQueue);
	}

	public static File fileHandler(){
		Scanner console = new Scanner(System.in);
		System.out.print("Please sepcify the name of the file: ");
		File fileHandle = new File(console.nextLine());
		while(!fileHandle.exists()){
			System.out.println("File Not Found!");
			System.out.print("Please enter a new file name: ");
			fileHandle = new File(console.nextLine());
		}
		return fileHandle;
	}

	public static MinPriorityQueue<Process, Integer> loadQueue(Scanner read) throws Exception{
		MinPriorityQueue<Process, Integer> processQueue = new MinPriorityQueue<>(2029);
		while(read.hasNextLine()){
			Scanner line = new Scanner(read.nextLine());
			int id = line.nextInt();
			int priority = line.nextInt();
			String name = line.next();
			Process p = new Process(id, priority, name);
			processQueue.enqueue(p);
		}
		return processQueue;
	}

	public static void print(MinPriorityQueue<Process,Integer> processQueue) throws Exception{
		while(!processQueue.isEmpty()){
			Process p = processQueue.dequeue();
			System.out.println("Process Name: " + p.getName() + " Priority: " + p.getPriority());
		}
	}

}
