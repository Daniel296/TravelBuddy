var matches;

$(document).ready(function () {
    var sessionUUID = getCookie("sessionUUID");

    // Get user matches
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/core-project/matches/getMatches/?sessionUUID=" + sessionUUID,
        dataType: 'json',
        async: false
    }).done(function (result) {
        matches = result;
    });

    generateMatches();
});

function generateMatches(){

    console.log("Matches: ");
    console.log(matches);


    var innerHtmlText= '';
    for( var i = 0; i < matches.length; i++ ){
        innerHtmlText += '<div class="match">'
            + '<div class="row">'
            + '<div class="col">'
            + '<div class="user-photo">'
            + '<img src="images/No_image_available.png" alt="">'
            + '</div>'
            + '</div>'
            + '</div>'
            + '<div class="row">'
            + '<div class="col">'
            + '<div class="user-data">'
            + '<p>Firstname: ' + matches[i].firstName +'</p>'
            + '<p>Lastname: ' + matches[i].lastName +'</p>'
            + '<p>Place of birth: ' + matches[i].city +'</p>'
            + '</div>'
            + '</div>'
            + '</div>'
            + '</div>'
    }

    $('.all-matches').html(innerHtmlText);
}