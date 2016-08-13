function makeReport(make) {
    var userId = $('#userForReportId').val();
    var fileFormat = $('#responseFormat option:selected').val();
    var numberOfResults = $('#numberOfTimes option:selected').attr("id");
    if(numberOfResults!="custRange") {
        document.getElementById("customRange").style.visibility ="hidden";
    }
    if (numberOfResults==="custRange") {
        document.getElementById("customRange").style.visibility="visible";
        if(make==true) {
            makeByCustomRange(userId, fileFormat);
        }
    }
    if( numberOfResults==="currentMonth" || numberOfResults==="lastMonth" ) {
        if(make==true) {
            makeByMonth(userId, fileFormat);
        }
    }
}


function makeByMonth(userId, format) {
    var month = $('#numberOfTimes option:selected').val();
   $.ajax({
        type: 'POST',
        url: '/DevelopersTimeTracker/users/admin/teamlead/report/' + userId + '/bymonth/' + month + '/' + format,
        data: JSON,
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {
        }
    });
}

function makeByCustomRange(userId, format) {
    var fromDate = $('#fromDate').val();
    var toDate = $('#toDate').val();
    $.ajax({
        type: 'POST',
        url: '/DevelopersTimeTracker/users/admin/teamlead/report/' + userId +'/byrange/' + fromDate + '/' + toDate + '/' + format,
        data: JSON,
        contentType: 'application/json',
        mimeType: 'application/json',
        success: function (data) {

        }
    });
}