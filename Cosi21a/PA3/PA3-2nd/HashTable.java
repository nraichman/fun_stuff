import java.lang.reflect.Array;
public class HashTable<E extends Hashable, K extends Comparable>{

  private LinkedList<E, K>[] table;
  private int totItems;
  private double loadFactor;


  public HashTable(){
    table = (LinkedList<E,K>[]) new LinkedList<?,?>[2029];
    totItems = 0;
    loadFactor = (double)totItems/(double)table.length;
  }

  public void add(E element) throws Exception{
    int index = hashFunction1((K)element.getKey());
    if(table[index] == null){
      table[index] = new LinkedList<E,K>(element);
      System.out.println("Process " + element.getKey() + " was added at index " + index);
      totItems++;
    }
    else if(!table[index].exists((K)element.getKey())){
      table[index].add(element);
      totItems++;
      System.out.println("Process " + element.getKey() + " was added at index " + index);
    }
    loadFactor = (double)totItems/(double)table.length;
    if(loadFactor > 4){
      rehash();
    }
  }

  public int tableSize(){
    return table.length;
  }

  public int totItems(){
    return totItems;
  }

  public E remove(K key) throws Exception{
    int index = hashFunction1(key);
    LinkedList<E,K> indexedList = table[index];
    E temp = null;
    if(!indexedList.exists(key)){
      temp = indexedList.remove(key);
      totItems--;
    }
    return temp;
  }

  public int hashFunction1(K key)throws IllegalArgumentException{
    if(!(key instanceof Integer)){
      throw new IllegalArgumentException();
    }
    return (Integer) key%table.length;
    /*
    Integer k = (Integer) key;
    double tmpA = k*((Math.sqrt(5.0)-1.0)/2.0);
    int tmpB = (int) tmpA;
    tmpA -= tmpB;
    int numOfDigits =numOfDigits(table.length);
    tmpA = tmpA*(Math.pow(10, numOfDigits));
    tmpB = (int)tmpA;
    return tmpB%table.length;
    */
  }

  private int numOfDigits(int number){
    int numOfDigits = 0;
    while(numOfDigits != 0){
      number /= 10;
      numOfDigits++;
    }
    return numOfDigits;
  }

  public void rehash() throws Exception{
    System.out.println("Rehashed!");
    LinkedList<E,K>[] tmpTable = table.clone();
    table = (LinkedList<E,K>[]) new LinkedList<?,?>[table.length*2+1];
    totItems = 0;
    for(int i = 0; i < tmpTable.length; i++){
      if(tmpTable[i] != null){
        ListNode<E> curr = tmpTable[i].getHead();
        for(int j = 0; j < tmpTable[i].size(); j++){
          add(curr.getData());
          curr = curr.getNext();
        }
      }
    }
  }

  public boolean isEmpty(){
    return totItems == 0;
  }

  public boolean isFull(){
    return totItems == table.length;
  }

  public boolean exists(K key) throws Exception{
    int index = hashFunction1(key);
    LinkedList<E,K> indexedList = table[index];
    if(indexedList == null){
      return false;
    }
    return indexedList.exists(key);
  }

  public E get(K key) throws Exception{
    int index = hashFunction1(key);
    LinkedList<E,K> indexedList = table[index];
    System.out.println("looking for " + key + " at index " + index);
    return indexedList.get(key);
  }

}
