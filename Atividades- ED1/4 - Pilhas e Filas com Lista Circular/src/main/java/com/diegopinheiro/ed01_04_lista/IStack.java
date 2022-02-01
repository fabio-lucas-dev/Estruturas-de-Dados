package com.diegopinheiro.ed01_04_lista;

public interface IStack<Value> {

	public boolean isEmpty();

	public void push(Value key);

	public Value pop() throws Exception;
}
