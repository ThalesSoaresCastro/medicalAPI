package com.medicalmanagement.apirest.repository;

import com.medicalmanagement.apirest.models.UsuarioMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface UsuarioMedicoRepository extends JpaRepository<UsuarioMedico, Long> {
    UsuarioMedico findById(long id);

    @Query(value="SELECT * FROM tb_usuariomedico u WHERE u.nome = ?1",
            nativeQuery = true)
    Collection<UsuarioMedico> findByName(String nome);

    @Query(value="SELECT * FROM tb_usuariomedico u WHERE u.crm = ?1",
            nativeQuery = true)
    Collection<UsuarioMedico> findByCRM(String crm);

    @Query(value="SELECT * FROM tb_usuariomedico u WHERE u.telefone_fixo = ?1",
            nativeQuery = true)
    Collection<UsuarioMedico> findByFixo(String fixo);

    @Query(value="SELECT * FROM tb_usuariomedico u WHERE u.telefone_celular = ?1",
            nativeQuery = true)
    Collection<UsuarioMedico> findByCelular(String celular);

    @Query(value="SELECT * FROM tb_usuariomedico u WHERE u.especialidade_id = ?1",
            nativeQuery = true)
    UsuarioMedico findByIDEsp(int esp);

    @Query(value="SELECT * FROM tb_usuariomedico u WHERE u.endereco_id = ?1",
            nativeQuery = true)
    UsuarioMedico findByIDEndereco(int address);


}
