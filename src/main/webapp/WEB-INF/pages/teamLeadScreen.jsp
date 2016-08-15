<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Team Lead</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/javaScript/main.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/javaScript/dateValidator.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/javaScript/reportRange.js"/>"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/teamLeadScreen.css"/>">
    <style type="text/css">
        body {  background-image: url("<c:url value="/resources/pictures/bg2.jpg" />");
                background-position: right;
                background-repeat: repeat-y;
                background-color: #033334;}
    </style>
</head>
<body onload="getAllProjects(), getUsersTeamLead(), getUsersInProject(), makeReport()">
<h2><a href="/DevelopersTimeTracker/users/admin" ><button name="back">Back</button></a> Welcome to team lead page</h2>

<form id="addNewProjectForm">
    <div class="block3">
        <div class="block6">Enter project name
            <div class="block5"><input type="text" name="projectName" id="projectName"></div>
        </div>
        <div class="block6" >
            <input type="submit" onclick="addNewProject()" name ="addProject" value="add new project"/>
        </div>
    </div>
</form>


<form id="responseForm">
    <h2 style="margin-left: 250px">Select project</h2>
    <div class="block3">
        <div id="projects"></div>
        <h2>Create response</h2>
        <div class="block6" style="width: 280px; height: 26px">Enter user Id
            <div class="block5" ><input type="text" name="userForReportId" id="userForReportId" style="width: 80px;"></div>
        </div>
            <select id="responseFormat" class="block1" style="height: auto; width: auto; margin-left: 10px;">
                <option value="pdf" >pdf</option>
                <option selected value="xml" >xml</option>
            </select>
        <select id="numberOfTimes" class="block1"
                style="height: auto;  margin-left: 10px;"
                onchange="makeReport(false)">
            <option selected value="${currentMonth}" id="currentMonth" >Current month</option>
            <option value="${lastMonth}"  id="lastMonth">Last month</option>
            <option id="custRange">CustomRange</option>
        </select>
        <div class="block1" style=" margin-left: 10px; height: 26px">
                <input type="submit" onclick="makeReport(true)"  name ="createResponse" value="create Response"/>
        </div>
    </div>

    <form >
        <div class="block3" style="padding-top: 20px" id="customRange">
            <div class="block6"> From
                <div class="block5"><input type="date" name="fromDate" id="fromDate" value="${currentDate}" onchange="changeFromDate()"></div>
            </div>
            <div class="block6"> To
                <div class="block5"><input type="date" name="toDate" id="toDate" value="${currentDate}" onchange="changeToDate()"></div>
            </div>
        </div>
    </form>
</form>

<h2 style="margin-left: 250px">Users in project</h2>
<div class="block3" id="usersInProject"></div>
<h2 style="margin-left: 250px">All users</h2>
<div class="block3" id="allUsersTeamLead"></div>
</body>
</html>
