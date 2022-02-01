package com.diegopinheiro.ed1_05;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	private Node<Key, Value> root;

	public Node<Key, Value> getRoot() {
		return root;
	}

	public void setRoot(Node<Key, Value> root) {
		this.root = root;
	}

	public Value get(Key key) {
		return get(this.root, key);
	}

	private Value get(Node<Key, Value> node, Key key) {
		if (node == null) {
			return null;
		}

		int result = key.compareTo(node.getKey());
		if (result < 0) {
			return get(node.getLeft(), key);
		} else if (result > 0) {
			return get(node.getRight(), key);
		} else {
			return node.getValue();
		}

	}

	public void put(Key key, Value value) {
		this.root = put(this.root, key, value);
	}

	private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {

		if (node == null) {
			return new Node<Key, Value>(key, value, 1);
		}

		int result = key.compareTo(node.getKey());
		if (result < 0) {
			Node<Key, Value> leftNode = this.put(node.getLeft(), key, value);
			node.setLeft(leftNode);
		} else if (result > 0) {
			Node<Key, Value> rightNode = this.put(node.getRight(), key, value);
			node.setRight(rightNode);
		} else {
			node.setValue(value);
		}

		int newSize = this.size(node.getLeft()) + this.size(node.getRight()) + 1;
		node.setSize(newSize);
		return node;
	}

	public int size() {

		return this.size(this.root);
	}

	private int size(Node<Key, Value> node) {
		if (node == null) {
			return 0;
		} else {
			return node.getSize();
		}
	}

	public Key min() {
		if (this.root == null) {
			return null;
		} else {
			return this.min(this.root);
		}
	}

	private Key min(Node<Key, Value> node) {
		if (node.getLeft() == null) {
			return node.getKey();
		} else {
			return this.min(node.getLeft());
		}
	}

	public Key max() {
		if (this.root == null) {
			return null;
		}
		Node<Key, Value> node = this.root;
		while (node.getRight() != null) {
			node = node.getRight();
		}
		return node.getKey();
	}

	public void delete(Key key) {

		// Estarei implementando posteriormente para aprendizado

	}
}
