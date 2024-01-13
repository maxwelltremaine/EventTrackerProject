package com.skilldistillery.americanfolklore.services;

import java.util.List;
import java.util.Optional;

import com.skilldistillery.americanfolklore.entities.Folklore;

public interface FolkloreService {

	List<Folklore> getAllFolklore();
	Folklore getFolkloreById(int folkloreId);
	List<Folklore> getFolkloreByCategory(); 

}
