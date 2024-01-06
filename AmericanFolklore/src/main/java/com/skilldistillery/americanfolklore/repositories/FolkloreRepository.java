package com.skilldistillery.americanfolklore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.americanfolklore.entities.Folklore;

public interface FolkloreRepository extends JpaRepository<Folklore, Integer> {

}
