package br.org.eldorado.cliente;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import br.org.eldorado.cliente.model.Cliente;
import br.org.eldorado.cliente.service.ClienteService;

public class App 
{
    public static void main( String[] args ) {
    	ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"Spring-AutoScan.xml"});

    	Cliente cliente = new Cliente();
    	cliente.setId(1);
    	cliente.setNome("Fulano");
    	cliente.setEmail("fulano@eldorado.org.br");
    	
    	ClienteService service = (ClienteService) context.getBean("clienteService");
    	service.save(cliente);
    	
    }
}
