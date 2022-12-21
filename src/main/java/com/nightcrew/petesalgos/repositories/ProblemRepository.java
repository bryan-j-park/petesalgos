package com.nightcrew.petesalgos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nightcrew.petesalgos.models.Problem;

@Repository
public interface ProblemRepository extends CrudRepository<Problem, Long> {

  List<Problem> findAll();

  List<Problem> findProblemById(Long userId);
 

  @Transactional
  @Modifying
  @Query(value = "SELECT * FROM problems WHERE datatype = :datatype",
  nativeQuery = true)
  List<Problem> sortDatatype(
    @Param("datatype") String datatype);

  @Transactional
  @Modifying
  @Query(value = "SELECT * FROM problems WHERE difficulty = :difficulty",
  nativeQuery = true)
  List<Problem> sortDifficulty(
    @Param("difficulty") String difficulty);

  @Transactional
  @Modifying
  @Query(value = "SELECT * FROM problems WHERE datatype = :datatype AND difficulty = :difficulty",
  nativeQuery = true)
  List<Problem> sortDatatypeDifficulty(
    @Param("datatype") String datatype,
    @Param("difficulty") String difficulty);
}
