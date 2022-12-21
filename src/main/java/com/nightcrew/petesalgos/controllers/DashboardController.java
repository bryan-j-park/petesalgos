package com.nightcrew.petesalgos.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
      model.addAttribute("user", loggedInUser);
      
      List<String> datatypes = problemService.datatypes();
      model.addAttribute("datatypes", datatypes);
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

// ================== Get Solved Problems By User Id ============
    List<Problem> solvedProblems = loggedInUser.getProblemsSolved();
    Set<Long> solvedProblemIds = new HashSet<>();
    for(Problem problem : solvedProblems){
      solvedProblemIds.add(problem.getId());
    }
    model.addAttribute("solvedProblemIds", solvedProblemIds);
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

// =============== Remove Favorite Button Code ==========================

  @PutMapping("/favorites/{id}/delete")
  public String deleteFavProblem(@PathVariable("id")Long problemId,HttpSession session){
    Long userId = (Long) session.getAttribute("userId");
    User loggedInUser = userService.getOneUser(userId);
    Problem problem = problemService.getProblem(problemId);
    problemService.deleteFav(loggedInUser, problem);
    return "redirect:/dashboard";
  }

  // ================= Sort DataType ===================
  @GetMapping("/sort/{datatype}")
  public String sortByDatatype(@PathVariable("datatype") String datatype,Model model, HttpSession session){
    Boolean notInSession = session.getAttribute("userId") == null; 
    if(notInSession){
      return "redirect:/";
    }
    else{
      List<Problem> sortDataType = problemService.sortDataType(datatype);

      model.addAttribute("datatype", sortDataType);

    return "test.jsp";
  }


}
  @GetMapping("/dashboard/{difficulty}")
  public String dashboardSort(@PathVariable("difficulty") String difficulty, Model model, HttpSession session){
    Boolean notInSession = session.getAttribute("userId") == null; 
    if(notInSession){
      return "redirect:/";
    }
    else{
      // if user is logged in, gets userId from session and uses it to get the user object.
      Long userId = (Long) session.getAttribute("userId");
      User loggedInUser = userService.getOneUser(userId);
      model.addAttribute("user", loggedInUser);

      List<String> datatypes = problemService.datatypes();
      model.addAttribute("datatypes", datatypes);
      // gets a list of all the problems from problemService and creates an empty list of favorite Problem.
    List<Problem> sortedProblems = problemService.sortDifficulty(difficulty);
    List<Problem> allProblems = problemService.allProblems();
    List<Problem> favoriteProblem = new ArrayList<>();

  // iterates over the all problem list of allProblems and checks id the logged in user has favorited each problem.
  // If a problem has been favorited by the logged-in user, it is added to the list of favorite problem.
    for(Problem problem : allProblems){
      if(problem.getFavorited().contains(loggedInUser)){
        favoriteProblem.add(problem);
      }
    }

    model.addAttribute("difficulty", difficulty);
    model.addAttribute("problemList", allProblems);
    model.addAttribute("favList", favoriteProblem);
    model.addAttribute("sortedProblems", sortedProblems);

  // ================== Get Solved Problems By User Id ============
    List<Problem> solvedProblems = loggedInUser.getProblemsSolved();
    Set<Long> solvedProblemIds = new HashSet<>();
    for(Problem problem : solvedProblems){
      solvedProblemIds.add(problem.getId());
    }
    model.addAttribute("solvedProblemIds", solvedProblemIds);
    return "sortedDashboard.jsp";
    }
}
}
