package com.medicalmanagement.apirest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TB_ENDERECO")
public class Endereco implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String rua;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String CEP;
    private long numero;

    @JsonIgnore
    @OneToOne(mappedBy = "endereco")
    private UsuarioMedico usuarioMedico;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public UsuarioMedico getUsuarioMedico() {
        return usuarioMedico;
    }

    public void setUsuarioMedico(UsuarioMedico usuarioMedico) {
        this.usuarioMedico = usuarioMedico;
    }
}
