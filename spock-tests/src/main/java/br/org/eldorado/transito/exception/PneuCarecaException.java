package br.org.eldorado.transito.exception;

@SuppressWarnings("serial")
public class PneuCarecaException extends Exception {
	
	public PneuCarecaException() {
		super("Um ou mais pneus não podem rodar essa kilometragem.");
	}
}
