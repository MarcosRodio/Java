package com.mr.cobranca20.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mr.cobranca20.model.Titulo;
import com.mr.cobranca20.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloControler {
	
	@Autowired // cria instancia de titulos
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public String novo() {
		return "cadastrotitulo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> todostitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulo");
		mv.addObject("titulos",todostitulos);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Titulo titulo) {
		titulos.save(titulo);
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject("mensagem", "Titulo Salvo com sucesso!");
		return mv;
	}
}
