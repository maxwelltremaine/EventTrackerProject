package com.skilldistillery.americanfolklore.data;

import com.skilldistillery.americanfolklore.entities.Folklore;

public interface FolkloreDAO {
	Folklore Create(Folklore folklore);
	Folklore Update(int folkloreId, Folklore folklore);

}
