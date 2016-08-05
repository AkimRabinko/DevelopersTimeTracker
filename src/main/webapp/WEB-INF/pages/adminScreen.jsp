<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Developers Time Tracker</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/javaScript/main.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/adminScreen.css"/>">
    <style type="text/css">
        body {  background-image: url("<c:url value="/resources/pictures/bg2.jpg" />");
                background-position: right;
                background-color:  #034748;}
    </style>
</head>
    <h2><a href="/DevelopersTimeTracker/users/${userId}" ><button name="back">Back</button></a>
        This page is for administrator and team lead only</h2>

    <div class="block3">
        <div class="block1">Add new user
            <div class="block2">
                    <a href="/DevelopersTimeTracker/users/admin/add">
                        <button name="addUser"  id="addUser" >GO</button>
                    </a>
            </div>
        </div>
        <div class="block1">View all users
            <div class="block2">
                <a href="/DevelopersTimeTracker/users/admin/time/descriptions">
                    <button name="allUsers"  id="allUsers">GO</button>
                </a>

            </div>
        </div>
    </div>
</body>
</html>
