// Prevent from accessing a page if you're not logged in
checkSession();


function disconnectUser() {
    setCookie("sessionUUID", null, 365);
    window.location = "login.html";
}

$('.disconnect-user').click(function () {
    disconnectUser();
});

function checkSession() {
    var session = getCookie("sessionUUID");
    if (session == null) {
        window.location = "login.html";
    }
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/core-project/session/checkIfSessionExists/?sessionUUID=" + session,
        dataType: 'json',
        async: false
    }).done(function (result) {
        if (result !== "OK") {
            window.location = "login.html";
        }
    });
}