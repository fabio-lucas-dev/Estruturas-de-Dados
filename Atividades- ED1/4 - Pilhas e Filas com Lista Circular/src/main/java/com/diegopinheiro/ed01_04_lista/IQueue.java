package com.diegopinheiro.ed01_04_lista;



public interface IQueue<Value> {
	
	public void enqueue(Value  key);
	public Value dequeue() throws Exception;
	public boolean isEmpty();

}
