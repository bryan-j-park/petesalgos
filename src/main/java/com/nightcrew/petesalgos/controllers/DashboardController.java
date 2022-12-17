package com.nightcrew.petesalgos.controllers;

import java.util.ArrayList;
import java.util.List;

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
      // if user is logged in, gets userId from session and uses it to get the user object.
      Long userId = (Long) session.getAttribute("userId");
      User loggedInUser = userService.getOneUser(userId);

      // gets a list of all the problems from problemService and creates an empty list of favorite Problem.
    List<Problem> allProblems = problemService.allProblems();
    List<Problem> favoriteProblem = new ArrayList<>();

// iterates over the all problem list of allProblems and checks id the logged in user has favorited each problem.
// If a problem has been favorited by the logged-in user, it is added to the list of favorite problem.
    for(Problem problem : allProblems){
      if(problem.getFavorited().contains(loggedInUser)){
        favoriteProblem.add(problem);
      }
    }


    model.addAttribute("problemList", allProblems);
    model.addAttribute("favList", favoriteProblem);
    return "dashboard.jsp";
    }
  }
// hello
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
