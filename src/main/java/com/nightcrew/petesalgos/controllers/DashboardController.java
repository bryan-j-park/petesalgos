package com.nightcrew.petesalgos.controllers;

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
    // ---------------- Dashboard Variables ----------------
    Long userId = (Long) session.getAttribute("userId"); // if user is logged in, gets userId from session
    User loggedInUser = userService.getOneUser(userId); // uses userId to get the user object assigned to the id number.
    List<String> datatypes = problemService.datatypes(); // gets a list of datatypes
    List<Problem> allProblems = problemService.allProblems(); // gets a list of all the problems

    // ---------------- Dashboard Models ----------------
    model.addAttribute("user", loggedInUser);
    model.addAttribute("datatypes", datatypes);
    model.addAttribute("problemList", allProblems);
    model.addAttribute("favList", problemService.getFavoriteProblems(loggedInUser));
    model.addAttribute("solvedProblemIds", problemService.getSolvedProblems(loggedInUser));
    return "dashboard.jsp";
  }

// ================ Sorted Dashboard ==========================
  @GetMapping("/dashboard/{difficulty}")
  public String dashboardSort(@PathVariable("difficulty") String difficulty, 
      Model model, HttpSession session){
    Boolean notInSession = session.getAttribute("userId") == null; 
    if(notInSession){
      return "redirect:/";
    }

    // ---------------- Sorted Dashboard Variables ----------------
    Long userId = (Long) session.getAttribute("userId"); // if user is logged in, gets userId from session
    User loggedInUser = userService.getOneUser(userId); // uses userId to get a user based on the id
    List<String> datatypes = problemService.datatypes(); // gets a list of datatypes 
    List<Problem> sortedProblems = problemService.sortDifficulty(difficulty); // gets a list of sorted problems
    List<Problem> allProblems = problemService.allProblems(); // gets a list of all the problems

    // ---------------- Sorted Dashboard Models ----------------
    model.addAttribute("user", loggedInUser);
    model.addAttribute("datatypes", datatypes);
    model.addAttribute("difficulty", difficulty);
    model.addAttribute("problemList", allProblems);
    model.addAttribute("favList", problemService.getFavoriteProblems(loggedInUser));
    model.addAttribute("sortedProblems", sortedProblems);
    model.addAttribute("solvedProblemIds", problemService.getSolvedProblems(loggedInUser));
    return "sortedDashboard.jsp";
  }

// ===================== Sort Datatype Dashboard =======================
@GetMapping("/sort/{datatype}")
public String sortDatatype(@PathVariable("datatype") String datatype, Model model, HttpSession session){
  Boolean notInSession = session.getAttribute("userId") == null; 
  if(notInSession){
    return "redirect:/";
  }

  // ---------------- Sort Datatype Dashboard Variables ----------------
  Long userId = (Long) session.getAttribute("userId"); // gets userId from session
  User loggedInUser = userService.getOneUser(userId); // gets a user based on the id
  List<String> datatypes = problemService.datatypes(); // gets a list of datatypes
  List<Problem> sortDataType = problemService.sortDataType(datatype); // gets a list of problems sorted by datatype
  List<Problem> allProblems = problemService.allProblems(); // gets a list of all problems

  // ---------------- Sort Datatype Dashboard Models ----------------
  model.addAttribute("user", loggedInUser);
  model.addAttribute("datatypeName", datatype);
  model.addAttribute("datatypes", datatypes);
  model.addAttribute("datatypeProblems", sortDataType);
  model.addAttribute("problemList", allProblems);
  model.addAttribute("favList", problemService.getFavoriteProblems(loggedInUser));
  model.addAttribute("solvedProblemIds", problemService.getSolvedProblems(loggedInUser));
  return "datatype.jsp";
}

// ===================== Sort Datatype and Difficulty Dashboard =======================
@GetMapping("/sort/{datatype}/{difficulty}")
public String sortDatatypeByDifficulty(@PathVariable("datatype") String datatype, 
    @PathVariable("difficulty") String difficulty, Model model, HttpSession session){
  Boolean notInSession = session.getAttribute("userId") == null; 
  if(notInSession){
    return "redirect:/";
  }
  // ----------------- Sort Datatype Dashboard Variables ----------------
  Long userId = (Long) session.getAttribute("userId"); // if logged in gets userId from session
  User loggedInUser = userService.getOneUser(userId); // gets user by userId
  List<String> datatypes = problemService.datatypes(); // gets a string of datatypes
  List<Problem> sortDataType = problemService.sortDataType(datatype); // gets list of problems sorted by datatype
  List<Problem> allProblems = problemService.allProblems(); // gets a list of all problems
  List<Problem> sortedProblems = problemService.sortDatatypeDifficulty(datatype, difficulty); // gets list of problems sorted by datatype and difficulty

  // ------------------ Sort Datatype Dashboard Models -----------------
  model.addAttribute("user", loggedInUser);
  model.addAttribute("datatypeName", datatype);
  model.addAttribute("datatypes", datatypes);
  model.addAttribute("datatypeProblems", sortDataType);
  model.addAttribute("problemList", allProblems);
  model.addAttribute("favList", problemService.getFavoriteProblems(loggedInUser));
  model.addAttribute("sortedProblems", sortedProblems);
  model.addAttribute("solvedProblemIds", problemService.getSolvedProblems(loggedInUser));
  return "sortedDatatype.jsp";
}

// =============== Favorite Button Code ==========================
  @PutMapping("/favorites/{problemId}/receive")
  public String favoriteProblem(@PathVariable("problemId")Long problemId,HttpSession session){
    problemService.favoriteProblem((Long)session.getAttribute("userId"), problemId);
    return "redirect:/dashboard";
  }

  @PutMapping("/{difficulty}/favorites/{problemId}/receive")
  public String sortedDashboardFavoriteProblem(@PathVariable("difficulty") String difficulty, 
      @PathVariable("problemId")Long problemId,HttpSession session){
    problemService.favoriteProblem((Long)session.getAttribute("userId"), problemId);
    return "redirect:/dashboard/{difficulty}";
  }

  @PutMapping("/favorites/{problemId}/receive/{datatype}")
  public String datatypeFavoriteProblem(@PathVariable("datatype") String datatype, 
      @PathVariable("problemId")Long problemId,HttpSession session){
    problemService.favoriteProblem((Long)session.getAttribute("userId"), problemId);
    return "redirect:/sort/{datatype}";
  }

  @PutMapping("/add/favorites/{problemId}/{datatype}/{difficulty}")
  public String sortedDatatypeFavoriteProblem(@PathVariable("problemId") Long problemId, 
      @PathVariable("datatype")String datatype, @PathVariable("difficulty")String difficulty,HttpSession session){
    problemService.favoriteProblem((Long)session.getAttribute("userId"), problemId);
    return "redirect:/sort/{datatype}/{difficulty}";
  }

// =============== Remove Favorite Button Code ==========================

  @PutMapping("/favorites/{problemId}/delete")
  public String deleteFavProblem(@PathVariable("problemId")Long problemId,HttpSession session){
    problemService.deleteFav((Long)session.getAttribute("userId"), problemId);
    return "redirect:/dashboard";
  }

  @PutMapping("/{difficulty}/favorites/{id}/delete")
  public String sortedDashboardDeleteFavProblem(@PathVariable("difficulty")String difficulty,
      @PathVariable("id")Long problemId,HttpSession session){
    problemService.deleteFav((Long)session.getAttribute("userId"), problemId);
    return "redirect:/dashboard/{difficulty}";
  }

  @PutMapping("/favorites/{id}/delete/{datatype}")
  public String datatypeDeleteFavProblem(@PathVariable("datatype")String datatype,
      @PathVariable("id")Long problemId,HttpSession session){
    problemService.deleteFav((Long)session.getAttribute("userId"), problemId);
    return "redirect:/sort/{datatype}";
  }

  @PutMapping("/delete/favorites/{id}/{datatype}/{difficulty}")
  public String sortedDatatypeDeleteFavProblem(@PathVariable("id")Long problemId,
      @PathVariable("datatype") String datatype, @PathVariable("difficulty")String difficulty,HttpSession session){
    problemService.deleteFav((Long)session.getAttribute("userId"), problemId);
    return "redirect:/sort/{datatype}/{difficulty}";
  }

}
