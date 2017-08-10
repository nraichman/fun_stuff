public abstract class Heap<T extends Comparable>{

  protected T[] array;
  protected heapLength;

  public Heap(int size){
    aray = (T[]) new Object[size];
    heapLength = 0;
  }

  public void add(T element){
    if(!isFull()&&!exists(element)){
      array[heapLength] = element;
      perculateUp(heapLength);
      heapLength++;
    }
  }

  public boolean isEmpty(){
    return heapLength == 1;
  }

  public boolean isFull(){
    return heapLength == array.length;
  }

  protected void resize(int newSize){
    if(newSize < heapLength){
      throw new Exception("Can't shrink the heap to a size smaller than it's current state!");
    }
    T[] tmp = table.clone();
    table = new (T[]) Object[newSize];
    for(int i = 0; i < tmp.length; i++){
      table[i] = tmp[i];
    }
  }

  public abstract boolean exists(T element);

  protected abstract int compare(T element, T other);

  public T deleteMin(){
    if(!isEmpty()){
      T min = array[1];
      array[1] = array[heapLength];
      heapLength--;
      perculateDown(1);
      return min;
    }
    return null;
  }

  protected void perculateUp(int index){
    if(index > 1 && compare(array[index], array[parent(index)]) < 0){
      swap(index, parent(index));
      perculateUp(parent(index));
    }
  }

  protected void perculateDown(int index){
    int smallestChild = smallestChild(index);
    if(smallestChild > 0 && compare(array[index], array[smallestChild]) > 0){
      swap(index, smallestChild);
      perculateDown(smallestChild);
    }
  }

  protected void swap(int index1, int index2){
    T tmp = array[index1];
    array[index1] = array[index2];
    array[index2] = tmp;
  }

  protected int parent(int index){
    return index/2;
  }

  protected int leftChild(int index){
    return index*2;
  }

  protected int rightChild(int index){
    return index*2+1;
  }

  protected int smallestChild(int index){
    if(leftChild(index) > heapLength){
      return -1;
    }
    else if(rightChild(index) > heapLength){
      return leftChild(index);
    }
    else if(compare(array[rightChild(index)],array[leftChild(index)]) < 0){
      return rightChild(index);
    }
    else{
      return leftChild(index);
    }
  }

}
