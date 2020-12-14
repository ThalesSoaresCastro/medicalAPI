package com.medicalmanagement.apirest.resources;

import com.medicalmanagement.apirest.models.UsuarioMedico;
import com.medicalmanagement.apirest.repository.UsuarioMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class UsuarioMedicoResource {
    @Autowired
    UsuarioMedicoRepository usuarioMedicoRepository;

    @GetMapping("/medicos")
    public List<UsuarioMedico> listaMedicos(){
        return usuarioMedicoRepository.findAll();
    }

    @GetMapping("/medico/{id}")
    public UsuarioMedico listaUsuarioUnico(@PathVariable(value = "id") long id){
        return usuarioMedicoRepository.findById(id);
    }

    @PostMapping("/medico")
    public UsuarioMedico salvaMedico(@RequestBody UsuarioMedico usuarioMedico){
        return usuarioMedicoRepository.save(usuarioMedico);
    }


    @DeleteMapping("/medico/{id}")
    public void deletaMedico(@PathVariable(value="id") long id){
        UsuarioMedico usuarioMedico = usuarioMedicoRepository.findById(id);
        usuarioMedicoRepository.delete(usuarioMedico);
    }

}
