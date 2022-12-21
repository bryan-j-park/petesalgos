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

        <h1>Credits</h1>
        <h2>Team:</h2>
        <h3>Felix Vargas Jr — <span>Back-end developer</span></h3>
        <p><a href="https://github.com/NeverGiveUp23">Github</a></p>

        <h3>Bryan Park — <span>Back-end developer</span></h3>
        <p><a href="https://github.com/bryan-j-park">Github</a></p>

        <h3>Jacob Reynolds — <span>Back-end developer</span></h3>
        <p><a href="https://github.com/jakjak2012">Github</a></p>

        <h3>Gabriela Flores — <span>Front-end developer</span></h3>
        <p><a href="https://github.com/floresgabriela">Github</a></p>

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