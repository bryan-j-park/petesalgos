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
            <h2><a href="">all algos</a></h2>
            <h2><a href="/logout">logout</a></h2>
        </div>
    </header>
    <main>
        <h1>All Algos</h1>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Difficulty</th>
                    <th>Leetcode link?</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><a href="">algo name</a></td>
                    <td>easy</td>
                    <td>link or whatever</td>
                </tr>
            </tbody>
        </table>
    </main>
</body>
</html>