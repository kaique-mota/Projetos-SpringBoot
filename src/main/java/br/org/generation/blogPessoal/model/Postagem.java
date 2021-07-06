package br.org.generation.blogPessoal.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "postagem")
@Getter @Setter @NoArgsConstructor
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(min=3, max=100)
	private String titulo;
	
	@NotNull
	@Size(min=10, max=1000)
	private String texto;
	
	@Temporal (TemporalType.TIMESTAMP)
	@Column (name = "hora_postagem")
	private Date datatempo = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties ("postagem")
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties ("postagem")
	private Usuario usuario;
}

