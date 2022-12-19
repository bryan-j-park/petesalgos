package com.nightcrew.petesalgos.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nightcrew.petesalgos.models.Comment;
import com.nightcrew.petesalgos.models.Problem;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
  List<Comment> findByProblem(Problem problem);
}
