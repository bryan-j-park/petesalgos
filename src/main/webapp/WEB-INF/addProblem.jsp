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
				<form:option value="Easy">Easy</form:option>
				<form:option value="Medium">Medium</form:option>
				<form:option value="Hard">Hard</form:option>
			</form:select>
			<form:errors path = "difficulty"/>
		</p>
		
		<p>
			<form:label path = "datatype">Datatype:</form:label>
			<form:select path="datatype">
				<form:option value="Array">Array</form:option>
				<form:option value="Binary Search">Binary Search</form:option>
				<form:option value="Binary Tree">Binary Tree</form:option>
				<form:option value="Breadth-First Search">Breadth-First Search</form:option>
				<form:option value="Depth-First Search">Depth-First Search</form:option>
				<form:option value="Doubly Linked List">Doubly-Linked List</form:option>
				<form:option value="Hash Table">Hash Table</form:option>
				<form:option value="Linked List">Linked List</form:option>
				<form:option value="Sorting">Sorting</form:option>
				<form:option value="Stack">Stack</form:option>
				<form:option value="String">String</form:option>
				<form:option value="Queue">Queue</form:option>
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