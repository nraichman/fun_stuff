
public class BinarySearchTree<E extends Comparable<E>> {

	private E element;
	private BinarySearchTree<E> parent;
	private BinarySearchTree<E> leftChild;
	private BinarySearchTree<E> rightChild;

	public BinarySearchTree(E element){
		parent = null;
		leftChild = null;
		rightChild = null;
		this.element = element;
	}

	public BinarySearchTree<E> getRoot(){
		BinarySearchTree<E> root = this;
		while(!root.isRoot()){
			root = root.parent;
		}
		return root;
	}
	public BinarySearchTree<E> getLeftChild(){
		return leftChild;
	}
	public BinarySearchTree<E> getRightChild(){
		return rightChild;
	}
	public BinarySearchTree<E> getParent(){
		return parent;
	}
	public void setParent(E element){
		parent = new BinarySearchTree<E>(element);
	}
	public void setParent(BinarySearchTree<E> parent){
		this.parent = parent;
	}
	public E getElement(){
		return element;
	}
	public void setElement(E element){
		this.element = element;
	}
	/**
	 *
	 * @return
	 */
	public boolean hasLeft() {
		return leftChild != null;
	}
	/**
	 *
	 * @return
	 */
	public boolean hasRight() {
		return rightChild != null;
	}
	/**
	 *
	 * @return
	 */
	public boolean isLeaf() {
		return !hasRight() && !hasLeft();
	}
	/**
	 *
	 * @return
	 */
	public boolean isEmpty() {
		return element != null;
	}
	/**
	 *
	 * @return
	 */
	public boolean isRoot() {
		return parent == null;
	}
	/**
	 *
	 * @return
	 */
	public boolean isLeftChild() throws Exception{
		if(!isRoot()){
			return parent.getLeftChild() == this;
		}
		else{
			throw new Exception("This tree does not have a parent!");
		}
	}
	/**
	 *
	 * @return
	 */
	public boolean isRightChild() throws Exception{
		if(!isRoot()){
			return parent.getRightChild() == this;
		}
		else{
			throw new Exception("This tree does not have a parent!");
		}
	}
	/**
	 *
	 * @return
	 */
	public boolean hasParent() {
		return parent == null;
	}
	/**
	 *
	 * @param e
	 * @return
	 */
	public BinarySearchTree<E> findNode(E e) {
		BinarySearchTree<E> curr = getRoot();
		//if(!curr.isEmpty()){
			curr = findNode(e, curr);
			if(curr.isLeaf()&& !(curr.getElement().compareTo(e) == 0)){
				return null;
			}
			else{
				return curr;
			}
	//	}
		//else{
		//	return null;
		//}
	}
	private BinarySearchTree<E> findNode(E e, BinarySearchTree<E> curr){
		if(curr.isLeaf()||curr.getElement().compareTo(e) == 0){
			return curr;
		}
		else if(curr.getElement().compareTo(e) < 0){
			//System.out.println(e.toString() + " is bigger than " + curr.getElement().toString() + ". Moved to the right of " + curr.getElement().toString());
			if(curr.hasRight()){
				return findNode(e, curr.getRightChild());
			}
			else{
				return curr;
			}
		}
		else{
			//System.out.println(e.toString() + " is smaller than " + curr.getElement().toString() + ". Moved to the left of " + curr.getElement().toString());
			if(curr.hasLeft()){
				return findNode(e, curr.getLeftChild());
			}
			else{
				return curr;
			}
		}
	}
	/**
	 *
	 * @return
	 */
	public BinarySearchTree<E> findMin() {
		BinarySearchTree<E> min = this;
		while(!min.isLeaf()&&min.hasLeft()){
			min = min.getLeftChild();
		}
		return min;
	}
	/**
	 *
	 * @return
	 */
	public BinarySearchTree<E> findSuccessor() throws Exception{
		BinarySearchTree<E> successor = this;
		if(successor.hasRight()){
			successor = successor.getRightChild();
			successor = successor.findMin();
			return successor;
		}
		else{
			while(!successor.isLeftChild()){
				successor = successor.getParent();
			}
			return successor.getParent();
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
	public BinarySearchTree<E> insert(E e)throws Exception {
		BinarySearchTree<E> curr = getRoot();
		//System.out.println("Starting from root " + curr.getElement().toString());
		curr = findNode(e, curr);
		int compare = curr.getElement().compareTo(e);
		if(compare == 0){
			throw new Exception("That Value already exists in the Tree");
		}
		else if(compare < 0){
			BinarySearchTree<E> right = new BinarySearchTree<>(e);
			curr.setRightChild(right);
		//	System.out.println(e.toString() + " was inserted at the right of " + curr.getElement().toString());
		}
		else{
			BinarySearchTree<E> left = new BinarySearchTree<>(e);
			curr.setLeftChild(left);
			//System.out.println(e.toString() + " was inserted at the left of " + curr.getElement().toString());
		}
		balance();
		BinarySearchTree<E> newRoot = getRoot();
		return newRoot;
	}
	public void setLeftChild(BinarySearchTree<E> leftChild){
		this.leftChild = leftChild;
		if(leftChild != null){
			this.leftChild.setParent(this);
		}
	}
	public void setRightChild(BinarySearchTree<E> rightChild){
		this.rightChild = rightChild;
		if(rightChild != null){
			this.rightChild.setParent(this);
		}
	}
	/**
	 *
	 * @param e
	 * @return
	 */
	public BinarySearchTree<E> search(E e) {
		return null;
	}
	/**
	 *
	 * @param e
	 * @return
	 */
	/*
	public BinarySearchTree<E> delete(E e) {
		BinarySearchTree<E> curr = findNode(e);
		if(curr.isLeaf()){// case no children(leaf)
			if(curr.isRightChild()){
				curr.getParent().setRightChild(null);
			}else{
				curr.getParent().setLeftChild(null);
			}
			return getRoot();
		}
		else if(curr.hasRight() && !curr.hasLeft()){//case only right child
			if(curr.isRightChild()){
				curr.getParent().setRightChild(curr.getRightChild());

			}
			else{
				curr.getParent().setLeftChild(curr.getRightChild());
			}
		}
		else if(curr.hasLeft() && !curr.hasRight()){// case only left child
			if(curr.isRightChild()){
				curr.getParent().setRightChild(curr.getLeftChild());
			}
			else{
				curr.getParent().setLeftChild(curr.getLeftChild());
			}
		}
		else{// case two children

		}
	}
	*/
	public BinarySearchTree<E> delete(E e) throws Exception{
		BinarySearchTree<E> curr = findNode(e);
		return delete(curr);
	}
	private BinarySearchTree<E> delete(BinarySearchTree<E> curr)throws Exception{
		if(curr.isLeaf()){// case no children(leaf)
			if(curr.isRightChild()){
				curr.getParent().setRightChild(null);
			}else{
				curr.getParent().setLeftChild(null);
			}
			return getRoot();
		}
		else if(curr.hasRight() && !curr.hasLeft()){//case only right child
			curr.setElement(curr.getRightChild().getElement());
			return delete(curr.getRightChild());
		}
		else if(curr.hasLeft() && !curr.hasRight()){// case only left child
			curr.setElement(curr.getLeftChild().getElement());
			return delete(curr.getLeftChild());
		}
		else{// case two children
			curr.setElement(curr.findSuccessor().getElement());
			return delete(curr.findSuccessor());
		}
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
		return -1;
	}
	/**
	 *
	 * @return
	 */
	public int depth() {
		return -1;
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
		BinarySearchTree<E> root = getRoot();
		String s = "";
		s = root.postorder(s);
		return s;
	}
	public String postorder(String s){
		if(hasLeft()){
			s = leftChild.postorder(s);
		}
		if(hasRight()){
			s = rightChild.postorder(s);
		}
		s = s + " " + element.toString();
		return s;
	}
	public String inOrder(){
		BinarySearchTree<E> root = getRoot();
		String s = "";
		s = root.inOrder(s);
		return s;
	}
	private String inOrder(String s){
		if(hasLeft()){
			s = leftChild.inOrder(s);
		}
		s = s + " " + element.toString();
		if(hasRight()){
			s = rightChild.inOrder(s);
		}
		return s;
	}
}
