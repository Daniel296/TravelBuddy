$(document).ready(function () {
    $('.register-btn').click(function (e) {
        if (validateRegisterForm()) {
            var firstName = $('#firstname').val();
            var lastName = $('#lastname').val();
            var city = $('#city').val();
            var country = $('#country').val();
            var gender = $("input:radio[name='gender']:checked").val();
            var genderInterest = $("input:radio[name='genderInterest']:checked").val();
            var email = $('#email').val();
            var phoneNumber = $('#phoneNumber').val();
            var password = $('#psw').val();

            var cityCode = findCityCode(city);
            var countryCode = findCountryCode(country);

            $.ajax({
                type: "POST",
                url: "http://localhost:8080/core-project/register",
                data: JSON.stringify({
                    "email": email,
                    "facebookToken": "",
                    "googleToken": "",
                    "id": 0,
                    "password": password,
                    "userProfile": {
                        "city": {
                            "cityCode": cityCode,
                            "country": {
                                "countryCode": countryCode,
                                "id": 0,
                                "name": country
                            },
                            "id": 0,
                            "name": city
                        },
                        "firstName": firstName,
                        "gender": gender,
                        "genderInterest": genderInterest,
                        "id": 0,
                        "interest": {
                            "amusement_park": false,
                            "aquarium": false,
                            "art_gallery": false,
                            "bar": false,
                            "beach": false,
                            "bowling_alley": false,
                            "bridge": false,
                            "cafe": false,
                            "casino": false,
                            "cemetery": false,
                            "church": false,
                            "embassy": false,
                            "hindu_temple": false,
                            "id": 0,
                            "lake": false,
                            "library": false,
                            "liquor_store": false,
                            "mall": false,
                            "mosque": false,
                            "mountain": false,
                            "movie_theater": false,
                            "museum": false,
                            "night_club": false,
                            "ocean": false,
                            "palace": false,
                            "park": false,
                            "restaurant": false,
                            "school": false,
                            "sea": false,
                            "ski": false,
                            "stadium": false,
                            "synagogue": false,
                            "theater": false,
                            "tower": false,
                            "tradition": false,
                            "zoo": false
                        },
                        "lastLat": 0,
                        "lastLng": 0,
                        "lastName": lastName,
                        "phoneNumber": phoneNumber,
                        "travelPlans": null
                    }
                }),
                contentType: 'application/json',
                mimeType: 'application/json',
                dataType: 'json',
                async: false
            }).done(function (data) {
                if (data === "OK") {
                    alert("You were successfully registered. Now you can log in...");
                    window.location.href = "login.html";
                } else {
                    alert("This email or phone number already exists. Unsuccessful registration...");
                }
            });
        }
    });
});

function validateRegisterForm() {
    var firstName = $('#firstname').val();
    var lastName = $('#lastname').val();
    var email = $('#email').val();
    var phoneNumber = $('#phone-number').val();
    var password = $('#psw').val();
    var repeatPassword = $('#psw-repeat').val();

    var errorNumber = 0;
    if (firstName.length > 25 || firstName.length < 3) {
        errorNumber++;
        $('.input-error-fname').show();
    } else {
        $('.input-error-fname').hide();
    }

    if (lastName.length > 25 || lastName.length < 3) {
        errorNumber++;
        $('.input-error-lname').show();
    } else {
        $('.input-error-lname').hide();
    }

    var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!regex.test(email)) {
        errorNumber++;
        $('.input-error-email').show();
    } else {
        $('input-error-email').hide();
    }

    regex = /\(?([0-9]{3})\)?([ .-]?)([0-9]{3})\2([0-9]{4})/;
    if (!regex.test(phoneNumber)) {
        errorNumber++;
        $('.input-error-number').show();
    } else {
        $('.input-error-number').hide();
    }

    if (!(password.length >= 5 && password.length <= 25) || password !== repeatPassword) {
        errorNumber++;
        $('.input-error-psw').show();
    } else {
        $('.input-error-psw').hide();
    }

    return errorNumber === 0;
}

function findCityCode(city) {
    var cityCode = "";
    $.ajax({
        type: "POST",
        url: "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + city
            + "&types=(cities)&key=AIzaSyAvEehceQnGa0DWPp6vWvzDOIXOjXEcf1g",
        async: false,
        dataType: "json"
    }).done(function (result) {
        cityCode = result.predictions[0].id;
    });
    return cityCode;
}

function findCountryCode(country) {
    var countryCode = "";
    $.ajax({
        type: "POST",
        url: "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + country
            + "&types=(regions)&key=AIzaSyAvEehceQnGa0DWPp6vWvzDOIXOjXEcf1g",
        async: false,
        dataType: "json"
    }).done(function (result) {
        countryCode = result.predictions[0].id;
    });
    return countryCode;
}