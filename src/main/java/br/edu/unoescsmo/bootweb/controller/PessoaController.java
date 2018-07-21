package br.edu.unoescsmo.bootweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public String salvar(@Valid Pessoa pessoa, BindingResult erros) {
		if (erros.hasErrors()) {
			return "pessoa/novo";
		}
		pessoaRegra.salvar(pessoa);
		return "redirect:/pessoa/listar";
	}
	
	@PostMapping("/alterar")
	public String alterar(@Valid Pessoa pessoa, BindingResult erros) {
		if (erros.hasErrors()) {
			return "pessoa/visualizar";
		}
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

	@GetMapping("/deletar/{codigo}")
	private String deletar(@PathVariable("codigo") Long codigo) {
		pessoaRegra.delete(new Pessoa(codigo));
		return "redirect:/pessoa/listar";
	}
	
	@GetMapping("/visualizar/{codigo}")
	private String visualizar(@PathVariable("codigo") Long codigo, Model model) {
		model.addAttribute("pessoa", pessoaRegra.buscarPorCodigo(codigo));
		return "pessoa/visualizar";
	}
}
