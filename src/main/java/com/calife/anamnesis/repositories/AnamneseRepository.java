package com.calife.anamnesis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.calife.anamnesis.domain.Anamnese;

public interface AnamneseRepository extends JpaRepository<Anamnese, Integer>{

}