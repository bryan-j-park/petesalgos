<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pete's Algos</title>
<link rel="stylesheet" type="text/css" href="/css/style.css" />
<link href="https://fonts.googleapis.com/css2?family=Righteous&family=Roboto&display=swap" rel="stylesheet">
</head>
<body>
    <header>
        <nav>
            <img src="/imgs/pete2.png" width="120px;">
            <h1>Pete's Algos</h1>
        </nav>
        <div class="links">
            <h2><a href="">all algos</a></h2>
            <h2><a href="/logout">logout</a></h2>
        </div>
    </header>
    <main>
        <form:form action = "/problem/new" method = "POST" modelAttribute ="problem">
		<p>
			<form:label path = "name">Name:</form:label>
			<form:input path = "name"/>
			<form:errors path = "name"/>
		</p>
		
		<p>
			<form:label path = "difficulty">Difficulty:</form:label>
			<form:select path = "difficulty">
				<form:option value="easy">Easy</form:option>
				<form:option value="medium">Medium</form:option>
				<form:option value="hard">Hard</form:option>
			</form:select>
			<form:errors path = "difficulty"/>
		</p>
		
		<p>
			<form:label path = "datatype">Datatype:</form:label>
			<form:select path="datatype">
				<form:option value="hash">Hash Function</form:option>
				<form:option value="binary indexed tree">Binary Indexed Tree</form:option>
				<form:option value="string matching">String Matching</form:option>
				<form:option value="shortest path">Shortest Path</form:option>
				<form:option value="merge sort">Merge Sort</form:option>
				<form:option value="doubly linked list">Doubly-Linked List</form:option>
				<form:option value="probability">Probability</form:option>
				<form:option value="array">Array</form:option>
				<form:option value="sort algorithms">Sort Algorithm</form:option>
				<form:option value="other">Other</form:option>
			</form:select>
			<form:errors path = "datatype"/>
		</p>
		
        <p>
			<form:label path = "number">Number:</form:label>
			<form:input type = "number" path = "number"/>
			<form:errors path = "number"/>
		</p>

		<p>
			<form:label path = "question">Question:</form:label>
			<form:textarea path = "question" rows="10"/>
			<form:errors path = "question"/>
		</p>

		<p>
			<form:label path = "description">Description:</form:label>
			<form:textarea path = "description" rows="10"/>
			<form:errors path = "description"/>
		</p>

		<p>
			<form:label path = "leetcodeLink">LeetCode Link:</form:label>
			<form:input path = "leetcodeLink"/>
			<form:errors path = "leetcodeLink"/>
		</p>

        <p>
			<form:label path = "code">Code:</form:label>
			<form:textarea path = "code" rows="10"/>
			<form:errors path = "code"/>
		</p>
		
		<input type="submit" value = "Add problem"/>
	</form:form>
    </main>
</body>
</html>