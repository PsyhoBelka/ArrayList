package ua.rozhkov.ArrayList;

public class ArrayList {
	
	private Object[] array;
	private Object[] tempStorage;
	//	initial capacity
	private int initialCapacity = 5;
	//	current capacity of ua.rozhkov.ArrayList.ArrayList
	private int currentCapacity;
	//	number of stored elements
	private int size;
	
	public int getInitialCapacity() {
		return initialCapacity;
	}
	
	public int getCurrentCapacity() {
		return currentCapacity;
	}
	
	public int getSize() {
		return size;
	}
	
	public ArrayList() {
		array = new Object[initialCapacity];
		currentCapacity = initialCapacity;
	}
	
	public ArrayList(int initialSize){
		initialCapacity=initialSize;
		array =new Object[initialCapacity];
		currentCapacity=initialCapacity;
	}
	
	//	check for reach capacity limit
	//	<0 - free
	//	=0 - full
	//	>0 - err
	private int isFull() {
		return (array.length - size);
	}
	
	//	resize array:
	//	true - increase size by initialCapacity
	//	false - decrease size by initialCapacity
	private void resize(boolean direction) {
		if (direction) {
			tempStorage = array.clone();
			currentCapacity += initialCapacity;
			array = new Object[currentCapacity];
			for (int i = 0; i < tempStorage.length; i++) {
				array[i] = tempStorage[i];
			}
		}
		else {
			if ((size + initialCapacity) < currentCapacity) {
				tempStorage = array.clone();
				currentCapacity -= initialCapacity;
				array = new Object[currentCapacity];
				for (int i = 0; i < array.length; i++) {
					array[i] = tempStorage[i];
				}
			}
		}
		tempStorage = null;
	}
	
	//	add element to the end of array
	public void add(Object object) {
		if (isFull() > 0) {
			size++;
			array[size - 1] = object;
		}
		else {
			if (isFull() == 0) {
				tempStorage = array;
				array = new Object[currentCapacity + initialCapacity];
				for (int i = 0; i < currentCapacity; i++) {
					array[i] = tempStorage[i];
				}
				array[size] = object;
				size++;
				currentCapacity += initialCapacity;
				tempStorage = null;
			}
		}
	}
	
	//	add element to specified position
	public void add(Object object, int index) {
		if (index < size) {
			if (isFull() < 0) {
				tempStorage = array;
				array = new Object[currentCapacity];
				//	read elements before index and write it to new array
				for (int i = 0; i <= index; i++) {
					array[i] = tempStorage[i];
				}
				// 	add new element
				array[index] = object;
				//	add old elements after new element
				for (int i = index+1; i < currentCapacity; i++) {
					array[i] = tempStorage[i - 1];
				}
				size++;
			}
			else {
				if (isFull() == 0) {
					resize(true);
					tempStorage = array;
					array = new Object[currentCapacity];
					for (int i = 0; i <= index; i++) {
						array[i] = tempStorage[i];
					}
					array[index] = object;
					for (int i = index+1; i < currentCapacity; i++) {
						array[i] = tempStorage[i - 1];
					}
					size++;
				}
				
			}
		}
		else {
			throw new IllegalArgumentException("Wrong index. Array index out of bound.");
		}
		tempStorage = null;
	}
	
	public Object get(int index) {
		if (index < size) {
			return array[index];
		}
		else {
			throw new IllegalArgumentException("Wrong index. Array index out of bound.");
		}
	}
	
	//	remove for index
	public Object remove(int index) {
		Object tmpObj;
		int j = 0;
		if (index > size) {
			throw new IllegalArgumentException("Wrong index. Array index out of bound.");
		}
		else {
			if (index < size) {
				tempStorage = array;
				tmpObj = tempStorage[index];
				array = new Object[size - 1];
				for (int i = 0; i < size; i++) {
					if (i != index) {
						array[j] = tempStorage[i];
						j++;
					}
				}
				tempStorage = null;
				size--;
			}
			else {
				throw new UnknownError("Something going wrong");
			}
		}
		return tmpObj;
	}
	
	//	remove first founded element
	public void remove(Object object) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(object)) {
				remove(i);
				break;
			}
		}
		
	}
	
	//	replace existing element in index position to given
	public void set(Object object, int index) {
		if (index < size) {
			array[index] = object;
		}
		else {
			throw new IllegalArgumentException("Wrong index. Array index out of bound.");
		}
	}
	
	//	return -1 if not found
	public int indexOf(Object object) {
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(object)){
				return i;
			}
		}
		return -1;
	}
	
	//	return -1 if not found
	public int lastIndexOf(Object object) {
		for (int i = size-1; i > 0; i--) {
			if (array[i].equals(object)) return i;
		}
		return -1;
	}
	
	//	check if array contains some element
	public boolean isEmpty() {
		return size<=0;
	}
	
	//	check if array contains specified element
	public boolean contains(Object object) {
		return indexOf(object)>=0;
	}
	
	//	remove all elements from array
	public void clear() {
		currentCapacity=initialCapacity;
		size=0;
		array=new Object[initialCapacity];
	}
}
