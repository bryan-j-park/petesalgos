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

@Controller
public class AdminController {
  @Autowired
  private ProblemService problemService;

  //  ========== Create Problem =========

@GetMapping("/problem/new")
public String createProblem(@ModelAttribute("newProblem") Problem problem, HttpSession session, Model model){
  Boolean userSession = session.getAttribute("userId") == null; 

  if(userSession){
    return "redirect:/logout";
  }
  else{
    return "createProblem.jsp";
  }
}

// Processing create problem form


@PostMapping("problem/new")
public String createProblemSolution(@Valid @ModelAttribute("newProblem")Problem problem, BindingResult result, Model model, HttpSession session){

  Boolean userSession = session.getAttribute("userId") == null; 

  if(userSession){
    return "redirect:/logout";
  }
    if(result.hasErrors()){
      return "createProblem.jsp";
    }
    else{
      problemService.createProblem(problem);
      return "redirect:/dashboard";
    }
}

// edit problem page by id
@RequestMapping("/problem/{id}/edit")
public String edit(@PathVariable("id")Long id, Model model, HttpSession session){
  Long nameUserId = problemService.getProblem(id).getUser().getId();

  if(session.getAttribute("userId") == null){
    return "redirect:/logout";
  }
  if(!session.getAttribute("userId").equals(nameUserId)){
    return "redirect:/dashboard";
  }
  else{
    Problem foundProblem = problemService.getProblem(id);
    model.addAttribute("foundProblem", foundProblem);
    return "editProblem.jsp";
  }
}

//  Process edit form
@PutMapping("/edit/{id}/problem")
//	foundProblem is the attribute to be passed into jsp form
	public String editProblemForm(@Valid @ModelAttribute("foundProblem")Problem problem, BindingResult result,HttpSession session) {
//		checking if the userID is in session/ assigning it the a boolean variable
		Boolean userSession = session.getAttribute("userId") == null;
		
		if(userSession) {
			return "redirect:/logout";
		}
		if(result.hasErrors()) {
			return "editProblem.jsp";
		}
		else {
			// editBook method from the bookServ file

			problemService.editProblem(problem); //<--- book is the name in the parameter to be passed in
			return "redirect:/dashboard";
		}
	}

  // delete problem by id
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		problemService.deleteProblem(id);
		return "redirect:/dashboard";
  }
}
