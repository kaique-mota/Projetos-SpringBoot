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
import br.org.generation.blogPessoal.Repository.TemaRepository;
import br.org.generation.blogPessoal.model.Tema;

@RestController
@RequestMapping ("/tema")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository temarepository;
	
	@GetMapping
	public ResponseEntity<List<Tema>> GetAll (){
		return ResponseEntity.ok(temarepository.findAll()); 
	}
    
	@GetMapping ("/{id}")
	public ResponseEntity<Tema>  GetById(@PathVariable long id){
		return temarepository.findById(id)
			.map(resp -> ResponseEntity.ok (resp))
			.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping ("/descricao/{descricao}")              
	public ResponseEntity<List<Tema>> GetByTema(@PathVariable String descricao){                   
		return ResponseEntity.ok(temarepository.findAllByDescricaoContainingIgnoreCase(descricao));
	}

	@PostMapping
	public ResponseEntity<Tema> postarTema (@RequestBody Tema descricao){
		return ResponseEntity.status(HttpStatus.CREATED).body(temarepository.save(descricao));
	
	}
	
	@PutMapping
	public ResponseEntity<Tema> alterarTema(@RequestBody Tema descricao){
		return ResponseEntity.status(HttpStatus.OK).body(temarepository.save(descricao));
	
	}
	
	@DeleteMapping("/{id}")
	public void deletarTema (@PathVariable long id) {
		temarepository.deleteById(id);
	}
}
