package ua.rozhkov.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("unchecked")
abstract public class ListTest {
	List testList;
	
	@Before
	public void before() throws Exception {
		testList.add(111);
		testList.add(222);
		testList.add(333);
	}
	
	@Test
	public void testAddBegin() throws Exception {
		assertEquals(3,testList.length());
	}
	
	@Test
	public void testAddEnd() throws Exception {
		testList.add(444, testList.length());
		assertEquals(4,testList.length());
	}
	
	@Test
	public void testAddIndex() throws Exception {
		testList.add(666,1);
		assertEquals(666,testList.get(1));
	}
	
	@Test
	public void testGet() throws Exception {
		assertEquals(222,testList.get(1));
	}
	
	@Test
	public void testRemoveBegin() throws Exception {
		testList.remove(0);
		assertEquals(222,testList.get(0));
	}
	
	@Test
	public void testRemoveEnd() throws Exception {
		testList.remove(testList.length()-1);
		assertEquals(222,testList.get(testList.length()-1));
	}
	
	@Test
	public void testRemoveIndex() throws Exception {
		assertEquals(111,testList.remove(0));
	}

	@Test
	public void testSetBegin() throws Exception {
		testList.set(777,0);
		assertEquals(777,testList.get(0));
	}
	
	@Test
	public void testSetEnd() throws Exception {
		testList.set(888,testList.length()-1);
		assertEquals(888, testList.get(testList.length()-1));
	}
	
	@Test
	public void testSetIndex() throws Exception {
		testList.set(999,2);
		assertEquals(999,testList.get(2));
	}
	
	@Test
	public void testIndexOf() throws Exception {
		assertEquals(0,testList.indexOf(111));
	}
	
	@Test
	public void testLastIndexOf() throws Exception {
		testList.add(111);
		assertEquals(3,testList.lastIndexOf(111));
	}
	
	@Test
	public void testIsEmpty() throws Exception {
		assertFalse(testList.isEmpty());
	}
	
	@Test
	public void testContains() throws Exception {
		assertFalse(testList.contains(000));
	}
	
	@Test
	public void testClear() throws Exception {
		testList.clear();
		assertTrue(testList.isEmpty());
	}
}
