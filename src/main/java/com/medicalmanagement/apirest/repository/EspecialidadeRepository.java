package com.medicalmanagement.apirest.repository;

import com.medicalmanagement.apirest.models.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    Especialidade findById(long id);
}
