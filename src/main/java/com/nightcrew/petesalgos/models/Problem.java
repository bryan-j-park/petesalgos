package com.nightcrew.petesalgos.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="problems")
public class Problem{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NotNull
  @Size(min = 3, message="name must be entered")
  private String name;
  @NotNull
  @Size(min = 1, message = "difficulty must be at least 1 character")
  private String difficulty;
  @NotNull
  @Lob
  @Size(min = 1, message="question must be at least 1 character")
  private String question;
  @NotNull
  @Lob
  @Size(min = 1, message = "description must be at least 1 character")
  private String description;
  @NotNull
  @Size(min = 2, message="field must be at least 2 characters")
  private String datatype;
  @NotNull
  private Long number;

  @NotNull
  @Size(min = 1, message="LeetCode Link must be at least 1 character")
  private String leetcodeLink;
  
  @NotNull
  @Lob
  @Size(min = 2, message = "code must be at least 2 characters")
  private String code;
//    joining user table 
  
  
  @Column(updatable=false)
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date createdAt;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date updatedAt;

// Table join
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="user_id")
  private User user;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "solved",
    joinColumns = @JoinColumn(name = "problem_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id")
  )
  private List<User> usersSolved;

  @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "favorites",
			joinColumns = @JoinColumn(name = "problem_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
		)
		private List<User> favorited;

  @ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "comments",
			joinColumns = @JoinColumn(name = "problem_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
		)
		private List<User> users;
  

  // contructors
  public Problem(){}

  public Problem(String name, String difficulty, String datatype, Long number){
    this.name = name;
    this.difficulty = difficulty;
    this.datatype = datatype;
    this.number = number;
  }
  
    // Getters & Setters
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public void setName(String name) {
    this.name = name;
  }
  public String getDifficulty() {
    return difficulty;
  }
  public void setDifficulty(String difficulty) {
    this.difficulty = difficulty;
  }
  public String getDatatype() {
    return datatype;
  }
  public void setDatatype(String datatype) {
    this.datatype = datatype;
  }
  public Long getNumber() {
    return number;
  }
  public void setNumber(Long number) {
    this.number = number;
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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getQuestion() {
    return question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public List<User> getFavorited() {
    return favorited;
  }

  public void setFavorited(List<User> favorited) {
    this.favorited = favorited;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLeetcodeLink() {
    return leetcodeLink;
  }

  public void setLeetcodeLink(String leetcodeLink) {
    this.leetcodeLink = leetcodeLink;
  }

  public List<User> getUsersSolved() {
    return usersSolved;
  }

  public void setUsersSolved(List<User> usersSolved) {
    this.usersSolved = usersSolved;
  }

}
