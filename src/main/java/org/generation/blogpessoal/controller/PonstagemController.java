package org.generation.blogpessoal.controller;

import java.util.List;


import org.generation.blogpessoal.model.Postagem;
import org.generation.blogpessoal.repository.PostagemRepository;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping ("/Postagens")
@CrossOrigin ("*")
public class PonstagemController {
	
	
	@Autowired
	private PostagemRepository postagemRepository;
	
	@GetMapping 
	public ResponseEntity<List<Postagem>> GetAll (){
		return ResponseEntity.ok(postagemRepository.findAll());
				
	}
	@GetMapping ("/{id}")
	public ResponseEntity<Postagem>getById(@PathVariable Long id){
		return postagemRepository.findById(id) 
				.map (resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND ).build());
	}
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(postagemRepository.findAllByTituloContainingIgnoreCase(titulo));
		
	}
	 @PostMapping 
	    public ResponseEntity<Postagem> post (@RequestBody Postagem postagem ){
		    return ResponseEntity.status(HttpStatus.CREATED).body (postagemRepository.save(postagem));
	 }
	 
	 @PutMapping
	 public ResponseEntity<Postagem> put (@RequestBody Postagem postagem ){
		    return ResponseEntity.status(HttpStatus.OK).body (postagemRepository.save(postagem));
	    }
	 
		@ResponseStatus(HttpStatus.NO_CONTENT)
		@ DeleteMapping ( "/{id}" )
		public void delete(@PathVariable long id) {
			java.util.Optional<Postagem> postagem = postagemRepository.findById(id);

			if (postagem.isEmpty())
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);

			postagemRepository.deleteById(id);
		}

}
