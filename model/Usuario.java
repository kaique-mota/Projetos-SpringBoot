package br.org.generation.minhalojadegames.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name= "tb_usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size (min = 2, max = 100)
	private String nome;
	
	@NotNull
	@Size (min = 2, max = 100)
	private String usuario;
	
	@NotNull
	@Size(min = 2)
	private String senha;
}
