package br.edu.ibmec.projeto_verduras_legumes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.edu.ibmec.projeto_verduras_legumes.models.User;
import br.edu.ibmec.projeto_verduras_legumes.services.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private UserService userService;

	// @PostMapping({ "/login" })
	// public String login(@RequestBody UserModel userModel) {
	// return "login";
	// }

	@GetMapping("/register")
	public String interface_register(Model model) {
		model.addAttribute("user", new User());

		return "auth/register";
	}

	@PostMapping("/register")
	public String process_register(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		System.out.println(user.getName());

		String hashed_password = encoder.encode(user.getPassword());
		user.setPassword(hashed_password);

		userService.save(user);

		return "auth/register_success";
	}

}
