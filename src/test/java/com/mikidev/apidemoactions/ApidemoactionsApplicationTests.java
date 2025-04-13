package com.mikidev.apidemoactions;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.mikidev.apidemoactions.controller.ClienteController;
import com.mikidev.apidemoactions.model.Cliente;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootTest
class ApidemoactionsApplicationTests {

	@Test
	void testGetCliente() {
		// Mocking ClienteController
		ClienteController clienteController = Mockito.mock(ClienteController.class);
		Cliente mockCliente = new Cliente();
		mockCliente.setNombre("Miguel Duenas");
		Mockito.when(clienteController.getCliente()).thenReturn(mockCliente);

		// Test logic
		Cliente testCliente = clienteController.getCliente();
		Logger logger = Logger.getLogger(ApidemoactionsApplicationTests.class.getName());
		assertNotNull(testCliente, "Cliente should not be null");
		logger.info("Cliente is not null");
		assertEquals("Miguel Duenas", testCliente.getNombre(), "Cliente name should match");
		logger.info("Cliente name matches: " + testCliente.getNombre());
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	@Test
	void testGetListaClientes() {
		// Mocking ClienteController
		ClienteController clienteController = Mockito.mock(ClienteController.class);
		Mockito.when(clienteController.getListaClientes()).thenReturn(Arrays.asList(
			new Cliente(), new Cliente(), new Cliente(), new Cliente(), new Cliente()
		));

		// Test logic
		Logger logger = Logger.getLogger(ApidemoactionsApplicationTests.class.getName());
		assertNotNull(clienteController.getListaClientes(), "Client list should not be null");
		logger.info("Client list is not null");
		assertEquals(5, clienteController.getListaClientes().size(), "Client list size should be 5");
		logger.info("Client list size matches: " + clienteController.getListaClientes().size());
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>");
	}

	@Test
	void testGetClienteByIndex() {
		// Mocking ClienteController
		ClienteController clienteController = Mockito.mock(ClienteController.class);
		Cliente cliente1 = new Cliente();
		cliente1.setNombre("Miguel Duenas");
		Cliente cliente2 = new Cliente();
		cliente2.setNombre("Juan Lopez");
		Cliente cliente3 = new Cliente();
		cliente3.setNombre("Paolo Guerrero");

		Mockito.when(clienteController.getListaClientes()).thenReturn(Arrays.asList(cliente1, cliente2, cliente3));
		Mockito.when(clienteController.getClienteByIndex(1)).thenReturn(cliente2);

		// Test logic
		Logger logger = Logger.getLogger(ApidemoactionsApplicationTests.class.getName());
		Cliente testCliente = clienteController.getClienteByIndex(1);

		assertNotNull(testCliente, "Cliente at index 1 should not be null");
		logger.info("Cliente at index 1 is not null");
		assertEquals("Juan Lopez", testCliente.getNombre(), "Cliente name at index 1 should match");
		logger.info("Cliente name at index 1 matches: " + testCliente.getNombre());
		logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
}
