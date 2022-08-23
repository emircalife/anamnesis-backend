package com.calife.anamnesis.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calife.anamnesis.domain.Chamado;
import com.calife.anamnesis.domain.Cliente;
import com.calife.anamnesis.domain.Tecnico;
import com.calife.anamnesis.domain.dtos.ChamadoDTO;
import com.calife.anamnesis.domain.enums.Prioridade;
import com.calife.anamnesis.domain.enums.Status;
import com.calife.anamnesis.repositories.ChamadoRepository;
import com.calife.anamnesis.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {
	@Autowired
	private ChamadoRepository repository;
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private ClienteService clienteService;
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não enocontrado ID: " + id));
	}
	
	public List<Chamado> findAll() {
		return repository.findAll();
	}
	
	public Chamado create(ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}

	public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
		objDTO.setId(id);
		Chamado oldObj = findById(id);
		oldObj = newChamado(objDTO);
		return repository.save(oldObj);
	}

	private Chamado newChamado(ChamadoDTO objDTO) {
		Tecnico tecnico = tecnicoService.findById(objDTO.getTecnico());
		Cliente cliente = clienteService.findById(objDTO.getCliente());
		
		Chamado chamado = new Chamado();
		if(objDTO.getId() != null) {
			chamado.setId(objDTO.getId());
		}
		
		if(objDTO.getStatus().equals(2)) {
			chamado.setDataFechamento(LocalDate.now());
		}
		
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnaum(objDTO.getPrioridade()));
		chamado.setStatus(Status.toEnaum(objDTO.getStatus()));
		chamado.setTitulo(objDTO.getTitulo());
		chamado.setObservacoes(objDTO.getObservacoes());
		
		return chamado;
	}
}
