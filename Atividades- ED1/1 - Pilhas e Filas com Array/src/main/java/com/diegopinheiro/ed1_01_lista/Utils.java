package com.diegopinheiro.ed1_01_lista;

public class Utils {

	public static void reverse(IQueue queueToBeReversed, IStack stackAuxiliary) {

		while (!queueToBeReversed.isEmpty()) {

			try {
				stackAuxiliary.push(queueToBeReversed.dequeue());
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		while (!stackAuxiliary.isEmpty()) {

			queueToBeReversed.enqueue(stackAuxiliary.pop());

		}

	}

}
