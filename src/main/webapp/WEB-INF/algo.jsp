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
            <h2><a href="/dashboard">problems</a></h2>
            <h2><a href="/logout">logout</a></h2>
        </div>
    </header>
    <main>
       
        <h2>${problem.number}. ${problem.name}</h2>
        <!-- <p>Status:</p> -->
        <c:choose>
            <c:when test="${solvedProblemIds.contains(problem.id)}">
                <form action="/delete/${userId}/${problem.id}" method="POST">
                    <input type="hidden" name="_method" value="delete"/>
                    <button type="submit">Solved</button>
                </form>
            </c:when>
            <c:otherwise>
                <form action="/solved/${userId}/${problem.id}" method="POST">
                    <button type="submit">Not Solved</button>
                </form>
            </c:otherwise>
        </c:choose>
        <p><a href="${problem.leetcodeLink}">View On LeetCode</a></p>
        <div class="line"></div>
        <pre><p>${problem.question}</p></pre>

        <!---- SOLUTION: SHOW IF THE USER HAS POSTED SOLUTION---->
        <div class="solution">
            <h3>Your Solution:</h3>
            <div class="solution-code">
                <pre>
                    <code>
                        ${problem.code}
                    </code>
                </pre>
            </div>
            
            <p>${problem.description}</p>
        </div>
        <div class="line"></div>
        <!---- SOLUTION---->

        
        <form:form action="/add/comment" method="POST" modelAttribute="newComment">
            <p class="">
                <form:label path = "comment">Comment:</form:label>
                <form:textarea path = "comment"></form:textarea>
                <form:errors path = "comment" style="color:red"/>
            </p>
            
            <p class="">
                <form:label path = "userSolution">Solution (Optional):</form:label>
                
                <div class="container">
                    <div class="editor">
                        <div class="editor__wrapper">
                            <div class="editor__body">
                                <div id="editorCode" class="editor__code">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <form:textarea style="display: none;" path="userSolution" name="userSolution"></form:textarea>
                <form:errors path = "userSolution" style="color:red"/>
            </p>

            <form:input type="hidden" path="user" value="${userId}"/>
            <form:input type="hidden" path="problem" value="${problem.id}"/>
            
            <button type="submit">Add Comment</button>
        </form:form>

    

    <script src="/js/ace-editor/src-min/ace.js"></script>
    <script src="/js/ace-editor/src-min/mode-javascript.js"></script>
    <script src="/js/editor.js"></script>
</body>
</html>