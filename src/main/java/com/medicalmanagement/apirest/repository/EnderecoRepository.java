package com.medicalmanagement.apirest.repository;

import com.medicalmanagement.apirest.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    Endereco findById(long id);

    @Query(value = "select id from tb_endereco u where u.cep=:cep", nativeQuery = true)
    ArrayList<Integer> findByCEP(@Param("cep") String cep);


    @Query(value = "select id from tb_endereco u where u.rua=:rua", nativeQuery = true)
    ArrayList<Integer> findByRua(@Param("rua") String rua);


    @Query(value = "select id from tb_endereco u where u.bairro=:bairro", nativeQuery = true)
    ArrayList<Integer> findByBairro(@Param("bairro") String bairro);


    @Query(value = "select id from tb_endereco u where u.cidade=:city", nativeQuery = true)
    ArrayList<Integer> findByCity(@Param("city") String city);


    @Query(value = "select id from tb_endereco u where u.estado=:estado", nativeQuery = true)
    ArrayList<Integer> findByEstado(@Param("estado") String estado);


    @Query(value = "select id from tb_endereco u where u.numero=:numero", nativeQuery = true)
    ArrayList<Integer> findByNumero(@Param("numero") int numero);

    @Query(value = "select id from tb_endereco u where u.pais=:pais", nativeQuery = true)
    ArrayList<Integer> findByPais(@Param("pais") String pais);

    @Query(value = "select id from tb_endereco u where u.cep=:cep and u.rua=:rua and u.bairro=:bairro and u.cidade=:city and u.estado=:estado and u.pais=:pais and u.numero=:numero", nativeQuery = true)
    ArrayList<Integer> findByAllAddress(@Param("cep") String cep, @Param("rua") String rua,
                                        @Param("bairro") String bairro, @Param("city") String city,
                                        @Param("estado") String estado, @Param("pais") String pais,
                                        @Param("numero") int numero);

}
