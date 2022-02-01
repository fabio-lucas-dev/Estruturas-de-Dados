package com.diegopinheiro.ed1_01_lista;

import org.junit.Assert;
import org.junit.Test;

public class TestReverse {

	@Test
	public void testReverse() {
		int size = 10;
		IQueue queueToBeReversed = new QueueArray(size);
		IStack stackAuxiliary = new StackArray(size);
		for (int i = 0; i < size; i++) {
			queueToBeReversed.enqueue(i);
		}
		Utils.reverse(queueToBeReversed, stackAuxiliary);
		for (int i = size - 1; i >= 0; i--) {
			try {
				int expected = i;
				int actual = queueToBeReversed.dequeue();
				Assert.assertEquals(expected, actual);
			} catch (Exception e) {
				Assert.fail();
			}
		}
	}

}
