package ua.rozhkov.datastructures.list;

interface List <T> {
	
	void add(T object);
	
	void add(T object, int index);
	
	T get(int index);
	
	T remove(int index);
	
	void remove(T object);
	
	void set(T object, int index);
	
	int indexOf(T object);
	
	int lastIndexOf(T object);
	
	boolean isEmpty();
	
	boolean contains(T object);
	
	void clear();
	
	int length();
	
}
