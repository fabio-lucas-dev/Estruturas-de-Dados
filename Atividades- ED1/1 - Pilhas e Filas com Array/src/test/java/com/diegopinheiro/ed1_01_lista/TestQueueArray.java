
package com.diegopinheiro.ed1_01_lista;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestQueueArray {

	private IQueue queue;

	@Before
	public void setUp() {
		int capacity = 2;
		this.queue = new QueueArray(capacity);
	}

	@Test
	public void test01EmptyQueueIsEmpty() {
		IQueue queue = this.queue;
		Assert.assertTrue(queue.isEmpty());
	}

	@Test
	public void test02OneElementQueueAfterEnqueueIsNotEmpty() {
		IQueue queue = this.queue;
		queue.enqueue(1);
		Assert.assertFalse(queue.isEmpty());
	}

	@Test
	public void test03OneElementQueueFirstInFirstOutFirstDequeue() {
		IQueue queue = this.queue;
		Integer first = 1;
		queue.enqueue(first);
		try {
			Integer actual = queue.dequeue();
			Integer expected = first;
			Assert.assertEquals(expected, actual);
		} catch (IllegalStateException e) {
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test03TwoElemementsQueueFirstInFirstOutFirstDequeue() {
		IQueue queue = this.queue;
		Integer first = 1;
		Integer sencod = 2;
		queue.enqueue(first);
		queue.enqueue(sencod);
		try {
			Integer actual = queue.dequeue();
			Integer expected = first;
			Assert.assertEquals(expected, actual);
		} catch (IllegalStateException e) {
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test04TwoElementsQueueFirstInFirstOutTwoDequeue() {
		IQueue queue = this.queue;
		Integer first = 1;
		Integer second = 2;
		queue.enqueue(first);
		queue.enqueue(second);
		try {
			queue.dequeue();
			Integer actual = queue.dequeue();
			Integer expected = second;
			Assert.assertEquals(expected, actual);
		} catch (IllegalStateException e) {
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test05EmptyQueueCannotDequeue() {
		IQueue queue = this.queue;
		try {
			queue.dequeue();
			Assert.fail("Queue is empty");
		} catch (IllegalStateException e) {
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test05OneElementQueueCannotDequeueTwoTimes() {
		IQueue queue = this.queue;
		try {
			queue.dequeue();
			queue.dequeue();
			Assert.fail("Queue is empty");
		} catch (IllegalStateException e) {
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test05TwoElementQueueCannotDequeueThreeTimes() {
		IQueue queue = this.queue;
		try {
			queue.dequeue();
			queue.dequeue();
			Assert.fail("Queue is empty");
		} catch (IllegalStateException e) {
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test06QueueCannotEnqueueMoreThanTwoElements() {
		IQueue queue = this.queue;
		try {
			queue.enqueue(0);
			queue.enqueue(0);
			queue.enqueue(0);
			
			Assert.fail("Queue cannot enqueue more than 3 elements");
		} catch (IllegalStateException e) {
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void test07QueueFullCapacityIsNotEmpty() {
		IQueue queue = this.queue;
		try {
			queue.enqueue(0);
			queue.enqueue(0);
			
			Assert.assertFalse(queue.isEmpty());
		} catch (IllegalStateException e) {
			Assert.fail(e.getMessage());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void teste11() {
		IQueue queue = this.queue;
		try {
			queue.enqueue(1);
			queue.enqueue(2);
			queue.dequeue();
			queue.enqueue(3);
		}catch(Exception e){
			Assert.fail(e.getMessage());
		}
	}


}
