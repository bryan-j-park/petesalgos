<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
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
            <h3><a href="/dashboard">dashboard</a></h3>
            <h3><a href="/logout">logout</a></h3>
        </div>
    </header>
    <main>

        <h1>About</h1>
        <p>Pete's Algos is a website created by developers with a passion for solving algorithms. Our mission is to provide an easy-to-use platform where other developers can browse, practice, and save their favorite JavaScript algorithms. No matter where you are in your coding journey, Pete's Algos is here to help.</p>
        
        <h2>Our Story</h2>
        <p>During our time in a coding bootcamp, we were tasked with solving a JavaScript algorithm every morning for 14 weeks. This led to a lot of algorithm practice and collaboration outside of class. When it came time for us to work on a group project, we thought it would be a good idea to create a website to showcase the work we've been doing. Pete's Algos was born out of a desire to organize our favorite algorithms all in one place.</p>

        <h2>Pete</h2>
        <p>The inspiration behind our beloved mascot, Pete, is a stuffed opossum that belongs to one of our developers. A fleeting thought to include a mascot in the website turned into our main project idea.</p>
        <div class="pete-imgs">
            <img src="/imgs/pete-coding.jpg" alt="image of Pete the Opossum">
            <img src="/imgs/pete-photo.jpg" alt="image of Pete the Opossum">
        </div>
        
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