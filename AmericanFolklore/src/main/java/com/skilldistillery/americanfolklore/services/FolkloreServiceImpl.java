package com.skilldistillery.americanfolklore.services;

import java.util.List;
import java.util.Optional;

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
		Optional<Folklore> gotFolklore = folkloreRepo.findById(folkloreId);
		if(gotFolklore.isEmpty()) {
			return null;
		}
		return gotFolklore.get();
		
	}

	@Override
	public boolean deleteById(int folkloreId) {
		folkloreRepo.deleteById(folkloreId);
		if(getFolklore(folkloreId) != null) {
			return false;
		}
		return true;
	}


}
