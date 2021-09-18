/**
 * Class AVL tree.
 * @author laraibpervez
 *
 * @param <T> is type parameter.
 */
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {
	/**
	 * Root.
	 */
	private AVLNode<T> root;
	/**
	 * initializes the root to null.
	 */
	public AVLTree() {
		root = null;
	}
	/**
	 * Initializes the root with the accepted value.
	 * @param data data
	 */
	public AVLTree(T data) {
		root = new AVLNode<T>(data);
	}
	/**
	 * Add.
	 * @param newEntry newEntry
	 * @return T 
	 */
	public T add(T newEntry) {
		super.add(newEntry);

		rebalance(root);

		return super.getEntry(newEntry);
		// rotate tree;
	}
	/**
	 * Remove.
	 * @param anEntry anEntry
	 * @return T
	 */
	public T remove(T anEntry) {
		super.remove(anEntry);
		AVLNode<T> node = (AVLNode<T>) super.getEntry(anEntry);

		if (node != null) {
			rebalance(root);
		}

		return node.getData();
	}
	/**
	 * Rebalance.
	 * @param root root
	 * @return T
	 */
	AVLNode<T> rebalance(AVLNode<T> root) {
		updateHeight(root);
		int balance = getBalance(root);
		if (balance > 1) {
			if (height((AVLNode<T>) root.getRightChild().getRightChild()) > height(
					(AVLNode<T>) root.getRightChild().getLeftChild())) {
				root = rotateLeft(root);
			} else {
				root.setRightChild(rotateRight((AVLNode<T>) root.getRightChild()));
				root = rotateLeft(root);
			}
		} else if (balance < -1) {
			if (height((AVLNode<T>) root.getLeftChild().getLeftChild()) > height(
					(AVLNode<T>) root.getLeftChild().getRightChild()))
				root = rotateRight(root);
			else {
				root.setLeftChild(rotateLeft((AVLNode<T>) root.getLeftChild()));
				root = rotateRight(root);
			}
		}
		return root;
	}
	/**
	 * update height.
	 * @param n n
	 */
	void updateHeight(AVLNode<T> n) {
		n.setHeight(1 + Math.max(height((AVLNode<T>) n.getLeftChild()), height((AVLNode<T>) n.getRightChild())));
	}
	/**
	 * Height.
	 * @param n n
	 * @return integeter
	 */
	int height(AVLNode<T> n) {
		return n == null ? -1 : n.getHeight();
	}
	/**
	 * GetBalance.
	 * @param n n
	 * @return integer
	 */
	int getBalance(AVLNode<T> n) {
		return (n == null) ? 0 : height((AVLNode<T>) n.getRightChild()) - height((AVLNode<T>) n.getLeftChild());
	}
	/**
	 * Rotate right.
	 * @param y y
	 * @return T
	 */
	AVLNode<T> rotateLeft(AVLNode<T> y) {
		AVLNode<T> x = (AVLNode<T>) y.getRightChild();
		AVLNode<T> z = (AVLNode<T>) x.getLeftChild();
		x.setLeftChild(y);
		y.setRightChild(z);
		updateHeight(y);
		updateHeight(x);
		return x;
	}
	/**
	 * Rotate Right.
	 * @param y y
	 * @return T
	 */
	AVLNode<T> rotateRight(AVLNode<T> y) {
		AVLNode<T> x = (AVLNode<T>) y.getLeftChild();
		;
		AVLNode<T> z = (AVLNode<T>) x.getRightChild();
		x.setRightChild(y);
		y.setLeftChild(z);
		updateHeight(y);
		updateHeight(x);
		return x;
	}
}
