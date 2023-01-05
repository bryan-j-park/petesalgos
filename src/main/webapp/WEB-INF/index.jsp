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
        <link rel="stylesheet" type="text/css" href="/css/index.css" />
        <link href="https://fonts.googleapis.com/css2?family=Righteous&family=Roboto&display=swap" rel="stylesheet">
        <link rel="apple-touch-icon" sizes="180x180" href="/imgs/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="/imgs/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="/imgs/favicon-16x16.png">
        <link rel="manifest" href="/imgs/site.webmanifest">
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
<body>
	<main>
        <section class="left">
            <div id="header">
                <img src="/imgs/pete2.png">
                <h1>Pete's Algos</h1>
            </div>
            <article>
                Welcome to Pete's Algo's, your one stop shop for algorithm practice on your coding journey! Pete is a cute and clever little opossum who is here to help you reach your goals. Pete's Algo's is a great place to practice your algorithms, work through the solutions, and save your favorites. Get started with Pete today! 
            </article>
        </section>
        
        <section class="right">
            <div class="form">
                <div class="form-content">
                    <header>Register</header>
                    <form:form action="/register" method="POST" modelAttribute="newUser">
                        <div class="field input-field">
                            <form:input type="text" path="userName" placeholder="Username" class="input"/>
                            <form:errors path="userName" style="color:red"/>
                        </div>
                        <div class="field input-field">
                            <form:input type="text" path="email" placeholder="Email" class="input"/>
                            <form:errors path="email" style="color:red"/>
                        </div>
                        <div class="field input-field">
                            <form:input type="password" path="password" placeholder="Password" class="password"/>
                            <i class='bx bx-hide eye-icon'></i>
                            <form:errors path="password" style="color:red"/>
                        </div>
                        <div class="field input-field">
                            <form:input type="password" path="confirm" placeholder="Confirm Password" class="password"/>
                            <form:errors path="confirm" style="color:red"/>
                        </div>
                        <div class="field button-field">
                            <button>Register</button>
                        </div>
                        <div class="form-link">
                            <span>Already have an account? <a href="/loginpage" class="signup-link">Log In</a></span>
                        </div>
                    </form:form>
                </div>
            </div>
        </section>
    </main>

    <script src="/js/script.js"></script>
</body>
</html>