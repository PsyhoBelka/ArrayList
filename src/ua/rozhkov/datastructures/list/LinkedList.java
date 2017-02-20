package ua.rozhkov.datastructures.list;


public class LinkedList <T> implements List <T> {
	
	private Node first, last;
	private int size;
	
	public void add(T object) {
		Node tmpNode = new Node(object);
		if (isEmpty()) {
			first = tmpNode;
			last = first;
		}
		else {
			last.next = tmpNode;
			tmpNode.prev = last;
			last = tmpNode;
		}
		size++;
	}
	
	public void add(T object, int index) {
		Node newNode = new Node(object);
		Node tmpNode;
		if (validateIndex(index)) {
			tmpNode = findByIndex(index);
			newNode.prev = tmpNode;
			newNode.next = tmpNode.next;
			tmpNode.next = newNode;
			size++;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index - " + index + " - argument. Index must be between 0 and " + size + ".");
		}
	}
	
	public T get(int index) {
		if (validateIndex(index)) {
			return findByIndex(index).value;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index - " + index + " - argument. Index must be between 0 and " + size + ".");
		}
	}
	
	public T remove(int index) {
		Node tmpNode;
		if (validateIndex(index)) {
			tmpNode = findByIndex(index);
			tmpNode.prev.next = tmpNode.next;
			tmpNode.next.prev = tmpNode.prev;
			size--;
			return tmpNode.value;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index - " + index + " - argument. Index must be between 0 and " + size + ".");
		}
	}
	
	public void remove(T object) {
		Node tmpNode = findByObject(object);
		tmpNode.prev.next = tmpNode.next;
		tmpNode.next.prev = tmpNode.prev;
		size--;
	}
	
	public void set(T object, int index) {
		Node tmpNode = findByIndex(index);
		if (tmpNode != null) {
			tmpNode.value = object;
		}
		else {
			throw new NullPointerException("Target object doesn't exist");
		}
	}
	
	public int indexOf(T object) {
		Node tmpNode = first;
		int i;
		for (i = 0; i < size; i++) {
			if (tmpNode.value.equals(object)) {
				break;
			}
			else {
				tmpNode = tmpNode.next;
			}
		}
		if (tmpNode != null) {
			return i;
		}
		else {
			throw new IndexOutOfBoundsException("No such object found.");
		}
	}
	
	public int lastIndexOf(T object) {
		Node tmpNode = last;
		int i;
		for (i = size; i > 0; i--) {
			if (tmpNode.value.equals(object)) {
				break;
			}
			else {
				tmpNode = tmpNode.prev;
			}
		}
		if (tmpNode != null) {
			return i;
		}
		else {
			throw new IndexOutOfBoundsException("No such object found.");
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(T object) {
		return indexOf(object)!=0;
	}
	
	public void clear() {
		first = null;
		last = null;
	}
	
	private boolean validateIndex(int index) {
		return ((index > 0) || (index < size));
	}
	
	private Node findByIndex(int index) {
		int i;
		Node tmpNode = first;
		if (validateIndex(index)) {
			for (i = 0; i < size; i++) {
				if (i == index) {
					break;
				}
				else {
					tmpNode = tmpNode.next;
				}
			}
			return tmpNode;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index - " + index + " - argument. Index must be between 0 and " + size + ".");
		}
	}
	
	private Node findByObject(T object) {
		Node tmpNode = first;
		for (int i = 0; i < size; i++) {
			if (tmpNode.value.equals(object)) {
				break;
			}
			else {
				tmpNode = tmpNode.next;
			}
		}
		if (tmpNode != null) {
			return tmpNode;
		}
		else {
			throw new IndexOutOfBoundsException("No such object found.");
		}
	}
	
	class Node {
		Node prev, next;
		T value;
		
		public Node(T value) {
			this.value = value;
		}
	}
}
