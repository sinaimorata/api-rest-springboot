package com.keepcoding.api.app.service;

import java.util.List;

import com.keepcoding.api.app.entity.Cliente;

//definimos los metodos que vamos a necesitar
public interface ClienteService {

	//metodos abtractos porque es una intefaz:

	//met para devolver todos los clientes
	public List <Cliente> buscarTodos(); 

	//metodo que devuelve cliente por ID
	public Cliente buscarPorId(Long id);

	//metodo para registrar un cliente
	public Cliente guardar(Cliente cliente);
	
	//metodo para buscar por nombre y apellido
	public List<Cliente> buscarPorNombreApellido(String nombre,String apellido);
	
	//metodo para buscar por email y telefono
	public Cliente buscarPorEmailTelefono(String email,int telefono);
	
}





	

