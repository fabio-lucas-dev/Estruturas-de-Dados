package com.diegopinheiro.ed1_05;

import java.util.List;
import java.util.ArrayList;

public class BinaryTreeWalker<Key extends Comparable<Key>, Value> {

	private BinarySearchTree<Key, Value> bst;

	public BinaryTreeWalker(BinarySearchTree<Key, Value> bst) {
		this.bst = bst;
	}

	public BinarySearchTree<Key, Value> getBst() {
		return bst;
	}

	public List<Key> inOrder() {
		List<Key> list = new ArrayList<>();
		this.inOrder(bst.getRoot(), list);
		return list;
	}

	private void inOrder(Node<Key, Value> node, List<Key> list) {
		if (node == null) {
			return;
		}
		this.inOrder(node.getLeft(), list);
		list.add(node.getKey());
		this.inOrder(node.getRight(), list);
	}

	public List<Key> breadthFirst() {
		List<Key> list = new ArrayList<Key>();
		this.breadthFirst(bst.getRoot(), list);
		return list;

	}

	private void breadthFirst(Node<Key, Value> node, List<Key> list) {
		if (node == null) {
			return;
		}

		if (node.getLeft() != null) {
			list.add(node.getKey());
		}

		if (node.getRight() != null) {
			list.add(node.getKey());
		}

		this.breadthFirst(node.getLeft(), list);
		this.breadthFirst(node.getRight(), list);

	}

	public List<Key> preorder() {
		List<Key> list = new ArrayList<Key>();
		this.preorder(bst.getRoot(), list);
		return list;
	}

	private void preorder(Node<Key, Value> node, List<Key> list) {
		if (node == null) {
			return;
		}

		list.add(node.getKey());
		this.preorder(node.getLeft(), list);
		this.preorder(node.getRight(), list);

	}

	public List<Key> postorder() {
		List<Key> list = new ArrayList<Key>();
		this.postorder(bst.getRoot(), list);
		return list;
	}

	private void postorder(Node<Key, Value> node, List<Key> list) {
		if (node == null) {
			return;
		}
		this.postorder(node.getLeft(), list);
		this.postorder(node.getRight(), list);
		list.add(node.getKey());
	}

}
