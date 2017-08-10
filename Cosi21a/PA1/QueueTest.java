public class QueueTest{
  public static void main(String[] args)throws Exception{
    Queue<Integer> que = new Queue<>(10);
    System.out.println("The size of the que is: " + que.size());
    while(!que.isFull()){
      que.enqueue(1);
      System.out.println("The size of the que is: " + que.size());
    }
    System.out.println("Dequeing...");
    System.out.println("The size of the que is: " + que.size());
    while(!que.isEmpty()){
      que.dequeue();
      System.out.println("The size of the que is: " + que.size());
    }
    System.out.println("done!");
  }
}
