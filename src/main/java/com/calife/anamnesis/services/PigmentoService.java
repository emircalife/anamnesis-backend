package com.calife.anamnesis.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calife.anamnesis.domain.Pigmento;
import com.calife.anamnesis.domain.dtos.PigmentoDTO;
import com.calife.anamnesis.repositories.PigmentoRepository;
import com.calife.anamnesis.services.exceptions.ObjectNotFoundException;

@Service
public class PigmentoService {
	@Autowired
	private PigmentoRepository repository;
	
	public Pigmento findById(Integer id) {
		Optional<Pigmento> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não enocontrado ID: " + id));
	}
	
	public List<Pigmento> findAll() {
		return repository.findAll();
	}
	
	public Pigmento create(PigmentoDTO objDTO) {
		return repository.save(newPigmento(objDTO));
	}

	public Pigmento update(Integer id, @Valid PigmentoDTO objDTO) {
		objDTO.setId(id);
		Pigmento oldObj = findById(id);
		oldObj = newPigmento(objDTO);
		return repository.save(oldObj);
	}

	private Pigmento newPigmento(PigmentoDTO objDTO) {
	
		Pigmento pigmento = new Pigmento();
		if(objDTO.getId() != null) {
			pigmento.setId(objDTO.getId());
		}
		
		pigmento.setDescricao(objDTO.getDescricao());
		pigmento.setAtivo(objDTO.isAtivo());		
		
		return pigmento;
	}
}
