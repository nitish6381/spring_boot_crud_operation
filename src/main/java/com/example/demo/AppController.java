package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Category;
import com.example.demo.Expense;

import com.example.demo.CategoryRepository;

import com.example.demo.ExpenseRepository;

@Controller
public class AppController {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private ExpenseRepository repo1;
	@Autowired
	private CategoryRepository repo2;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		userRepo.save(user);
		
		return "register_success";
	}
	@GetMapping("/users")
	public String after_login()
	{
		return "users";
	}
	@GetMapping("/usr")
	public String listUsers(Model model) {
		List<Expense> listUsers = repo1.findAll();
		model.addAttribute("listUsers", listUsers);
		
		return "allexpense";
	}
	@RequestMapping("/new_category")
	public String after_login_new_category()
		{
			return "new_category";
		}
	
	@RequestMapping("/new_expense")
	public String after_login_new_expense()
		{
			return "new_expense";
		}
	@PostMapping("/Expense_Dtls")
		public String expense_add(@ModelAttribute Expense t)
		{
			System.out.println(t);
			repo1.save(t);
			return "/new_expense";
			
		}
	@PostMapping("/Category_Dtls")
	public String category_add(@ModelAttribute Category t)
	{
		System.out.println(t);
		repo2.save(t);
		return "/new_category";
	}
}
