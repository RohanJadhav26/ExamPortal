package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.helper.UserFoundException;
import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.service.UserService;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			 System.out.println("Starting Code");
			 User user =new User();
			  user.setFirstName("Rohan"); 
			  user.setLastName("Jadhav");
			  user.setUsername("Rohan26");
			  user.setPassword(bCryptPasswordEncoder.encode("abc"));
			  user.setEmail("abc@gmail.com");
			  user.setPhone("9876559755");
			  user.setProfile("default.png");
			  
			  Role role1=new Role(); 
			  role1.setId(44L); 
			  role1.setRoleName("ADMIN");
			  
			  Set<UserRole> userRoleSet =new HashSet<>();
			  UserRole userRole =new  UserRole(); 
			  userRole.setRole(role1);
			  userRole.setUser(user);
			 
			  userRoleSet.add(userRole); 
			  User user1 = userService.createUser(user, userRoleSet); 
			  System.out.println(user1.getUsername());
		} catch (UserFoundException e) {
			e.printStackTrace();
		}
		 
		
		
	}
	

}
