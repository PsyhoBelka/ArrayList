package ua.rozhkov.datastructures.list;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class LinkedList <T> implements List <T> {
	
	private Node first, last;
	private int size;
	
	public int length() {
		return size;
	}
	
	public void add(T object) {
		add(object, size);
		
		/*
		Node tmpNode = new Node(object);
		if (isEmpty()) {
			first = tmpNode;
			last = first;
		} else {
			last.next = tmpNode;
			tmpNode.prev = last;
			last = tmpNode;
		}
		size++;*/
	}
	
	public void add(T object, int index) {
		if (validateIndexAdd(index)) {
			Node <T> newNode = new Node <T>(object);
			if (index == 0) {
				if (size == 0) {
					first = newNode;
					last = first;
				} else {
					newNode.next = first;
					first.prev = newNode;
					first = newNode;
				}
			} else {
				if (index == size) {
					last.next = newNode;
					newNode.prev = last;
					last = newNode;
				} else {
					Node <T> tempNode = findByIndex(index);
					tempNode.prev.next = newNode;
					newNode.prev = tempNode.prev;
					newNode.next = tempNode.next;
					tempNode.next.prev = newNode;
				}
			}
			size++;
		}
		/*
		Node newNode = new Node(object);
		Node tmpNode;
		if (validateIndex(index)) {
			if (index != 0) {
				tmpNode = findByIndex(index - 1);
				newNode.prev = tmpNode;
				newNode.next = tmpNode.next;
				tmpNode.next = newNode;
			}
			else {
				add(object);
			}
			size++;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index - " + index + " - argument. Index must be between 0 and " + size + ".");
		}*/
	}
	
	public T get(int index) {
		if (validateIndex(index)) {
			return (T) findByIndex(index).value;
		} else {
			return null;
		}
	}
	
	public T remove(int index) {
		Node tempNode;
		if (validateIndex(index)) {
			if (index != 0) {
				tempNode = findByIndex(index);
				if (tempNode.next != null) {
					tempNode.prev.next = tempNode.next;
					tempNode.next.prev = tempNode.prev;
				} else {
					last=tempNode.prev;
					last.next=null;
				}
			} else {
				tempNode = first;
				first = first.next;
				first.prev = null;
			}
			size--;
			return (T) tempNode.value;
		} else {
			return null;
		}
	}
	
	public void remove(T object) {
		Node tempNode = findByObject(object);
		if (tempNode != null) {
			if (tempNode == first) {
				first = first.next;
				first.prev = null;
			} else if (tempNode == last) {
				last = last.prev;
				last.next = null;
			} else {
				tempNode.prev.next = tempNode.next;
				tempNode.next.prev = tempNode.prev;
			}
			size--;
		} else {
			throw new NoSuchElementException("Given object does not exist in collection.");
		}
		/*
		if (length() > 1) {
			Node tmpNode = findByObject(object);
			tmpNode.prev.next = tmpNode.next;
			tmpNode.next.prev = tmpNode.prev;
			size--;
		} else {
			clear();
			size=0;
		}*/
	}
	
	public void set(T object, int index) {
		if (validateIndex(index)) {
			Node tempNode = findByIndex(index);
			tempNode.value = object;
		}
		
		/*
		Node tmpNode = findByIndex(index);
		if (tmpNode != null) {
			tmpNode.value = object;
		} else {
			throw new NullPointerException("Target object doesn't exist");
		}*/
	}
	
	public int indexOf(T object) {
		Node tmpNode = first;
		boolean found = false;
		int i;
		for (i = 0; i < size; i++) {
			if (tmpNode.value.equals(object)) {
				found = true;
				break;
			} else {
				tmpNode = tmpNode.next;
			}
		}
		if (found) {
			return i;
		} else {
			return -1;
		}
	}
	
	public int lastIndexOf(T object) {
		Node tmpNode = last;
		boolean found = false;
		int i;
		for (i = size - 1; i >= 0; i--) {
			if (tmpNode.value.equals(object)) {
				found = true;
				break;
			} else {
				tmpNode = tmpNode.prev;
			}
		}
		if (found) {
			return i;
		} else {
			return -1;
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(T object) {
		return indexOf(object) >= 0;
	}
	
	public void clear() {
		first = null;
		last = null;
		size = 0;
	}
	
	private boolean validateIndexAdd(int index) {
		if ((index >= 0) || (index <= size)) {
			return true;
		} else {
			throw new IndexOutOfBoundsException("Illegal index - " + index + " - argument. Index must be between 0 and " + size + ".");
		}
	}
	
	private boolean validateIndex(int index) {
		if ((index >= 0) || (index < size)) {
			return true;
		} else {
			throw new IndexOutOfBoundsException("Illegal index - " + index + " - argument. Index must be between 0 and " + size + ".");
		}
	}
	
	private Node findByIndex(int index) {
		int i;
		Node tmpNode;
		if (index <= size / 2) {
			tmpNode = first;
			for (i = 0; i < size; i++) {
				if (i == index) {
					break;
				} else {
					tmpNode = tmpNode.next;
				}
			}
		} else {
			tmpNode = last;
			for (i = size - 1; i >= 0; i--) {
				if (i == index) {
					break;
				} else {
					tmpNode = tmpNode.next;
				}
			}
		}
		return tmpNode;
	}
	
	private Node findByObject(T object) {
		Node tempNode = first;
		for (int i = 0; i < size; i++) {
			if (tempNode.value.equals(object)) {
				return tempNode;
			} else {
				tempNode = tempNode.next;
			}
		}
		return null;
	}
	
	static class Node <T> {
		Node <T> prev, next;
		T value;
		
		public Node(T value) {
			this.value = value;
		}
	}
}
