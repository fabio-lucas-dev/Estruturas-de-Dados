package com.diegopinheiro.ed01_02_lista;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSinglyLinkedList {

	private SinglyLinkedList list;

	@Before
	public void setUp() {
		this.list = new SinglyLinkedList();
	}

	// @Test(timeout = 5000)
	@Test
	public void test01EmptyTrue() {
		SinglyLinkedList list = this.list;
		assertTrue(list.isEmpty());
	}

	// @Test(timeout = 5000)
	@Test
	public void test02EmptyFalse() {
		SinglyLinkedList list = this.list;
		Integer value = 0;
		list.addFirst(value);
		assertTrue(!list.isEmpty());
	}

	// @Test(timeout = 5000)
	@Test
	public void test03AddFirst() {
		SinglyLinkedList list = this.list;
		Integer[] listValues = { 1, 2, 3 };
		for (int value : listValues) {
			list.addFirst(value);
		}

		Integer[] listValuesReversed = { 3, 2, 1 };
		int size = list.size();
		if (size != 3) {
			Assert.fail();
		}
		SinglyListNode node = list.getHead();
		for (Integer expected : listValuesReversed) {
			Integer actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getNext();
		}
	}

	// @Test(timeout = 5000)
	@Test
	public void test04SearchEmpty() {
		SinglyLinkedList list = this.list;
		Integer valueSearched = 1;
		SinglyListNode expected = null;
		SinglyListNode actual = list.search(valueSearched);
		assertEquals(expected, actual);
	}

	// @Test(timeout = 5000)
	@Test
	public void test05SearchNull() {
		SinglyLinkedList list = this.list;
		Integer[] listValues = { 1, 2, 3 };
		for (int value : listValues) {
			list.addLast(value);
		}
		Integer valueNotAdded = 4;
		SinglyListNode expected = null;
		SinglyListNode actual = list.search(valueNotAdded);
		assertEquals(expected, actual);
	}

	// @Test(timeout = 5000)
	@Test
	public void test06SearchTrue() {
		SinglyLinkedList list = this.list;
		Integer[] listValues = { 1, 2, 3 };
		for (Integer value : listValues) {
			list.addLast(value);
		}
		Integer valueAdded = 2;
		SinglyListNode expected = new SinglyListNode(valueAdded, null);
		SinglyListNode actual = list.search(valueAdded);
		assertEquals(expected, actual);
	}

	// @Test(timeout = 5000)
	@Test
	public void test07SizeEmpty() {
		SinglyLinkedList list = this.list;
		int expected = 0;
		int actual = list.size();
		assertEquals(expected, actual);
	}

	// @Test(timeout = 5000)
	@Test
	public void test08Size3() {
		SinglyLinkedList list = this.list;
		Integer[] valuesAdded = { 1, 2, 3 };
		for (Integer value : valuesAdded) {
			list.addLast(value);
		}
		int expected = 3;
		int actual = list.size();
		assertEquals(expected, actual);
	}

	// @Test(timeout = 5000)
	@Test
	public void test09AddLast() {
		SinglyLinkedList list = this.list;
		Integer[] valuesAdded = { 1, 2, 3 };
		for (Integer value : valuesAdded) {
			list.addLast(value);
		}

		int size = list.size();
		if (size != 3) {
			Assert.fail();
		}
		SinglyListNode node = list.getHead();
		for (Integer expected : valuesAdded) {
			Integer actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getNext();
		}
	}

	@Test
	// @Test(timeout = 5000)
	public void test10Reverse() {
		SinglyLinkedList list = this.list;
		Integer[] valuesAdded = { 1, 2, 3 };
		for (Integer value : valuesAdded) {
			list.addFirst(value);
		}

		list.reverse();

		SinglyListNode node = list.getHead();
		int size = list.size();
		if (size != 3) {
			Assert.fail();
		}
		for (Integer expected : valuesAdded) {
			Integer actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getNext();
		}
	}

	@Test
	public void test11ReverseOneElement() {
		SinglyLinkedList list = this.list;
		Integer[] valuesAdded = { 1 };
		for (Integer value : valuesAdded) {
			list.addFirst(value);
		}

		list.reverse();

		SinglyListNode node = list.getHead();
		int size = list.size();
		if (size != 1) {
			Assert.fail();
		}
		for (Integer expected : valuesAdded) {
			Integer actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getNext();
		}
	}

	// @Test(timeout = 5000)
	@Test
	public void test12IsOrderedFalseAscendingTrue() {
		SinglyLinkedList list = this.list;
		Integer[] valuesNotOrdered = { 2, 1, 3 };
		for (int value : valuesNotOrdered) {
			list.addLast(value);
		}
		boolean expected = false;
		boolean ascending = true;
		boolean actual = list.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	// @Test(timeout = 5000)
	@Test
	public void test13IsOrderedFalseAscendingFalse() {
		SinglyLinkedList list = this.list;
		Integer[] valuesNotOrdered = { 2, 1, 3 };
		for (Integer value : valuesNotOrdered) {
			list.addLast(value);
		}
		boolean expected = false;
		boolean ascending = false;
		boolean actual = list.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	// @Test(timeout = 5000)
	@Test
	public void test14IsOrderedTrueAscendingFalse() {
		SinglyLinkedList list = this.list;
		Integer[] valuesOrderedDescending = { 3, 2, 1 };
		for (int value : valuesOrderedDescending) {
			list.addLast(value);
		}
		boolean expected = true;
		boolean ascending = false;
		boolean actual = list.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	// @Test(timeout = 5000)
	@Test
	public void test15IsOrderedTrueAscendingTrue() {
		SinglyLinkedList list = this.list;
		Integer[] valuesOrderedAscending = { 1, 2, 3 };
		for (int value : valuesOrderedAscending) {
			list.addLast(value);
		}
		boolean expected = true;
		boolean ascending = true;
		boolean actual = list.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	// @Test(timeout = 5000)
	@Test
	public void test16IsOrderedEmptyAscendingTrue() {
		SinglyLinkedList list = this.list;

		boolean expected = true;
		boolean ascending = true;
		boolean actual = list.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	// @Test(timeout = 5000)
	@Test
	public void test17DeleteMiddle() {
		SinglyLinkedList list = new SinglyLinkedList();
		int[] listBeforeDelete = { 1, 2, 3 };
		for (int value : listBeforeDelete) {
			list.addLast(value);
		}
		SinglyListNode nodeDelete = list.search(2);
		Integer[] listAfterDelete = { 1, 3 };
		list.delete(nodeDelete);
		int size = list.size();
		if (size != 2) {
			Assert.fail();
		}
		SinglyListNode node = list.getHead();
		for (Integer expected : listAfterDelete) {
			Integer actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getNext();
		}
	}

	@Test
	public void test18DeleteLast() {
		SinglyLinkedList list = this.list;
		Integer[] listBeforeDelete = { 1, 2, 3 };
		for (Integer value : listBeforeDelete) {
			list.addLast(value);
		}
		SinglyListNode nodeDelete = list.search(3);
		Integer[] listAfterDelete = { 1, 2 };
		list.delete(nodeDelete);
		int size = list.size();
		if (size != 2) {
			Assert.fail();
		}
		SinglyListNode node = list.getHead();
		for (Integer expected : listAfterDelete) {
			Integer actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getNext();
		}
	}

	@Test
	public void test19DeleteThenEmpty() {
		SinglyLinkedList list = this.list;
		Integer[] listBeforeDelete = { 1, 2, 3 };
		for (Integer value : listBeforeDelete) {
			list.addLast(value);
		}

		SinglyListNode nodeDelete;
		nodeDelete = list.search(1);
		list.delete(nodeDelete);

		nodeDelete = list.search(2);
		list.delete(nodeDelete);

		nodeDelete = list.search(3);
		list.delete(nodeDelete);

		int size = list.size();
		if (size != 0) {
			Assert.fail();
		}
		boolean expected = true;
		boolean actual = list.isEmpty();
		Assert.assertEquals(expected, actual);
	}

	// @Test(timeout = 5000)
	@Test
	public void test20DeleteFirst() {
		SinglyLinkedList list = new SinglyLinkedList();
		Integer[] listBeforeDelete = { 1, 2, 3 };
		for (Integer value : listBeforeDelete) {
			list.addLast(value);
		}
		SinglyListNode nodeDelete = list.search(1);
		Integer[] listAfterDelete = { 2, 3 };
		list.delete(nodeDelete);
		SinglyListNode node = list.getHead();
		for (Integer expected : listAfterDelete) {
			Integer actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getNext();
		}
	}

	// @Test(timeout = 5000)
	@Test
	public void test21DeleteBeforeEmpty() {
		SinglyLinkedList list = this.list;
		Integer[] listBeforeDelete = { 1 };
		for (Integer value : listBeforeDelete) {
			list.addLast(value);
		}
		SinglyListNode nodeDelete = list.search(1);
		assertTrue(nodeDelete != null);
		list.delete(nodeDelete);
		assertTrue(list.isEmpty());

	}

	// @Test(timeout = 5000)
	@Test
	public void test22deleteFirstElement() {
		SinglyLinkedList list = new SinglyLinkedList();
		Integer[] listBeforeDelete = { 1, 2, 3 };
		for (Integer value : listBeforeDelete) {
			list.addLast(value);
		}
		SinglyListNode nodeDelete = list.search(1);
		Integer[] listAfterDelete = { 2, 3 };
		list.delete(nodeDelete);
		int size = list.size();
		if (size != 2) {
			Assert.fail();
		}
		SinglyListNode node = list.getHead();
		for (Integer expected : listAfterDelete) {
			Integer actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getNext();
		}
	}
}