package com.medicalmanagement.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TB_ESPECIALIDADE")
public class Especialidade implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int alergologia;
    private int angiologia;
    private int buco_maxilo;
    private int cardiologia_clinica;
    private int cardiologia_infantil;
    private int cirurgia_cabeca_pescoco;
    private int cirurgia_cargiaca;
    private int cirurgia_torax;

    @JsonIgnore
    @OneToOne(mappedBy = "especialidade")
    private UsuarioMedico usuarioMedico;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAlergologia() {
        return alergologia;
    }

    public void setAlergologia(int alergologia) {
        this.alergologia = alergologia;
    }

    public int getAngiologia() {
        return angiologia;
    }

    public void setAngiologia(int angiologia) {
        this.angiologia = angiologia;
    }

    public int getBuco_maxilo() {
        return buco_maxilo;
    }

    public void setBuco_maxilo(int buco_maxilo) {
        this.buco_maxilo = buco_maxilo;
    }

    public int getCardiologia_clinica() {
        return cardiologia_clinica;
    }

    public void setCardiologia_clinica(int cardiologia_clinica) {
        this.cardiologia_clinica = cardiologia_clinica;
    }

    public int getCardiologia_infantil() {
        return cardiologia_infantil;
    }

    public void setCardiologia_infantil(int cardiologia_infantil) {
        this.cardiologia_infantil = cardiologia_infantil;
    }

    public int getCirurgia_cabeca_pescoco() {
        return cirurgia_cabeca_pescoco;
    }

    public void setCirurgia_cabeca_pescoco(int cirurgia_cabeca_pescoco) {
        this.cirurgia_cabeca_pescoco = cirurgia_cabeca_pescoco;
    }

    public int getCirurgia_cargiaca() {
        return cirurgia_cargiaca;
    }

    public void setCirurgia_cargiaca(int cirurgia_cargiaca) {
        this.cirurgia_cargiaca = cirurgia_cargiaca;
    }

    public int getCirurgia_torax() {
        return cirurgia_torax;
    }

    public void setCirurgia_torax(int cirurgia_torax) {
        this.cirurgia_torax = cirurgia_torax;
    }

    public UsuarioMedico getUsuarioMedico() {
        return usuarioMedico;
    }

    public void setUsuarioMedico(UsuarioMedico usuarioMedico) {
        this.usuarioMedico = usuarioMedico;
    }
}
