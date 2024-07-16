package com.keepcoding.api.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keepcoding.api.app.entity.Cliente;
import com.keepcoding.api.app.repository.ClienteRepository;
import com.keepcoding.api.app.service.ClienteService;
@Service
//AQUI TENGO QUE LLAMAR O INYECTAR MI REPOSITORIO
public class ClienteServiceImpl implements ClienteService{
	@Autowired
	private ClienteRepository clienteRepository;

	//FALTA ANOTACION PARA ESTOS METS: TRANSACIONAL
	//Sirve para optimizar recursos: en post:@transactional y en get, se les pone un valor de solo lectura
	//(readOnly = true)
	//transactional va debajo del override en todas, pero


	@Override
	@Transactional(readOnly = true)
	public List<Cliente> buscarTodos() {

		return (List<Cliente>) clienteRepository.findAll();
	}



	@Override
	@Transactional
	public Cliente guardar(Cliente cliente) {

		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}


}
