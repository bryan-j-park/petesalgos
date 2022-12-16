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
import org.springframework.web.bind.annotation.RequestMapping;

import com.nightcrew.petesalgos.models.Problem;
import com.nightcrew.petesalgos.services.ProblemService;
import com.nightcrew.petesalgos.services.UserService;

@Controller
public class DashboardController {
  @Autowired
  private UserService userService;
  
 
  @Autowired
  private ProblemService problemService;



@GetMapping("/dashboard")
public String dashboard( HttpSession session, Model model){
  
  Boolean userSession = session.getAttribute("userId") == null; 

  if(userSession){
    return "redirect:/logout";
  }
  else{
    // if user in session, pass to dashboard page showing problems
    model.addAttribute("problemList", problemService.allProblems());
    return "dashboard.jsp";
  }
}

// Display page

@GetMapping("display/problem/{id}")
public String displayProblem(@PathVariable("id")Long id,Model model, HttpSession session){

  Boolean userSession = session.getAttribute("userId") == null; 

  if(userSession){
    return "redirect:/logout";
  } else{

    Problem problem = problemService.getProblem(id);

    model.addAttribute("problem", problem);
    model.addAttribute("user", problem.getUser());
    return "displayProblem.jsp";
  }
}


}
