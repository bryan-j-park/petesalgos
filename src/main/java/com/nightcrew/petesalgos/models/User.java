package com.nightcrew.petesalgos.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

	@Entity
	@Table(name="users")
	public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		@NotEmpty(message="Username is required!")
		@Size(min=3, max=30, message="Username must be between 3 and 30 characters")
		private String userName;
		
		@NotEmpty(message="Email is required!")
		@Email(message="Please enter a valid email!")
		private String email;
		
		@NotEmpty(message="Password is required!")
		@Size(min=8, max=128, message="Password must be between 8 and 128 characters")
		private String password;
		
		@Transient
		@NotEmpty(message="Confirm Password is required!")
		@Size(min=8, max=128, message="Confirm Password must be between 8 and 128 characters")
		private String confirm;
		
		@Column(updatable=false)
		@DateTimeFormat(pattern="yyy-MM-dd")
		private Date createdAt;
		
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;
	
		@PrePersist
		protected void onCreated() {
			this.createdAt = new Date();
		}
			
		@PreUpdate
		protected void onUpdate() {
			this.updatedAt = new Date();
		}
      //joining person with License as a 1:n
		@OneToMany(mappedBy="user", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
		private List<Problem> problem;

		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
			name = "solved",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "problem_id")
		)
		private List<Problem> problemsSolved;
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
			name = "favorites",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "problem_id")
		)
		private List<Problem> favorites;

		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
			name = "comments",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "problem_id")
		)
		private List<Problem> problems;

		public User() {}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getConfirm() {
			return confirm;
		}

		public void setConfirm(String confirm) {
			this.confirm = confirm;
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

		public List<Problem> getProblem() {
			return problem;
		}

		public void setProblem(List<Problem> problem) {
			this.problem = problem;
		}

		public List<Problem> getFavorites() {
			return favorites;
		}

		public void setFavorites(List<Problem> favorites) {
			this.favorites = favorites;
		}

		public List<Problem> getProblems() {
			return problems;
		}

		public void setProblems(List<Problem> problems) {
			this.problems = problems;
		}
	
		public List<Problem> getProblemsSolved() {
			return problemsSolved;
		}

		public void setProblemsSolved(List<Problem> problemsSolved) {
			this.problemsSolved = problemsSolved;
		}
		
}
