package ua.rozhkov.dataStructures;

import java.util.Arrays;

public class ArrayList {
	
	private Object[] array;
	private int initialCapacity = 5;
	private int size;
	
	public int size() {
		return size;
	}
	
	public ArrayList() {
		array = new Object[initialCapacity];
	}
	
	public ArrayList(int initialSize) {
		initialCapacity = initialSize;
		array = new Object[initialCapacity];
	}
	
	private int isFull() {
		return (array.length - size);
	}
	
	private int validateIndex(int index) {
		if (index < size) {
			if (isFull() > 0) {
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			if (index == size) {
				return -1;
			}
			else {
				throw new IndexOutOfBoundsException("Illegal index argument");
			}
		}
	}
	
	private void increaseCapacity() {
		array=Arrays.copyOf(array,array.length+initialCapacity);
	}
	
	private void decreaseCapacity() {
		if (array.length-size>initialCapacity*2){
			System.arraycopy(array,0,array,0,size);
		}
	}
	
	public void add(Object object) {
		if (isFull() > 0) {
			array[size++] = object;
		}
		else {
			increaseCapacity();
			add(object);
		}
	}
	
	public void add(Object object, int index) {
		switch (validateIndex(index)) {
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
				add(object);
				break;
			}
		}
	}
	
	public Object get(int index) {
		if ((validateIndex(index) == 1) || (validateIndex(index) == 0)) {
			return array[index];
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index argument");
		}
	}
	
	public Object remove(int index) {
		Object tmpObj;
		
		if (validateIndex(index) != -1)  {
			tmpObj = array[index];
			System.arraycopy(array, index + 1, array, index, size - index - 1);
			size--;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index argument");
		}
		decreaseCapacity();
		return tmpObj;
	}
	
	public void remove(Object object) {
		remove(lastIndexOf(object));
	}
	
	public void set(Object object, int index) {
		if (validateIndex(index) != -1) {
			array[index] = object;
		}
		else {
			throw new IndexOutOfBoundsException("Illegal index argument");
		}
	}
	
	public int indexOf(Object object) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(object)) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(Object object) {
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
	
	public boolean contains(Object object) {
		return indexOf(object) >= 0;
	}
	
	public void clear() {
		size = 0;
		for (int i = 0; i < array.length; i++) {
			array[i]=null;
		}
	}
	
}
