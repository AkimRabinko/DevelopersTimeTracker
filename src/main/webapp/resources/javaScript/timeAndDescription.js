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