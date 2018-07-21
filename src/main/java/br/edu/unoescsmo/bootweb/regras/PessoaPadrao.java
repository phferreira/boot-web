package br.edu.unoescsmo.bootweb.regras;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoescsmo.bootweb.model.Pessoa;
import br.edu.unoescsmo.bootweb.repository.PessoaRepository;

@Service
public class PessoaPadrao implements PessoaRegra {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Override
	public void salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);
	}

	public List<Pessoa> listar() {
		return pessoaRepository.findAll();

	}
	
	@Override
	public List<Pessoa> listarPorNome(String nome) {
		return pessoaRepository.findByNomeLike("%"+nome+"%");

	}
	
	@Override
	public List<Pessoa> listarPorCpf(String cpf) {
		return pessoaRepository.findByCpf(cpf);

	}

	@Override
	public void delete(Pessoa pessoa) {
		pessoaRepository.delete(pessoa);
	}

	@Override
	public Pessoa buscarPorCodigo(Long codigo) {
		return pessoaRepository.findById(codigo).orElse(new Pessoa());
	}
}
