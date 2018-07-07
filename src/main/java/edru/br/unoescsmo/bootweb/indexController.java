package edru.br.unoescsmo.bootweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.edu.unoescsmo.regras.PessoaRegra;

@Controller
public class indexController {
	
	@Autowired
	private PessoaRegra pessoaRegra;
	
	@GetMapping("/")
	@ResponseBody
	public String salvarPessoa() {
		return pessoaRegra.Salvar();
	}

}
