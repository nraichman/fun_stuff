
public class BinarySearchTree<E extends Comparable<E>> {
	private BinarySearchTree<E> parent;
	private BinarySearchTree<E> left;
	private BinarySearchTree<E> right;
	private E data;
	
	public BinarySearchTree(E data){
		parent = null;
		left = null;
		right = null;
		this.data = data;
	}
	/**
	 * 
	 * @param 
	 * @return
	 */ 
	public BinarySearchTree<E> getRoot(){
		BinarySearchTree<E> root = this;
		while(root.parent != null){
			root = root.parent;
		}
		return root;
	}
	public boolean hasLeft() {
		if(this.left == null){
			return false;
		}
		return true;
	}
	/**
	 * 
	 * @return
	 */
	public boolean hasRight() {
		if(this.right == null){
			return false;
		}
		return true;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isLeaf() {
		if(hasLeft()||hasRight()){
			return false;
		}
		return true;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		BinarySearchTree<E> root = 
		if(this == null){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isRoot() {
		if(root.getParent() == null){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isLeftChild() {
		if(this.parent.left == this){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isRightChild() {
		if(this.parent.right == this){
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return
	 */
	public boolean hasParent() {
		if(this.parent == null){
			return false;
		}
		return true;
	}
	/**
	 * 
	 * @param e
	 * @return
	 */
	public BinarySearchTree<E> findNode(E e) {
		search(e);
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public BinarySearchTree<E> findMin() {
		BinarySearchTree<E> curr = getRoot();
		return findMin(curr);
	}
		
	private BinarySearchTree<E>	findMin(BinarySearchTree<E> curr){
		while(curr.left != null){
			curr = curr.left;
		}
		return curr;
	}
	public BinarySearchTree<E> findMax(BinarySearchTree<E> curr){
		while(curr.right != null){
			curr = curr.right;
		}
		return curr;
	}
	/**
	 * 
	 * @return
	 */
	public BinarySearchTree<E> findSuccessor() {
		BinarySearchTree<E> curr = getRoot();
		if(curr.right != null){
			return findMin(curr.right);
		}
		else{
			BinarySearchTree<E> tmp = curr.parent;
			while(tmp!=null && curr==tmp.right){
				curr = tmp;
				tmp = tmp.parent;
			}
			return tmp;
		}
	}
	/**
	 * 
	 * @param e
	 * @return
	 */
	public BinarySearchTree<E> addRoot(E e) {
		return this;
	}
	/**
	 * 
	 * @param e
	 * @return
	 */
	public BinarySearchTree<E> insert(E e) {
		return this;
	}
	/**
	 * 
	 * @param e
	 * @return
	 */
	public BinarySearchTree<E> search(E e) {
		BinarySearchTree<E> curr = getRoot();
		return search(e, curr);
	}
	
	public BinarySearchTree<E> search(E e, BinarySearchTree<E> curr){
		if(curr == null || e == curr.data){
			return curr;
		}
		if(curr.data.compareTo(e) < 0){
			return search(e, curr.left);
		}
		else{
			return search(e, curr.right);
		}
	}
	/**
	 * 
	 * @param e
	 * @return
	 */
	public BinarySearchTree<E> delete(E e) {
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public int size() {
		return -1;
	}
	/**
	 * 
	 * @return
	 */
	public int balanceFactor() {
		return 0;
	}
	/**
	 * 
	 * @return
	 */
	public int height() {
		if(getRoot() == null){
			return -1;
		}
		return height(getRoot());
	}
	public int height(BinarySearchTree<E> curr){
		int h = 0;
		if(curr.hasLeft()){
			if(curr.left.isLeaf()){
				if(h < depth(curr.left)){
					h = depth(curr.left);
				}
			}
		}
		if(curr.hasRight()){
			if(curr.left.isLeaf()){
				if(h < depth(curr.right)){
					h = depth(curr.right);
				}
			}
		}
		return h;
	}
	
	private int maxHeight(BinarySearchTree<E> curr, int h){
		int tmp = 0;
		if(curr.hasLeft()){
			tmp = maxHeight(curr.left, h);
		}
		if(curr.hasRight()){
			h = maxHeight(curr.right, h);
		}
		if(tmp > h){
			h = tmp;
		}
		if (curr.isLeaf()){
			return depth(curr);
		}
		return h;
	}
	/**
	 * 
	 * @return
	 */
	public int depth() {
		if(getRoot() == null){
			return -1;
		}
		return depth(getRoot());
	}
	public int depth(BinarySearchTree<E> curr){
		if(curr == getRoot()){
			return 0;
		}
		else{
			return 1 + depth(curr.parent);
		}
	}
	/**
	 * 
	 */
	public void balance() {

	}
	/**
	 * 
	 */
	public void rightRotation() {

	}
	/**
	 * 
	 */
	public void leftRotation() {

	}
	/**
	 * 
	 */
	public String postorder() {
		return postorder(getRoot());
	}
	private String postorder(BinarySearchTree<E> curr){
		String elements ="";
		if(curr.hasLeft()){
			elements += postorder(curr.left);
		}
		if(curr.hasRight()){
			elements += postorder(curr.right);
		}
		return elements + " " + (String) curr.data;	
	}
	
	
	
}
