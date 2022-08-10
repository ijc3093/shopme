package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;

import antlr.collections.List;
//import java.util.List;
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
	
	@Autowired
	private RoleRepository repo;
	
	@Test
	public void testCreateFirstRole() {
		Role roleAdmin = new Role("Admin", "manage everythings");
		Role savedRole = repo.save(roleAdmin);
		assertThat(savedRole.getId()).isGreaterThan(0);
	}
	
	
	@Test
	public void testCreateFirstRoles() {
		Role roleAdmin2 = new Role("Admin", "manage everythings");
		Role roleSalesperson = new Role("Salesperson", "manage product price, customers, shipping, orders and sales report");
		
		Role roleEditor = new Role("Editor", "manage cateries, brands, products, articles and menus");
		
		Role roleShipper = new Role("Shipper", "view product, view orders and update order status");
		
		Role roleAssistant = new Role("Assistant", "manage questions and reviews");
		
		Role savedRole = repo.save(roleAdmin2);
		Role savedRole1 = repo.save(roleSalesperson);
		Role savedRole2 = repo.save(roleEditor);
		Role savedRole3 = repo.save(roleShipper);
		Role savedRole4 = repo.save(roleAssistant);
		
		assertThat(savedRole.getId()).isGreaterThan(0);
		assertThat(savedRole1.getId()).isGreaterThan(0);
		assertThat(savedRole2.getId()).isGreaterThan(0);
		assertThat(savedRole3.getId()).isGreaterThan(0);
		assertThat(savedRole4.getId()).isGreaterThan(0);
		
		//Issue with "of"
		//repo.saveAll(List.of(roleSalesperson, roleEditor, roleShipper, roleAssistant));

	}
}
