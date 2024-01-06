package com.skilldistillery.americanfolklore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.americanfolklore.entities.Folklore;
import com.skilldistillery.americanfolklore.repositories.FolkloreRepository;

@Service
public class FolkloreServiceImpl implements FolkloreService {
	
	@Autowired
	private FolkloreRepository folkloreRepo;
	
	@Override
	public List<Folklore> getAllFolklore() {
		return folkloreRepo.findAll();
	}

	@Override
	public Folklore getFolklore(int folkloreId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Folklore create(Folklore folklore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Folklore update(int folkloreId, Folklore folklore) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(int folkloreId) {
		// TODO Auto-generated method stub
		return false;
	}

}
