<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
<body>
    <header>
        <nav>
            <img src="/imgs/pete2.png" width="100px;">
            <h1>Pete's Algos</h1>
        </nav>
        <div class="links">
            <h2><a href="/dashboard">dashboard</a></h2>
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
                    <button type="submit">Remove From Solved</button>
                </form>
            </c:when>
            <c:otherwise>
                <form action="/solved/${userId}/${problem.id}" method="POST">
                    <button type="submit">I Solved This</button>
                </form>
            </c:otherwise>
        </c:choose>
        <p><a href="${problem.leetcodeLink}" target="_blank" rel="noopener noreferrer">View On LeetCode</a></p>
        <div class="line"></div>
        <pre><p>${problem.question}</p></pre>

        <!---- SOLUTION THAT WE PROVIDE---->
        <button id="sol-btn" type="button" onclick="solShowHide()">Show Solution</button>
        <div id="solution" style="display:none;">
            <h3>Pete's Solution:</h3>
            <div class="solution-code">
                <pre>
                    <code>
                        ${problem.code}
                    </code>
                </pre>
            </div>
            <h3>Explanation:</h3>
            <pre>
                <p>${problem.description}</p>
            </pre>
        </div>
        <div class="line"></div>
        <!---- SOLUTION---->

        <!-- COMMENTS-->
        <section class="comments">

        <h2><i class='bx bx-comment'></i> Comments</h2>
        <form:form action="/add/comment/${problem.id}" method="POST" modelAttribute="newComment">
            <p class="">
                <form:label path = "comment" >Comment:</form:label>
                <form:textarea path = "comment" placeholder="Add a comment..."></form:textarea>
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
                <form:textarea style="display: none;" path="userSolution" id="userSolution"></form:textarea>
                <form:errors path = "userSolution" style="color:red"/>
            </p>

            <form:input type="hidden" path="user" value="${userId}"/>
            <form:input type="hidden" path="problem" value="${problem.id}"/>
            
            <button type="submit">Add Comment</button>
        </form:form>
        <div class="line"></div>

            <!--COMMENT SECTION-->
            <c:forEach var="comment" items="${allComments}">

                <div class="comment-container">
                    <!-- user's comment -->
                    <h3 class="username"><c:out value="${comment.user.userName}"/></h3>
                    <p>posted on: <fmt:formatDate value="${comment.createdAt}" pattern="MMMM dd yyyy"/></p>
                    <div class="line"></div>
                    <p><c:out value="${comment.comment}"/></p>

                    <!-- user's solution if it exists-->
                    <c:if test="${comment.userSolution.length() > 0}">
                        <p style="color:#8A6A7A; font-weight:600;"><c:out value="${comment.user.userName}"/>'s solution:</p>
                        <pre><p class="comment-solution"><c:out value="${comment.userSolution}"/></p></pre>
                    </c:if>

                    <!-- delete button for logged in user-->
                    <c:if test="${comment.user.id.equals(userId)}">
                        <form action="/delete/comment/${comment.id}/${problem.id}" method="post">
                            <input type="hidden" name="_method" value="delete" />
                            <button type="submit">Delete</button>
                        </form>
                    </c:if>
                </div>
            </c:forEach>
        </section>
    </main>

    <footer>
        <div class="links">
            <p><a href="/about">About</a></p>
            <p><a href="/credits">Credits</a></p>
            <p>Night Crew 2022</p>
        </div>
    </footer>


    <script src="/js/ace-editor/src-min/ace.js"></script>
    <script src="/js/ace-editor/src-min/mode-javascript.js"></script>
    <script src="/js/editor.js"></script>
    <script src="/js/script.js"></script>
</body>
</html>