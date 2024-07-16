package com.keepcoding.api.app.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

//SI HAGO CAMBIOS DESDE LA BASE DE DATOS. NO SE REFLEJA EN NUESTRO COD. NOSOTROS ESTAMOS HACIENDO CAMBIOS
//DESDE EL CÓD.

//la idea es q la clase cliente representa 1 tabla de base de datos y los atributos las columnas
//Serializable, da como un identificador unico a esta clase
//el id se genera poniendose sobre la palabra q se ha puesto en amarillo: cliente.boton drcho. 1ªopcion.
//LO MIN NECESARIO PR Q LA CLASE CLIENTE CREE MI TABLA: ENTITY, TABLE(NOMBRA Y CAMPO ES EL ID,
@Entity
@Table(name="cliente")
public class Cliente implements Serializable {
	
	//atributos
	//con esta etiqueta le digo cual de los atributos se va a comportar como identificador y para eso
	//la etiqueta @Id que la pongo encima del atributo q necesito. Clase 4. min: 50
	//Esto es lo minimo para q me cree en spring en mi base de datos.
	//PARA QUE EL ID este autoincremental:se hace poniendo debajo de id GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	// si yo quiero q no aparezcan en la tabla como vacios, nulos, pongo la etiqueta @Column(nullable = false)
	@Column(nullable = false)
	private String nombre;
	private String apellido;
	private String email;
	private int telefono;
	//sirve para poner not null, la longitud del valor o darle nombre diferente a la columna
	@Column(name="fecha_creacion")
	//hace referencia a al columna que guarda una fecha, un registro
	//date formato fecha. tiene varias nomenclaturas lo tengo como datetime(fecha/hora) solo quiero fecha:
	@Temporal(TemporalType.DATE)
	private Date createAt;
	
	//METODO genera fechas. Q se ejecute esto cuando llamemos a los valores de arriba. Me da la fecha del pc con hora 
	//y todo. 
	@PrePersist
	public void prePersist() {
		createAt = new Date();
		
	}
	
	
	//getters y setters
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
