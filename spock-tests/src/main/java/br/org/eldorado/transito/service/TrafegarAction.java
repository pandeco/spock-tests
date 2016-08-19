package br.org.eldorado.transito.service;

import java.math.BigDecimal;

import br.org.eldorado.transito.exception.LimiteTanqueExcedidoException;
import br.org.eldorado.transito.exception.PneuCarecaException;
import br.org.eldorado.transito.exception.SemCombustivelException;
import br.org.eldorado.transito.model.Carro;
import br.org.eldorado.transito.model.Pneu;

public class TrafegarAction {
	
	private Carro carro;
	
	public TrafegarAction(Carro carro) {
		this.carro = carro;
	}
	
	public void rodar(Integer km) throws SemCombustivelException, PneuCarecaException {
		BigDecimal kmBigDecimal = new BigDecimal(km);
		BigDecimal combustivelGasto = kmBigDecimal.divide(carro.getConsumoKmL()); 
		if (combustivelGasto.compareTo(carro.getQtCombustivelAtual()) > 0) {
			throw new SemCombustivelException(combustivelGasto, carro.getQtCombustivelAtual());
		} else if (pneusFicaramCareca(kmBigDecimal)){
			throw new PneuCarecaException();
		} else {
			carro.addKm(kmBigDecimal);
			carro.consomeCombustivel(combustivelGasto);
			for (Pneu pneu : carro.getPneus()) {
				pneu.setKmAtual(pneu.getKmAtual().add(kmBigDecimal));
			}
		}
	}
	
	public void abastecer(Double litros) throws LimiteTanqueExcedidoException {
		BigDecimal litrosBigDecimal = new BigDecimal(litros);
		BigDecimal totalCombustivel = litrosBigDecimal.add(carro.getQtCombustivelAtual()); 
		if (totalCombustivel.compareTo(carro.getCapacidadeTanque()) > 0) {
			throw new LimiteTanqueExcedidoException(totalCombustivel.subtract(carro.getCapacidadeTanque()));
		} else {
			carro.abasteceCombustivel(litrosBigDecimal);
		}
	}
	
	private boolean pneusFicaramCareca(BigDecimal km) {
		for (Pneu pneu : carro.getPneus()) {
			if (pneu.getKmAtual().add(km).compareTo(pneu.getKmMaxima()) > 0) {
				return true;
			}
		}
		return false;
	}
	
}
