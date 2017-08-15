
public class Sorts{
	
	public static <T extends Comparable> T[] bubbleSort(T[] array){
		for(int i = 0; i < array.length-1; i++){
			if(array[i].compareTo(array[i+1]) > 0){
				T tmp = array[i];
				array[i] = array[i+1];
				array[i+1] = tmp;
				return bubbleSort(array);
			}
		}
		return array;
	}

}
