package br.org.eldorado.transito.service;

import java.math.BigDecimal;

import br.org.eldorado.transito.exception.LimiteTanqueExcedidoException;
import br.org.eldorado.transito.exception.SemCombustivelException;
import br.org.eldorado.transito.model.Carro;

public class TrafegarAction {
	
	private Carro carro;
	
	public TrafegarAction(Carro carro) {
		this.carro = carro;
	}
	
	public boolean rodar(Integer km) throws SemCombustivelException {
		BigDecimal kmBigDecimal = new BigDecimal(km);
		BigDecimal combustivelGasto = kmBigDecimal.divide(carro.getConsumoKmL()); 
		if (combustivelGasto.compareTo(carro.getQtCombustivelAtual()) < 0) {
			throw new SemCombustivelException(combustivelGasto, carro.getQtCombustivelAtual());
		} else {
			carro.addKm(kmBigDecimal);
			carro.consomeCombustivel(combustivelGasto);
			return true;
		}
	}
	
	public boolean abastecer(Double litros) throws LimiteTanqueExcedidoException {
		BigDecimal litrosBigDecimal = new BigDecimal(litros);
		BigDecimal totalCombustivel = litrosBigDecimal.add(carro.getQtCombustivelAtual()); 
		if (totalCombustivel.compareTo(carro.getCapacidadeTanque()) > 0) {
			throw new LimiteTanqueExcedidoException(totalCombustivel.subtract(carro.getCapacidadeTanque()));
		} else {
			carro.abasteceCombustivel(litrosBigDecimal);
			return true;
		}
	}
	
}
