package com.diegopinheiro.ed01_04_lista;

public class StackCircularLinkedList<Type> implements IStack<Type> {

	private CircularLinkedList<Type> list;

	public StackCircularLinkedList() {

		list = new CircularLinkedList<Type>();
	}

	@Override
	public boolean isEmpty() {

		return this.list.isEmpty();
	}

	@Override
	public void push(Type value) {

		this.list.addLast(value);
	}

	@Override
	public Type pop() throws Exception {

		if (this.isEmpty()) {
			throw new IllegalStateException();
		}

		Type value = this.list.getTail().getValue();
		this.list.delete(this.list.getTail());
		return value;
	}

}
