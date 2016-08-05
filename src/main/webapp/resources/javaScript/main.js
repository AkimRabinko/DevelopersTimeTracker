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

            function getUserTimeAndDescription(userId) {
                var numberOfResults = $('#numberOfTimes option:selected').attr("id");
                if(numberOfResults!="custRange") {
                    document.getElementById("customDate").style.visibility ="hidden";
                }
                if (numberOfResults==="custRange") {
                    document.getElementById("customDate").style.visibility="visible";
                    getByCustomRange(userId);
                }
                if( numberOfResults==="currentMonth" || numberOfResults==="lastMonth" ) {
                    getByMonth(userId);
                }
                else {
                    getByLimit(userId)
                }

            }

            function getByLimit(userId) {
                var limit = $('#numberOfTimes option:selected').val();
                $.ajax({
                    type: 'GET',
                    url: '/DevelopersTimeTracker/users/' + userId +'/time/descriptions/bylimit/' + limit,
                    data: JSON,
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                        var timeDate= "<div class=\"block4\" style='width: 150px'>Date</div>" +
                            "<div class=\"block4\" style='width: 80px'>Time (h)</div>" +
                            "<div class=\"block4\">Description</div>"+
                            "<div class=\"block4\">Project</div>";
                        $.each(data, function (id, time) {
                            timeDate += "<div class=\"block4\" style='width: 150px'>" + time.date + "</div>"
                                + "<div class=\"block4\" style='width: 80px'>" + time.time + "</div>"
                                + "<div class=\"block4\">" + time.description + "</div>"
                                + "<div class=\"block4\">" + time.project.projectName  + "</div>";
                        });
                        $('#userDate').html(timeDate);
                    }
                });
            }

            function getByMonth(userId) {
                var month = $('#numberOfTimes option:selected').val();
                $.ajax({
                    type: 'GET',
                    url: '/DevelopersTimeTracker/users/' + userId +'/time/descriptions/bymonth/' + month,
                    data: JSON,
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                        var timeDate= "<div class=\"block4\" style='width: 150px'>Date</div>" +
                            "<div class=\"block4\" style='width: 80px'>Time (h)</div>" +
                            "<div class=\"block4\">Description</div>" +
                            "<div class=\"block4\">Project</div>";
                        $.each(data, function (id, time) {
                            timeDate += "<div class=\"block4\" style='width: 150px'>" + time.date + "</div>"
                                + "<div class=\"block4\" style='width: 80px'>" + time.time + "</div>"
                                + "<div class=\"block4\">" + time.description + "</div>"
                                + "<div class=\"block4\">" + time.project.projectName  + "</div>";
                        });
                        $('#userDate').html(timeDate);
                    }
                });
            }

            function getByCustomRange(userId) {
                var fromDate = $('#fromDate').val();
                var toDate = $('#toDate').val();
                $.ajax({
                    type: 'GET',
                    url: '/DevelopersTimeTracker/users/' + userId +'/time/descriptions/byrange/' + fromDate +'/' + toDate,
                    data: JSON,
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                        var timeDate= "<div class=\"block4\" style='width: 150px'>Date</div>" +
                            "<div class=\"block4\" style='width: 80px'>Time (h)</div>" +
                            "<div class=\"block4\">Description</div>" +
                            "<div class=\"block4\">Project</div>";
                        $.each(data, function (id, time) {
                            timeDate += "<div class=\"block4\" style='width: 150px'>" + time.date + "</div>"
                                + "<div class=\"block4\" style='width: 80px'>" + time.time + "</div>"
                                + "<div class=\"block4\">" + time.description + "</div>"
                                + "<div class=\"block4\">" + time.project.projectName  + "</div>";
                        });
                        $('#userDate').html(timeDate);
                    }
                });
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

            function getAvailableProjects() {
                $.ajax({
                    type: 'GET',
                    url: '/DevelopersTimeTracker/users/availableprojects',
                    data: JSON,
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                        var items = "<select  style='width: auto ; height: auto' id=\"selectedProject\" class=\"block1\""
                            + "style=\"height: auto; margin-left: 83px\">";
                        $.each(data, function (id, projects) {
                            items += "<option value=\" " + projects.projectName + "\">" +  projects.projectName  +  "</option>";
                        });
                        items+= "</select>";
                        $('#projects').html(items);
                    }
                });
            }
