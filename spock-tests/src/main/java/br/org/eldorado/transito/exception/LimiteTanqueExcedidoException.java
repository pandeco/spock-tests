package br.org.eldorado.transito.exception;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
public class LimiteTanqueExcedidoException extends Exception {
	
	public LimiteTanqueExcedidoException(BigDecimal qtExcedida) {
		super("A quantidade a abastecer excede o limite do tanque em " 
				+ new DecimalFormat("#0.00").format(qtExcedida) + " litros.");
	}
}
