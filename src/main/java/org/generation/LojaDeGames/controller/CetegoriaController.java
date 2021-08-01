package org.generation.LojaDeGames.controller;

import java.util.List;

import org.generation.LojaDeGames.model.Cetegoria;
import org.generation.LojaDeGames.repository.CetegoriaRepository;
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

@RestController
@RequestMapping("/categoria")
@CrossOrigin("*")
public class CetegoriaController 
{
	@Autowired
private CetegoriaRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Cetegoria>> GetAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cetegoria> GetById(@PathVariable long id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/jogos/{jogos}")
	public ResponseEntity<List<Cetegoria>> GetByJogos(@PathVariable String jogos)
	{
		return ResponseEntity.ok(repository.findAllByJogosContainingIgnoreCase(jogos));
	}
	@PostMapping
	public ResponseEntity<Cetegoria> post (@RequestBody Cetegoria cetegoria)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cetegoria));
	}
	
	@PutMapping
	public ResponseEntity<Cetegoria> put (@RequestBody Cetegoria cetegoria)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(cetegoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id)
	{
		repository.deleteById(id);
	}
}
