package com.nightcrew.petesalgos.repositories;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nightcrew.petesalgos.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO solved (user_id, problem_id) VALUES(:userId, :problem)",
        nativeQuery = true)
    void addSolvedProblem(
        @Param("userId") Long userId,
        @Param("problem") Long problemId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM solved WHERE user_id = :userId AND problem_id = :problemId",
        nativeQuery = true)
    void deleteSolvedProblem(
        @Param("userId") Long userId,
        @Param("problemId") Long problemId);
}
