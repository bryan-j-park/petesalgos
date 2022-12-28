package com.nightcrew.petesalgos.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nightcrew.petesalgos.models.Comment;
import com.nightcrew.petesalgos.models.Problem;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
  List<Comment> findByProblem(Problem problem);

  @Transactional
  @Modifying
  @Query(value="INSERT INTO comments(comment, user_solution, user_id, problem_id) VALUES (:comment, :user_solution, :userId, :problemId)",
  nativeQuery = true)
  void addComment(
    @Param("comment") String comment,
    @Param("user_solution") String user_solution,
    @Param("userId") Long userId,
    @Param("problemId") Long problemId
  );

  @Transactional
  @Modifying
  @Query(value="DELETE FROM comments WHERE id = :commentId", 
  nativeQuery = true)
  void deleteComment(
    @Param("commentId") Long commentId);

// order comments by DESC
  @Transactional
  @Modifying
  @Query(value="SELECT * FROM comments WHERE problem_id = :problemId ORDER BY id DESC;", 
  nativeQuery = true)
  List<Comment> allCommentDesc(
    @Param("problemId") Problem problem);
}
