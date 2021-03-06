package com.bookstore.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookstore.entity.Customer;

public class CustomerDAOTest {
	
	private static CustomerDAO customerDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerDAO = new CustomerDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		customerDAO.close();
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("tadacsang98@gmail.com");
		customer.setFullname("Dac Sang");
		customer.setCity("Ha Noi");
		customer.setCountry("Viet Nam");
		customer.setAddress("86 mieu dam");
		customer.setPassword("123");
		customer.setPhone("0986888888");
		customer.setZipcode("10000");
		
		Customer savedCustomer = customerDAO.create(customer);
		assertTrue(savedCustomer.getCustomerId() > 0);
	}

	@Test
	public void testGet() {
		Integer customerId = 11;
		Customer customer = customerDAO.get(customerId);
		
		assertNotNull(customer);
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer = customerDAO.get(11);
		String fullName = "Ta Dac Sang";
		customer.setFullname(fullName);
		Customer updatedCustomer = customerDAO.update(customer);
		
		assertTrue(updatedCustomer.getFullname().equals(fullName));
	}
	
	@Test
	public void testDeleteObject() {
		Integer customerId = 11;
		customerDAO.delete(customerId);
		Customer customer = customerDAO.get(11);
		
		assertNull(customer);
	}
	
	@Test
	public void testListAll() {
		List<Customer> listCustomers = customerDAO.listAll();
		for(Customer customer: listCustomers) {
			System.out.println(customer.getFullname());
		}
		assertFalse(listCustomers.isEmpty());
	}
	
	@Test
	public void testCount() {
		long totalCustomers = customerDAO.count();
		assertEquals(1, totalCustomers);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "tadacsang98@gmail.com";
		Customer customer = customerDAO.findByEmail(email);
		
		assertNotNull(customer);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "tadacsang98@gmail.com";
		String password = "sangvjp5";
		
		Customer customer = customerDAO.checkLogin(email, password);
		
		assertNotNull(customer);
	}
	
	@Test
	public void testCheckLoginFail() {
		String email = "tadacsang98@gmail.com";
		String password = "sangvjp58";
		
		Customer customer = customerDAO.checkLogin(email, password);
		
		assertNull(customer);
	}
}
