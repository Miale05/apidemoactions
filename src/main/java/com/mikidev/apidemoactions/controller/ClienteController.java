package com.mikidev.apidemoactions.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikidev.apidemoactions.model.Cliente;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"*"})
public class ClienteController {
    
    @GetMapping("/cliente")
    public Cliente getCliente() {
        Cliente clientedemo = new Cliente("Miguel Duenas", "miguel@mail.com", 987654321);
        return clientedemo;
    }

    @GetMapping("/lista")
    public List<Cliente> getListaClientes() {
        Cliente cliente1 = new Cliente("Miguel Duenas", "miguel@mail.com", 987654321);
        Cliente cliente2 = new Cliente("Ana Lopez", "ana@mail.com", 123456789);
        Cliente cliente3 = new Cliente("Carlos Perez", "carlos@mail.com", 987123456);
        Cliente cliente4 = new Cliente("Laura Gomez", "laura@mail.com", 654789321);
        Cliente cliente5 = new Cliente("Jose Martinez", "jose@mail.com", 321654987);
        
        List<Cliente> listaClientes = new ArrayList<>();
        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        listaClientes.add(cliente4);
        listaClientes.add(cliente5);
        
        return listaClientes;
    }
    
    @GetMapping("/lista/{id}")
    public Cliente getClienteByIndex(@PathVariable int id) {
        List<Cliente> listaClientes = getListaClientes();
        if (id >= 0 && id < listaClientes.size()) {
            return listaClientes.get(id);
        } else {
            throw new IndexOutOfBoundsException("El índice proporcionado está fuera de rango.");
        }
    }
}
