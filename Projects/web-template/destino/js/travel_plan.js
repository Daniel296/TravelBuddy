var allTravelItems = [];
var lastSelectChanged = null;

var isStartTravelGood = false;
var isEndTravelGood = false;

$(document).ready(function () {
    "use strict";

    /*

    1. Vars and Inits

    */

    var header = $('.header');
    var hamb = $('.hamburger');
    var hambActive = false;
    var menuActive = false;
    var ctrl = new ScrollMagic.Controller();

    setHeader();

    $(window).on('resize', function () {
        setHeader();
    });

    $(document).on('scroll', function () {
        setHeader();
    });

    initHamburger();
    initParallax();
    initIsotope();

    displayAttractions();

    /*

    2. Set Header

    */

    function setHeader() {
        if (window.innerWidth < 992) {
            if ($(window).scrollTop() > 100) {
                header.addClass('scrolled');
            } else {
                header.removeClass('scrolled');
            }
        } else {
            if ($(window).scrollTop() > 100) {
                header.addClass('scrolled');
            } else {
                header.removeClass('scrolled');
            }
        }
        if (window.innerWidth > 991 && menuActive) {
            closeMenu();
        }
    }

    /*

    3. Initialize Hamburger

    */

    function initHamburger() {
        if ($('.hamburger').length) {
            hamb.on('click', function (event) {
                event.stopPropagation();

                if (!menuActive) {
                    openMenu();

                    $(document).one('click', function cls(e) {
                        if ($(e.target).hasClass('menu_mm')) {
                            $(document).one('click', cls);
                        } else {
                            closeMenu();
                        }
                    });
                } else {
                    $('.menu_container').removeClass('active');
                    menuActive = false;
                }
            });
        }
    }

    function openMenu() {
        var fs = $('.menu_container');
        fs.addClass('active');
        hambActive = true;
        menuActive = true;
    }

    function closeMenu() {
        var fs = $('.menu_container');
        fs.removeClass('active');
        hambActive = false;
        menuActive = false;
    }

    /*

    4. Init Parallax

    */

    function initParallax() {
        // Add parallax effect to every element with class prlx
        // Add class prlx_parent to the parent of the element
        if ($('.prlx_parent').length && $('.prlx').length) {
            var elements = $('.prlx_parent');

            elements.each(function () {
                var ele = this;
                var bcg = $(ele).find('.prlx');

                var slideParallaxScene = new ScrollMagic.Scene({
                    triggerElement: ele,
                    triggerHook: 1,
                    duration: "200%"
                })
                    .setTween(TweenMax.from(bcg, 1, {y: '-30%', ease: Power0.easeNone}))
                    .addTo(ctrl);
            });
        }
    }

    /*

    5. Init Isotope

    */

    function initIsotope() {
        var sortingButtons = $('.item_sorting_btn');

        if ($('.item_grid').length) {
            var grid = $('.item_grid').isotope({
                itemSelector: '.item',
                getSortData:
                    {
                        price: function (itemElement) {
                            var priceEle = $(itemElement).find('.item_price').text().replace('From $', '');
                            return parseFloat(priceEle);
                        },
                        name: '.item_title',
                        stars: function (itemElement) {
                            var starsEle = $(itemElement).find('.rating');
                            var stars = starsEle.attr("data-rating");
                            return stars;
                        }
                    },
                animationOptions:
                    {
                        duration: 750,
                        easing: 'linear',
                        queue: false
                    }
            });

            // Change view to Box
            if ($('.box_view').length) {
                var box = $('.box_view');
                box.on('click', function () {
                    if (window.innerWidth > 767) {
                        $('.item').addClass('box');
                        var option = '{ "sortBy": "original-order" }';
                        option = JSON.parse(option);
                        grid.isotope(option);
                    }
                });
            }

            // Change view to List
            if ($('.detail_view').length) {
                var detail = $('.detail_view');
                detail.on('click', function () {
                    if (window.innerWidth > 767) {
                        $('.item').removeClass('box');
                        var option = '{ "sortBy": "original-order" }';
                        option = JSON.parse(option);
                        grid.isotope(option);
                        setTimeout(function () {
                            grid.isotope(option);
                        }, 500);
                    }
                });
            }
        }
    }
});

/*
    Script snippet for selecting city from suggestions autocomplete
*/
$(document).ready(function () {
    $('#city').bind('input', function () {
        $.ajax({
            type: "POST",
            url: "https://maps.googleapis.com/maps/api/place/autocomplete/json?input=" + this.value
                + "&types=(cities)&key=AIzaSyAvEehceQnGa0DWPp6vWvzDOIXOjXEcf1g",
            async: false,
            dataType: "json"
        }).done(function (result) {
            var htmlInnerText = "";
            for (var i = 0; i < result.predictions.length; i++) {
                htmlInnerText += "<option>" + result.predictions[i].description + "</option>\n";
            }
            $('#cities').html(htmlInnerText);
        });
    });
});

/*
    Hide div for resulted places if no city is selected
 */
$(document).ready(function () {
    $('.travel-plan-items').hide();
    $('.select-items').hide();
});

/*
This function creates each travel plan item and displays it
 */
function createItem(photos, attractionName, interests, address) {
    var photoReference = "";
    if (photos.length === 0) {
        photoReference = "images/No_image_available.png";
    } else {
        photoReference = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photoreference=" + photos[0]
            + "&key=AIzaSyAvEehceQnGa0DWPp6vWvzDOIXOjXEcf1g";
    }

    var tagsHtml = "";
    for (var i = 0; i < interests.length; i++) {
        var temp = interests[i].chars;
        tagsHtml += '<li class="tag">#' + temp + '</li>\n';
    }
    var item = undefined;
    item = ['<div class="item clearfix">\n',
        '<div class="item_image">\n',
        '<img src="' + photoReference + '" alt="">\n',
        '</div>\n',
        '<div class="item_content">\n',
        '<div class="item_title">' + attractionName + '\n',
        '</div>\n',
        '<div class="item_address">' + address + '\n',
        '</div>\n',
        '<div class="item_address">\n',
        '<div class="item_text">\n',
        '<ul class="tags_content d-flex flex-row flex-wrap align-items-start justify-content-start">\n',
        tagsHtml,
        '</div>\n',
        '</div>\n',
        '</div>\n'
    ];

    // a jQuery node
    return $(item.join(''));
}

/*
Display attractions
 */
function displayAttractions(city, listOfInterests) {
    var sessionUUID = getCookie("sessionUUID");
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/core-project/attraction/getAll/?session=" + sessionUUID,
        data: JSON.stringify({cityName: city, userInterests: listOfInterests}),
        contentType: 'application/json; charset=utf-8',
        mimeType: 'application/json',
        dataType: 'json',
        async: false
    }).done(function (result) {

        var items = undefined;
        items = $();

        $('.items').empty();

        if(result.length === 0 ){
            $('.places-bad').show();
            $('.places-good').hide();
            $('.select-items').hide();
        }else{
            $('.places-bad').hide();
            $('.places-good').show();

            for (var i = 0; i < result.length; i++) {
                items = items.add(createItem(result[i].photoReferences, result[i].attractionName, result[i].interests, result[i].address));

                var item = {
                    attractionName: result[i].attractionName,
                    attractionCode: result[i].placeId,
                    isSelected: false
                };
                allTravelItems[i] = item;
            }

            $(function () {
                $('.items').append(items);
            });
        }
    });
}

/*
    Show div for resulted places if no city is selected
 */
$(document).ready(function () {
    $('#search-places-button').click(function () {
        $('.travel-plan-items').show();
        $('.places-bad').hide();
        $('.places-good').hide();
        $('.select-items').show();
        $('.text-select-preferences').hide();
        $('.dropdown-select-preferences').hide();

        $('#search-places-button').keypress(function (e) {
            if (e.which == 13) {//Enter key pressed
                $('#search-places-button').click();//Trigger search button click event
            }
        })

        var interests = [];
        interests = ($('#interests').val()).split(' ');

        var filtered = interests.filter(function (el) {
            return el != '';
        });

        interests = undefined;
        interests = filtered;

        var city = $('#city').val().split(", ")[0];

        city = myFunction(city);


        displayAttractions(city, interests);

        $('.start-travel-datepicker').change(function () {
            if (checkIfStartDateForTravelIsCompleted() && checkIfStartDateForTravelIsInTheFuture()) {
                isStartTravelGood = true;
            } else {
                isStartTravelGood = false;
            }
            isEndTravelGood = false;
            if (isStartTravelGood && isEndTravelGood) {
                $('.text-select-preferences').show();
                $('.dropdown-select-preferences').show();
            } else {
                $('.text-select-preferences').hide();
                $('.dropdown-select-preferences').hide();
            }
        });

        $('.end-travel-datepicker').change(function () {
            if (checkIfEndDateForTravelIsCompleted() && checkIdStartDateIsSmallerThanEndDate()) {
                isEndTravelGood = true;
            } else {
                isEndTravelGood = false;
            }

            if (isStartTravelGood && isEndTravelGood) {
                $('.text-select-preferences').show();
                $('.dropdown-select-preferences').show();
            } else {
                $('.text-select-preferences').hide();
                $('.dropdown-select-preferences').hide();
            }
        });
    });
});

/*

 */
function setOptionsForSelect(e) {
    if ($(e).children(':selected').text().length === 0 || $(e).children(':selected').text() === "Please select...") {
        var innerHtmlText = '';
        innerHtmlText = '<option id="default-value" selected>Please select...</option>\n';
        for (var i = 0; i < allTravelItems.length; i++) {
            if (allTravelItems[i].isSelected === false) {
                innerHtmlText += '<option id="' + allTravelItems[i].attractionCode + '">' + allTravelItems[i].attractionName + '</option>\n';
            }
        }
        $(e).html(innerHtmlText);
    }
}

/*
This function add a new dropdown when the link "Add more" is clicked
 */
function addNewDropdown(e) {
    var selectedOption = $(lastSelectChanged).children('option').filter(':selected');

    var filteredTravelItems = allTravelItems.filter(function (obj) {
        return (obj.isSelected === false);
    });

    if (selectedOption.text() !== "Please select..." && filteredTravelItems.length > 1) {
        var foundItemIndex = allTravelItems.findIndex((obj => obj.attractionCode === selectedOption.attr('id')));
        allTravelItems[foundItemIndex].isSelected = true;

        var innerHtmlText = '';
        innerHtmlText += '<br/>' +
            '<div class="row">' +
            '<div class="col-sm-4"' +
            '<label class="select-place-label"> Select place:\n' +
            '<select class="preference-selector"  onclick="setOptionsForSelect(this)" onchange="changeItemOptionEvent(this)">\n' +
            '<option id="default-value" selected>Please select...</option>' +
            '</select>\n' +
            '</label>' +
            '</div>' +
            '<div class="col-sm-4 start-datepicker">' +
            '<p> Pick your start date for visiting this place:<br/>' +
            '<input type="date" class="start-item-datepicker"></p>' +
            '</div>' +
            '<div class="col-sm-4 end-datepicker">' +
            '<p> Pick your end date for visiting this place:<br/>' +
            '<input type="date" class="end-item-datepicker"></p>' +
            '</div>' +
            '</div>';
        $('.select-each-preference').append(innerHtmlText);
    }
}

/*

 */
function changeItemOptionEvent(e) {
    lastSelectChanged = e;

    var foundItemIndex = allTravelItems.findIndex((obj => obj.attractionCode === $(e).children(':selected').attr('id')));
    allTravelItems[foundItemIndex].isSelected = true;
}

/*
 */
function checkIfStartDateForTravelIsInTheFuture() {
    var startDatepicker = $('.select-items').find('.datepicker').eq(0).find('.start-travel-datepicker').first();

    if (new Date($(startDatepicker).val()).getTime() >= new Date().getTime()) {
        return true;
    }
    alert("Selected time is in the past. Choose a date in the future.");
    return false;
}

/*

 */
function checkIfStartDateForTravelIsCompleted() {
    var startDatepicker = $('.select-items').find('.datepicker').eq(0).find('.start-travel-datepicker').first();

    if ($(startDatepicker).val() !== "") {
        return true;
    }
    return false;
}

/*

 */
function checkIfEndDateForTravelIsCompleted() {
    var endDatepicker = $('.select-items').find('.datepicker').eq(1).find('.end-travel-datepicker').first();

    if ($(endDatepicker).val() !== "") {
        return true;
    }
    return false;
}

function checkIdStartDateIsSmallerThanEndDate() {
    var startDatepicker = $('.select-items').find('.datepicker').eq(0).find('.start-travel-datepicker').first();
    var endDatepicker = $('.select-items').find('.datepicker').eq(1).find('.end-travel-datepicker').first();

    if (new Date($(startDatepicker).val()).getTime() <= new Date($(endDatepicker).val()).getTime()) {
        return true;
    }
    alert("End date must be bigger the start date in you plan.");
    return false;
}

/*

 */
function validateAndSubmitData(e) {
    var listOfTravelItems = [];
    var index = 0;
    var repeat = 0;
    $("body").find('.select-each-preference').first().find('.row').each(function () {
        var currentElement = $(this);
        repeat++;

        var currentIdForSelectedOption = $(this).find('.preference-selector').first().children('option').filter(':selected').attr('id');

        var currentStartDateForSelectedOption = $(this).find('.start-datepicker').first().find('input').val();

        var currentEndDateForSelectedOption = $(this).find('.end-datepicker').first().find('input').val();

        var travelPlanItem = {
            startDate: new Date(currentStartDateForSelectedOption).getTime(),
            endDate: new Date(currentEndDateForSelectedOption).getTime(),
            attractionCode: currentIdForSelectedOption,
        };

        listOfTravelItems[index++] = travelPlanItem;
    });

    if( listOfTravelItems.length === 1 && listOfTravelItems[0].attractionCode === 'default-value'){
        alert("You have to select al least one place to visit in order to finalize your travel plan...");
    }else{

        var endDatepicker = $('.select-items').find('.datepicker').eq(1).find('.end-travel-datepicker').first().val();
        var startDatepicker = $('.select-items').find('.datepicker').eq(0).find('.start-travel-datepicker').first().val();

        var startDateMillis = new Date(startDatepicker).getTime().toString();
        var endDateMillis = new Date(endDatepicker).getTime().toString();

        var sessionUUID = getCookie("sessionUUID");

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/core-project/trip/create/?session=" + sessionUUID,
            data: JSON.stringify({startDate: startDateMillis, endDate: endDateMillis, travelPlanItems: listOfTravelItems}),
            contentType: 'application/json',
            mimeType: 'application/json',
            dataType: 'json',
            async: false
        }).done(function (result) {
            if (result === "OK") {
                alert("Congratulations, you successfully created the trip plan!!!");
                window.location = "index.html";
            } else {
                alert("We encountered a problem with server. Sorry for this inconvenient...");
                window.location = "index.html";
            }
        });
    }
}