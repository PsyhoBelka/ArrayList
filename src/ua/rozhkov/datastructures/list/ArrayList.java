package ua.rozhkov.datastructures.list;

import java.util.Arrays;

public class ArrayList <T> implements List <T> {
	
	private T[] array;
	private int initialCapacity = 5;
	private int size;
	
	int size() {
		return size;
	}
	
	ArrayList() {
		array = (T[]) new Object[initialCapacity];
	}
	
	public ArrayList(int initialSize) {
		initialCapacity = initialSize;
		array = (T[]) new Object[initialCapacity];
	}
	
	private int fullness() {
		return (array.length - size);
	}
	
	private boolean validateIndex(int index) {
		return (!((index < 0) || (index > size)));
	}
	
	private boolean validateIndexAdd(int index) {
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
	
	public void add(T object) {
		add(object, size);
	}
	
	public void add(T object, int index) {
		if (validateIndexAdd(index)) {
			if (size==array.length){
				increaseCapacity();
			}
			array[index] = object;
			size++;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index argument. Index must be between 0 and " + array.length + ".");
		}
		/*
		if ((validateIndex(index))||(index==size)) {
			switch (fullness()) {
				case 0: {
					increaseCapacity();
				}
				case 1: {
					System.arraycopy(array, index, array, index + 1, size - index - 1);
					array[index] = object;
					size++;
					break;
				}
				case -1: {
					throw new UnknownError("Something gone bad!");
				}
			}
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index argument. Index must be between 0 and " + array.length + ".");
		}
		*/
	}
	
	public T get(int index) {
		if (validateIndex(index)) {
			return array[index];
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index argument. Index must be between 0 and " + array.length + ".");
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
			throw new IndexOutOfBoundsException("Illegal index argument. Index must be between 0 and " + array.length + ".");
		}
	}
	
	public void remove(T object) {
		remove(lastIndexOf(object));
	}
	
	public void set(T object, int index) {
		if (validateIndex(index)) {
			array[index] = object;
		}
	}
	
	public int indexOf(T object) {
		for (int i = 0; i < array.length; i++) {
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
	
}
