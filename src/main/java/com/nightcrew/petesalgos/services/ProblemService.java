package com.nightcrew.petesalgos.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nightcrew.petesalgos.models.Problem;
import com.nightcrew.petesalgos.models.User;
import com.nightcrew.petesalgos.repositories.ProblemRepository;
import com.nightcrew.petesalgos.repositories.UserRepository;

@Service
public class ProblemService {
  private final ProblemRepository problemRepo;

  @Autowired
  private UserRepository userRepo;

  public ProblemService(ProblemRepository problemRepo){
    this.problemRepo = problemRepo;
  }

  // list all problems
  public List<Problem> allProblems(){
    return problemRepo.findAll();
  }

  // ============ Get List of Datatypes ============
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

// ============ Add Favorite Problem By userId and problemId ============
public void favoriteProblem(Long userId, Long problemId){
  Optional<User> optionalUser = userRepo.findById(userId);
  Optional<Problem> optionalProblem = problemRepo.findById(problemId);
  if(optionalUser.isPresent() && optionalProblem.isPresent()){
    User user = optionalUser.get();
    Problem problem = optionalProblem.get();
    problem.getFavorited().add(user);
    problemRepo.save(problem);
  }
}

// ============ Delete Favorite Problem By userId and problemId ============
public void deleteFav(Long userId, Long problemId){
  Optional<User> optionalUser = userRepo.findById(userId);
  Optional<Problem> optionalProblem = problemRepo.findById(problemId);
  if(optionalUser.isPresent() && optionalProblem.isPresent()){
    User user = optionalUser.get();
    Problem problem = optionalProblem.get();
    problem.getFavorited().remove(user);
    problemRepo.save(problem);
  }
}

  // ============ Get Favorite Problems By User ============
  public List<Problem> getFavoriteProblems(User user){
    List<Problem> allProblems = allProblems();
    List<Problem> favoriteProblems = new ArrayList<>();
    for(Problem problem : allProblems){
      if(problem.getFavorited().contains(user)){
        favoriteProblems.add(problem);
      }
    }
    return favoriteProblems;
  }

  // ============ Get Solved Problems By User ============
  public Set<Long> getSolvedProblems(User user){
    List<Problem> allProblemsSolved = user.getProblemsSolved();
    Set<Long> solvedProblemsIds = new HashSet<>();
    for(Problem problem : allProblemsSolved){
      solvedProblemsIds.add(problem.getId());
    }
    return solvedProblemsIds;
  }

}
