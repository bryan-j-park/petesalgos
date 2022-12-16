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
        <h2>1. Title of Problem</h2>
        <pre>insert problem here</pre>
        <br><br>

        <div class="solution">
        <pre>
            <code>
                ${problem.code}
            </code>
        </pre>
        </div>

    </main>
</body>
</html>