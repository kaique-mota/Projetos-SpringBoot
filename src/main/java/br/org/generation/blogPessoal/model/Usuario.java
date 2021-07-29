package br.org.generation.blogPessoal.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data 
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

	public Usuario(long id, @NotNull @Size(min = 2, max = 100) String nome,
			@NotNull @Size(min = 2, max = 100) String usuario, @NotNull @Size(min = 5) String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.usuario = usuario;
		this.senha = senha;
	}

	public Usuario() {
	}

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
	@Size(min = 5)
	private String senha;
	
	private String foto;
	
	private String tipo;
		
	@OneToMany (mappedBy = "usuario", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("usuario")
	private List <Postagem> postagem;
}
