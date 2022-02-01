package com.diegopinheiro.ed1_projectchallenge_01;

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

	public int get(CircularListNode currentNode, int index) {
		if (this.isEmpty()) {
			return 0;
		}
		for (int i = 0; i < index; i++) {
			currentNode = getSuccessor(currentNode);

		}
		return currentNode.getValue();
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
