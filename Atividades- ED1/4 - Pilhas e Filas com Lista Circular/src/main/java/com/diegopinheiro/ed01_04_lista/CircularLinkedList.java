package com.diegopinheiro.ed01_04_lista;

public class CircularLinkedList<Type> {

	private CircularListNode<Type> sentinel;
	private int capacity = 0;

	public CircularLinkedList() {
		this.sentinel = new CircularListNode<Type>();
		this.sentinel.setNext(sentinel);
		this.sentinel.setPrevious(sentinel);
	}

	public CircularListNode<Type> getHead() {

		return this.sentinel.getNext();
	}

	public CircularListNode<Type> getTail() {

		return this.sentinel.getPrevious();
	}

	public void setHead(CircularListNode<Type> newHead) {
		this.sentinel.setNext(newHead);
	}

	public void setTail(CircularListNode<Type> newTail) {
		this.sentinel.setPrevious(newTail);
	}

	public int size() {

		return this.capacity;
	}

	public boolean isEmpty() {

		return this.getHead() == this.sentinel && this.getTail() == this.sentinel;
	}

	public void addFirst(Type i) {
		CircularListNode<Type> oldHead = this.getHead();
		CircularListNode<Type> newHead = new CircularListNode<Type>(i, oldHead, this.sentinel);
		oldHead.setPrevious(newHead);
		this.setHead(newHead);
		this.capacity++;

	}

	public void addLast(Type i) {
		CircularListNode<Type> oldTail = this.getTail();
		CircularListNode<Type> newTail = new CircularListNode<Type>(i, this.sentinel, oldTail);
		oldTail.setNext(newTail);
		this.setTail(newTail);
		this.capacity++;
	}

	public CircularListNode<Type> search(Type i) {
		CircularListNode<Type> node = this.getHead();
		while (node != this.sentinel) {
			if (node.getValue() == i) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}

	public void delete(CircularListNode<Type> nodeDelete) {

		nodeDelete.getPrevious().setNext(nodeDelete.getNext());
		nodeDelete.getNext().setPrevious(nodeDelete.getPrevious());
		this.capacity--;

	}

	

	public void reverse() {
		CircularListNode<Type> currentNode = this.sentinel;
		do {
			CircularListNode<Type> aux = currentNode.getNext();
			currentNode.setNext(currentNode.getPrevious());
			currentNode.setPrevious(aux);
			currentNode = aux;
		} while (currentNode != this.sentinel);

	}

	public CircularLinkedList<Type> copy() {

		CircularLinkedList<Type> copiedList = new CircularLinkedList<Type>();
		if (this.isEmpty()) {
			return copiedList;
		}

		CircularListNode<Type> aux = this.getHead();
		do {
			copiedList.addLast(aux.getValue());
			aux = aux.getNext();
		} while (aux != this.sentinel);
		return copiedList;
	}

	public boolean isEquals(CircularLinkedList<Type> l2) {

		if (this == l2) {
			return true;
		}

		CircularListNode<Type> nodeL1 = this.getHead();
		CircularListNode<Type> nodeL2 = l2.getHead();
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
		CircularListNode<Type> aux = this.getHead();
		for (int i = 0; i <= index; i++) {
			value = (int) aux.getValue();
			aux = this.getSuccessor(aux);
		}

		return value;
	}

	public CircularListNode<Type> getSuccessor(CircularListNode<Type> currentNode) {
		if (this.isEmpty()) {
			throw new IllegalStateException();
		}
		if (currentNode == this.getTail()) {
			return this.getHead();
		}

		return currentNode.getNext();

	}

}
