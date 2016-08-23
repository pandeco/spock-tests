package br.org.eldorado.calculadora;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculadora {
	
	public Integer soma(Integer a, Integer b) {
		/* bug proposital para demonstrar os testes */
		return Math.abs(a + b);
	}
	
	public Integer subtrai(Integer a, Integer b) {
		return a - b;
	}
	
	public Integer multiplica(Integer a, Integer b) {
		return a * b;
	}
	
	public Double divide(Integer a, Integer b) {
		if (b.equals(0)) {
			return null;
		} else {
			BigDecimal bdA = BigDecimal.valueOf(a);
			BigDecimal bdB = BigDecimal.valueOf(b);
			return bdA.divide(bdB, 3, RoundingMode.HALF_DOWN).doubleValue();
		}
	}
	
	public Long elevadoAo(Integer a, Integer b) {
		if (b.equals(0)) {
			return 1L;
		} else {
			Long result = Long.valueOf(a);
			for (int i = 1; i < b; i++) {
				result = result * a; 
			}
			return result;
		}
	}
}
