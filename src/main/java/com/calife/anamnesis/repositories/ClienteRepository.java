package com.calife.anamnesis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calife.anamnesis.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
