package com.medicalmanagement.apirest.repository;

import com.medicalmanagement.apirest.models.UsuarioMedico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioMedicoRepository extends JpaRepository<UsuarioMedico, Long> {
    UsuarioMedico findById(long id);
}
