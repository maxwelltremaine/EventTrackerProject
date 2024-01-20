package com.skilldistillery.americanfolklore.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Folklore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String name;
	private String category;
	private String description;
	@Column(name = "image_url")
	private String imageUrl;
	private String lore;
	private String location;
	@Column(name = "lore_url")
	private String loreUrl;
	
	private boolean enabled;
	
	//consider switch exclusively to location instead of what is above
	//if I do rememeber to update in folklore ts in angular
	
	
	public Folklore() {
		super();
	}

	
	

	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getLore() {
		return lore;
	}




	public void setLore(String lore) {
		this.lore = lore;
	}




	public String getLoreUrl() {
		return loreUrl;
	}




	public void setLoreUrl(String loreUrl) {
		this.loreUrl = loreUrl;
	}





	public String getImageUrl() {
		return imageUrl;
	}




	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public boolean isEnabled() {
		return enabled;
	}




	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}




	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folklore other = (Folklore) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Folklore [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", imageUrl=" + imageUrl + ", lore=" + lore + ", location=" + location + ", loreUrl=" + loreUrl
				+ ", enabled=" + enabled + "]";
	}
	
	

}
