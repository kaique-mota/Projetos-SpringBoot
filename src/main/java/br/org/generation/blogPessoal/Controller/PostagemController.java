package br.org.generation.blogPessoal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.generation.blogPessoal.Repository.PostagemRepository;
import br.org.generation.blogPessoal.model.Postagem;
import br.org.generation.blogPessoal.service.PostagemService;

@RestController
@RequestMapping ("/postagem")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	
	@Autowired
	private PostagemService postagemService;
	
	@GetMapping //find all
	public ResponseEntity<List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll()); 
	}
    
	@GetMapping ("/{id}") //find by id
	public ResponseEntity<Postagem>  GetById(@PathVariable Long id){
		return repository.findById(id)
			.map(resp -> ResponseEntity.ok (resp))
			.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping ("/titulo/{titulo}")  //find by titulo            
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){                   
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	@PostMapping
	public ResponseEntity<Postagem> postarPostagem (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping
	public ResponseEntity<Postagem> alterarPostagem(@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	
	}
	
	@PutMapping("curtir/{id}")
	public ResponseEntity<Postagem> curtirPostagemId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(postagemService.curtir(id));
	}
	
	@PutMapping("descurtir/{id}")
	public ResponseEntity<Postagem> descurtirPostagemId(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(postagemService.descurtir(id));
	}
	
	@DeleteMapping("/{id}")
	public void deletaPostagem (@PathVariable long id) {
		repository.deleteById(id);
	}
}
