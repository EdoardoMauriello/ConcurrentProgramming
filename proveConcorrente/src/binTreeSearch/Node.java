package binTreeSearch;

public class Node {
	private int value;
	private boolean isLeaf;
	private Node leftSon, rightSon;

	public Node() {
		isLeaf = true;
		value = -1;
		leftSon = null;
		rightSon = null;
	}

	public Node(int value) {
		this();
		this.value = value;
	}

	public Node(int value, Node leftSon) {
		this(value);
		this.leftSon = leftSon;
		isLeaf = false;
	}

	public Node(int value, Node leftSon, Node rightSon) {
		this(value, leftSon);
		this.rightSon = rightSon;
	}

	private boolean addLeft(Node node) {
		if (isLeaf) {
			isLeaf = false;
			leftSon = node;
			return true;
		} else if (leftSon == null) {
			leftSon = node;
			return true;
		}
		return false;
	}

	private boolean addRight(Node node) {
		if (isLeaf) {
			isLeaf = false;
			rightSon = node;
			return true;
		} else if (rightSon == null) {
			rightSon = node;
			return true;
		}
		return false;
	}

	private Node removeLeft() {
		Node temp = leftSon;
		if (leftSon != null && rightSon == null) {
			isLeaf = true;
			leftSon = null;
		} else if (leftSon != null && rightSon != null) {
			leftSon = null;
		}
		return temp;
	}

	private Node removeRight() {
		Node temp = rightSon;
		if (rightSon != null && leftSon == null) {
			isLeaf = true;
			rightSon = null;
		} else if (rightSon != null && leftSon != null) {
			rightSon = null;
		}
		return temp;
	}
}
