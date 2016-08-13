            function getUsers() {
                $.ajax({
                    type: 'GET',
                    url: '/DevelopersTimeTracker/users/admin/time/descriptions',
                    data: JSON,
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                        var items = "<div class=\"block1\">Name(Login)</div>"
                            + "<div class=\"block1\">Last name</div>"
                            + "<div class=\"block1\">Position</div>"
                            + "<div class=\"block1\">Role</div>";
                        $.each(data, function (id, user) {
                            items += "<div class=\"block2\">" + user.userName + " (" + user.userLogin + ") " + "</div>"
                                    + "<div class=\"block2\">" + user.userLastName + "</div>"
                                    + "<div class=\"block2\">" + user.userPosition + "</div>"
                                    + "<div class=\"block2\">" + user.userRole + "</div>";
                        });
                        $('#allUsers').html(items);
                    }
                });
            }

            function getUsersTeamLead() {
                $.ajax({
                    type: 'GET',
                    url: '/DevelopersTimeTracker/users/admin/time/descriptions',
                    data: JSON,
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                        var items = "<div class=\"block4\">Name(Login)</div>"
                            + "<div class=\"block4\">Last name</div>"
                            + "<div class=\"block4\">Role</div>"
                            + "<div class=\"block4\">Add to project</div>";
                        $.each(data, function (id, user) {
                            items += "<div class=\"block4\">" + user.userName + " (" + user.userLogin + ") " + "</div>"
                                + "<div class=\"block4\">" + user.userLastName + "</div>"
                                + "<div class=\"block4\">" + user.userRole + "</div>"
                                + "<div class=\"block4\">" +
                                    "<input type='button' name='Add' value='Add' style='margin: -1px' onclick='addUserToProject(" + user.userId + ") , getUsersInProject()'/>" +
                                "</div>";
                        });
                        $('#allUsersTeamLead').html(items);
                    }
                });
            }

            function addUserToProject(userId) {
                var projectName = $('#projects option:selected').val()
                $.ajax({

                    type: 'PUT',
                    contentType: 'application/json',
                    url:  '/DevelopersTimeTracker/users/admin/teamlead/' + userId +'/' + projectName,
                    dataType: "json",
                    data: JSON,
                    success: function(data){
                    }
                });
            }

            function getUsersInProject() {
                var projectName = $('#projects option:selected').val();
                $.ajax({
                    type: 'GET',
                    url: '/DevelopersTimeTracker/users/admin/teamlead/' + projectName + '/getUsers',
                    data: JSON,
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                        var items = "<div class=\"block4\">Name(Login)</div>"
                            + "<div class=\"block4\">Last name</div>"
                            + "<div class=\"block4\">Role</div>"
                            + "<div class=\"block4\">Remove user</div>";
                        $.each(data, function (id, user) {
                            items += "<div class=\"block4\">" + user.userName + " (" + user.userLogin + ") " + "</div>"
                                + "<div class=\"block4\">" + user.userLastName + "</div>"
                                + "<div class=\"block4\">" + user.userRole + "</div>"
                                + "<div class=\"block4\">" + 
                                "<input type='button' name='Remove' value='Remove' style='margin: -1px' onclick='removeUserFromProject("+user.userId +"), getUsersInProject()'/>"
                                + "</div>";
                        });
                        $('#usersInProject').html(items);
                    }
                });
            }

            function removeUserFromProject(userId) {
                var projectName = $('#projects option:selected').val()
                $.ajax({

                    type: 'DELETE',
                    contentType: 'application/json',
                    url:  '/DevelopersTimeTracker/users/admin/teamlead/' + userId +'/' + projectName + '/remove',
                    dataType: "json",
                    data: JSON,
                    success: function(data){
                    }
                });
            }

            function getUserById(userId) {
                    $.ajax({
                        type: 'GET',
                        url: '/DevelopersTimeTracker/users/' + userId,
                        data: JSON,
                        dataType: "json",
                        contentType: 'application/json',
                        mimeType: 'application/json',
                        success: function (data) {
                            $('#name').text(data.userName);
                            $('#lastName').text(data.userLastName);
                            $('#position').text(data.userPosition);
                            $('#userRole').text(data.userRole);
                        }
                    })
            }

            function check() {
                var userPassword = $('#userPassword').val();
                var userConfirmPassword = $('#userConfirmPassword').val();
                if (userPassword != userConfirmPassword) {
                    alert("password isn't identical");
                }
                    else {
                    addNewUser();
                    alert("user created");
                }
            }
            
            function addNewUser() {
                var userLogin = $('#userLogin').val();
                var userPassword = $('#userPassword').val();
                var userName = $('#userName').val();
                var userLastName = $('#userLastName').val();
                var userPosition = $('#userPosition').val();
                var userRole = $("#userRole input[type='radio']:checked").val();
                var JSONObject = {"userLogin" : userLogin, "userPassword" : userPassword, 
                    "userName" : userName, "userLastName" : userLastName , 
                    "userPosition" : userPosition , "userRole" : userRole};
                $.ajax({
                    type: 'POST',
                    contentType: 'application/json',
                    url: '/DevelopersTimeTracker/users/admin/add',
                    data: JSON.stringify(JSONObject),
                    dataType: 'json',
                    success: function(data) {
                        $("#addUserForm")[0].reset();
                    }
                });
            }

            function updateUserTimeAndDescriptions(userId) {
                var userDate = $('#date').val();
                var userTime = $('#time').val();
                var timeDescription = $('#description').val();
                var name = $('#selectedProject option:selected').val();
                var JSONObject = {"date" : userDate, "time" : userTime,
                    "description" : timeDescription };
                $.ajax({
                    type: 'PUT',
                    contentType: 'application/json',
                    url:  '/DevelopersTimeTracker/users/' + userId + '/' + name + '/update',
                    dataType: "json",
                    data: JSON.stringify(JSONObject),
                    success: function(data){
                        $("#dateForm")[0].reset();
                    }
                });
            }
            
            function totalTime(userId) {
                $.ajax({
                    type: 'GET',
                    url: '/DevelopersTimeTracker/users/' + userId + '/totaltime',
                    data: JSON,
                    dataType: "json",
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                        $('#totalTime').text("Total time for the current month : " + data + " hours");
                       
                    }
                })
            }

            function getAvailableProjects(userId) {
                $.ajax({
                    type: 'GET',
                    url: '/DevelopersTimeTracker/users/' + userId + '/availableprojects',
                    data: JSON,
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                        var items = "<select  style='width: auto ; height: auto' id=\"selectedProject\" class=\"block1\""
                            + "style=\"height: auto;\" onchange='getUsersInProject()'>";
                        $.each(data, function (id, projects) {
                            items += "<option value=\" " + projects.projectName + "\">" +  projects.projectName  +  "</option>";
                        });
                        items+= "</select>";
                        $('#project').html(items);
                    }
                });
            }

            function getAllProjects() {
                $.ajax({
                    type: 'GET',
                    url: '/DevelopersTimeTracker/users/allprojects',
                    data: JSON,
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                        var items = "<select  style='width: auto ; height: auto' id=\"selectedProject\" class=\"block1\""
                            + "style=\"height: auto;\" onchange='getUsersInProject()'>";
                        $.each(data, function (id, projects) {
                            items += "<option value=\" " + projects.projectName + "\">" +  projects.projectName  +  "</option>";
                        });
                        items+= "</select>";
                        $('#projects').html(items);
                    }
                });
            }
            
            function addNewProject() {
                var projectName = $('#projectName').val();
                var JSONObject = {"projectName" : projectName};
                $.ajax({
                    type: 'PUT',
                    contentType: 'application/json',
                    url:  '/DevelopersTimeTracker/users/admin/teamlead/addproject',
                    dataType: "json",
                    data: JSON.stringify(JSONObject),
                    success: function(data){
                        $("#addNewProjectForm")[0].reset();
                    }
                });
            }

            