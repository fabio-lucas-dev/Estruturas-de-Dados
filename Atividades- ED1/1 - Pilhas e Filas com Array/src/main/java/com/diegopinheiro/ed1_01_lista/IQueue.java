package com.diegopinheiro.ed1_01_lista;

public interface IQueue {
	public void enqueue(Integer value);

	public Integer dequeue() throws Exception;

	public boolean isEmpty();

}
