package com.nightcrew.petesalgos.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "comments")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @NotNull
  @Size(min = 1, message = "Comment must be at least 1 characters")
  private String comment;

  @Lob
  private String userSolution;

  @Column(updatable=false)
  @DateTimeFormat(pattern="MM-dd-yyyy")
  private Date createdAt;
  @DateTimeFormat(pattern="MM-dd-yyyy")
  private Date updatedAt;

  @PrePersist
  protected void onCreated() {
    this.createdAt = new Date();
  }
    
  @PreUpdate
  protected void onUpdate() {
    this.updatedAt = new Date();
  }

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "problem_id")
  private Problem problem;

public Comment(){}

public Comment(String comment, String userSolution){
  this.comment = comment;
  this.userSolution = userSolution;
}

  // getters/setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Problem getProblem() {
    return problem;
  }

  public void setProblem(Problem problem) {
    this.problem = problem;
  }

  public void setUserSolution(String userSolution) {
    this.userSolution = userSolution;
  }

  public String getUserSolution() {
    return userSolution;
  }
}