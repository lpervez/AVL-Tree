/**
 * Class Avlnode.
 * @author laraibpervez
 * @param <T> is type parameter.
 */
public class AVLNode<T> extends BinaryNode<T> {
	/**
	 * Attribute.
	 */
	private AVLNode<T> leftChild, rightChild;
	/**
	 * Height.
	 */
	private int height;
	/**
	 * Data.
	 */
	private T data;
	/**
	 * initializes all the attributes to null. and height to -1.
	 */
	public AVLNode() {
		height = -1;
		leftChild = null;
		rightChild = null;
		data = null;
	}
	/**
	 * AVL node.
	 * @param data data
	 */
	public AVLNode(T data) {
		this.data = data;
		leftChild = null;
		rightChild = null;
		height = 0;
	}
	/**
	 * Initializing data, rightChild and leftChild.
	 * @param data data
	 * @param leftChild leftChild
	 * @param rightChild rightChild
	 */
	public AVLNode(T data, AVLNode<T> leftChild, AVLNode<T> rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		height = 1;
	}
	/**
	 * Setting the leftChild.
	 * @param leftChild leftChild
	 */
	public void setLeftChild(AVLNode<T> leftChild) {
		this.leftChild = leftChild;
		if (!this.hasRightChild()) {
			height++;
		}
	}
	/**
	 * setting rightChild.
	 * @param rightChild rightChild
	 */
	public void setRightChild(AVLNode<T> rightChild) {
		this.rightChild = rightChild;
		if (!this.hasLeftChild()) {
			height++;
		}
	}
	/**
	 * height.
	 * @return height
	 */
	public int getHeight() {
		return this.height;
	}
	/**
	 * Setting height.
	 * @param height height
	 */
	public void setHeight(int height) {
		this.height = height;
	}
}

