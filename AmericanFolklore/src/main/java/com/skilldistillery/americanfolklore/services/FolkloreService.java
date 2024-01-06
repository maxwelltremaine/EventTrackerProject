package com.skilldistillery.americanfolklore.services;

import java.util.List;

import com.skilldistillery.americanfolklore.entities.Folklore;

public interface FolkloreService {

	List<Folklore> getAllFolklore();
	Folklore getFolklore(int folkloreId);
	Folklore create(Folklore folklore);
	Folklore update(int folkloreId, Folklore folklore);
	boolean deleteById(int folkloreId);
}
