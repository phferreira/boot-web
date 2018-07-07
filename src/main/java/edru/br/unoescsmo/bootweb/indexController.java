package edru.br.unoescsmo.bootweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class indexController {

	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "Testando Controller";
	}

}
