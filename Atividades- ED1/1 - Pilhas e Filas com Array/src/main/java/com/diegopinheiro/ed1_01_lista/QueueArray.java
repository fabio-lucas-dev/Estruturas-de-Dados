package com.diegopinheiro.ed1_01_lista;

public class QueueArray implements IQueue {

	private Integer queue[];
	private int first;
	private int last;
	private int total;

	public QueueArray(int capacity) {
		this.queue = new Integer[capacity];
		this.first = 0;
		this.last = 0;
		this.total = 0;

	}

	@Override
	public void enqueue(Integer value) {

		if (this.isFull()) {
			throw new IllegalStateException();
		}

		this.queue[last] = value;
		this.last = (this.last + 1) % this.queue.length;

		this.total++;

	}

	@Override
	public Integer dequeue() throws Exception { 

		Integer dequeueValue;

		if (this.isEmpty()) {
			throw new IllegalStateException();
		}

		dequeueValue = this.queue[first];
		this.first = (this.first + 1) % this.queue.length;
		this.total--;
		return dequeueValue;
	}

	@Override
	public boolean isEmpty() {

		return (this.total == 0);
	}

	public boolean isFull() {

		return (this.total == this.queue.length);
	}

}
