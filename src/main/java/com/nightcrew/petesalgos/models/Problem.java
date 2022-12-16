package com.nightcrew.petesalgos.models;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
  private String difficulty;
  @NotNull
  @NotNull
  @Size(min = 5, message="field must be at least 5 characters")
  private String datatype;
  @NotNull
  private Long number;


//    joining user table 
  
  
  @Column(updatable=false)
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date createdAt;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date updatedAt;

// Table join
  // @ManyToOne(fetch=FetchType.LAZY)
  // @JoinColumn(name="user_id")
  // private User user;
  
  

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

  

}
