public class MinPriorityQueue<T extends Comparable, E extends Hashable> extends Heap<E>{

  HashTable<E> hashTable;

  public MinPriorityQueue(int size){
    super(size);
    hashTable = new HashTable<>();
  }

  public boolean exists(T element){
    return hashTable.exists(element);
  }

  private int compare(T element, T other){
    return hashTable.get(element).compareTo(hashTable.get(element));
  }

  public void enqueue(E element){
    hashTable.add(element);
    super.add(element.getKey());
    if(super.array.length < hashTable.tableSize()){
      super.resize(hashTable.tableSize());
    }
  }

  public E dequeue(){
    if(!super.isEmpty()){
      E key = super.deleteMin();
    }
  }
}
