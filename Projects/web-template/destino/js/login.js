$(document).ready(function () {
    $('.login-google').hide();
    $('.login-facebook').hide();
    $('.login-email').hide();
    $('.login-error').hide();

    $('.login-facebook-type-btn').click(function (e) {
        $('.login-authorization-type').hide();
        $('.login-facebook').show();
    });

    $('.login-google-type-btn').click(function (e) {
        $('.login-authorization-type').hide();
        $('.login-google').show();
    });

    $('.login-email-type-btn').click(function (e) {
        $('.login-authorization-type').hide();
        $('.login-email').show();
    });

    $('.login-btn').click(function(e){
        var email =  $('#email').val();
        var password = $('#psw').val();
        var sessionUUID;

        if( getCookie("sessionUUID") == null ){
            sessionUUID = "";
        }else{
            sessionUUID = getCookie("sessionUUID");
        }

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/core-project/login",
            data: JSON.stringify({
                email: email,
                password: password,
                facebookToken: "",
                googleToken: "",
                authorizationMethod: "Password",
                sessionUUID: sessionUUID
            }),
            contentType: 'application/json',
            mimeType: 'application/json',
            dataType: 'json',
            async: false
        }).done(function (data) {
            if (data === "NOT OK") {
                $('.login-error').show();
            } else {
                setCookie("sessionUUID", data, 10);
                window.location = "index.html";
            }
        });
    });
});