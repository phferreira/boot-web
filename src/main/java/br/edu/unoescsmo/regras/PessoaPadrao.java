package br.edu.unoescsmo.regras;

import org.springframework.stereotype.Service;

@Service
public class PessoaPadrao implements PessoaRegra {

	@Override
	public String Salvar() {
		return "Testando o salvar pessoa";
	}
	
}
