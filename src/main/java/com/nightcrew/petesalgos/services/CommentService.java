package com.nightcrew.petesalgos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nightcrew.petesalgos.models.Comment;
import com.nightcrew.petesalgos.models.Problem;
import com.nightcrew.petesalgos.repositories.CommentRepository;

@Service
public class CommentService {
  @Autowired
  private CommentRepository commentRepo;

  public List<Comment> getCommentsByProblem(Problem problem){
    return commentRepo.findByProblem(problem);
  }

  public Comment createComment(Comment comment){
    return commentRepo.save(comment);
  }

  public void addComment(String comment, String user_solution, Long userId, Long problemId){
    commentRepo.addComment(comment,user_solution, userId, problemId);
  }

  public List<Comment> getCommentDesc(Problem problem){
    return commentRepo.allCommentDesc(problem);
  }
}
