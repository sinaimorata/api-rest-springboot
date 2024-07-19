package com.keepcoding.api.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keepcoding.api.app.entity.Cliente;
import com.keepcoding.api.app.service.ClienteService;

//SE PUEDEN PASAR 1 SUBRUTA A TODO ESTE CONTROLADOR XQ PUEDO TENER UN CONTROLADOR PARA EL CLIENTE, PRODUCTO PROVEEDOR
//Y SE HACE @REQUESTMAPPING y defino api pj. ("/api").lo que cambia: paso localhost:8080/api/y aqui lo q puse cliente/4
//@PostMapping: se hacen x formulario, se les llama igual q a los get.El post envia los datos de una manera especial.Con
//muchas cosas x debajo. Para recibir 1 modelo tenemos q pasar una anotacion: @RequestBody y se queda esperando 1 modelo de cliente
// id, nombre, apellido.....
//Postman: probar de manera local APIs. https://www.postman.com
//La etiqueta indica que lleva el protocolo rest y es el controlador

@RestController
@RequestMapping("/api")
public class ClienteRestController {
	//inyectar los metodos de service.Inyecto la interfaz del servicio,no la implementacion
	@Autowired
	ClienteService clienteService;
	
	//Este metodo nos devuelte todos los datos
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.buscarTodos();
	}
	
	//metodo que busca por id
	//@PathVariable: se usa para recoger datos
	@GetMapping("/clientes/{id}")
	public Cliente show(@PathVariable Long id) {
		return clienteService.buscarPorId(id);
		
	}
	@PostMapping("/clientes")
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.guardar(cliente);
	// para probar esto necesito una heramienta Postman	
	}
	@GetMapping("/clientes/namelastname/{nombre}/{apellido}")
	public List<Cliente> buscarNombre(@PathVariable String nombre,@PathVariable String apellido){
		return clienteService.buscarPorNombreApellido(nombre,apellido);
	}
	
	@GetMapping("/clientes/emailphone/{email}/{phone}")
	public Cliente buscarEmailPhone(@PathVariable String email,@PathVariable int phone){
		return clienteService.buscarPorEmailTelefono(email,phone);
	}	
		
}

