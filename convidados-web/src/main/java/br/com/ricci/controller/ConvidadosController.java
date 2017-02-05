package br.com.ricci.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.ricci.model.Convidado;
import br.com.ricci.service.ConvidadosService;
import br.com.ricci.service.EmailService;

@Controller
public class ConvidadosController {

	@Autowired
	private ConvidadosService convidadosService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model) {
		Iterable<Convidado> convidados = convidadosService.obterTodos();
		model.addAttribute("convidados", convidados);
		return "listaconvidados";
	}

	@RequestMapping(value = "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email,
			@RequestParam("telefone") String telefone, Model model) {

		Convidado convidado = new Convidado(nome, email, telefone);
		convidadosService.salvar(convidado);
		new EmailService().enviaEmail(convidado.getNome(), convidado.getEmail());
		return listaConvidados(model);
	}
}
