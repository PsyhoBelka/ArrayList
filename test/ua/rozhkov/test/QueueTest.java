package ua.rozhkov.test;

import org.junit.Before;
import org.junit.Test;
import ua.rozhkov.dataStructures.Queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QueueTest {
	Queue queue;
	
	//@Ignore
	@Before
	public void before() {
		queue = new Queue();
		queue.inQueue(true);
		queue.inQueue(3.14);
	}
	
	
	@Test
	public void testInQueue() {
		queue.inQueue(4);
		assertEquals(4, queue.getLastValue());
	}
	
	@Test
	public void testDeQueue() throws Exception {
		queue.deQueue();
		assertEquals(3.14, queue.getFirstValue());
	}
	
	@Test
	public void testIsEmty() throws Exception {
		queue = new Queue();
		assertTrue(queue.isEmty());
	}
}
