package br.edu.ibmec.projeto_verduras_legumes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.edu.ibmec.projeto_verduras_legumes.models.Newsletter;
import br.edu.ibmec.projeto_verduras_legumes.models.Product;
import br.edu.ibmec.projeto_verduras_legumes.models.Resource;
import br.edu.ibmec.projeto_verduras_legumes.models.User;
import br.edu.ibmec.projeto_verduras_legumes.services.NewsletterService;
import br.edu.ibmec.projeto_verduras_legumes.services.ProductService;
import br.edu.ibmec.projeto_verduras_legumes.services.ResourceService;
import br.edu.ibmec.projeto_verduras_legumes.services.UserService;
import br.edu.ibmec.projeto_verduras_legumes.utils.ModelHelper;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ProductService productService;

	@Autowired
	private ResourceService resourceService;

	@Autowired
	private NewsletterService newsletterService;
        
        @Autowired
        private UserService userService;

	// todo restore login logic
	// oh fuck i dont remember how the fuck spring auth works.

	@GetMapping({ "/login", "/admin/login" })
	public String login(Model model) {
	Resource banner = resourceService.findByID(1);
	model.addAttribute("banner", banner);

	model.addAttribute("user", new User());

	return "admin/login";
	}
        
        @PostMapping("/login")
            public String processLogin(
                @RequestParam("email") String email,
                @RequestParam("senha") String senha,
                HttpSession session,
                Model model
            ) {
    // Busca o usuário pelo email (assegure-se de que seu userService tenha esse método)
    User user = userService.findByEmail(email);
    
    // Se o usuário existir e a senha bater (usando BCrypt para verificar)
    if (user != null && new BCryptPasswordEncoder().matches(senha, user.getPassword())) {
        // Salva o usuário na sessão (ou apenas um flag de login)
        session.setAttribute("loggedInUser", user);
        // Redireciona para a página principal do admin
        return "redirect:/admin/home";
    } else {
        // Se falhar, adiciona uma mensagem de erro e retorna para a página de login
        model.addAttribute("errorMessage", "Email ou senha inválidos.");
        return "admin/login";
    }
}
     
	@GetMapping("/register")
	public String interface_register(Model model) {
	model.addAttribute("user", new User());

	return "admin/register";
	}

	@PostMapping("/register")
	public String process_register(User user) {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	//System.out.println(user.getPassword());
	//System.out.println(user.getEmail());
	//System.out.println(user.getName());

	String hashed_password = encoder.encode(user.getPassword());
	user.setPassword(hashed_password);

	userService.save(user);

	return "redirect:/admin/login";
	}

	@GetMapping({ "/home", "", "/" })
	public String admin_home(Model model) {
		ModelHelper modelHelper = new ModelHelper(resourceService, model);

		modelHelper.addBanner();
		modelHelper.addFooterThings();

		return "admin/portal";
	}

	@GetMapping("/newsletter")
	public String admin_newsletter(Model model) {
		ModelHelper modelHelper = new ModelHelper(resourceService, model);

		modelHelper.addBanner();
		modelHelper.addFooterThings();

		Newsletter[] newsletters = newsletterService.getNewsletters();
		model.addAttribute("newsletters", newsletters);

		return "admin/newsletter";
	}

	@GetMapping({ "/produtos", "/produto", "/product", "/products" })
	public String admin_product(Model model) {
		ModelHelper modelHelper = new ModelHelper(resourceService, model);

		modelHelper.addBanner();
		modelHelper.addFooterThings();

		Product[] produtos = productService.getProducts();
		model.addAttribute("products", produtos);

		// new empty product for the form
		model.addAttribute("product", new Product());

		return "admin/product";
	}

	@GetMapping({ "/resources", "/resource", "/recursos", "/recurso" })
	public String admin_resource(Model model) {
		ModelHelper modelHelper = new ModelHelper(resourceService, model);

		modelHelper.addBanner();
		modelHelper.addFooterThings();

		Resource[] resources = resourceService.getResources();
		model.addAttribute("resources", resources);

		// new empty product for the form
		model.addAttribute("resource", new Resource());

		return "admin/resource";
	}
}
