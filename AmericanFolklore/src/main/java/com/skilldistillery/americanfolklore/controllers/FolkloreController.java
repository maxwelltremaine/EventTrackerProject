package com.skilldistillery.americanfolklore.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.americanfolklore.data.FolkloreDAO;
import com.skilldistillery.americanfolklore.entities.Folklore;
import com.skilldistillery.americanfolklore.services.FolkloreService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("api")
public class FolkloreController {

	@Autowired
	private FolkloreService folkloreService;
	
	@Autowired
	private FolkloreDAO folkloreDao;
	
	
	@GetMapping(path = {"folklore", "folklore/"})
	public List<Folklore> index(){
		List<Folklore> folklore = folkloreService.getAllFolklore();
		return folklore;
		

		}
	
	@GetMapping("folklore/{folkloreId}")
	public Folklore getFolklore(@PathVariable("folkloreId") Integer folkloreId, 
			HttpServletResponse res
	) {
		Folklore folklore = folkloreService.getFolklore(folkloreId);
		if (folklore == null) {
			res.setStatus(404);
		}
		return folklore;
	}
	
	@PostMapping("folklore")
	public Folklore addFolklore(@RequestBody Folklore newFolklore,
			HttpServletResponse res,
			HttpServletRequest req
	) {
		try {
			newFolklore = folkloreDao.Create(newFolklore);
			res.setStatus(201);
			res.setHeader("Location", req.getRequestURL().append("/").append(newFolklore.getId()).toString());
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			newFolklore = null;
		}
		return newFolklore;
	}
	
	@PutMapping("folklore/{folkloreId}")
	public Folklore updateFolklore(@PathVariable("folkloreId") Integer folkloreId,
			@RequestBody Folklore folklore,
			HttpServletResponse res
	) {
		try {
			folklore = folkloreDao.Update(folkloreId, folklore);
			if (folklore == null) {
				res.setStatus(404);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.setStatus(400);
			folklore = null;
		}
		return folklore;
	}
	
	@DeleteMapping("folklore/{folkloreId}")
	public void deletePost(@PathVariable("folkloreId") Integer folkloreId, HttpServletResponse res) {
		try {
			if ( folkloreService.deleteById(folkloreId) ) {
				res.setStatus(204);
			}
			else {
				res.setStatus(404);
			}
		} catch (Exception e) {
			res.setStatus(400);
		}
	}
	
	
	
	
	
	
}
