package br.edu.unoescsmo.bootweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.unoescsmo.bootweb.model.Pessoa;
import br.edu.unoescsmo.bootweb.regras.PessoaRegra;

@Controller
public class PessoaController {

	@Autowired
	private PessoaRegra pessoaRegra;

	@GetMapping("/pessoa/salvar")
	@ResponseBody
	public String salvar() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Paulo");
		pessoa.setCpf("12345678901");
		pessoaRegra.salvar(pessoa);
		return "Pessoa salva com sucesso";
	}

	@GetMapping("/pessoa/listar")
	@ResponseBody
	private List<Pessoa> listar() {
		return pessoaRegra.listar();
	}
	
	@GetMapping("/pessoa/nome/{nome}")
	@ResponseBody
	private List<Pessoa> listarPorNome(@PathVariable("nome")String nome) {
		return pessoaRegra.listarPorNome(nome);
	}
	
	@GetMapping("/pessoa/cpf/{cpf}")
	@ResponseBody
	private List<Pessoa> listarPorCpf(@PathVariable("cpf")String cpf) {
		return pessoaRegra.listarPorCpf(cpf);
	}

	@GetMapping("/pessoa/deletar")
	@ResponseBody
	private String deletar() {
		pessoaRegra.delete(new Pessoa(1L));
		return "Pessoa deletada";
	}
}
