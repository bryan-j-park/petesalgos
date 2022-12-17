package com.nightcrew.petesalgos.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.nightcrew.petesalgos.models.Problem;
import com.nightcrew.petesalgos.models.User;
import com.nightcrew.petesalgos.services.ProblemService;
import com.nightcrew.petesalgos.services.UserService;

@Controller
public class DashboardController {
  @Autowired
  private ProblemService problemService;

  @Autowired
  private UserService userService;

// ============= Dashboard ==================
  @GetMapping("/dashboard")
  public String dashboard(Model model, HttpSession session){
    Boolean notInSession = session.getAttribute("userId") == null; 
    if(notInSession){
      return "redirect:/";
    }
    else{
    model.addAttribute("problemList", problemService.allProblems());
    return "dashboard.jsp";
    }
  }

// =============== Favorite Button Code ==========================
  @PutMapping("/favorites/{id}/receive")
  public String favoriteProblem(@PathVariable("id")Long problemId,HttpSession session){
    Long userId = (Long) session.getAttribute("userId");
    User loggedInUser = userService.getOneUser(userId);
    Problem problem = problemService.getProblem(problemId);
    problemService.favoriteProblem(loggedInUser, problem);
    return "redirect:/dashboard";
  }


}
