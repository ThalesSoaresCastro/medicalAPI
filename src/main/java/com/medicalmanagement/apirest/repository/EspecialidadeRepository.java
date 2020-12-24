package com.medicalmanagement.apirest.repository;

import com.medicalmanagement.apirest.models.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface EspecialidadeRepository extends JpaRepository<Especialidade, Long> {
    Especialidade findById(long id);

    @Query(value= "select id from tb_especialidade u where u.alergologia=:p1 and u.angiologia=:p2 and u.buco_maxilo=:p3  and u.cardiologia_clinica=:p4 and u.cardiologia_infantil=:p5 and u.cirurgia_cabeca_pescoco=:p6 and u.cirurgia_cargiaca=:p7 and u.cirurgia_torax=:p8",
            nativeQuery = true)
    ArrayList<Integer> findByEspeciality(
            @Param("p1") String p1, @Param("p2") String p2, @Param("p3") String p3,
            @Param("p4") String p4, @Param("p5") String p5, @Param("p6") String p6,
            @Param("p7") String p7, @Param("p8") String p8
    );

}
