
package com.diegopinheiro.ed1_01_lista;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestStackArray {

	private IStack stack; 
	
	@Before
	public void setUp() {
		int capacity = 2;
		this.stack = new StackArray(capacity);
	}
	
	@Test
	public void test01EmptyStackIsEmpty() {
		IStack stack = this.stack;
		Assert.assertTrue(stack.isEmpty());

	}

	@Test
	public void test02EmptyStackIsNotEmptyAfterPushOneElement() {
		IStack stack = this.stack;
		stack.push(1);
		Assert.assertFalse(stack.isEmpty());
	}

	@Test
	public void test03OneElementStackLastInFirstOut() {
		IStack stack = this.stack;
		Integer first = 1;

		stack.push(first);

		try {
			Integer actual = stack.pop();
			Integer expected = first;
			Assert.assertEquals(expected, actual);
		}catch(IllegalStateException e) {
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test03TwoElemementsStackLastInFirstOutFirstPop() {
		IStack stack = this.stack;
		Integer first = 1;
		Integer second = 2;
		stack.push(first);
		stack.push(second);
		try {
			Integer actual = stack.pop();
			Integer expected = second;
			Assert.assertEquals(expected, actual);
		}catch(IllegalStateException e) {
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test04TwoElementsStackLastInFirstOutSecondPop() {
		IStack stack = this.stack;
		Integer first = 1;
		Integer second = 2;
		stack.push(first);
		stack.push(second);
		try {
			stack.pop();
			Integer actual = stack.pop();
			Integer expected = first;
			Assert.assertEquals(expected, actual);
		}catch(IllegalStateException e) {
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test05EmptyStackCannotPop() throws Exception {
		IStack stack = this.stack;
		try {
			stack.pop();
			Assert.fail("Stack is empty");
		}catch(IllegalStateException e) {
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test05OneElementStackCannotPopTwoTimes() throws Exception {
		IStack stack = this.stack;
		try {
			stack.pop();
			stack.pop();
			Assert.fail("Stack is empty");
		}catch(IllegalStateException e) {
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	@Test
	public void test05TwoElementStackCannotPopThreeTimes() throws Exception {
		IStack stack = this.stack;
		try {
			stack.pop();
			stack.pop();
			Assert.fail("Queue is empty");
		}catch(IllegalStateException e) {
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void test06StackCannotPushMoreThanTwoElements() {
		IStack stack = this.stack;
		try {
			stack.push(0);
			stack.push(0);
			stack.push(0);
			
			Assert.fail("Stack cannot push more than 3 elements");
		}catch(IllegalStateException e) {
			Assert.assertTrue(true);
		}
		catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void test07StackFullCapacityIsNotEmpty() {
		IStack stack = this.stack;
		try {
			stack.push(0);
			stack.push(0);
			
			Assert.assertFalse(stack.isEmpty());
		} catch (IllegalStateException e) {
			Assert.fail(e.getMessage());
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
}
