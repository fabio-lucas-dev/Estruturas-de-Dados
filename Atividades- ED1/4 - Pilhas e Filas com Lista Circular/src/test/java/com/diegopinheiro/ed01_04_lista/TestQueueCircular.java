
package com.diegopinheiro.ed01_04_lista;

import org.junit.Assert;
import org.junit.Test;

public class TestQueueCircular {

	@Test
	public void test01() {
		QueueCircularLinkedList<Integer> queue = new QueueCircularLinkedList<>();
		boolean actual = queue.isEmpty();
		boolean expected = true;
		Assert.assertEquals(expected, actual);

		Integer valueFirst = 1;
		Integer valueSecond = 2;

		queue.enqueue(valueFirst);
		Assert.assertFalse(queue.isEmpty());

		queue.enqueue(valueSecond);

		Integer expectedValue;
		Integer actualValue;

		try {

			expectedValue = valueFirst;
			actualValue = queue.dequeue();
			Assert.assertEquals(expectedValue, actualValue);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		try {

			expectedValue = valueSecond;
			actualValue = queue.dequeue();
			Assert.assertEquals(expectedValue, actualValue);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertTrue(queue.isEmpty());
	}

	@Test
	public void test02() throws Exception {
		QueueCircularLinkedList<Integer> queue = new QueueCircularLinkedList<>();
		boolean expected = true;
		boolean actual = queue.isEmpty();
		Assert.assertEquals(expected, actual);

		try {
			Integer value;
			value = queue.dequeue();
			Assert.fail("Queue is empty");
		} catch (Exception e) {
			// Success
			Assert.assertTrue(true);
		}
	}
}
