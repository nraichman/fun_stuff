public class ListNode<T>{

  private T data;
  private ListNode next;
  private ListNode prev;

  public ListNode(T element){
    data = element;
    next = null;
    prev = null;
  }

  public T getData(){
    return data;
  }

  public ListNode<T> getNext(){
    return next;
  }

  public ListNode<T> getPrev(){
    return prev;
  }

  public void setNext(ListNode<T> next){
    this.next = next;
  }

  public void setPrev(ListNode<T> prev){
    this.prev = prev;
  }
}
