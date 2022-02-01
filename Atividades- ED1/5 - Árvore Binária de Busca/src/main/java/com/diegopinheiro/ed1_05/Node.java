package com.diegopinheiro.ed1_05;

public class Node<Key extends Comparable<Key>, Value> {

	private Key key;
	private Value value;
	private Node<Key, Value> left;
	private Node<Key, Value> right;
	private int size;

	public Node() {

	}

	public Node(Key key, Value value, int size) {
		super();
		this.key = key;
		this.value = value;
		this.size = size;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public Node<Key, Value> getLeft() {
		return left;
	}

	public void setLeft(Node<Key, Value> left) {
		this.left = left;
	}

	public Node<Key, Value> getRight() {
		return right;
	}

	public void setRight(Node<Key, Value> right) {
		this.right = right;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
