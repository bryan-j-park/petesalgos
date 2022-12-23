package com.nightcrew.petesalgos.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.nightcrew.petesalgos.models.Comment;
import com.nightcrew.petesalgos.models.Problem;
import com.nightcrew.petesalgos.models.User;
import com.nightcrew.petesalgos.repositories.CommentRepository;
import com.nightcrew.petesalgos.repositories.UserRepository;
import com.nightcrew.petesalgos.services.CommentService;
import com.nightcrew.petesalgos.services.ProblemService;
import com.nightcrew.petesalgos.services.UserService;

@Controller
public class MainController {
  @Autowired
  private ProblemService problemService;

  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepo;

  @Autowired
  private CommentService commentService;

  @Autowired
  private CommentRepository commentRepo;

// ============== Display Algo By Id ==================
  @GetMapping("/algo/{id}")
  public String algo(@ModelAttribute("newComment") Comment comment, 
      @PathVariable("id") Long id, Model model, HttpSession session) {
    Boolean notInSession = session.getAttribute("userId") == null;
    if(notInSession){
      return "redirect:/";
    } 
    else{
      Problem problem = problemService.getProblem(id);
      model.addAttribute("problem", problem);
// ================== Get Solved Problems By User Id ============
    Long userId = (Long) session.getAttribute("userId");
    User loggedInUser = userService.getOneUser(userId);
    List<Problem> solvedProblems = loggedInUser.getProblemsSolved();
    Set<Long> solvedProblemIds = new HashSet<>();
    for(Problem algo : solvedProblems){
      solvedProblemIds.add(algo.getId());
    }
    model.addAttribute("solvedProblemIds", solvedProblemIds);
    
    // ================= Comment Section =====================
    List<Comment> allComments = commentService.getCommentDesc(problem);
    model.addAttribute("allComments", allComments);

    return "algo.jsp";
    }
  }

  // ============= Add Solved Algo By userId and problemId ===================
  @PostMapping("/solved/{userId}/{problemId}")
  public String addSolvedProblem(@PathVariable("userId") Long userId, 
      @PathVariable("problemId") Long problemId, HttpSession session){
    Boolean notInSession = session.getAttribute("userId") == null;
    if(notInSession){
      return "redirect:/";
    }
    if(!session.getAttribute("userId").equals(userId)){
      return "algo.jsp";
    }
    userRepo.addSolvedProblem(userId, problemId);
    return "redirect:/algo/{problemId}";
  }

// ============= Delete Solved Algo By userId and problemId ===================
  @DeleteMapping("/delete/{userId}/{problemId}")
  public String deleteSolvedProblem(@PathVariable("userId") Long userId, 
      @PathVariable("problemId") Long problemId){
    userRepo.deleteSolvedProblem(userId, problemId);
    return "redirect:/algo/{problemId}";
  }

// =================== Add Comment ======================
  @PostMapping("/add/comment/{problemId}")
  public String addComment(@Valid @ModelAttribute("newComment") Comment comment, 
      BindingResult result, @PathVariable("problemId")Long problemId, Model model, HttpSession session){
    Boolean notInSession = session.getAttribute("userId") == null; 
    if(notInSession){
      return "redirect:/";
    }
    if(!session.getAttribute("userId").equals(comment.getUser().getId())){
      return "algo.jsp";
    }
    if(result.hasErrors()){
        Problem problem = problemService.getProblem(problemId);
        model.addAttribute("problem", problem);
  // ================== Get Solved Problems By User Id ============
      Long userId = (Long) session.getAttribute("userId");
      User loggedInUser = userService.getOneUser(userId);
      List<Problem> solvedProblems = loggedInUser.getProblemsSolved();
      Set<Long> solvedProblemIds = new HashSet<>();
      for(Problem algo : solvedProblems){
        solvedProblemIds.add(algo.getId());
      }
      model.addAttribute("solvedProblemIds", solvedProblemIds);
      
      // ================= Comment Section =====================
      List<Comment> allComments = commentService.getCommentDesc(problem);
      model.addAttribute("allComments", allComments);
      return "algo.jsp";
    }
      commentService.createComment(comment);
    return "redirect:/algo/{problemId}";
  }

// ===================== Delete Comment ====================
  @DeleteMapping("/delete/comment/{commentId}/{problemId}")
  public String deleteComment(@PathVariable("commentId")Long commentId,
      @PathVariable("problemId")Long problemId){
    commentRepo.deleteComment(commentId);
    return "redirect:/algo/{problemId}";
  }

}
