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
		carro.encherTanque();

		when: "Carro anda 500 km com um tanque" 
		TrafegarAction action = new TrafegarAction(carro);
		assert carro.getAutonomia() == 500; // se essa condição falhar, todo o teste falha
		action.rodar(500);

		then: "Tanque de combustivel fica zerado"
		carro.getAutonomia().equals(BigDecimal.ZERO);
	}

	
	def "Rodando com um carro até ficar sem combustivel"() {

		given: "Um carro é criado"
		Carro carro = new Carro("Ford Focus", new BigDecimal(50), new BigDecimal(10), new BigDecimal(3000));
		carro.encherTanque();

		when: "Carro anda alem da autonomia"
		TrafegarAction action = new TrafegarAction(carro);
		action.rodar(300);
		action.rodar(250);

		then: "Tanque de combustivel fica vazio"
		thrown(SemCombustivelException)
	}

	
	def "Pneus ficam careca"() {

		given: "Um carro é criado"
		Carro carro = new Carro("Fiat Uno", new BigDecimal(50), new BigDecimal(20), new BigDecimal(1000));
		carro.encherTanque();

		when: "Carro anda acima da capacidade dos pneus, abastecendo antes de ficar sem combustivel"
		TrafegarAction action = new TrafegarAction(carro);
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

		when: "Abastece acima da capacidade do tanque"
		TrafegarAction action = new TrafegarAction(carro);
		action.abastecer(10);
		action.abastecer(600);
		assert false; // <- teste lança exceçao antes de chegar aqui
		
		then: "lança uma exceção"
		assert carro.getQtCombustivelAtual() == 10;
		thrown(LimiteTanqueExcedidoException)
	}
}
