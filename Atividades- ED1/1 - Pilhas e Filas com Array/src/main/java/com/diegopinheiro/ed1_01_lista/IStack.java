package com.diegopinheiro.ed1_01_lista;

public interface IStack {

	public void push(Integer value);

	public Integer pop() throws IllegalStateException;

	public boolean isEmpty();
}
