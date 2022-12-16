package com.nightcrew.petesalgos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nightcrew.petesalgos.models.Problem;
import com.nightcrew.petesalgos.repositories.ProblemRepository;

@Service
public class ProblemService {
  @Autowired
  private ProblemRepository problemRepository;

  public Problem createProblem(Problem problem){
    return problemRepository.save(problem);
  }

  public List<Problem> getAllProblems(){
    return problemRepository.findAll();
  }
}
