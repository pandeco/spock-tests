package br.org.eldorado.transito.exception;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class SemCombustivelException extends Exception {
	
	public SemCombustivelException(BigDecimal qtGasto, BigDecimal qtDisponivel) {
		super("Para rodar essa dist�ncia, este carro precisa de " 
				+ new DecimalFormat("#0.00").format(qtGasto) + " litros, por�m s� tem " 
				+ new DecimalFormat("#0.00").format(qtDisponivel) + " litros no tanque.");
	}
}
