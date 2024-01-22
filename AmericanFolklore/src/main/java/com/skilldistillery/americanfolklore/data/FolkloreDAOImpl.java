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
		folklore.setEnabled(true);
		if( folklore.getImageUrl() == null || folklore.getImageUrl().equals("")) {
			folklore.setImageUrl("https://i.imgur.com/IEdhJoy.jpg");
		}
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
			existing.setImageUrl(folklore.getImageUrl());
			existing.setLore(folklore.getLore());
			existing.setLocation(folklore.getLocation());
			existing.setLoreUrl(folklore.getLoreUrl());			
			existing.setEnabled(true);
			if(existing.getImageUrl() == null || folklore.getImageUrl().equals("")) {
				existing.setImageUrl("https://i.imgur.com/IEdhJoy.jpg");
			}
			em.flush();
		}
		return existing;
	}

	@Override
	public boolean Delete(int folkloreId) {
		Folklore existing = em.find(Folklore.class, folkloreId);
		existing.setEnabled(false);
		em.flush();
		return true;
	}


}
