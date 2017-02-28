package ua.rozhkov.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinkedListTest {
	LinkedList linkedList;
	
	@Before
	public void before(){
		linkedList=new LinkedList();
	}
	
	@Test
	public void testAdd(){
		linkedList.add("aaaaaa");
		assertEquals(1,linkedList.length());
	}
	
	@Test
	public void testAddIndex() {
		linkedList.add('d');
		linkedList.add("svsvsv");
		linkedList.add(7);
		linkedList.add(true,2);
		assertEquals(true,linkedList.contains(true));
		assertEquals(2,linkedList.indexOf(true));
	}
	
	@Test
	public void testGet() throws Exception {
		linkedList.add(4);
		assertEquals(4, linkedList.get(0));
	}
	
	@Test
	public void testRemove() throws Exception {
		linkedList.add(1);
		linkedList.remove(0);
		assertTrue(linkedList.isEmpty());
	}
	
	@Test
	public void testRemoveIndex(){
		linkedList.add("123");
		linkedList.remove("123");
		assertTrue(linkedList.isEmpty());
	}
	
	@Test
	public void testSet() {
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.set(56,1);
		assertEquals(56,linkedList.get(1));
	}
	
	@Test
	public void testIndexOf() throws Exception {
		linkedList.add(1);
		linkedList.add(2);
		assertEquals(1,linkedList.indexOf(2));
	}
	
	@Test
	public void testLastIndexOf() throws Exception {
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(2);
		linkedList.add(1);
		assertEquals(3,linkedList.lastIndexOf(1));
	}
	
	@Test
	public void testContains() throws Exception {
		linkedList.add(2);
		assertTrue(linkedList.contains(2));
	}
}
