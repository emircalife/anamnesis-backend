package com.calife.anamnesis.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.calife.anamnesis.domain.Anamnese;
import com.calife.anamnesis.domain.dtos.AnamneseDTO;
import com.calife.anamnesis.services.AnamneseService;

@RestController
@RequestMapping(value = "/anamneses")
public class AnamneseResource {
	
	@Autowired
	private AnamneseService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AnamneseDTO> findById(@PathVariable Integer id){
		Anamnese obj = service.findById(id);
		return ResponseEntity.ok().body(new AnamneseDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<AnamneseDTO>> findAll(){
		List<Anamnese> list = service.findAll();
		List<AnamneseDTO> listDTO = list.stream().map(obj -> new AnamneseDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<AnamneseDTO> create(@Valid @RequestBody AnamneseDTO objDTO){
		Anamnese newObj = service.create(objDTO);
		URI	uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<AnamneseDTO> update(@PathVariable Integer id, @Valid @RequestBody AnamneseDTO objDTO){
		Anamnese newObj = service.update(id, objDTO);
		
		return ResponseEntity.ok().body(new AnamneseDTO(newObj));
	}
}
