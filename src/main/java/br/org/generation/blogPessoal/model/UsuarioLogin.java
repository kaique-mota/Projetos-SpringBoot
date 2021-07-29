package br.org.generation.blogPessoal.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
public class UsuarioLogin {

	private long id;
	
    private String nome;
	
	private String usuario;
	
	private String senha;
	
	private String token;
	
	private String foto;
	
	private String tipo;
}
