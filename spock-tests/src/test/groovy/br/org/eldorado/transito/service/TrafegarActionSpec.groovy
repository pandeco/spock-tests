package br.org.eldorado.transito.service


import spock.lang.*
import br.org.eldorado.transito.exception.LimiteTanqueExcedidoException
import br.org.eldorado.transito.exception.PneuCarecaException
import br.org.eldorado.transito.exception.SemCombustivelException;
import br.org.eldorado.transito.model.Carro
import br.org.eldorado.transito.service.TrafegarAction

class TrafegarActionSpec extends Specification {

	@Issue("JIRA-561")
	def "Rodando com um carro ate zerar o tanque"() {

		given: "Um carro é criado"
		Carro carro = new Carro("Honda City", 50, 10, 1000);
		TrafegarAction action = new TrafegarAction(carro);

		when: "Carro anda 500 km com um tanque" 
		carro.encherTanque();
		assert carro.getAutonomia() == 500; // se essa condição falhar, todo o teste falha
		action.rodar(500);

		then: "Tanque de combustivel fica zerado"
		carro.autonomia == 0;
	}

	
	def "Rodando com um carro até ficar sem combustivel"() {

		given: "Um carro é criado"
		Carro carro = new Carro("Ford Focus", new BigDecimal(50), new BigDecimal(10), new BigDecimal(3000));
		TrafegarAction action = new TrafegarAction(carro);

		when: "Carro anda alem da autonomia"
		carro.encherTanque();
		action.rodar(300);
		action.rodar(250);

		then: "Tanque de combustivel fica vazio"
		thrown(SemCombustivelException)
	}

	
	def "Pneus ficam careca"() {

		given: "Um carro é criado"
		Carro carro = new Carro("Fiat Uno", new BigDecimal(50), new BigDecimal(20), new BigDecimal(1000));
		TrafegarAction action = new TrafegarAction(carro);

		when: "Carro anda acima da capacidade dos pneus, abastecendo antes de ficar sem combustivel"
		carro.encherTanque();
		action.rodar(500);
		action.rodar(400);
		action.abastecer(30);
		action.rodar(200);

		then: "Pneus ficam careca antes que o carro fique sem combustivel"
		thrown(PneuCarecaException);
	}

	
	def "Abastecendo um carro alem do limite do tanque"() {

		given: "Um carro é criado"
		Carro carro = new Carro(kmAtual:90000, capacidadeTanque:50, consumoKmL:10, modelo:"Honda City");
		TrafegarAction action = new TrafegarAction(carro);

		when: "Abastece acima da capacidade do tanque"
		action.abastecer(10);
		action.abastecer(600);
		assert false; // <- teste lança exceçao antes de chegar aqui
		
		then: "lança uma exceção"
		carro.getQtCombustivelAtual() == 10;
		thrown(LimiteTanqueExcedidoException)
	}


	def "Abastecendo um carro 5x"() {

		given: "Um carro é criado"
		Carro carro = new Carro("Chevrolet Captiva", new BigDecimal(100), new BigDecimal(5), new BigDecimal(1000));

		when: "Abastece 20 litros por 5 vezes"
		carro.abasteceCombustivel(new BigDecimal(20))
		carro.abasteceCombustivel(new BigDecimal(20))
		carro.abasteceCombustivel(new BigDecimal(20))
		carro.abasteceCombustivel(new BigDecimal(20))
		carro.abasteceCombustivel(new BigDecimal(20))

		then: "Verifica que o tanque está cheio"
		carro.getQtCombustivelAtual() == 100
		carro.getQtCombustivelAtual().compareTo(carro.capacidadeTanque) == 0
		notThrown(LimiteTanqueExcedidoException)
	}
}
