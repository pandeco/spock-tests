package br.org.eldorado.vsjunit;

import br.org.eldorado.cliente.dao.ClienteDAO;
import br.org.eldorado.cliente.dao.ClienteDAOImpl;
import br.org.eldorado.cliente.model.Cliente;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;




/**
 * Created by paulo on 23/08/16.
 */
public class SpockVsJunitTest {

    @Test
    public void testBlabla() {
        Cliente pauloschreiner = new Cliente();
        pauloschreiner.setNome("Paulo Schreiner");
        pauloschreiner.setEmail("paulo.schreiner@eldorado.org.br");

        Cliente paulosouza = new Cliente();
        paulosouza.setNome("Paulo Souza");
        paulosouza.setEmail("pasouza@eldorado.org.br");

        Cliente rene = new Cliente();
        rene.setNome("Rene Santos");
        rene.setEmail("renes@eldorado.org.br");

        ClienteDAOImpl dao = new ClienteDAOImpl();
        dao.setClientes(new HashSet<Cliente>(Arrays.asList(pauloschreiner, paulosouza, rene)));

        Set<Cliente> clientes = dao.findByFirstName("Paulo");

        assertThat(clientes, hasSize(2));
        assertThat(clientes, containsInAnyOrder(pauloschreiner, paulosouza));
    }
}
