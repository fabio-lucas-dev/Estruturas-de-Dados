package com.diegopinheiro.ed01_03_lista;

public class CircularLinkedList {

	private CircularListNode sentinel;
	private int capacity = 0;

	public CircularLinkedList() {
		this.sentinel = new CircularListNode();
		this.sentinel.setNext(sentinel);
		this.sentinel.setPrevious(sentinel);
	}

	public CircularListNode getHead() {

		return this.sentinel.getNext();
	}

	public CircularListNode getTail() {

		return this.sentinel.getPrevious();
	}

	public void setHead(CircularListNode newHead) {
		this.sentinel.setNext(newHead);
	}

	public void setTail(CircularListNode newTail) {
		this.sentinel.setPrevious(newTail);
	}

	public int size() {

		return this.capacity;
	}

	public boolean isEmpty() {

		return this.getHead() == this.sentinel && this.getTail() == this.sentinel;
	}

	public void addFirst(Integer i) {
		CircularListNode oldHead = this.getHead();
		CircularListNode newHead = new CircularListNode(i, oldHead, this.sentinel);
		oldHead.setPrevious(newHead);
		this.setHead(newHead);
		this.capacity++;

	}

	public void addLast(Integer i) {
		CircularListNode oldTail = this.getTail();
		CircularListNode newTail = new CircularListNode(i, this.sentinel, oldTail);
		oldTail.setNext(newTail);
		this.setTail(newTail);
		this.capacity++;
	}

	public CircularListNode search(Integer i) {
		CircularListNode node = this.getHead();
		while (node != this.sentinel) {
			if (node.getValue() == i) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}

	public void delete(CircularListNode nodeDelete) {

		nodeDelete.getPrevious().setNext(nodeDelete.getNext());
		nodeDelete.getNext().setPrevious(nodeDelete.getPrevious());
		this.capacity--;

	}

	public boolean isOrdered(boolean ascending) {

		CircularListNode currentNode = this.getHead();
		while (currentNode.getNext() != this.sentinel) {
			CircularListNode nextNode = currentNode.getNext();
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
		CircularListNode currentNode = this.sentinel;
		do {
			CircularListNode aux = currentNode.getNext();
			currentNode.setNext(currentNode.getPrevious());
			currentNode.setPrevious(aux);
			currentNode = aux;
		} while (currentNode != this.sentinel);

	}

	public CircularLinkedList copy() {

		CircularLinkedList copiedList = new CircularLinkedList();
		if (this.isEmpty()) {
			return copiedList;
		}

		CircularListNode aux = this.getHead();
		do {
			copiedList.addLast(aux.getValue());
			aux = aux.getNext();
		} while (aux != this.sentinel);
		return copiedList;
	}

	public boolean isEquals(CircularLinkedList l2) {

		if (this == l2) {
			return true;
		}

		CircularListNode nodeL1 = this.getHead();
		CircularListNode nodeL2 = l2.getHead();
		int contNode = 0;
		do {
			if (nodeL1.equals(nodeL2)) {
				contNode++;
			}
			nodeL1 = nodeL1.getNext();
			nodeL2 = nodeL2.getNext();
		} while (nodeL1 != this.sentinel);

		if (contNode == this.size()) {
			return true;
		}
		return false;
	}

	public int get(int index) {
		int value = 0;
		CircularListNode aux = this.getHead();
		for (int i = 0; i <= index; i++) {
			value = aux.getValue();
			aux = this.getSuccessor(aux);
		}

		return value;
	}

	public CircularListNode getSuccessor(CircularListNode currentNode) {
		if (this.isEmpty()) {
			throw new IllegalStateException();
		}
		if (currentNode == this.getTail()) {
			return this.getHead();
		}

		return currentNode.getNext();

	}

}
