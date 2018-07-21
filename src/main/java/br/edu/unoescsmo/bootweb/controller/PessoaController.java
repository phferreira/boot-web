package br.edu.unoescsmo.bootweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.unoescsmo.bootweb.model.Pessoa;
import br.edu.unoescsmo.bootweb.regras.PessoaRegra;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRegra pessoaRegra;

	@PostMapping("/salvar")
	public String salvar(Pessoa pessoa) {
		pessoaRegra.salvar(pessoa);
		return "redirect:/pessoa/listar";
	}

	@GetMapping("/listar")
	private String listar(Model model) {
		// Model: torna a pessoa acessivel no JSP
		model.addAttribute("pessoas", pessoaRegra.listar());
		//Caminho/nome do JSP que sera renderizado na tela
		return "pessoa/lista";
	}

	@GetMapping("/novo")
	private String novo() {
		return "pessoa/novo";
	}
	
	@GetMapping("/nome/{nome}")
	@ResponseBody
	private List<Pessoa> listarPorNome(@PathVariable("nome") String nome) {
		return pessoaRegra.listarPorNome(nome);
	}

	@GetMapping("/pessoa/cpf/{cpf}")
	@ResponseBody
	private List<Pessoa> listarPorCpf(@PathVariable("cpf") String cpf) {
		return pessoaRegra.listarPorCpf(cpf);
	}

	@GetMapping("/pessoa/deletar")
	@ResponseBody
	private String deletar() {
		pessoaRegra.delete(new Pessoa(1L));
		return "Pessoa deletada";
	}
}
