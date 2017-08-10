public class TestCode{
  public static void main(String[] args)throws Exception{
    BinarySearchTree<Integer> root = new BinarySearchTree<>(50);
    root = root.insert(30);
    root = root.insert(70);
    root = root.insert(20);
    root = root.insert(40);
    root = root.insert(60);
    root = root.insert(80);
    BinarySearchTree<Integer> curr = root.findNode(30);
    root = root.delete(30);
    root = root.delete(50);
    //System.out.println(curr.findSuccessor().getElement().toString());
    System.out.println(root.inOrder());
  }
}
