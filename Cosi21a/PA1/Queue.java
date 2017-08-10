
public class Queue<T> {
	private int front;
	private int rear;
	private T[] arr;
	private boolean full;
	@SuppressWarnings("unchecked")
	public Queue(int length){
		front = 0;
		rear = 0;
		arr = (T[])new Object[length];
		full = false;
	}
	public void enqueue(T element) throws Exception{
		if(!full){
			arr[rear] = element;
			rear = (rear+1)%arr.length;
		}
		else{
			throw new Exception("The queue is full!");
		}
		if(size() >= arr.length){
			full = true;
		}

	}
	public T dequeue(){
		T tmp = arr[front];
		front = (front+1)%arr.length;
		if(full){
			full = false;
		}
		return tmp;
	}
	public boolean isEmpty(){
		//return front == rear && !full;
		return size() == 0;
	}
	public boolean isFull(){
		return full;
	}
	public int size(){
		if(rear>=front){
			return rear - front;
		}
		else{
			return arr.length - (front) + rear;

		}
	}
	public T front(){
		if (isEmpty() == true){
			throw new NullPointerException("Queue Empty");
		}
		else{
			return arr[front];
		}
	}
	public T rear(){
		if(isEmpty() == true){
			throw new NullPointerException("Queue Empty");
		}
		else{
			return arr[rear-1%arr.length];
		}
	}

	public String toString(){
		String s = "[";
		int curr = front;
		while(curr != rear){
			s = s + arr[curr] + ", ";
			curr = (curr+1)%arr.length;
		}
		s = s + arr[curr] + ", ";
		s = s + "]";
		return s;
	}

}
