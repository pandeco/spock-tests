package br.org.eldorado.transito.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Carro {

	private String modelo;
	
	private BigDecimal kmAtual;
	
	private BigDecimal capacidadeTanque;
	private BigDecimal qtCombustivelAtual;
	private BigDecimal consumoKmL;
	
	private Pneu pneuDianteiroDireito;
	private Pneu pneuDianteiroEsquerdo;
	private Pneu pneuTraseiroDireito;
	private Pneu pneuTraseiroEsquerdo;
	
	public Carro(String modelo, BigDecimal capacidadeTanque, BigDecimal consumoKmL, BigDecimal autonomiaPneus) {
		super();
		this.modelo = modelo;
		this.capacidadeTanque = capacidadeTanque;
		this.consumoKmL = consumoKmL;
		this.kmAtual = BigDecimal.ZERO;
		this.qtCombustivelAtual = BigDecimal.ZERO;
		trocarPneusDianteiros(autonomiaPneus);
		trocarPneusTraseiros(autonomiaPneus);
	}

	public Carro() {
		super();
		this.kmAtual = BigDecimal.ZERO;
		this.qtCombustivelAtual = BigDecimal.ZERO;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public BigDecimal getKmAtual() {
		return kmAtual;
	}
	
	public void setKmAtual(BigDecimal kmAtual) {
		this.kmAtual = kmAtual;
	}
	
	public BigDecimal getCapacidadeTanque() {
		return capacidadeTanque;
	}
	
	public void setCapacidadeTanque(BigDecimal capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}
	
	public BigDecimal getQtCombustivelAtual() {
		return qtCombustivelAtual;
	}
	
	public void setQtCombustivelAtual(BigDecimal qtCombustivelAtual) {
		this.qtCombustivelAtual = qtCombustivelAtual;
	}
	
	public BigDecimal getConsumoKmL() {
		return consumoKmL;
	}
	
	public void setConsumoKmL(BigDecimal consumoKmL) {
		this.consumoKmL = consumoKmL;
	}
	
	public List<Pneu> getPneus() {
		return Arrays.asList(this.pneuDianteiroDireito, this.pneuDianteiroEsquerdo, 
				this.pneuTraseiroDireito, this.pneuTraseiroEsquerdo);
	}
	
	public void addKm(BigDecimal km) {
		this.kmAtual = this.kmAtual.add(km);
	}
	
	public void abasteceCombustivel(BigDecimal qt) {
		this.qtCombustivelAtual = this.qtCombustivelAtual.add(qt);
	}
	
	public void encherTanque() {
		this.qtCombustivelAtual = this.capacidadeTanque;
	}
	
	public void consomeCombustivel(BigDecimal qt) {
		this.qtCombustivelAtual = this.qtCombustivelAtual.subtract(qt);
	}
	
	public BigDecimal getAutonomia() {
		return qtCombustivelAtual.multiply(consumoKmL);
	}
	
	public void trocarPneusDianteiros(BigDecimal kmMaxima) {
		this.pneuDianteiroDireito = new Pneu(kmMaxima);
		this.pneuDianteiroEsquerdo = new Pneu(kmMaxima);
	}
	
	public void trocarPneusTraseiros(BigDecimal kmMaxima) {
		this.pneuTraseiroDireito= new Pneu(kmMaxima);
		this.pneuTraseiroEsquerdo = new Pneu(kmMaxima);
	}
	
	
}
