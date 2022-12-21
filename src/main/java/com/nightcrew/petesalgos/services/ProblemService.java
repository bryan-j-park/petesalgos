package com.nightcrew.petesalgos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nightcrew.petesalgos.models.Problem;
import com.nightcrew.petesalgos.models.User;
import com.nightcrew.petesalgos.repositories.ProblemRepository;

@Service
public class ProblemService {
  private final ProblemRepository problemRepo;

  public ProblemService(ProblemRepository problemRepo){
    this.problemRepo = problemRepo;
  }

  // list all problems
  public List<Problem> allProblems(){
    return problemRepo.findAll();
  }


  // List all sorted by datatype
  public List<Problem> sortDataType(String datatype){
    return problemRepo.sortDatatype(datatype);
  }

  // List all sorted by difficulty
  public List<Problem> sortDifficulty(String difficulty){
    return problemRepo.sortDifficulty(difficulty);
  }

  // List all problems sorted by datatype and difficulty
  public List<Problem> sortDatatypeDifficulty(String datatype, String difficulty){
    return problemRepo.sortDatatypeDifficulty(datatype, difficulty);
  }

  //Create problem
  
  public Problem createProblem(Problem problem) {
    return problemRepo.save(problem);
  }
  
  //Retrieves one problem
  
  public Problem getProblem(Long id) {
    Optional<Problem> optionalProblem = problemRepo.findById(id);
    
  //	checking to see if the problem is in the DB
    if(optionalProblem.isPresent()) {
      return optionalProblem.get();
    }
    else {
      return null;
    }
  }


  //edit name

public Problem editProblem(Problem problem) {
	return problemRepo.save(problem);
}

//Delete Name

public void deleteProblem(Long id) {
	problemRepo.deleteById(id);
}


// Fav btn code
public void favoriteProblem(User user, Problem problem){

//  if(problem.getFavorited() == null){
//   ArrayList<Problem> problem.getFavorited() = new ArrayList<Problem>();

//  }
  problem.getFavorited().add(user);
  problemRepo.save(problem);
}

// delete Favorite Problem

public void deleteFav(User user, Problem problem){
  problem.getFavorited().remove(user);
  problemRepo.save(problem);
}

public List<String> datatypes(){
  List<String> datatypes = new ArrayList<String>();
  datatypes.add("Array");
  datatypes.add("Binary Search");
  datatypes.add("Binary Tree");
  datatypes.add("Breadth-First Search");
  datatypes.add("Depth-First Search");
  datatypes.add("Doubly Linked List");
  datatypes.add("Hash Table");
  datatypes.add("Linked List");
  datatypes.add("Sorting");
  datatypes.add("Stack");
  datatypes.add("String");
  datatypes.add("Queue");
  return datatypes;
}



}
