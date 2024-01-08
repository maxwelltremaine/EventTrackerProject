package com.skilldistillery.americanfolklore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.americanfolklore.entities.Folklore;

public interface FolkloreRepository extends JpaRepository<Folklore, Integer> {
	List<Folklore> findByCategoryLike(String keyword);
	List<Folklore> findByNameLike(String keyword);
	List<Folklore> findByEnabledTrue();
}
