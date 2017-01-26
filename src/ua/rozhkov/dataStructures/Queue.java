package ua.rozhkov.dataStructures;

public class Queue {
	
	private Node first;
	private Node last;
	
	public Node getFirst() {
		return first;
	}
	
	public Node getLast() {
		return last;
	}
	
	public Object getLastValue() {
		return last.value;
	}
	
	public Object getFirstValue() {
		return first.value;
	}
	
	public Queue() {
		this.first = null;
		this.last = first;
	}
	
	public void inQueue(Object object) {
		if (isEmty()) {
			first = new Node(object);
			//first.value=object;
			last = first;
		}
		else {
			last.next = new Node(object);
			last = last.next;
		}
	}
	
	public Object deQueue() {
		Object tmp = first;
		if (!isEmty()) {
			first = first.next;
		}
		else {
			first = null;
			last = first;
		}
		return tmp;
	}
	
	public boolean isEmty() {
		return first == null;
	}
}

class Node {
	
	Object value;
	Node next;
	
	Node(Object value) {
		this.value = value;
	}
}
