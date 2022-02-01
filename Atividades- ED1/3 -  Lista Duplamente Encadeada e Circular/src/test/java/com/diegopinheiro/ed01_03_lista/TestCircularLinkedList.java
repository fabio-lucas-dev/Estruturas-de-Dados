package com.diegopinheiro.ed01_03_lista;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class TestCircularLinkedList {

	@Test
//	@Test(timeout = 5000)
	public void test01EmptyTrue()
	{
		CircularLinkedList l = new CircularLinkedList();
		assertTrue(l.isEmpty());
	}

	@Test
//	@Test(timeout = 5000)
	public void testEmptyFalse()
	{
		CircularLinkedList l = new CircularLinkedList();
		l.addFirst(0);
		assertTrue(!l.isEmpty());
	}

	@Test
//	@Test(timeout = 5000)
	public void test02AddFirst()
	{
		CircularLinkedList l = new CircularLinkedList();
		int[] list_expected = {1,2,3};
		for (int i: list_expected ) {
			l.addFirst(i);
		}

		CircularListNode node = l.getTail();
		int size = l.size();
		if(size != 3) {
			Assert.fail();
		}
		for (int expected: list_expected  ) {
			int actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getPrevious();
		}      
	}

	@Test
//	@Test(timeout = 5000)
	public void test03AddLast()
	{
		CircularLinkedList l = new CircularLinkedList();
		int[] list_expected = {1,2,3};
		for (int i: list_expected ) {
			l.addLast(i);
		}

		int[] list_expected_reversed = {3,2,1};
		int size = l.size();
		if(size != 3) {
			Assert.fail();
		}
		CircularListNode node = l.getTail();
		for (int expected: list_expected_reversed  ) {
			int actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getPrevious();
		}       
	}

	@Test
//	@Test(timeout = 5000)
	public void test04Reverse()
	{
		CircularLinkedList l = new CircularLinkedList();

		int[] listOriginal = {1,2,3};
		for (int i: listOriginal ) {
			l.addLast(i);
		}

		l.reverse();
		int[] listReversed = {3,2,1};
		CircularListNode nodeHead = l.getHead();
		CircularListNode nodeTail = l.getTail();

		int i = 0;
		int size = l.size();
		if(size != 3) {
			Assert.fail();
		}
		while (i < size) {
			int actualHead = nodeHead.getValue();
			Assert.assertEquals(listReversed[i], actualHead);
			int actualTail = nodeTail.getValue();
			assertEquals(listOriginal[i], actualTail);
			nodeHead = nodeHead.getNext();
			nodeTail = nodeTail.getPrevious();
			i ++;
		}     

	}

	@Test
//	@Test(timeout = 5000)
	public void test05IsOrderedFalseAscendingTrue() 
	{
		CircularLinkedList l = new CircularLinkedList();
		int[] list_ordered_false = {2,1,3};
		for (int i: list_ordered_false ) {
			l.addLast(i);
		}
		boolean expected = false;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}


	@Test
//	@Test(timeout = 5000)
	public void test06IsOrderedFalseAscendingFalse() 
	{
		CircularLinkedList l = new CircularLinkedList();
		int[] list_ordered_false = {2,1,3};
		for (int i: list_ordered_false ) {
			l.addLast(i);
		}
		boolean expected = false;
		boolean ascending = false;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	@Test
//	@Test(timeout = 5000)
	public void test07IsOrderedTrueAscendingFalse() 
	{
		CircularLinkedList l = new CircularLinkedList();
		int[] list_ordered_false = {3,2,1};
		for (int i: list_ordered_false ) {
			l.addLast(i);
		}
		boolean expected = true;
		boolean ascending = false;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	@Test
//	@Test(timeout = 5000)
	public void test08IsOrderedTrueAscendingTrue() 
	{
		CircularLinkedList l = new CircularLinkedList();
		int[] list_ordered_false = {1,2, 3};
		for (int i: list_ordered_false ) {
			l.addLast(i);
		}
		boolean expected = true;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	@Test
//	@Test(timeout = 5000)
	public void test09IsOrderedEmptyAscendingTrue()
	{
		CircularLinkedList l = new CircularLinkedList();

		boolean expected = true;
		boolean ascending = true;
		boolean actual = l.isOrdered(ascending);
		assertEquals(expected, actual);
	}

	@Test
//	@Test(timeout = 5000)
	public void test10deleteBeforeEmpty() {
		CircularLinkedList l = new CircularLinkedList();
		int[] listBeforeDelete = {1};
		for (int i: listBeforeDelete ) {
			l.addLast(i);
		}
		CircularListNode nodeDelete = l.search(1);
		assertTrue(nodeDelete != null);
		l.delete(nodeDelete);
		assertTrue(l.isEmpty()); 
	}

	@Test
//	@Test(timeout = 5000)
	public void test11DeleteThenEmpty() {
		CircularLinkedList l = new CircularLinkedList();
		int[] listBeforeDelete = {1,2,3};
		for (int i: listBeforeDelete ) {
			l.addLast(i);
		}

		CircularListNode nodeDelete;
		nodeDelete = l.search(1);
		l.delete(nodeDelete);

		nodeDelete = l.search(2);
		l.delete(nodeDelete);

		nodeDelete = l.search(3);
		l.delete(nodeDelete);


		int size = l.size();
		if(size != 0) {
			Assert.fail();
		}
		boolean expected = true;
		boolean actual = l.isEmpty();
		Assert.assertEquals(expected, actual);       
	}

	@Test
//	@Test(timeout = 5000)
	public void test12DeleteFirstElement() {
		CircularLinkedList l = new CircularLinkedList();
		int[] listBeforeDelete = {1,2,3};
		for (int i: listBeforeDelete ) {
			l.addLast(i);
		}
		CircularListNode nodeDelete = l.search(1);
		int[] listAfterDelete = {3,2};
		l.delete(nodeDelete);
		int size = l.size();
		if(size != 2) {
			Assert.fail();
		}
		CircularListNode node = l.getTail();
		for (int expected: listAfterDelete  ) {
			int actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getPrevious();
		}      
	}

	@Test
//	@Test(timeout = 5000)
	public void test13DeleteLastElement() {
		CircularLinkedList l = new CircularLinkedList();
		int[] listBeforeDelete = {1,2,3};
		for (int i: listBeforeDelete ) {
			l.addLast(i);
		}
		CircularListNode nodeDelete = l.search(3);
		int[] listAfterDelete = {2,1};
		l.delete(nodeDelete);
		int size = l.size();
		if(size != 2) {
			Assert.fail();
		}
		CircularListNode node = l.getTail();
		for (int expected: listAfterDelete  ) {
			int actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getPrevious();
		}      
	}

	@Test
//	@Test(timeout = 5000)
	public void test14DeleteMiddleElement() {
		CircularLinkedList l = new CircularLinkedList();
		int[] listBeforeDelete = {1,2,3};
		for (int i: listBeforeDelete ) {
			l.addLast(i);
		}
		CircularListNode nodeDelete = l.search(2);
		int[] listAfterDelete = {3,1};
		l.delete(nodeDelete);
		int size = l.size();
		if(size != 2) {
			Assert.fail();
		}
		CircularListNode node = l.getTail();
		for (int expected: listAfterDelete  ) {
			int actual = node.getValue();
			assertEquals(expected, actual);
			node = node.getPrevious();
		}       
	}

	@Test
//	@Test(timeout = 5000)
	public void test15EqualsTrue()
	{
		CircularLinkedList l1 = new CircularLinkedList();
		CircularLinkedList l2 = new CircularLinkedList();
		int[] list_elements = {1,2,3};
		for (int i: list_elements ) {
			l1.addFirst(i);
			l2.addFirst(i);
		}

		boolean isEquals = l1.isEquals(l2);
		Assert.assertTrue(isEquals);
	}

	@Test
//	@Test(timeout = 5000)
	public void test16EqualsFalse()
	{
		CircularLinkedList l1 = new CircularLinkedList();
		CircularLinkedList l2 = new CircularLinkedList();
		int[] list_elements = {1,2,3};
		for (int i: list_elements ) {
			l1.addFirst(i);
			l2.addLast(i);
		}

		boolean isEquals = l1.isEquals(l2);
		Assert.assertFalse(isEquals);
	}

	@Test
//	@Test(timeout = 5000)
	public void test17CopyEmpty()
	{
		CircularLinkedList listOriginal = new CircularLinkedList();

		CircularLinkedList listCopy = listOriginal.copy();
		Assert.assertFalse(listOriginal == listCopy);
		Assert.assertTrue(listCopy.isEmpty());
	}


	@Test
//	@Test(timeout = 5000)
	public void test18CopyNotEmpty()
	{
		CircularLinkedList listOriginal = new CircularLinkedList();
		int[] list_elements = {1,2,3};
		for (int i: list_elements ) {
			listOriginal.addLast(i);
		}
		CircularLinkedList listCopy = listOriginal.copy();
		Assert.assertTrue(listOriginal != listCopy);
		CircularListNode nodeOriginal = listOriginal.getHead();
		CircularListNode nodeCopy = listCopy.getHead();
		int i =0;
		int size = listOriginal.size();

		if(size != 3) {
			Assert.fail();
		}
		while (i < size) {
			Assert.assertEquals(nodeOriginal.getValue(), nodeCopy.getValue());
			nodeOriginal = nodeOriginal.getNext();
			nodeCopy = nodeCopy.getNext();
			i++;
		} 
	}

	@Test
//	@Test(timeout = 5000)
	public void test19GetEmpty()
	{
		CircularLinkedList listOriginal = new CircularLinkedList();

		try {
			listOriginal.get(0);
			Assert.fail("List is empty");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}

	}

	@Test
//	@Test(timeout = 5000)
	public void test20GetNotEmpty()
	{
		CircularLinkedList listOriginal = new CircularLinkedList();
		int[] list_elements = {1,2,3};
		for (int i: list_elements ) {
			listOriginal.addLast(i);
		}

		try {
			Assert.assertEquals(1, listOriginal.get(0));
			Assert.assertEquals(2, listOriginal.get(1));
			Assert.assertEquals(3, listOriginal.get(2));
			Assert.assertEquals(1, listOriginal.get(3));
			Assert.assertEquals(2, listOriginal.get(4));
			Assert.assertEquals(3, listOriginal.get(5));
			Assert.assertEquals(1, listOriginal.get(6));
			Assert.assertEquals(2, listOriginal.get(7));
			Assert.assertEquals(3, listOriginal.get(8));
		} catch (Exception e) {
			Assert.fail("List not empty");
		}
	}
	
	@Test
	public void test21SuccessorNotSentinel() {
		CircularLinkedList list = new CircularLinkedList();
		int[] listElements = {1,2,3};
		for (int i: listElements ) {
			list.addLast(i);
		}
		CircularListNode currentNode = list.search(2);
		CircularListNode sucessorExpected = list.search(3);
		try {
			CircularListNode sucessorActual = list.getSuccessor(currentNode);
			Assert.assertEquals(sucessorExpected, sucessorActual);	
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	public void test22SuccessorSentinel() {
		CircularLinkedList list = new CircularLinkedList();
		int[] listElements = {1,2,3};
		for (int i: listElements ) {
			list.addLast(i);
		}
		
		CircularListNode currentNode = list.search(3);
		CircularListNode sucessorExpected = list.search(1);
		try {
			CircularListNode sucessorActual = list.getSuccessor(currentNode);
			Assert.assertEquals(sucessorExpected, sucessorActual);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	public void test23SuccessorEmpty() {
		CircularLinkedList list = new CircularLinkedList();
		
		CircularListNode anyNode = new CircularListNode(0, null, null);
		try {
			 list.getSuccessor(anyNode);
			Assert.fail("Circular list is empty");
		} catch (Exception e) {
			
		}
	}

	@Test
	public void test24SuccessorSentinelBigList() {
		CircularLinkedList list = new CircularLinkedList();
		int[] listElements = {1,2,3,4,5,6,7,8,9,10,11};
		for (int i: listElements ) {
			list.addLast(i);
		}
		
		CircularListNode currentNode = list.search(11);
		CircularListNode sucessorExpected = list.search(1);
		try {
			CircularListNode sucessorActual = list.getSuccessor(currentNode);
			Assert.assertEquals(sucessorExpected, sucessorActual);
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
}
