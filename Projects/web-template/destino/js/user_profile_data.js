var userProfileData;

var places = [];

$(document).ready(function () {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/core-project/user-profile/getBySessionUuid/?sessionUuid=temporary_uuid",
        data: JSON.stringify({}),
        contentType: 'application/json',
        mimeType: 'application/json',
        dataType: 'json',
        async: false
    }).done(function (result) {
        console.log("BACK-END RESPONSE:");
        console.log(result);
        userProfileData = result;
    });

    //Get all places fromm TravelPlanItems by place id
    var counter = 0;
    if (userProfileData.travelPlans.length !== 0) {
        for (var i = 0; i < userProfileData.travelPlans.length; i++) {
            for (var j = 0; j < userProfileData.travelPlans[i].travelPlanItems.length; j++) {
                $.ajax({
                    type: "POST",
                    url: "https://maps.googleapis.com/maps/api/place/details/json?placeid="
                        + userProfileData.travelPlans[i].travelPlanItems[j].attractionCode
                        + "&key=AIzaSyAvEehceQnGa0DWPp6vWvzDOIXOjXEcf1g",
                    async: false,
                    dataType: "json"
                }).done(function (result) {
                    console.log("RESULTED PLACE: ");
                    console.log(result);
                    places[counter++] = result;
                });
            }
        }
    }

    for( var i =0 ; i < places.length; i++){
        console.log('PLACE: ' + places[i]);
    }
    personalProfile();
    travelHistory();
    userInterests();
});

function personalProfile() {
    var innerHtmlText = '';
    innerHtmlText += '<img src="images/No_image_available.png" alt="">';
    $('.user-photo').html(innerHtmlText);

    innerHtmlText = '<label> Your firstname: ' + userProfileData.firstName + '</label><br/>'
        + '<label> Your lastname: ' + userProfileData.lastName + '</label><br/>'
        + '<label> Your phone number: ' + userProfileData.phoneNumber + '</label><br/>'
        + '<label> Your gender: ' + userProfileData.gender + '</label><br/>'
        + '<label> Your gender interest: ' + userProfileData.genderInterest + '</label><br/>';
    $('.user-details').html(innerHtmlText);
}

function travelHistory() {
    innerHtmlText = '';
    if (userProfileData.travelPlans.length === 0) {
        innerHtmlText = '<h1> You don\'t have a travel plan yet...';
    } else {
        for (var i = 0; i < userProfileData.travelPlans.length; i++) {

        }
    }
    $('.travel-places-links').html(innerHtmlText);

}

function userInterests() {

}