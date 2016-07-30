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
                var numberOfResults = $('#numberOfTimes option:selected').val();
                $.ajax({
                    type: 'GET',
                    url: '/DevelopersTimeTracker/users/' + userId +'/time/descriptions/' + numberOfResults,
                    data: JSON,
                    contentType: 'application/json',
                    mimeType: 'application/json',
                    success: function (data) {
                        var timeDate= "<div class=\"block4\">Date</div>" +
                            "<div class=\"block4\">Time (in hours)</div>" +
                            "<div class=\"block4\">Description</div>" ;
                        $.each(data, function (id, time) {
                            timeDate += "<div class=\"block4\">" + time.date + "</div>"
                                + "<div class=\"block4\">" + time.time + "</div>"
                                + "<div class=\"block4\">" + time.description + "</div>";
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
                var JSONObject = {"date" : userDate, "time" : userTime,
                    "description" : timeDescription };
                $.ajax({
                    type: 'PUT',
                    contentType: 'application/json',
                    url:  '/DevelopersTimeTracker/users/' + userId + '/update',
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