package com.nightcrew.petesalgos.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.nightcrew.petesalgos.models.Problem;
import com.nightcrew.petesalgos.services.ProblemService;

@Controller
public class AdminController {
  @Autowired
  private ProblemService problemService;

//  ========== Create Problem Page =========
  @GetMapping("/problem/new")
  public String createProblemPage(@ModelAttribute("problem") Problem problem, 
      Model model, HttpSession session){
    Boolean notInSession = session.getAttribute("userId") == null; 
    if(notInSession){
      return "redirect:/";
    }
    else{
      return "addProblem.jsp";
    }
  }

// =============== Process New Problem Form ================
  @PostMapping("/problem/new")
  public String submitProblem(@Valid @ModelAttribute("problem")Problem problem, 
      BindingResult result, Model model, HttpSession session){
    Boolean notInSession = session.getAttribute("userId") == null; 
    if(notInSession){
      return "redirect:/";
    }
    if(result.hasErrors()){
      return "addProblem.jsp";
    }
    else{
      problemService.createProblem(problem);
      return "redirect:/dashboard";
    }
  }

// ================= Edit Problem Page ====================
  @GetMapping("/problem/edit/{id}")
  public String edit(@PathVariable("id")Long id, 
      Model model, HttpSession session){
    Boolean notInSession = session.getAttribute("userId") == null; 
    if(notInSession){
      return "redirect:/";
    }
    else{
      Problem problem = problemService.getProblem(id);
      model.addAttribute("problem", problem);
      return "editProblem.jsp";
    }
  }

// ==================== Process Edit Form ======================
  @PutMapping("/problem/edit/{id}")
	public String editProblemForm(@Valid @ModelAttribute("problem")Problem problem, 
      BindingResult result,HttpSession session) {
    Boolean notInSession = session.getAttribute("userId") == null; 
		if(notInSession) {
			return "redirect:/";
		}
		if(result.hasErrors()) {
			return "editProblem.jsp";
		}
		else {
			problemService.editProblem(problem);
			return "redirect:/dashboard";
		}
	}

// ================ Delete Problem By Id ==========================
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		problemService.deleteProblem(id);
		return "redirect:/dashboard";
  }

// ================== About Page =======================
  @GetMapping("/about")
  public String about(){
    return "about.jsp";
  }

// =================== Credit Page =======================
  @GetMapping("/credits")
  public String credits(){
    return "credits.jsp";
  }
}
