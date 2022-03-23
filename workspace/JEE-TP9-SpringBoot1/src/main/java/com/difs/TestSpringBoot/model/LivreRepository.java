package com.difs.TestSpringBoot.model;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface LivreRepository extends CrudRepository<Livre, Integer>{

	Livre findByTitre(String titre);
	
	Collection<Livre> findByAuteur(String auteur);

}
