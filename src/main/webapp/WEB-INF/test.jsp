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
        <h1>All Algos</h1>
        <section class="main">

            <table>
                <thead>
                    <tr>
                        <th>Solved</th>
                        <th>Number</th>
                        <th>Problem</th>
                        <th>Datatype</th>
                        <th>Difficulty</th>
                        <th>Add to Favorites</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="problem"  items="${datatype}">
                    <tr>

                            <td> <c:out value="${problem.number}"/></td>

                            <td><c:out value="${problem.name}"/></td>

                            <td><c:out value="${problem.datatype}"/></td>

                            <td><c:out value="${problem.difficulty}"/></td>
                            <!-- remove/Add favorite btn -->
                    </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- <table class="favorites">
                <thead>
                    <tr>
                        <th>Number</th>
                        <th>Problem</th>
                        <th>Datatype</th>
                        <th>Difficulty</th>
                        <th>Add to Favorites</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="favorites"  items="${favList}">
                    <tr>

                            <td> <c:out value="${favorites.number}"/></td>

                            <td><a href="/display/problem/${problem.id}"><c:out value="${favorites.name}"/></a></td>

                            <td><c:out value="${favorites.datatype}"/></td>

                            <td><c:out value="${favorites.difficulty}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table> -->
        </section>

    </main>


    <footer>
        <div class="links">
            <p><a href="/about">About</a></p>
            <p><a href="/credits">Credits</a></p>
            <p>Night Crew 2022</p>
        </div>
    </footer>
    
</body>
</html>