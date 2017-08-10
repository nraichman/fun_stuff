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
    }
    size++;
  }

  public T remove(T element)throws Exception{
    return remove(element.getKey());
  }

  public T remove(K key)throws Exception{
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

  public boolean exists(T element)throws Exception{
    return find(element.getKey()) != null;
  }

  private ListNode<T> find(K key)throws Exception{
    if(!isEmpty()){
      ListNode<T> curr = head;
      while(curr != null && curr.getData().getKey().compareTo(key)){
        curr = curr.getNext();
      }
      return curr;
    }else{
      throw new Exception("List is empty!");
    }
  }

  public T get(K key)throws Exception{//returns the element matching the key if exists. If not returns null
    if(!isEmpty()){
      ListNode<T> curr = head;
      while(curr != null && curr.getData().getKey() != key){
        curr = curr.getNext();
      }
      return curr.getData();
    }else{
      throw new Exception("List is empty!");
    }
  }

  public boolean isEmpty(){
    return head == null;
  }
}
