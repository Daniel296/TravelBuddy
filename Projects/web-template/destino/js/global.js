function disconnectUser() {
    setCookie("sessionUUID", "", 365);
    window.location = "login.html";
}

$('.disconnect-user').click(function () {
    disconnectUser();
});

