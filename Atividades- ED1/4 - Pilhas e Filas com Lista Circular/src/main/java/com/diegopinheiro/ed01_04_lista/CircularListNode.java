package com.diegopinheiro.ed01_04_lista;

public class CircularListNode<Type> {

	private Type value;
	private CircularListNode<Type> next;
	private CircularListNode<Type> previous;

	public CircularListNode() {

	}

	public CircularListNode(Type value, CircularListNode<Type> next, CircularListNode<Type> previous) {
		this.value = value;
		this.next = next;
		this.previous = previous;
	}

	public Type getValue() {
		return value;
	}

	public void setValue(Type value) {
		this.value = value;
	}

	public CircularListNode<Type> getNext() {
		return next;
	}

	public void setNext(CircularListNode<Type> next) {
		this.next = next;
	}

	public CircularListNode<Type> getPrevious() {
		return previous;
	}

	public void setPrevious(CircularListNode<Type> previous) {
		this.previous = previous;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (obj instanceof CircularListNode<?>) {
			CircularListNode<?> other = (CircularListNode<?>) obj;
			return this.value.equals(other.value);
		}

		return false;
	}
}
