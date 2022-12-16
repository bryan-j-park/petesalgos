package com.nightcrew.petesalgos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nightcrew.petesalgos.models.Problem;

public interface ProblemRepository extends CrudRepository<Problem, Long>{
  List<Problem> findAll();
}
