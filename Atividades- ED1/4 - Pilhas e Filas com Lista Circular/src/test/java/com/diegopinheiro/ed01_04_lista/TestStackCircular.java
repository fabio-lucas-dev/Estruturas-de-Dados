
package com.diegopinheiro.ed01_04_lista;

import org.junit.Assert;
import org.junit.Test;

public class TestStackCircular {

	@Test
	public void testPushPop() {
		IStack<Integer> stack = new StackCircularLinkedList<>();
		boolean actual = stack.isEmpty();
		boolean expected = true;
		Assert.assertEquals(expected, actual);

		Integer valueFirst = 1;
		Integer valueSecond = 2;

		stack.push(valueFirst);
		Assert.assertFalse(stack.isEmpty());

		stack.push(valueSecond);

		Integer expectedValue;
		Integer actualValue;

		try {

			expectedValue = valueSecond;
			actualValue = stack.pop();
			Assert.assertEquals(expectedValue, actualValue);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		try {
			expectedValue = valueFirst;
			actualValue = stack.pop();
			Assert.assertEquals(expectedValue, actualValue);

		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}

		Assert.assertTrue(stack.isEmpty());
	}

	@Test
	public void testPopEmptyStack() throws Exception {
		StackCircularLinkedList<Integer> stack = new StackCircularLinkedList<>();
		boolean expected = true;
		boolean actual = stack.isEmpty();
		Assert.assertEquals(expected, actual);

		try {
			Integer value;
			value = stack.pop();
			Assert.fail("Stack is empty");
		} catch (Exception e) {
			// Success
			Assert.assertTrue(true);
		}
	}
}
