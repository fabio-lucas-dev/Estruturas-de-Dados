package com.diegopinheiro.ed01_04_lista;

public class QueueCircularLinkedList<Type> implements IQueue<Type> {

	private CircularLinkedList<Type> list;

	public QueueCircularLinkedList() {

		list = new CircularLinkedList<Type>();
	}

	@Override
	public void enqueue(Type value) {

		this.list.addLast(value);
	}

	@Override
	public Type dequeue() throws Exception {

		if (this.isEmpty()) {
			throw new IllegalStateException();
		}

		Type value = this.list.getHead().getValue();
		this.list.delete(this.list.getHead());
		return value;
	}

	@Override
	public boolean isEmpty() {

		return this.list.isEmpty();
	}

}
