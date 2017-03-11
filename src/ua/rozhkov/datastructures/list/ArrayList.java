package ua.rozhkov.datastructures.list;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class ArrayList <T> implements List <T> {
	
	private T[] array;
	private final int INITIAL_CAPACITY = 5;
	private int size;
	
	ArrayList() {
		array = (T[]) new Object[INITIAL_CAPACITY];
	}
	
	public int length() {
		return size;
	}
	
	public ArrayList(int initialSize) {
		array = (T[]) new Object[INITIAL_CAPACITY];
	}
	
	public void add(T object) {
		add(object, size);
	}
	
	public void add(T object, int index) {
		if (validateIndex(index)) {
			if (size == array.length) {
				increaseCapacity();
			}
			array[index] = object;
			size++;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index - " + index + " - argument. Index must be between 0 and " + array.length + ".");
		}
	}
	
	public T get(int index) {
		if (validateIndex(index)) {
			return array[index];
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index - " + index + " - argument. Index must be between 0 and " + array.length + ".");
		}
	}
	
	public T remove(int index) {
		if (validateIndex(index)) {
			T tmpObject;
			tmpObject = array[index];
			System.arraycopy(array, index + 1, array, index, size - index - 1);
			size--;
			decreaseCapacity();
			return tmpObject;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index - " + index + " - argument. Index must be between 0 and " + array.length + ".");
		}
	}
	
	public void remove(T object) {
		remove(lastIndexOf(object));
	}
	
	public void set(T object, int index) {
		if (validateIndex(index)) {
			array[index] = object;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index - " + index + " - argument. Index must be between 0 and " + array.length + ".");
		}
	}
	
	public int indexOf(T object) {
		for (int i = 0; i < length()-1; i++) {
			if (array[i].equals(object)) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(T object) {
		for (int i = size - 1; i > 0; i--) {
			if (array[i].equals(object)) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(T object) {
		return indexOf(object) >= 0;
	}
	
	public void clear() {
		size = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = null;
		}
	}
	
	private boolean validateIndex(int index) {
		return (!((index < 0) || (index > size)));
	}
	
	private void increaseCapacity() {
		array = Arrays.copyOf(array, array.length * 2);
	}
	
	private void decreaseCapacity() {
		if (array.length / size == 2) {
			Arrays.copyOf(array, size);
		}
	}
	
}