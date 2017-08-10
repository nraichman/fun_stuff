public class MinPriorityQueue<E extends Hashable, K extends Comparable> extends Heap<K>{

  HashTable<E,K> hashTable;
  public MinPriorityQueue(int size){
    super(size);
    hashTable = new HashTable<E,K>();
  }

  public boolean exists(K key) throws Exception{
    return hashTable.exists(key);
  }

  protected int compare(K key, K other) throws Exception{
    return hashTable.get(key).compareTo(hashTable.get(other));
  }

  public void enqueue(E element) throws Exception{
    hashTable.add(element);
    add((K)element.getKey());
    if(super.totSize() < hashTable.tableSize()){
      super.resize(hashTable.tableSize());
    }
  }

  public E dequeue() throws Exception{
    if(!super.isEmpty()){
      K key = super.deleteMin();
      return hashTable.remove(key);
    }
    return null;
  }
}
