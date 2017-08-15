import java.util.*;
public class ClientCode {
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		System.out.print("Please enter the size of your array: ");
		Integer[] array = new Integer[console.nextInt()];
		//Integer[] array = {8,1,3,11,7,5,4};
		for(int i = 0; i < array.length; i ++){
			System.out.print("Please enter the " + (i+1) + " number of your array: ");
			array[i] = console.nextInt();
		}
		
		System.out.println("Your original array was: " + Arrays.deepToString(array));
		System.out.println("Array is being sorted...");
		array = Sorts.<Integer>bubbleSort(array);
		System.out.println();
		System.out.print("Your sorted array is: " + Arrays.deepToString(array));
	}
}
