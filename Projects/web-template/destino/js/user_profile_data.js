var userProfileData;
var places = [];

$(document).ready(function () {
    $('.personal-profile').hide();
    $('.travel-history').hide();
    $('.user-interests').hide();

    // Get user profile data and interests
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

    // Get all places fromm TravelPlanItems by place id
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
}

$(document).ready(function () {
    $('.show-travel-items').hide();
    $(document).on('click', '.href-select-travel', function (e) {
        if ($(this).next().next().first().find('.show-travel-items').first().is(":visible")) {
            $(this).next().next().first().find('.show-travel-items').first().hide();
        } else {
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

                var tagsHtml = "";
                for (var j = 0; j < place.types.length; j++) {
                    tagsHtml += '<li class="tag">#' + place.types[i] + '</li>\n';
                }

                var photoReference;
                if (place.photos.length === 0) {
                    photoReference = "images/No_image_available.png";
                } else {
                    photoReference = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=" + place.photos[0].photo_reference
                        + "&key=AIzaSyAvEehceQnGa0DWPp6vWvzDOIXOjXEcf1g";
                }
                innerHtmlText += '<div class="item clearfix">\n'
                    + '<div class="item_image">\n'
                    + '<img src="' + photoReference + '" alt="">\n'
                    + '</div>\n'
                    + '<div class="item_content">\n'
                    + '<div class="item_title">' + place.name + '\n'
                    + '</div>\n'
                    + '<div class="item_address">' + place.formatted_address + '\n'
                    + '</div>\n'
                    + '<div class="item_address">\n'
                    + '<div class="item_text">\n'
                    + '<ul class="tags_content d-flex flex-row flex-wrap align-items-start justify-content-start">\n'
                    + tagsHtml
                    + '</div>\n'
                    + '</div>\n'
                    + '</div>\n';
            }
            $(this).next().next().first().find('.show-travel-items').first().html(innerHtmlText);
        }
    });
});

function userInterests() {
    var innerHtmlText = '';
    innerHtmlText += '<table>'
        + '<tr><td> Question </td><td> Answer </td></tr>';

    var dataArray = userProfileData.interest;
    for (var prop in dataArray) {
        if (dataArray.hasOwnProperty(prop) && prop !== 'id') {
            innerHtmlText += '<tr>'
                + '<td>'
                + '<div class="interest-question">'
                + ' <h5>Formulare intrebare</h5>'
                + '<p>#' + prop + '</p>'
                + '</div>'
                + '</td>'
                + '<td> '+ dataArray[prop] +' </td>'
                + '</tr>';
        }
    }
    innerHtmlText += '</table>';
    $('.interests-data').html(innerHtmlText);
}

function showPersonalProfile(){
    $('.user-interests').hide();
    $('.travel-history').hide();
    if( $('.personal-profile').is(":visible") ){
        $('.personal-profile').hide();
    }else{
        $('.personal-profile').show();
    }
}

function showTravelHistory(){
    $('.personal-profile').hide();
    $('.user-interests').hide();
    if( $('.travel-history').is(":visible") ){
        $('.travel-history').hide();
    }else{
        $('.travel-history').show();
    }
}

function showUserInterests(){
    $('.personal-profile').hide();
    $('.travel-history').hide();
    if( $('.user-interests').is(":visible") ){
        $('.user-interests').hide();
    }else{
        $('.user-interests').show();
    }
}