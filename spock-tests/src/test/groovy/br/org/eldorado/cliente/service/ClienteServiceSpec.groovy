package br.org.eldorado.cliente.service


import br.org.eldorado.cliente.model.Cliente
import br.org.eldorado.cliente.dao.ClienteDAO
import br.org.eldorado.cliente.service.ClienteService
import spock.lang.Specification

class ClienteServiceSpec extends Specification {

	def "Testando service de Cliente"() {
		given: "um serviço de persistência de clientes é instanciado"
		
		ClienteDAO dao = Stub(ClienteDAO)
		dao.save(_) >> new Cliente(id:1,nome:"Fulano",email:"fulano@eldorado.org.br",salvo:false)
		
		when: "salvo um novo cliente"
		ClienteService service = new ClienteService(clienteDAO:dao)
		Cliente cliente = new Cliente(nome:"Fulano",email:"fulano@eldorado.org.br",salvo:false)
		Cliente clienteSalvo = service.save(cliente)

		then: "cliente é salvo"
		clienteSalvo.isSalvo()
	}


}
