package br.org.eldorado.vsjunit

import br.org.eldorado.cliente.dao.ClienteDAO
import br.org.eldorado.cliente.model.Cliente
import spock.lang.Specification


/**
 * Created by paulo on 23/08/16.
 */
class SpockVsJunitSpec extends Specification {

    def "clients by first name"() {
        given: "a DAO with 3 clients, of which 2 are named Paulo"
        def pauloschreiner = new Cliente(nome: "Paulo Schreiner", email: "paulo.schreiner@eldorado.org.br")
        def paulosouza = new Cliente(nome: "Paulo Souza", email: "pasouza@eldorado.org.br")
        def rene = new Cliente(nome: "Rene Santos", email: "renes@eldorado.org.br")

        def dao = new ClienteDAO(clientes: [pauloschreiner, paulosouza, rene])

        when: "I get clients by first name Paulo"
        def clients = dao.findByFirstName("Paulo")

        then: "I get both Paulos"
        clients == [pauloschreiner, paulosouza] as Set
    }
}