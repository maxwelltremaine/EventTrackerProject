package com.skilldistillery.americanfolklore.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

class FolkloreTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Folklore folklore;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("JPAFolkLore");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		folklore = em.find(Folklore.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		folklore = null;
	}

	@Test
	void test() {
		assertNotNull(folklore);
		assertEquals(folklore.getLoreUrl(), "https://www.youtube.com/watch?v=2jnCwbXaDhM");
		assertEquals("Mothman", folklore.getName());
		assertEquals("Creature", folklore.getCategory());
		assertEquals("West Virginian", folklore.getLocation());
		assertEquals(true, folklore.isEnabled());
	}

}
