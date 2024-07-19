package com.keepcoding.api.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.keepcoding.api.app.entity.Cliente;
//ESTE REPOSITORIO ES DE METODOS YA HECHOS PR LAS OPERACIONES BASICAS DE UN REGISTRO

//CRUD:create-crear, read-leer,update-actualizar,delete-borrar. Operaciones básicas sobre un registro

//si me pongo encima,bton drcho y pone component significa q puedo inyectarlo
//tengo q heredar propiedades de CrudRepository q es 1 clase de jpa q ya tiene 1 repositorio 
//de metodos para poder manipular nuestra entity
@Repository
//pide dos objetos<> la entity q es el nombre de la clase y lo segundo es el tipo de dato de la ID de esta
//clase y va en mayuscula cm objeto. Se pasa el objeto del tipo de dato

// En Spring-jpa Query Methods query cration. TE EXPLICA los metodos especiales q puedes meter en
//CLIENTE REPOSITORY

//LA CLASE CIENTEREPOSITORY HEREDA DE CRUDREPOSITORY Q TIENE LOS METODOS
//Y LE PASAMOS LA ENTIDAD Y EL TIPO DE ID. TOMA ESE REPOSITORIO PARA 
//UTILIZARLO DD QUERAMOS
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	//el proceso se puede hacer de dos maneras: 
	//a
	//List<Cliente> findByApellido(String apellido);
	
	//Cliente va en mayuscula porque se refiere a nuestra entidad, al objeto
	//=?1. Hace referencia al parametro, en este caso al apellido
	@Query("select c from Cliente c where c.apellido =?1")
	List<Cliente> findByApellido(String apellido);
	
	
	List<Cliente> findAll();
	

	//se puede buscar por más parametros nombre y apellido
	
	//El proceso se puede hacer de dos maneras:
	
	//a
	//List<Cliente> findByNombreAndApellido(String nombre, String apellido);
	
	//b
	@Query("select c from Cliente c where c.nombre =?1 and c.apellido =?2")
	List<Cliente> findByNombreAndApellido(String nombre, String apellido);
	
	
	//List<Cliente> findByEmailAndTelefono(String email, int telefono);
	
	@Query("select c from Cliente c where c.email =?1 and c.telefono =?2")
	Cliente findByEmailAndTelefono(String email, int telefono);
	
}
