package com.skilldistillery.americanfolklore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.americanfolklore.entities.Folklore;
import com.skilldistillery.americanfolklore.services.FolkloreService;

@RestController
@RequestMapping("api")
public class FolkloreController {

	@Autowired
	private FolkloreService folkloreService;
	
	
	@GetMapping("folklore")
	public List<Folklore> index(){
		List<Folklore> folklore = folkloreService.getAllFolklore();
		return folklore;
		}
	
	
}
