package com.nightcrew.petesalgos.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.nightcrew.petesalgos.models.LoginUser;
import com.nightcrew.petesalgos.models.Problem;
import com.nightcrew.petesalgos.models.User;
import com.nightcrew.petesalgos.services.ProblemService;
import com.nightcrew.petesalgos.services.UserService;

@Controller
public class MainController {
    @Autowired
	private UserService userService;

	@Autowired
	private ProblemService problemService;



	@GetMapping("/")
	public String logreg(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "logreg.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result, Model model, HttpSession session) {
		User registeredUser = userService.register(newUser, result);
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "logreg.jsp";
		}
		else {
			session.setAttribute("userId", registeredUser.getId());
			session.setAttribute("username", registeredUser.getUserName());
			return "redirect:/dashboard";
		}
		
	}
	
 
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result, Model model, HttpSession session) {
		User loginUser = userService.login(newLogin, result);
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "logreg.jsp";
		}
		else {
			session.setAttribute("userId", loginUser.getId());
			session.setAttribute("userName", loginUser.getUserName());
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

    @GetMapping("/algo")
    public String algo() {
        return "algo.jsp";
    }

		// ================= Adding Problem Page =================
	@GetMapping("/add/problem")
	public String addProblem(@ModelAttribute("problem") Problem problem, HttpSession session){
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		return "addProblem.jsp";
	}

// ================= Submitting Problem to Database =================
	@PostMapping("/add/problem")
	public String submitProblem(@Valid @ModelAttribute("problem") Problem problem, BindingResult result, 
			Model model, HttpSession session){
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "addProblem.jsp";
		}
		problemService.createProblem(problem);
		return "redirect:/algo";
	}

// ===================== View Problem by ID ======================
	@GetMapping("/view/problem/{id}")
	public String viewProblem( @PathVariable("id") Long id, Model model, HttpSession session){
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		model.addAttribute("problem", problemService.getProblem(id));
		return "problem.jsp";
	}

















}
