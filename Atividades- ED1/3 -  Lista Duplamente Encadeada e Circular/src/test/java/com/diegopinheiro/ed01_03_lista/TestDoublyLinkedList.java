package com.diegopinheiro.ed01_03_lista;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class TestDoublyLinkedList {
	@Test(timeout = 5000)
	public void test01EmptyTrue() {
		DoublyLinkedList l = new DoublyLinkedList();
		assertTrue(l.isEmpty());
	}

	@Test(timeout = 5000)
	public void testEmptyFalse() {
		DoublyLinkedList l = new DoublyLinkedList();
		l.addFirst(0);
		assertTrue(!l.isEmpty());
	}

	@Test(timeout = 5000)
	public void test02AddFirst() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_expected = { 1, 2, 3 };
		for (int i : list_expected) {
			l.addFirst(i);
		}

		DoublyListNode node = l.getTail();
		for (int expected : list_expected) {
			int actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getPrevious();
		}
	}

	@Test(timeout = 5000)
	public void test03SearchEmpty() {
		DoublyLinkedList l = new DoublyLinkedList();
		DoublyListNode expected = null;
		DoublyListNode actual = l.search(1);
		assertEquals(expected, actual);
	}

	@Test(timeout = 5000)
	public void testSearchNull() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_expected = { 1, 2, 3 };
		for (int i : list_expected) {
			l.addLast(i);
		}
		DoublyListNode expected = null;
		DoublyListNode actual = l.search(4);
		assertEquals(expected, actual);
	}

	@Test(timeout = 5000)
	public void test04SearchTrue() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_expected = { 1, 2, 3 };
		for (int i : list_expected) {
			l.addLast(i);
		}
		DoublyListNode expected = new DoublyListNode(2, null, null);
		DoublyListNode actual = l.search(2);
		assertEquals(expected, actual);
	}

	@Test(timeout = 5000)
	public void testSizeEmpty() {
		DoublyLinkedList l = new DoublyLinkedList();
		int expected = 0;
		int actual = l.size();
		assertEquals(expected, actual);
	}

	@Test(timeout = 5000)
	public void test05Size3() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_expected = { 1, 2, 3 };
		for (int i : list_expected) {
			l.addLast(i);
		}
		int expected = 3;
		int actual = l.size();
		assertEquals(expected, actual);
	}

//	@Test(timeout = 5000)
	@Test
	public void test06AddLast() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_expected = { 1, 2, 3 };
		for (int i : list_expected) {
			l.addLast(i);
		}

		int size = l.size();
		if (size != 3) {
			Assert.fail();
		}

		int[] list_expected_reversed = { 3, 2, 1 };
		DoublyListNode node = l.getTail();
		for (int expected : list_expected_reversed) {
			int actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getPrevious();
		}
	}

	@Test
//	@Test(timeout = 5000)
	public void test07Reverse() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listOriginal = { 1, 2, 3 };
		for (int i : listOriginal) {
			l.addLast(i);
		}

		l.reverse();
		int[] listReversed = { 3, 2, 1 };
		DoublyListNode nodeHead = l.getHead();
		DoublyListNode nodeTail = l.getTail();
		int i = 0;
		int size = l.size();
		if (size != 3) {
			Assert.fail();
		}

		while (i < size) {
			int actualHead = nodeHead.getValue();
			Assert.assertEquals(listReversed[i], actualHead);
			int actualTail = nodeTail.getValue();
			assertEquals(listOriginal[i], actualTail);
			nodeHead = nodeHead.getNext();
			nodeTail = nodeTail.getPrevious();
			i++;
		}
	}

	@Test
//	@Test(timeout = 5000)
	public void test08ReverseOneElement() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listOriginal = { 1 };
		for (int i : listOriginal) {
			l.addLast(i);
		}

		l.reverse();
		int[] listReversed = { 1 };
		DoublyListNode nodeHead = l.getHead();
		DoublyListNode nodeTail = l.getTail();
		int i = 0;
		int size = l.size();
		while (i < size) {
			int actualHead = nodeHead.getValue();
			Assert.assertEquals(listReversed[i], actualHead);
			int actualTail = nodeTail.getValue();
			assertEquals(listOriginal[i], actualTail);
			nodeHead = nodeHead.getNext();
			nodeTail = nodeTail.getPrevious();
			i++;
		}
	}

	@Test(timeout = 5000)
	public void test09IsOrderedFalseAscendingTrue() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_ordered_false = { 2, 1, 3 };
		for (int i : list_ordered_false) {
			l.addLast(i);
		}
		boolean expected = false;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	@Test(timeout = 5000)
	public void test10IsOrderedFalseAscendingFalse() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_ordered_false = { 2, 1, 3 };
		for (int i : list_ordered_false) {
			l.addLast(i);
		}
		boolean expected = false;
		boolean ascending = false;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	@Test(timeout = 5000)
	public void test11IsOrderedTrueAscendingFalse() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_ordered_false = { 3, 2, 1 };
		for (int i : list_ordered_false) {
			l.addLast(i);
		}
		boolean expected = true;
		boolean ascending = false;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	@Test(timeout = 5000)
	public void test12IsOrderedTrueAscendingTrue() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] list_ordered_false = { 1, 2, 3 };
		for (int i : list_ordered_false) {
			l.addLast(i);
		}
		boolean expected = true;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	@Test(timeout = 5000)
	public void test13IsOrderedEmptyAscendingTrue() {
		DoublyLinkedList l = new DoublyLinkedList();

		boolean expected = true;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	@Test(timeout = 5000)
	public void test14DeleteBeforeEmpty() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = { 1 };
		for (int i : listBeforeDelete) {
			l.addLast(i);
		}
		DoublyListNode nodeDelete = l.search(1);
		assertTrue(nodeDelete != null);
		l.delete(nodeDelete);
		assertTrue(l.isEmpty());

	}

	@Test(timeout = 5000)
	public void test15DeleteFirstElement() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = { 1, 2, 3 };
		for (int i : listBeforeDelete) {
			l.addLast(i);
		}
		DoublyListNode nodeDelete = l.search(1);
		int[] listAfterDelete = { 3, 2 };
		l.delete(nodeDelete);
		DoublyListNode node = l.getTail();
		for (int expected : listAfterDelete) {
			int actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getPrevious();
		}
	}

	@Test(timeout = 5000)
	public void test16DeleteLastElement() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = { 1, 2, 3 };
		for (int i : listBeforeDelete) {
			l.addLast(i);
		}
		DoublyListNode nodeDelete = l.search(3);
		int[] listAfterDelete = { 2, 1 };
		l.delete(nodeDelete);
		DoublyListNode node = l.getTail();
		for (int expected : listAfterDelete) {
			int actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getPrevious();
		}
	}

	@Test(timeout = 5000)
	public void test17DeleteMiddleElement() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = { 1, 2, 3 };
		for (int i : listBeforeDelete) {
			l.addLast(i);
		}
		DoublyListNode nodeDelete = l.search(2);
		int[] listAfterDelete = { 3, 1 };
		l.delete(nodeDelete);
		DoublyListNode node = l.getTail();
		for (int expected : listAfterDelete) {
			int actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getPrevious();
		}

	}

	@Test
	public void test18DeleteThenEmpty() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] listBeforeDelete = { 1, 2, 3 };
		for (int i : listBeforeDelete) {
			l.addLast(i);
		}

		DoublyListNode nodeDelete;
		nodeDelete = l.search(1);
		l.delete(nodeDelete);

		nodeDelete = l.search(2);
		l.delete(nodeDelete);

		nodeDelete = l.search(3);
		l.delete(nodeDelete);

		int size = l.size();
		if (size != 0) {
			Assert.fail();
		}
		boolean expected = true;
		boolean actual = l.isEmpty();
		Assert.assertEquals(expected, actual);
	}

	@Test(timeout = 5000)
	public void test19IsPalindromeTrue() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] a = { 1, 5, 5, 1 };
		for (int i : a) {
			l.addLast(i);
		}
		boolean result = Utils.isPalindrome(l);
		Assert.assertTrue(result);
	}

	//@Test(timeout = 5000)
	@Test
	public void test20IsPalindromeFalse() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] a = { 1, 5, 4, 1 };
		for (int i : a) {
			l.addLast(i);
		}
		boolean result = Utils.isPalindrome(l);
		Assert.assertTrue(!result);
	}

	@Test(timeout = 5000)
	public void test21IsPalindromeUnit() {
		DoublyLinkedList l = new DoublyLinkedList();
		int[] a = { 1 };
		for (int i : a) {
			l.addLast(i);
		}
		boolean result = Utils.isPalindrome(l);
		Assert.assertTrue(result);
	}
}
