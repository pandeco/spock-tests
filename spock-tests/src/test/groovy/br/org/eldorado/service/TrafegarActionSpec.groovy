package br.org.eldorado.service


import spock.lang.*
import br.org.eldorado.exception.LimiteTanqueExcedidoException
import br.org.eldorado.model.Carro

class TrafegarActionSpec extends Specification {

	def "Rodando com um carro"() {

		given: "Um carro é criado"
		Carro carro = new Carro("Honda City", new BigDecimal(50), new BigDecimal(10));
		carro.encherTanque();

		when: "Carro anda"
		TrafegarAction action = new TrafegarAction(carro);

		then: "roda 500 km com um tanque"
		action.rodar(500);
		carro.getAutonomia().equals(BigDecimal.ZERO);
	}

	def "Abastecendo um carro"() {

		given: "Um carro é criado"
		Carro carro = new Carro("Honda City", new BigDecimal(50), new BigDecimal(10));

		when: "Abastece acima da capacidade do tanque"
		TrafegarAction action = new TrafegarAction(carro);
		action.abastecer(600);

		then: "lança uma exceção"
//		thrown(LimiteTanqueExcedidoException)
	}
}
