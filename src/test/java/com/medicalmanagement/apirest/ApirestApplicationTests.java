package com.medicalmanagement.apirest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.medicalmanagement.apirest.models.Endereco;
import com.medicalmanagement.apirest.models.Especialidade;
import com.medicalmanagement.apirest.models.UsuarioMedico;
import com.medicalmanagement.apirest.repository.UsuarioMedicoRepository;
import com.medicalmanagement.apirest.resources.UsuarioMedicoResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvc.*;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

import java.util.Collection;
import java.util.Objects;

@SpringBootTest
@AutoConfigureMockMvc
class ApirestApplicationTests {

	public String urlAPI = "http://localhost:8080/api";

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UsuarioMedicoResource usuarioMedicoResource;

	@Autowired
	UsuarioMedicoRepository usuarioMedicoRepository;

	/*
	*
	*
	* 		TESTES DAS REQUISIÇÕES GET
	*
	*
	* */

	/* Teste para listar todos os usuários */
	@Test
	void case1() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(urlAPI+"/medicos"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	//UsuarioMedico usuarioMedico = new UsuarioMedico();

	/* Teste para listas apenas um usuário (id = 1) */
	@Test
	void case2() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(urlAPI+"/medico/1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/* Teste para listar os médicos de acordo com a especialidade */
	/*
		teste de médidos com especialidade em:
		  buco maxilo, cirurgia no tórax e angiologia
		  [0,1,1,0,0,0,0,1]
	 */
	@Test
	void case3() throws Exception{
		String arr = "0,1,1,0,0,0,0,1";
		mockMvc.perform(MockMvcRequestBuilders.get(urlAPI+"/especialidade/"+arr))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/* Teste para listas apenas um usuário (nome = test1) */
	@Test
	void case4() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(urlAPI+"/mediconome/test1"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/* Teste para listas apenas um usuário (crm = 123) */
	@Test
	void case5() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get(urlAPI+"/medicocrm/123"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/* Teste para listar apenas um usuário pelo número do telefone fixo (fixo) */
	@Test
	void case6() throws Exception{
		String fixo = "3234-4434";
		mockMvc.perform(MockMvcRequestBuilders.get(urlAPI+"/medicofixo/"+fixo))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/* Teste para listar apenas um usuário pelo número do telefone celular (cel) */
	@Test
	void case7() throws Exception{
		String celular = "33212-3232";
		mockMvc.perform(MockMvcRequestBuilders.get(urlAPI+"/medicocel/"+celular))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/* Teste para listar todos os usuários pelo bairro escolhido (bairro) */
	@Test
	void case8() throws Exception{
		String bairro = "testeBairro1";
		mockMvc.perform(MockMvcRequestBuilders.get(urlAPI+"/address/bairro/"+bairro))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/* Teste para listar todos os usuários pelo cep escolhido (cep) */
	@Test
	void case9() throws Exception{
		String cep = "testeCep1";
		mockMvc.perform(MockMvcRequestBuilders.get(urlAPI+"/address/cep/"+cep))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/* Teste para listar todos os usuários pela rua escolhida (rua) */
	@Test
	void case10() throws Exception{
		String rua = "testeRua1";
		mockMvc.perform(MockMvcRequestBuilders.get(urlAPI+"/address/rua/"+rua))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/* Teste para listar todos os usuários pelo estado escolhido (estado) */
	@Test
	void case11() throws Exception{
		String estado = "testeEstado1";
		mockMvc.perform(MockMvcRequestBuilders.get(urlAPI+"/address/estado/"+estado))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}


	/* Teste para listar todos os usuários pelo número escolhido (número) */
	@Test
	void case12() throws Exception{
		int numero = 101;
		mockMvc.perform(MockMvcRequestBuilders.get(urlAPI+"/address/numero/"+numero))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	/*
	*
	*
	* 		TESTE DE ROTA POST
	*
	* */

	/* Teste para listar todos os usuários pelo número escolhido (número) */
	@Test
	void case13() throws Exception{
		/*Criando o objeto de teste*/
		UsuarioMedico usuarioMedico =  new UsuarioMedico();
		usuarioMedico.setNome("Any");
		usuarioMedico.setTelefoneCelular("99883-2332");
		usuarioMedico.setTelefoneFixo("3923-1233");
		usuarioMedico.setCRM("12345");

		Especialidade especialidade = new Especialidade();
		especialidade.setAlergologia(0);
		especialidade.setAngiologia(0);
		especialidade.setBuco_maxilo(1);
		especialidade.setCardiologia_clinica(1);
		especialidade.setCardiologia_infantil(0);
		especialidade.setCirurgia_cargiaca(0);
		especialidade.setCirurgia_cabeca_pescoco(0);
		especialidade.setCirurgia_torax(1);

		Endereco endereco = new Endereco();
		endereco.setBairro("bairro1");
		endereco.setCEP("26245-765");
		endereco.setCidade("cidade1");
		endereco.setEstado("estado1");
		endereco.setNumero(233);
		endereco.setPais("pais1");
		endereco.setRua("rua1");

		usuarioMedico.setEspecialidade(especialidade);
		usuarioMedico.setEndereco(endereco);


		mockMvc.perform(MockMvcRequestBuilders.post(urlAPI+"/medico")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(usuarioMedico)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}


	/*
	 *
	 *
	 * 		TESTE DE ROTA DELETE
	 *
	 * */

	/* Teste para deletar um usuário pelo seu id(deletando o usuário que foi criado anteriormente) */
	@Test
	void case14() throws Exception{

		String nameCriado = "Any";
		int idDelete;
		Collection<UsuarioMedico> user = usuarioMedicoRepository.findByName(nameCriado);
		UsuarioMedico aux = user.stream().filter(u -> u.getNome().contains(nameCriado))
				.findFirst().orElse(null);
		idDelete = (int) aux.getId();

		//int idDelete = usuarioMedicoRepository.findByName(nameCriado);
		mockMvc.perform(MockMvcRequestBuilders.delete(urlAPI+"/medico/"+idDelete))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}


}
