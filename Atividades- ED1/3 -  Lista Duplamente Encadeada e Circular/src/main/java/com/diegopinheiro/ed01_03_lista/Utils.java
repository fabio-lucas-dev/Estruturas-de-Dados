package com.diegopinheiro.ed01_03_lista;

public class Utils {

	public static boolean isPalindrome(DoublyLinkedList l) {

		DoublyLinkedList reversedList = new DoublyLinkedList(l);
		reversedList.reverse();
		DoublyListNode originalNode = l.getHead();
		DoublyListNode reversedNode = reversedList.getHead();
		while (originalNode != null) {
			if (!originalNode.equals(reversedNode)) {
				return false;
			}
			originalNode = originalNode.getPrevious();
			reversedNode = reversedNode.getNext();
		}
		return true;

	}

}
