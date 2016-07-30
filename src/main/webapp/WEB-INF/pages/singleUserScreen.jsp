<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Single User</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/javaScript/main.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/singleUserScreen.css"/>">
    <style type="text/css">
        body {  background-image: url("<c:url value="/resources/pictures/bg2.jpg" />");  }
    </style>
</head>
<body  onload="getUserById(${userId}), getUserTimeAndDescription(${userId}) , totalTime(${userId})">

<h2><a href="/DevelopersTimeTracker/users/admin" ><button name="admin">Admin page</button></a>
    Single user preview
    <a href="<c:url value="/logout"/>"><button>Logout</button></a>
</h2>
        <div class="block3" >
            <div class="block1"><spring:message text="name" /></div>
            <div class="block1"><spring:message text="last name" /></div>
            <div class="block1"><spring:message text="position" /></div>
            <div class="block1"><spring:message text="user role" /></div>
            <div class="block2" id="name"></div>
            <div class="block2" id="lastName" ></div>
            <div class="block2" id="position"></div>
            <div class="block2" id="userRole"></div>
        </div>

<h2 style="margin-left: 250px">Add new time to tracker</h2>
<form id="dateForm">
    <div class="block3">
        <div class="block6"> Select date
            <div class="block5"><input type="date" name="date" id="date" value="${currentDate}"></div>
        </div>
        <div class="block6">Time (in hours)
            <div class="block5"><input type="text" name="time" id="time"></div>
        </div>
        <div class="block6">Description
            <div class="block5"><input type="text" name="description" id="description"></div>
        </div>
        <div class="block6" >
            <input type="submit" onclick="updateUserTimeAndDescriptions(${userId})" name ="addTime" value="add new time"/>
        </div>
    </div>
</form>
    <h2 style="margin-left: 250px" id="totalTime"></h2>
    <h2 style="margin-left: 250px">User time. Select number of visible trackers
    <select id="numberOfTimes" class="block1"
            style="height: auto; margin-left: 83px"
            onchange="getUserTimeAndDescription(${userId})">
        <option value="5" id="5">5</option>
        <option selected value="10">10</option>
        <option value="20">20</option>
        <option value="50">50</option>
        <option value="100">100</option>
    </select>
    </h2>
    <div class="block3" id="userDate"></div>

</body>
</html>
