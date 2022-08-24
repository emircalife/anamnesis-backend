package com.calife.anamnesis.services;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.calife.anamnesis.domain.Chamado;
import com.calife.anamnesis.domain.Cliente;
import com.calife.anamnesis.domain.Tecnico;
import com.calife.anamnesis.domain.enums.Perfil;
import com.calife.anamnesis.domain.enums.Prioridade;
import com.calife.anamnesis.domain.enums.Status;
import com.calife.anamnesis.repositories.ChamadoRepository;
import com.calife.anamnesis.repositories.ClienteRepository;
import com.calife.anamnesis.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Emir Calife", "02159070432", "emircalife@gmail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Linus Torvalds", "16805083001", "4324060", LocalDate.now(), "Av. Sem rua", "111", 
				"Complemento", "Bairro", "Cidade", "UF", "53030-030", "81999013765", "81999013765", "torvalds@mail.com", 
				encoder.encode("123"), "laranja");
			
		Chamado ch1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(ch1));
	}
}
