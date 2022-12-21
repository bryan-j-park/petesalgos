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
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
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
        <section class="sort">
            <h2>Datatypes:</h2>
            <c:forEach var="datatype" items="${datatypes}">
                <a href="/sort/${datatype}"><button>${datatype}</button></a>
            </c:forEach>
        </section>

        <h1>${datatypeName}</h1>
        <section class="main">

            <table>
                <thead>
                    <tr>
                        <th>Status</th>
                        <th>Number</th>
                        <th>Problem</th>
                        <th>Datatype</th>
                        <th>
                            <select onchange="sortByDifficulty(this)" class="difficulty">
                                <option hidden value="">Select Difficulty</option>
                                <option value="http://localhost:8080/sort/${datatypeName}/Easy">Easy</option>
                                <option value="http://localhost:8080/sort/${datatypeName}/Medium">Medium</option>
                                <option value="http://localhost:8080/sort/${datatypeName}/Hard">Hard</option>
                            </select>
                            
                        </th>
                        <th>Add to Favorites</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="problem" items="${datatypeProblems}">
                    <tr>
                        <c:choose>
                            <c:when test="${solvedProblemIds.contains(problem.id)}">
                                <td><i class='bx bx-check-square'></i></td>
                            </c:when>
                            <c:otherwise>
                                <td></td>
                            </c:otherwise>
                        </c:choose>

                            <td> <c:out value="${problem.number}"/></td>

                            <td><a href="/algo/${problem.id}"><c:out value="${problem.name}"/></a></td>

                            <td><c:out value="${problem.datatype}"/></td>

                            <td><c:out value="${problem.difficulty}"/></td>
                            <!-- remove/Add favorite btn -->
                        <c:choose>
                            <c:when test="${problem.favorited.contains(user)}">
                                <!-- favorited referring to the list in the problem model -->
                            <td>
                                <form action="/favorites/${problem.id}/delete/${datatypeName}" method="post" class="fave-btn">
                                    <input type="hidden" name="_method" value="put" />
                                    <button type="submit">Remove Favorite</button>
                                </form>

                            </td>
                        </c:when>

                        <c:otherwise>
                            <td>
                                    <form action="/favorites/${problem.id}/receive/${datatypeName}" method="post" class="fave-btn">
                                        <input type="hidden" name="_method" value="put" />
                                        <button type="submit">Add To Favorites</button>
                                    </form>

                                </td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
            
            <div class="profile">
                <h2>${user.userName}</h2>
                <div class="line"></div>
                <h3>Your Favorites:</h3>
                <c:forEach var="favorites" items="${favList}">
                <ul>
                    <li>
                        <a href="/algo/${favorites.id}"><c:out value="${favorites.name}"/></a>
                    </li>
                </ul>
                </c:forEach>
            </div>
        </section>

    </main>

    <footer>
        <div class="links">
            <p><a href="/about">About</a></p>
            <p><a href="/credits">Credits</a></p>
            <p>Night Crew 2022</p>
        </div>
    </footer>
    
    <script src="/js/script.js"></script>
</body>
</html>