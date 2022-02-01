package com.diegopinheiro.ed1_01_lista;

public class StackArray implements IStack {

	private int top;
	private Integer vector[];

	public StackArray(int capacity) {
		this.vector = new Integer[capacity];
		this.top = -1;

	}

	@Override
	public void push(Integer value) {

		if (this.isFull()) {
			throw new IllegalStateException();
		}

		this.top++;
		this.vector[this.top] = value;
		
	}

	@Override
	public Integer pop() throws IllegalStateException {

		Integer popValue;

		if (this.isEmpty()) {
			throw new IllegalStateException();
		}

		popValue = this.vector[top];
		this.top--;
		return popValue;
	}

	@Override
	public boolean isEmpty() {
		return (this.top == -1);

	}

	public boolean isFull() {

		return (this.top == this.vector.length - 1);

	}

}
