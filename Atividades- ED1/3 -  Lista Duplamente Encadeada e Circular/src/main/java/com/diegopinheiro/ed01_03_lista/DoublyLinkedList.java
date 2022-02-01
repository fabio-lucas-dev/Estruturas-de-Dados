package com.diegopinheiro.ed01_03_lista;

public class DoublyLinkedList {

	private DoublyListNode head;
	private DoublyListNode tail;
	private int capacity = 0;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
	}

	public DoublyLinkedList(DoublyLinkedList l) {

		this.head = l.head;
		this.tail = l.tail;
		this.capacity = l.capacity;
	}

	public DoublyListNode getHead() {
		return this.head;
	}

	public DoublyListNode getTail() {
		return this.tail;
	}

	public void setHead(DoublyListNode head) {
		this.head = head;
	}

	public void setTail(DoublyListNode tail) {
		this.tail = tail;
	}

	public boolean isEmpty() {

		return (this.head == null);

	}

	public int size() {

		return this.capacity;
	}

	public void addFirst(Integer i) {
		DoublyListNode newHead = new DoublyListNode(i, this.head, null);
		if (this.isEmpty()) {
			this.tail = newHead;
		} else {
			this.head.setPrevious(newHead);
		}
		this.head = newHead;
		this.capacity++;
	}

	public void addLast(Integer i) {
		DoublyListNode newTail = new DoublyListNode(i, null, this.tail);
		if (this.isEmpty()) {
			this.head = newTail;
		} else {
			this.tail.setNext(newTail);
		}
		this.tail = newTail;
		this.capacity++;
	}

	public DoublyListNode search(Integer i) {

		DoublyListNode node = this.head;
		while (node != null) {
			if (node.getValue() == i) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}

	public void reverse() {
		DoublyListNode current = this.head;
		DoublyListNode aux = null;

		while (current != null) {
			aux = current.getNext();
			current.setNext(current.getPrevious());
			current.setPrevious(aux);
			current = aux;
		}
		aux = this.head;
		this.head = this.tail;
		this.tail = aux;
	}

	public void delete(DoublyListNode nodeDelete) {

		if (nodeDelete == this.head) {
			this.head = this.head.getNext();
			if (this.head != null) {
				this.head.setPrevious(null);
			}
			this.capacity--;
			return;
		}

		if (nodeDelete == this.tail) {
			this.tail = this.tail.getPrevious();
			if (this.tail != null) {
				this.tail.setNext(null);
			}
			this.capacity--;
			return;
		}

		DoublyListNode currentNode = this.head;
		while (currentNode.getNext() != null) {
			if (currentNode.getNext() == nodeDelete) {
				currentNode.setNext(currentNode.getNext().getNext());
				currentNode.getNext().setPrevious(currentNode);
				this.capacity--;
				break;
			}
			currentNode = currentNode.getNext();
		}

	}

	public boolean isOrdered(boolean ascending) {

		if (this.isEmpty()) {
			return true;
		}

		DoublyListNode currentNode = this.head;
		while (currentNode.getNext() != null) {
			DoublyListNode nextNode = currentNode.getNext();
			if (ascending) {
				if (currentNode.getValue() > nextNode.getValue()) {
					return false;
				}
			} else {
				if (currentNode.getValue() < nextNode.getValue()) {
					return false;
				}
			}
			currentNode = currentNode.getNext();
		}

		return true;

	}
}
