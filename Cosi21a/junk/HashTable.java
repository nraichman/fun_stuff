public class HashTable<T extends Hashable, K>{

  private LinkedList<T>[] table;
  private int totItems;
  private double loadFactor;

  public HashTable(){
    table = (LinkedList<T>[]) new Object[2029];
    totItems = 0;
    loadFactor = (double)totItems/(double)table.length;
  }

  public void add(T element){
    int index = hashFunction1(element.getKey());
    LinkedList<T> indexedList = table[index];
    if(!indexedList.exists(element)){
      indexedList.add(element);
      totItems++;
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

  public T remove(K key){
    int index = hashFunction1(key);
    LinkedList<T> indexedList = table[index];
    if(!indexedList.exists(key)){
      indexedList.remove(key);
      totItems--;
    }
  }

  public int hashFunction1(K key)throws IllegalArgumentException{
    if(!(key instanceof int)){
      throw new IllegalArgumentException();
    }
    double tmpA = key*((Math.sqrt(5.0)-1.0)/2.0);
    int tmpB = (int) tmpA;
    tmpA -= tmpB;
    int numOfDigits =numOfDigits(table.length);
    tmpA = tmpA*(Math.pow(10, numOfDigits));
    tmpB = (int)tmpA;
    return tmpB%table.length;
  }

  private int numOfDigits(int number){
    int numOfDigits = 0;
    while(numOfDigits != 0){
      number /= 10;
      numOfDigits++;
    }
    return numOfDigits;
  }

  public void rehash(){
    LinkedList<T>[] tmpTable = table.clone();
    table = (LinkedList<T>[]) new Object[table.length*2+1];
    totItems = 0;
    for(int i = 0; i < tmpTable.length; i++){
      ListNode<T> curr = tmpTable[i].getHead();
      for(int j = 0; j < tmpTable[i].size(); j++){
        add(curr.getData());
        curr = curr.getNext();
      }
    }
  }

  public boolean isEmpty(){
    return totItems == 0;
  }

  public boolean isFull(){
    return totItems == table.length;
  }

  public boolean exists(T element){
    int index = hashFunction1(element.getKey());
    LinkedList<T> indexedList = table[index];
    return indexedList.exists(element);
  }

  public T get(K key){
    int index = hashFunction1(key);
    LinkedList<T> indexedList = table[index];
    return indexedList.get(key);
  }

}
