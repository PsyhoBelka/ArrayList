package ua.rozhkov.datastructures.list;

import org.junit.Before;

public class ArrayListTest extends ListTest {
	
	@Before
	@Override
	public void before() throws Exception {
		testList=new ArrayList();
		super.before();
	}
}
