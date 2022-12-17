package com.nightcrew.petesalgos.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nightcrew.petesalgos.models.Problem;
import com.nightcrew.petesalgos.services.ProblemService;

@Controller
public class MainController {
  @Autowired
  private ProblemService problemService;

// ============== Display Algo By Id ==================
  @GetMapping("/algo/{id}")
  public String algo(@PathVariable("id") Long id, Model model, HttpSession session) {
    Boolean notInSession = session.getAttribute("userId") == null;
    if(notInSession){
      return "redirect:/";
    } 
    else{
      Problem problem = problemService.getProblem(id);
      model.addAttribute("problem", problem);
      return "algo.jsp";
    }
  }

}
