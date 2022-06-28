package util;

public class List<T> {

	private Node<T> head = null;
	private int length;

	/**
	 * Add new element at beginning of list
	 * 
	 * @param value (T) value to add
	 */
	public void addFirst(T value) {
		head = new Node<T>(value, head);
		length++;
	}

	/**
	 * Add new element at last of list
	 * 
	 * @param value (T) value to add
	 */
	public void addLast(T value) {
		if (head == null) {
			addFirst(value);
		} else {
			Node<T> node = head;
			while (node.getNext() != null) {
				node = node.getNext();
			}
			node.setNext(new Node<T>(value));
			length++;
		}
	}

	/**
	 * Add new element at index position of list
	 * 
	 * @param index (int) index of list
	 * @param value (T) value to add
	 */
	public void addIndex(int index, T value) {
		if (index <= 0) {
			addFirst(value);
		} else if (index >= length) {
			addLast(value);
		} else {
			Node<T> node = head;
			for (int i=0; i<index-1; i++) {
				node = node.getNext();
			}
			node.setNext(new Node<T>(value, node.getNext()));
			length++;
		}
	}

	/**
	 * Remove element at beginning of list
	 * 
	 * @return (T) value of removed element
	 */
	public T removeFirst() {
		if (head == null) {
			return null;
		}
		T value = head.getValue();
		head = head.getNext();
		length--;
		return value;
	}

	/**
	 * Remove element at last of list
	 * 
	 * @return (T) value of removed element
	 */
	public T removeLast() {
		if (head == null) {
			return null;
		}
		if (head.getNext() == null) {
			T value = head.getValue();
			head = null;
			length--;
			return value;
		}
		Node<T> node = head;
		while (node.getNext() != null) {
			if (node.getNext().getNext() == null) {
				T value = node.getNext().getValue();
				node.setNext(null);
				length--;
				return value;
			}
			node = node.getNext();
		}
		return null;
	}

	/**
	 * Sort elements of list considering values (T) are of type String
	 */
	public void sort() {
		if (head == null || head.getNext() == null) {
			return;
		}
		Node<T> node = head, index = null;
		while (node != null) {
			index = node.getNext();
			while (index != null) {
				if (compareString(node, index)) {
					T temp = node.getValue();
					node.setValue(index.getValue());
					index.setValue(temp);
				}
				index = index.getNext();
			}
			node = node.getNext();
		}
	}

	/**
	 * Remove element at index position of list 
	 * @param index (int) index of list
	 * @return (T) value of element removed
	 */
	public T removeIndex(int index) {
		if (index <= 0) {
			return removeFirst();
		} else if (index >= length) {
			return removeLast();
		} else {
			Node<T> node = head;
			for (int i=0; i<index-1; i++) {
				node = node.getNext();
			}
			T value = node.getValue();
			node.setNext(node.getNext().getNext());
			length--;
			return value;
		}
	}

	private boolean compareString(Node<T> actual, Node<T> next) {
		return ((String) actual.getValue()).compareTo((String) next.getValue()) > 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Length: " + length + " [");
		Node<T> p = head;
		while (p != null) {
			sb.append(p.getValue());
			p = p.getNext();
			if (p != null) {
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}


}
