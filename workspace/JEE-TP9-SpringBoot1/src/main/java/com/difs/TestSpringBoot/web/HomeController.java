package com.difs.TestSpringBoot.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.difs.TestSpringBoot.model.Livre;
import com.difs.TestSpringBoot.model.LivreRepository;

@RestController
public class HomeController {
	
	@Autowired
	private LivreRepository repository;
	
	@Value("${app.nom:BOB}")
	private String nom;
	
	@RequestMapping("/")
	public String sayHello() {
		return "Hello, it works ! Hi, " + nom;
	}
	
	@GetMapping("/vue")
	public ModelAndView getVue() {
		ModelAndView modelAndView = new ModelAndView("vue");
		modelAndView.addObject("message", "La date : " + new Date());
		List<Livre> livres = new ArrayList<Livre>();
		repository.findAll().forEach(livres::add);
		modelAndView.addObject("livres", livres);
		return modelAndView;
	}
}

