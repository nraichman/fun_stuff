public class LinkedList<T extends Hashable, K extends Comparable>{

  private ListNode<T> head;
  private ListNode<T> tail;
  private int size;

  public LinkedList(){
    head = null;
    tail = null;
    size =0;
  }

  public LinkedList(T element){
    head = new ListNode<T>(element);
  }

  public ListNode<T> getHead(){
    return head;
  }

  public void add(T element){
    if(!isEmpty()){
      ListNode<T> curr = head;
      while(curr.getNext() != null){
        curr = curr.getNext();
      }
      curr.setNext(new ListNode<T>(element));
      tail = curr.getNext();
      tail.setPrev(curr);
    }else{
      head = new ListNode<T>(element);
      tail = head;
    }
    size++;
  }

  public T remove(T element){
    return remove((K)element.getKey());
  }

  public T remove(K key){
      ListNode<T> curr = find(key);
      if(curr == head){
        head = null;
      }else{
        ListNode<T> tmp = curr.getNext();
        curr.setNext(tmp.getNext());
        tmp.getNext().setPrev(curr);
      }
      size--;
      return curr.getData();
  }

  public int size(){
    return size;
  }

  public boolean exists(K key){
    return find(key) != null;
  }

  private ListNode<T> find(K key){
    if(!isEmpty()){
      ListNode<T> curr = head;
      while(curr != null && curr.getData().getKey().compareTo(key) != 0){
        curr = curr.getNext();
      }
      return curr;
    }else{
      return null;
    }
  }

  public T get(K key){//returns the element matching the key if exists. If not returns null
    if(!isEmpty()){
      ListNode<T> curr = head;
      while(curr != null && curr.getData().getKey().compareTo(key) != 0){
        curr = curr.getNext();
      }
      return curr.getData();
    }else{
      return null;
    }
  }

  public boolean isEmpty(){
    return head == null;
  }
}
