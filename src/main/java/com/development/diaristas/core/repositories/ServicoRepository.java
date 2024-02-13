package com.development.diaristas.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.development.diaristas.core.models.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>{
    
}
