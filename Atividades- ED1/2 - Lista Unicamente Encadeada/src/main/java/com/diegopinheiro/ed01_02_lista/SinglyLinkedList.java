package com.diegopinheiro.ed01_02_lista;

public class SinglyLinkedList {

	private SinglyListNode head;

	public SinglyLinkedList() {
		this.head = null;
	}

	public SinglyListNode getHead() {

		return this.head;
	}

	public boolean isEmpty() {

		return (this.head == null);

	}

	public void addFirst(Integer value) {
		SinglyListNode newHead = new SinglyListNode(value, this.head);
		this.head = newHead;
	}

	public void addLast(Integer value) {
		SinglyListNode newTail = new SinglyListNode(value, null);
		if (this.isEmpty()) {
			this.head = newTail;
			return;
		}
		SinglyListNode aux = this.head;
		while (aux.getNext() != null) {

			aux = aux.getNext();
		}
		aux.setNext(newTail);

	}

	public SinglyListNode search(Integer value) {

		SinglyListNode aux = this.head;

		while (aux != null) {
			if (aux.getValue() == value) {
				return aux;
			}

			aux = aux.getNext();

		}
		return null;

	}

	public int size() {
		int size = 0;
		SinglyListNode current = this.head;
		while (current != null) {
			current = current.getNext();
			size++;
		}
		return size;
	}

	public boolean isOrdered(boolean ascending) {

		if (this.isEmpty()) {
			return true;
		}

		SinglyListNode currentNode = this.head;
		while (currentNode.getNext() != null) {
			SinglyListNode nextNode = currentNode.getNext();
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

	public void reverse() {

		SinglyListNode previous = null;
		SinglyListNode current = this.head;
		SinglyListNode next = null;

		while (current != null) {
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		this.head = previous;

	}

	public void delete(SinglyListNode nodeDelete) {

		if (this.head == nodeDelete) {
			this.head = this.head.getNext();
			return;
		}

		SinglyListNode current = this.head;
		while (current != null) {
			if (current.getNext() == nodeDelete) {
				current.setNext(current.getNext().getNext());
				break;
			}
			current = current.getNext();
		}
	}

}
