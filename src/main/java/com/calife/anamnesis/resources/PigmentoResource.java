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

import com.calife.anamnesis.domain.Pigmento;
import com.calife.anamnesis.domain.dtos.PigmentoDTO;
import com.calife.anamnesis.services.PigmentoService;

@RestController
@RequestMapping(value = "/pigmentos")
public class PigmentoResource {
	
	@Autowired
	private PigmentoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PigmentoDTO> findById(@PathVariable Integer id){
		Pigmento obj = service.findById(id);
		return ResponseEntity.ok().body(new PigmentoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<PigmentoDTO>> findAll(){
		List<Pigmento> list = service.findAll();
		List<PigmentoDTO> listDTO = list.stream().map(obj -> new PigmentoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<PigmentoDTO> create(@Valid @RequestBody PigmentoDTO objDTO){
		Pigmento newObj = service.create(objDTO);
		URI	uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PigmentoDTO> update(@PathVariable Integer id, @Valid @RequestBody PigmentoDTO objDTO){
		Pigmento newObj = service.update(id, objDTO);
		
		return ResponseEntity.ok().body(new PigmentoDTO(newObj));
	}
}
