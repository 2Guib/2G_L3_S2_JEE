package com.difs.TestSpringBoot.web;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.difs.TestSpringBoot.model.Livre;
import com.difs.TestSpringBoot.model.LivreRepository;

@RestController
public class AjouteController {
	
	private Random random;
	
	@Autowired
	private LivreRepository repository;
	
	public AjouteController() {
		this.random = new Random();
	}
	
	@RequestMapping("/ajoute")
	public String addRandomLivre() {
		Livre l = new Livre();
		l.setTitre("Livre "+random.nextInt(1000));
		l.setAuteur("DIFS");
		repository.save(l);
		return "Ajout de " + l.getTitre();
	}
}
