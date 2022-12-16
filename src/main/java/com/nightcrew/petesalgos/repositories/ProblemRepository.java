package com.nightcrew.petesalgos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nightcrew.petesalgos.models.Problem;

@Repository
public interface ProblemRepository extends CrudRepository<Problem, Long> {

  List<Problem> findAll();

  List<Problem> findProblemById(Long userId);
 
}
