package com.mikidev.apidemoactions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.mikidev.apidemoactions.controller.ClienteController;
import com.mikidev.apidemoactions.model.Cliente;
import java.util.logging.Logger;

@SpringBootTest
class ApidemoactionsApplicationTests {

	@Test
	public void clientExists() {
		ClienteController clienteController = new ClienteController();
		Cliente testcliente = clienteController.getCliente();
		Logger logger = Logger.getLogger(ApidemoactionsApplicationTests.class.getName());
		logger.info("Verificando que el cliente exista...");
		logger.info("Cliente: " + testcliente.getNombre());
		assert testcliente.getNombre().equals("Miguel Duenas");
	}

	@Test
	public void clientListExists() {
		ClienteController clienteController = new ClienteController();
		Logger logger = Logger.getLogger(ApidemoactionsApplicationTests.class.getName());
		logger.info("Verificando que la lista de clientes exista...");
		logger.info("Lista de Clientes: " + clienteController.listarClientes().size());
		assert clienteController.listarClientes().size() == 5;
	}

}
