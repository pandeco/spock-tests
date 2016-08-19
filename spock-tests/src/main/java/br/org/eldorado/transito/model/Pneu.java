package br.org.eldorado.transito.model;

import java.math.BigDecimal;

public class Pneu {
	
	private BigDecimal kmMaxima;
	private BigDecimal kmAtual;
	
	public Pneu(BigDecimal kmMaxima) {
		this.kmMaxima = kmMaxima;
		this.kmAtual = BigDecimal.ZERO;
	}
	
	public BigDecimal getKmMaxima() {
		return kmMaxima;
	}
	public void setKmMaxima(BigDecimal kmMaxima) {
		this.kmMaxima = kmMaxima;
	}
	public BigDecimal getKmAtual() {
		return kmAtual;
	}
	public void setKmAtual(BigDecimal kmAtual) {
		this.kmAtual = kmAtual;
	}
	
	

}
