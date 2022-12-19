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
        <link rel="apple-touch-icon" sizes="180x180" href="/imgs/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="/imgs/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="/imgs/favicon-16x16.png">
        <link rel="manifest" href="/imgs/site.webmanifest">
    </head>
<body>
    <header>
        <nav>
            <img src="/imgs/pete2.png" width="100px;">
            <h1>Pete's Algos</h1>
        </nav>
        <div class="links">
            <h2><a href="/dashboard">all algos</a></h2>
            <h2><a href="/logout">logout</a></h2>
        </div>
    </header>
    <main>
        <p>Status:</p>
        <c:choose>
            <c:when test="${solvedProblemIds.contains(problem.id)}">
                <form action="/delete/${userId}/${problem.id}" method="POST">
                    <input type="hidden" name="_method" value="delete"/>
                    <input type="submit" value="Solved" class=""/>
                </form>
            </c:when>
            <c:otherwise>
                <form action="/solved/${userId}/${problem.id}" method="POST">
                    <input type="submit" value="Not Solved">
                </form>
            </c:otherwise>
        </c:choose>

        <h2>${problem.number}. ${problem.name}</h2>
        <p><a href="${problem.leetcodeLink}">View On LeetCode</a></p>
        <pre>${problem.question}</pre>
        <br><br>

        <div class="solution">
        <pre>
            <code>
                ${problem.code}
            </code>
        </pre>
        </div>

        <pre>${problem.description}</pre>

        <form:form action="/add/comment" method="POST" modelAttribute="comment">
            <p class="">
                <form:label path = "comment">Comment:</form:label>
                <form:textarea path = "comment"/>
                <form:errors path = "comment" class=""/>
            </p>

            <p class="">
                <form:label path = "user_solution">Solution (Optional):</form:label>
                <form:textarea path = "user_solution"/>
                <form:errors path = "user_solution" class=""/>
            </p>

            <input type="hidden" path="user" value="${userId}"/>
            <input type="hidden" path="problem" value="${problem.id}"/>

            <input type="submit" value="Add Comment"/>
        </form:form>
    </main>
</body>
</html>