package com.calife.anamnesis.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calife.anamnesis.domain.Anamnese;
import com.calife.anamnesis.domain.Cliente;
import com.calife.anamnesis.domain.Tecnico;
import com.calife.anamnesis.domain.dtos.AnamneseDTO;
import com.calife.anamnesis.repositories.AnamneseRepository;
import com.calife.anamnesis.services.exceptions.ObjectNotFoundException;

@Service
public class AnamneseService {
	@Autowired
	private AnamneseRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public Anamnese findById(Integer id) {
		Optional<Anamnese> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não enocontrado ID: " + id));
	}
	
	public List<Anamnese> findAll() {
		return repository.findAll();
	}
	
	public Anamnese create(AnamneseDTO objDTO) {
		return repository.save(newAnamnese(objDTO));
	}

	public Anamnese update(Integer id, @Valid AnamneseDTO objDTO) {
		objDTO.setId(id);
		Anamnese oldObj = findById(id);
		oldObj = newAnamnese(objDTO);
		return repository.save(oldObj);
	}

	private Anamnese newAnamnese(AnamneseDTO objDTO) {
		Tecnico tecnico = tecnicoService.findById(objDTO.getTecnico());
		Cliente cliente = clienteService.findById(objDTO.getCliente());
		
		Anamnese anamnese = new Anamnese();
		if(objDTO.getId() != null) {
			anamnese.setId(objDTO.getId());
		}

		anamnese.setDescricao(objDTO.getDescricao());
		anamnese.setObrigatorio(objDTO.isObrigatorio());
		anamnese.setExcludente(objDTO.isExcludente());
		anamnese.setObservacoes(objDTO.getObservacoes());
		anamnese.setDataAnamnese(objDTO.getDataAnamnese());
		anamnese.setTecnico(tecnico);
		anamnese.setCliente(cliente);
		
		return anamnese;
	}
}
