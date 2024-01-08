package com.skilldistillery.americanfolklore.data;

import org.springframework.stereotype.Service;

import com.skilldistillery.americanfolklore.entities.Folklore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class FolkloreDAOImpl implements FolkloreDAO {
	
	@PersistenceContext
	private EntityManager em;


	@Override
	public Folklore Create(Folklore folklore) {
		em.persist(folklore);
		return folklore;
	}

	@Override
	public Folklore Update(int folkloreId, Folklore folklore) {
		Folklore existing = em.find(Folklore.class, folkloreId);
		if (existing != null) {
			existing.setName(folklore.getName());;
			existing.setCategory(folklore.getCategory());
			existing.setDescription(folklore.getDescription());
			existing.setState(folklore.getState());
			existing.setCity(folklore.getCity());
			existing.setStreet(folklore.getStreet());
			existing.setLoreUrl(folklore.getLoreUrl());			
			em.flush();
		}
		return existing;
	}

}
