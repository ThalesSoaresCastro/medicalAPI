package com.medicalmanagement.apirest.repository;

import com.medicalmanagement.apirest.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco findById(long id);
}
