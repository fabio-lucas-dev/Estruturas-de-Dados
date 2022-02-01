package com.diegopinheiro.ed1_projectchallenge_01;

public class CircularListNode {

	private Integer value;
	private CircularListNode next;
	private CircularListNode previous;

	public CircularListNode() {

	}

	public CircularListNode(Integer value, CircularListNode next, CircularListNode previous) {
		this.value = value;
		this.next = next;
		this.previous = previous;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public CircularListNode getNext() {
		return next;
	}

	public void setNext(CircularListNode next) {
		this.next = next;
	}

	public CircularListNode getPrevious() {
		return previous;
	}

	public void setPrevious(CircularListNode previous) {
		this.previous = previous;
	}

}
