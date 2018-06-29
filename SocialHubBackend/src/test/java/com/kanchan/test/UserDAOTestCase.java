package com.kanchan.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kanchan.dao.UserDAO;
import com.kanchan.model.UserDetail;



public class UserDAOTestCase
{
	static UserDAO userDAO;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.kanchan");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
		
	}
	@Ignore
	@Test
	public void registerUserTestCase()
	{
		UserDetail userDetail=new UserDetail();
		
		userDetail.setLoginname("rajesh");
		userDetail.setPassword("pass123");
		userDetail.setUsername("Rajesh Kumar");
		userDetail.setEmailid("rajesh@gmail.com");
		userDetail.setRole("ROLE_USER");
		userDetail.setAddress("Hyderabad");
		userDetail.setMobile("9988877755");
		
		assertTrue("Problem in Registering the User:",userDAO.registerUser(userDetail));
	}
	
	@Test
	public void updateUserTestCase()
	{
		UserDetail userDetail=userDAO.getUser("rajesh");
		userDetail.setMobile("9988987755");
		
		assertTrue("Problem in Updating User:",userDAO.updateUser(userDetail));
	}
	
	@Test
	public void checkLoginTestCase()
	{
		UserDetail userDetail=new UserDetail();
		userDetail.setLoginname("rajesh");
		userDetail.setPassword("pass123");
		
		UserDetail userDetail1=userDAO.checkUser(userDetail);
		
		assertNotNull("Problem in loginCheck",userDetail1);
		System.out.println("User Name:"+userDetail1.getUsername());
	}
}
