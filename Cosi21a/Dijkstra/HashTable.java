public class HashTable<K extends Hashable,V>{

  private class ListNode{
    K key;
    V value;
    ListNode next;

    public ListNode(K key, V value){
      this.key = key;
      this.value = value;
      next = null;
    }

    public void append(ListNode newNode){
      ListNode curr = this;
      while(next != null){
        curr = next;
      }
      next = newNode;
    }
  }

  private ListNode[] table;
  private int totItems;
  private double loadFactor;

  public HashTable(){
    table = (ListNode[]) new Object[2029];
    totItems = 0;
    loadFactor = 0;
  }

  public void add(K key, V value){
    int numProbes = 0;
    int index = hash(key);
    if(table[index] == null){
      table[index] = new ListNode(key, value);
    }else{
      table[index].append(new ListNode(key,value));
    }
    totItems++;
    loadFactor = (double)totItems/(double)table.length;
    if(loadFactor > 0.5){
      rehash();
    }
  }

  public int hash(K key){
    double numKey = key.getNumRepresentation();
    return numKey%table.length;
  }


  public V remove(K key){

  }

  public V get(K key){
    int index = hash(key);
    ListNode curr = table[index];
    while(curr != null && curr.key)
  }



}
