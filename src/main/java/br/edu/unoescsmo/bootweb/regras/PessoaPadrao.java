package br.edu.unoescsmo.bootweb.regras;

import org.springframework.stereotype.Service;

@Service
public class PessoaPadrao implements PessoaRegra {

	@Override
	public String Salvar() {
		return "Testando o salvar pessoa";
	}
	
}
