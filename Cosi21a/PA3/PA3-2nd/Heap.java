public abstract class Heap<K>{

  protected K[] array;
  protected int heapLength;

  public Heap(int size){
    array = (K[]) new Object[size];
    heapLength = 0;
  }

  public void add(K element) throws Exception{
    if(!isFull()&&!exists(element)){
      array[heapLength] = element;
      perculateUp(heapLength);
      heapLength++;
    }
  }

  public int totSize(){
    return array.length;
  }

  public boolean isEmpty(){
    return heapLength == 1;
  }

  public boolean isFull(){
    return heapLength == array.length;
  }

  protected void resize(int newSize) throws Exception{
    if(newSize < heapLength){
      throw new Exception("Can't shrink the heap to a size smaller than it's current state!");
    }
    K[] tmp = array.clone();
    array = (K[]) new Object[newSize];
    for(int i = 0; i < tmp.length; i++){
      array[i] = tmp[i];
    }
  }

  public abstract boolean exists(K element) throws Exception;

  protected abstract int compare(K element, K other) throws Exception;

  public K deleteMin() throws Exception{
    if(!isEmpty()){
      K min = array[1];
      array[1] = array[heapLength];
      heapLength--;
      perculateDown(1);
      return min;
    }
    return null;
  }

  protected void perculateUp(int index) throws Exception{
    if(index > 1 && compare(array[index], array[parent(index)]) < 0){
      swap(index, parent(index));
      perculateUp(parent(index));
    }
  }

  protected void perculateDown(int index) throws Exception{
    int smallestChild = smallestChild(index);
    if(smallestChild > 0 && compare(array[index], array[smallestChild]) > 0){
      swap(index, smallestChild);
      perculateDown(smallestChild);
    }
  }

  protected void swap(int index1, int index2){
    K tmp = array[index1];
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

  protected int smallestChild(int index) throws Exception{
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
