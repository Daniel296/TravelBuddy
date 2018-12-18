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
                    console.log(result.result);
                    places[counter++] = result.result;
                });
            }
        }
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
    var innerHtmlText = '';
    if (userProfileData.travelPlans.length === 0) {
        innerHtmlText = '<h1> You don\'t have a travel plan yet...';
    } else {
        var startDate;
        var endDate;
        for (var i = 0; i < userProfileData.travelPlans.length; i++) {
            startDate = new Date(userProfileData.travelPlans[i].startDate).toLocaleDateString();
            endDate = new Date(userProfileData.travelPlans[i].endDate).toLocaleDateString();

            var items = jQuery.map(userProfileData.travelPlans[i].travelPlanItems, function (a) {
                return a.attractionCode;
            });
            console.log("ITEMS:" + items);
            innerHtmlText += '<div class="travel-plan">'
                + '<a class="href-select-travel" id="' + items + '" href="javascript:void(0);">'
                + 'Travel between ' + startDate + ' - ' + endDate + '</a><br/>'
                + '<div class = "row">'
                + '<div class = "col">'
                + '<div class="show-travel-items"> </div>'
                + '</div>'
                + '</div>'
                + '</div>';
        }
    }
    $('.travel-places-links').html(innerHtmlText);
    console.log("AICI: " + $('.travel-places-links').first().find('.show-travel-items').first().attr('class'));
}

$(document).ready(function () {
    $('.show-travel-items').hide();
    $(document).on('click', '.href-select-travel', function (e) {
        if( $(this).next().next().first().find('.show-travel-items').first().is(":visible") ){
            $(this).next().next().first().find('.show-travel-items').first().hide();
        }else{
            $(this).next().next().first().find('.show-travel-items').first().show();
            console.log("Click " + $(this).attr('id'));
            var id = $(this).attr('id');
            var items = id.split(',');
            var innerHtmlText = '';
            for (var i = 0; i < items.length; i++) {
                var place = places.filter(function (el) {
                    return el.place_id === items[i];
                })[0];
                console.log("Found place at pos[" + i + "]: " + place);

                innerHtmlText += '<div class="travel-item-address">'
                    + '<h3>' + place.adr_address + '</h3>'
                    + '</div>';
            }
            $(this).next().next().first().find('.show-travel-items').first().html(innerHtmlText);
        }
    });
});

function userInterests() {

}