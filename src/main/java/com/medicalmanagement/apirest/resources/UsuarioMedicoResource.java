package com.medicalmanagement.apirest.resources;

import com.medicalmanagement.apirest.models.UsuarioMedico;
import com.medicalmanagement.apirest.repository.EnderecoRepository;
import com.medicalmanagement.apirest.repository.EspecialidadeRepository;
import com.medicalmanagement.apirest.repository.UsuarioMedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.regex.Pattern;

@RestController
@RequestMapping(value="/api")
public class UsuarioMedicoResource {
    @Autowired
    UsuarioMedicoRepository usuarioMedicoRepository;

    @Autowired
    EspecialidadeRepository especialidadeRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

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

    @GetMapping("/mediconome/{nome}")
    public Collection<UsuarioMedico> listaUsuarioNome(@PathVariable(value="nome") String nome){
        return usuarioMedicoRepository.findByName(nome);
    }

    @GetMapping("/medicocrm/{crm}")
    public Collection<UsuarioMedico> listaUsuarioCRM(@PathVariable(value="crm") String crm){
        return usuarioMedicoRepository.findByCRM(crm);
    }

    @GetMapping("/medicofixo/{fixo}")
    public Collection<UsuarioMedico> listaUsuariofixo(@PathVariable(value="fixo") String fixo){
        return usuarioMedicoRepository.findByFixo(fixo);
    }

    @GetMapping("/medicocel/{cel}")
    public Collection<UsuarioMedico> listaUsuarioCelular(@PathVariable(value="cel") String cel){
        return usuarioMedicoRepository.findByCelular(cel);
    }

    @GetMapping("/especialidade/{values}")
    public List<UsuarioMedico> listaEspecialidade(@PathVariable(value="values") String values){

        List<String> parameters = Arrays.asList(values.split(Pattern.quote(",")));
        List<UsuarioMedico> l = new ArrayList<>();

        ArrayList<Integer> arr= especialidadeRepository.findByEspeciality(
                parameters.get(0), parameters.get(1), parameters.get(2),
                parameters.get(3), parameters.get(4), parameters.get(5),
                parameters.get(6), parameters.get(7)
        );

        arr.forEach(a ->{
            l.add(usuarioMedicoRepository.findByIDEsp(a));
        });
        return l;
    }

    @GetMapping("/address/cep/{values}")
    public List<UsuarioMedico> listaCeps(@PathVariable(value="values") String values){

        List<UsuarioMedico> l = new ArrayList<>();
        ArrayList<Integer> arr = enderecoRepository.findByCEP(values);

        arr.forEach(a->{
            l.add(usuarioMedicoRepository.findByIDEndereco(a));
        });
        return l;
    }

    @GetMapping("/address/bairro/{values}")
    public List<UsuarioMedico> listaBairro(@PathVariable(value="values") String values){

        List<UsuarioMedico> l = new ArrayList<>();
        ArrayList<Integer> arr = enderecoRepository.findByBairro(values);

        arr.forEach(a->{
            l.add(usuarioMedicoRepository.findByIDEndereco(a));
        });
        return l;
    }

    @GetMapping("/address/rua/{values}")
    public List<UsuarioMedico> listaRua(@PathVariable(value="values") String values){

        List<UsuarioMedico> l = new ArrayList<>();
        ArrayList<Integer> arr = enderecoRepository.findByRua(values);

        arr.forEach(a->{
            l.add(usuarioMedicoRepository.findByIDEndereco(a));
        });
        return l;
    }

    @GetMapping("/address/estado/{values}")
    public List<UsuarioMedico> listaEstado(@PathVariable(value="values") String values){

        List<UsuarioMedico> l = new ArrayList<>();
        ArrayList<Integer> arr = enderecoRepository.findByEstado(values);

        arr.forEach(a->{
            l.add(usuarioMedicoRepository.findByIDEndereco(a));
        });
        return l;
    }

    @GetMapping("/address/numero/{values}")
    public List<UsuarioMedico> listaNumeroAddress(@PathVariable(value="values") int values){

        List<UsuarioMedico> l = new ArrayList<>();
        ArrayList<Integer> arr = enderecoRepository.findByNumero(values);

        arr.forEach(a->{
            l.add(usuarioMedicoRepository.findByIDEndereco(a));
        });
        return l;
    }
}
