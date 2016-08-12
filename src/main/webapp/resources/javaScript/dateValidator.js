function changeDate() {
    var userDate = document.getElementById('date').value;
    if (!Date.parse(userDate)){
        document.getElementById('date').style.color = "red";
    } else {
        document.getElementById('date').style.color = "white";
    }
}

function changeFromDate() {
    var fromDate = document.getElementById('fromDate').value;
    if (!Date.parse(fromDate)){
        document.getElementById('fromDate').style.color = "red";
    } else {
        document.getElementById('fromDate').style.color = "white";
    }
}

function changeToDate() {
    var fromDate = document.getElementById('fromDate').value;
    var toDate = document.getElementById('toDate').value;
    if (!Date.parse(toDate)) {
        document.getElementById('toDate').style.color = "red";
    } else if (toDate < fromDate) {
        document.getElementById('toDate').style.color = "red";
    } else {
        document.getElementById('toDate').style.color = "white";
    }
}
