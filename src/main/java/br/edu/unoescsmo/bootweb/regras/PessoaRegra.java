package br.edu.unoescsmo.bootweb.regras;

import java.util.List;

import br.edu.unoescsmo.bootweb.model.Pessoa;

public interface PessoaRegra {

	void salvar(Pessoa pessoa);

	void delete(Pessoa pessoa);

	List<Pessoa> listar();
	
	List<Pessoa> listarPorNome(String nome);
	
	List<Pessoa> listarPorCpf(String cpf);

}
