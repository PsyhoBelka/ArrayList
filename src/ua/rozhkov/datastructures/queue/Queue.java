package ua.rozhkov.datastructures.queue;

public class Queue {
	
	private Node first;
	private Node last;
	
	Object getLast() {
		return last.value;
	}
	
	Object getFirst() {
		return first.value;
	}
	
	public void inQueue(Object object) {
		if (isEmty()) {
			first = new Node(object);
			last = first;
		}
		else {
			last.next = new Node(object);
			last = last.next;
		}
	}
	
	public Object deQueue() {
		Node tmp = first;
		if (!isEmty()) {
			first = first.next;
		}
		else {
			first = null;
			last = first;
		}
		return tmp.value;
	}
	
	public boolean isEmty() {
		return first == null;
	}
	
	class Node {
		
		Object value;
		Node next;
		
		Node(Object value) {
			this.value = value;
		}
	}
}


