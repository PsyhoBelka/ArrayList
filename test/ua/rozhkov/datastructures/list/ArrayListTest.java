package ua.rozhkov.datastructures.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArrayListTest {
	
	ArrayList arrayList;
	
	@Before
	public void before() {
		arrayList = new ArrayList();
		for (int i = 0; i < 7; i++) {
			arrayList.add(i);
		}
		arrayList.add("String 1");
		arrayList.add(new int[]{1, 2, 3, 4, 5});
		arrayList.add(true);
	}
	
	@Test
	public void testAdd() {
		int tmp = arrayList.size();
		arrayList.add(10);
		assertEquals(11, arrayList.size());
	}
	
	@Test
	public void testAddIndex() {
		int tmp = arrayList.size();
		arrayList.add(34.45, 4);
		assertEquals(tmp + 1, arrayList.size());
		assertEquals(34.45, arrayList.get(4));
	}
	
	@Test
	public void testGet() {
		assertEquals(6, arrayList.get(6));
	}
	
	@Test
	public void testRemove() {
		int tmp = arrayList.size();
		arrayList.remove(7);
		assertEquals(tmp - 1, arrayList.size());
		assertEquals(1, ((int[]) arrayList.get(7))[0]);
	}
	
	@Test
	public void testRemoveObj() {
		int tmp = arrayList.size();
		arrayList.remove(true);
		assertEquals(tmp - 1, arrayList.size());
	}
	
	@Test
	public void testSet() {
		arrayList.set(false, 3);
		assertEquals(false, arrayList.get(3));
	}
	
	@Test
	public void testIndexOf() {
		assertEquals(-1, arrayList.indexOf('a'));
	}
	
	@Test
	public void testLastIndexOf() {
		arrayList.add(6);
		assertEquals(10, arrayList.lastIndexOf(6));
	}
	
	@Test
	public void testIsEmty() {
		arrayList.clear();
		assertTrue(arrayList.isEmpty());
	}
	
	@Test
	public void testContains() {
		assertTrue(arrayList.contains(5));
	}
}
