package ua.rozhkov.datastructures.list;

import org.junit.Before;

@SuppressWarnings("unchecked")
public class LinkedListTest extends ListTest {
		
	
	@Before
	@Override
	public void before() throws Exception {
		testList=new LinkedList();
		super.before();
	}
}
