/* JS Document */

/******************************

 [Table of Contents]

 1. Vars and Inits
 2. Set Header
 3. Initialize Hamburger
 4. Init Parallax
 5. Init Isotope

 ******************************/

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
            }
            else {
                header.removeClass('scrolled');
            }
        }
        else {
            if ($(window).scrollTop() > 100) {
                header.addClass('scrolled');
            }
            else {
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
                        }
                        else {
                            closeMenu();
                        }
                    });
                }
                else {
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
                // console.log("prediction:" + result.predictions[i].description);
                htmlInnerText += "<option>" + result.predictions[i].description + "</option>\n";
            }
            $('#cities').html(htmlInnerText);
        });
    })
});

/*
    Hide div for resulted places if no city is selected
 */
$(document).ready(function () {
    // if($('#city').val().length === 0 || $('#interests').val().length === 0 ){
    $('.travel-plan-items').hide();
    // }
});

/*
<!-- Item -->
<div class="item clearfix">
<div class="item_image">
    <img src="" alt="">
</div>
<div class="item_content">
    <div class="item_title">
        Titlu
    </div>
    <div class="item_text">
        Tags
    </div>
</div>
</div>

<ul class="tags_content d-flex flex-row flex-wrap align-items-start justify-content-start">
                            <li class="tag"><a href="#">travel</a></li>
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
    item = ['<div class="item clearfix">',
        '<div class="item_image">',
        '<img src="' + photoReference + '" alt="">',
        '</div>',
        '<div class="item_content">',
        '<div class="item_title">' + attractionName + '',
        '</div>',
        '<div class="item_text">',
        '<ul class="tags_content d-flex flex-row flex-wrap align-items-start justify-content-start">',
        tagsHtml,
        '</div>',
        '</div>',
        '</div>'
    ];

    // a jQuery node
    return $(item.join(''));
}

/*
Display attractions
 */
function displayAttractions(city, listOfInterests) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/core-project/attraction/getAll",
        data: JSON.stringify({cityName: city, userInterests: listOfInterests}),
        contentType: 'application/json; charset=utf-8',
        mimeType: 'application/json',
        dataType: 'json',
        async: false
    }).done(function (result) {
        console.log("Result, please work");
        console.log(result);

        var items = undefined;
        items = $();

        for (var i = 0; i < result.length; i++) {
            items = items.add(createItem(result[i].photoReferences, result[i].attractionName, result[i].interests, result[i].address))
        }

        $(function () {
            $('.items').append(items);
        });
    });
}

/*
    Show div for resulted places if no city is selected
 */
$(document).ready(function () {
    $('#search-places-button').click(function () {
        $('.travel-plan-items').show();

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

        console.log("City:" + city);
        console.log("Interests:" + interests);

        city = myFunction(city);
        console.log("Latinizat: " + city);

        displayAttractions(city, interests);
    });
});

/*
Function created for latinize all the special letters into latins one (e.g. ș -> s)
 */
function myFunction(word) {
    var Latinise = {};
    Latinise.latin_map = {
        "Á": "A",
        "Ă": "A",
        "Ắ": "A",
        "Ặ": "A",
        "Ằ": "A",
        "Ẳ": "A",
        "Ẵ": "A",
        "Ǎ": "A",
        "Â": "A",
        "Ấ": "A",
        "Ậ": "A",
        "Ầ": "A",
        "Ẩ": "A",
        "Ẫ": "A",
        "Ä": "A",
        "Ǟ": "A",
        "Ȧ": "A",
        "Ǡ": "A",
        "Ạ": "A",
        "Ȁ": "A",
        "À": "A",
        "Ả": "A",
        "Ȃ": "A",
        "Ā": "A",
        "Ą": "A",
        "Å": "A",
        "Ǻ": "A",
        "Ḁ": "A",
        "Ⱥ": "A",
        "Ã": "A",
        "Ꜳ": "AA",
        "Æ": "AE",
        "Ǽ": "AE",
        "Ǣ": "AE",
        "Ꜵ": "AO",
        "Ꜷ": "AU",
        "Ꜹ": "AV",
        "Ꜻ": "AV",
        "Ꜽ": "AY",
        "Ḃ": "B",
        "Ḅ": "B",
        "Ɓ": "B",
        "Ḇ": "B",
        "Ƀ": "B",
        "Ƃ": "B",
        "Ć": "C",
        "Č": "C",
        "Ç": "C",
        "Ḉ": "C",
        "Ĉ": "C",
        "Ċ": "C",
        "Ƈ": "C",
        "Ȼ": "C",
        "Ď": "D",
        "Ḑ": "D",
        "Ḓ": "D",
        "Ḋ": "D",
        "Ḍ": "D",
        "Ɗ": "D",
        "Ḏ": "D",
        "ǲ": "D",
        "ǅ": "D",
        "Đ": "D",
        "Ƌ": "D",
        "Ǳ": "DZ",
        "Ǆ": "DZ",
        "É": "E",
        "Ĕ": "E",
        "Ě": "E",
        "Ȩ": "E",
        "Ḝ": "E",
        "Ê": "E",
        "Ế": "E",
        "Ệ": "E",
        "Ề": "E",
        "Ể": "E",
        "Ễ": "E",
        "Ḙ": "E",
        "Ë": "E",
        "Ė": "E",
        "Ẹ": "E",
        "Ȅ": "E",
        "È": "E",
        "Ẻ": "E",
        "Ȇ": "E",
        "Ē": "E",
        "Ḗ": "E",
        "Ḕ": "E",
        "Ę": "E",
        "Ɇ": "E",
        "Ẽ": "E",
        "Ḛ": "E",
        "Ꝫ": "ET",
        "Ḟ": "F",
        "Ƒ": "F",
        "Ǵ": "G",
        "Ğ": "G",
        "Ǧ": "G",
        "Ģ": "G",
        "Ĝ": "G",
        "Ġ": "G",
        "Ɠ": "G",
        "Ḡ": "G",
        "Ǥ": "G",
        "Ḫ": "H",
        "Ȟ": "H",
        "Ḩ": "H",
        "Ĥ": "H",
        "Ⱨ": "H",
        "Ḧ": "H",
        "Ḣ": "H",
        "Ḥ": "H",
        "Ħ": "H",
        "Í": "I",
        "Ĭ": "I",
        "Ǐ": "I",
        "Î": "I",
        "Ï": "I",
        "Ḯ": "I",
        "İ": "I",
        "Ị": "I",
        "Ȉ": "I",
        "Ì": "I",
        "Ỉ": "I",
        "Ȋ": "I",
        "Ī": "I",
        "Į": "I",
        "Ɨ": "I",
        "Ĩ": "I",
        "Ḭ": "I",
        "Ꝺ": "D",
        "Ꝼ": "F",
        "Ᵹ": "G",
        "Ꞃ": "R",
        "Ꞅ": "S",
        "Ꞇ": "T",
        "Ꝭ": "IS",
        "Ĵ": "J",
        "Ɉ": "J",
        "Ḱ": "K",
        "Ǩ": "K",
        "Ķ": "K",
        "Ⱪ": "K",
        "Ꝃ": "K",
        "Ḳ": "K",
        "Ƙ": "K",
        "Ḵ": "K",
        "Ꝁ": "K",
        "Ꝅ": "K",
        "Ĺ": "L",
        "Ƚ": "L",
        "Ľ": "L",
        "Ļ": "L",
        "Ḽ": "L",
        "Ḷ": "L",
        "Ḹ": "L",
        "Ⱡ": "L",
        "Ꝉ": "L",
        "Ḻ": "L",
        "Ŀ": "L",
        "Ɫ": "L",
        "ǈ": "L",
        "Ł": "L",
        "Ǉ": "LJ",
        "Ḿ": "M",
        "Ṁ": "M",
        "Ṃ": "M",
        "Ɱ": "M",
        "Ń": "N",
        "Ň": "N",
        "Ņ": "N",
        "Ṋ": "N",
        "Ṅ": "N",
        "Ṇ": "N",
        "Ǹ": "N",
        "Ɲ": "N",
        "Ṉ": "N",
        "Ƞ": "N",
        "ǋ": "N",
        "Ñ": "N",
        "Ǌ": "NJ",
        "Ó": "O",
        "Ŏ": "O",
        "Ǒ": "O",
        "Ô": "O",
        "Ố": "O",
        "Ộ": "O",
        "Ồ": "O",
        "Ổ": "O",
        "Ỗ": "O",
        "Ö": "O",
        "Ȫ": "O",
        "Ȯ": "O",
        "Ȱ": "O",
        "Ọ": "O",
        "Ő": "O",
        "Ȍ": "O",
        "Ò": "O",
        "Ỏ": "O",
        "Ơ": "O",
        "Ớ": "O",
        "Ợ": "O",
        "Ờ": "O",
        "Ở": "O",
        "Ỡ": "O",
        "Ȏ": "O",
        "Ꝋ": "O",
        "Ꝍ": "O",
        "Ō": "O",
        "Ṓ": "O",
        "Ṑ": "O",
        "Ɵ": "O",
        "Ǫ": "O",
        "Ǭ": "O",
        "Ø": "O",
        "Ǿ": "O",
        "Õ": "O",
        "Ṍ": "O",
        "Ṏ": "O",
        "Ȭ": "O",
        "Ƣ": "OI",
        "Ꝏ": "OO",
        "Ɛ": "E",
        "Ɔ": "O",
        "Ȣ": "OU",
        "Ṕ": "P",
        "Ṗ": "P",
        "Ꝓ": "P",
        "Ƥ": "P",
        "Ꝕ": "P",
        "Ᵽ": "P",
        "Ꝑ": "P",
        "Ꝙ": "Q",
        "Ꝗ": "Q",
        "Ŕ": "R",
        "Ř": "R",
        "Ŗ": "R",
        "Ṙ": "R",
        "Ṛ": "R",
        "Ṝ": "R",
        "Ȑ": "R",
        "Ȓ": "R",
        "Ṟ": "R",
        "Ɍ": "R",
        "Ɽ": "R",
        "Ꜿ": "C",
        "Ǝ": "E",
        "Ś": "S",
        "Ṥ": "S",
        "Š": "S",
        "Ṧ": "S",
        "Ş": "S",
        "Ŝ": "S",
        "Ș": "S",
        "Ṡ": "S",
        "Ṣ": "S",
        "Ṩ": "S",
        "Ť": "T",
        "Ţ": "T",
        "Ṱ": "T",
        "Ț": "T",
        "Ⱦ": "T",
        "Ṫ": "T",
        "Ṭ": "T",
        "Ƭ": "T",
        "Ṯ": "T",
        "Ʈ": "T",
        "Ŧ": "T",
        "Ɐ": "A",
        "Ꞁ": "L",
        "Ɯ": "M",
        "Ʌ": "V",
        "Ꜩ": "TZ",
        "Ú": "U",
        "Ŭ": "U",
        "Ǔ": "U",
        "Û": "U",
        "Ṷ": "U",
        "Ü": "U",
        "Ǘ": "U",
        "Ǚ": "U",
        "Ǜ": "U",
        "Ǖ": "U",
        "Ṳ": "U",
        "Ụ": "U",
        "Ű": "U",
        "Ȕ": "U",
        "Ù": "U",
        "Ủ": "U",
        "Ư": "U",
        "Ứ": "U",
        "Ự": "U",
        "Ừ": "U",
        "Ử": "U",
        "Ữ": "U",
        "Ȗ": "U",
        "Ū": "U",
        "Ṻ": "U",
        "Ų": "U",
        "Ů": "U",
        "Ũ": "U",
        "Ṹ": "U",
        "Ṵ": "U",
        "Ꝟ": "V",
        "Ṿ": "V",
        "Ʋ": "V",
        "Ṽ": "V",
        "Ꝡ": "VY",
        "Ẃ": "W",
        "Ŵ": "W",
        "Ẅ": "W",
        "Ẇ": "W",
        "Ẉ": "W",
        "Ẁ": "W",
        "Ⱳ": "W",
        "Ẍ": "X",
        "Ẋ": "X",
        "Ý": "Y",
        "Ŷ": "Y",
        "Ÿ": "Y",
        "Ẏ": "Y",
        "Ỵ": "Y",
        "Ỳ": "Y",
        "Ƴ": "Y",
        "Ỷ": "Y",
        "Ỿ": "Y",
        "Ȳ": "Y",
        "Ɏ": "Y",
        "Ỹ": "Y",
        "Ź": "Z",
        "Ž": "Z",
        "Ẑ": "Z",
        "Ⱬ": "Z",
        "Ż": "Z",
        "Ẓ": "Z",
        "Ȥ": "Z",
        "Ẕ": "Z",
        "Ƶ": "Z",
        "Ĳ": "IJ",
        "Œ": "OE",
        "ᴀ": "A",
        "ᴁ": "AE",
        "ʙ": "B",
        "ᴃ": "B",
        "ᴄ": "C",
        "ᴅ": "D",
        "ᴇ": "E",
        "ꜰ": "F",
        "ɢ": "G",
        "ʛ": "G",
        "ʜ": "H",
        "ɪ": "I",
        "ʁ": "R",
        "ᴊ": "J",
        "ᴋ": "K",
        "ʟ": "L",
        "ᴌ": "L",
        "ᴍ": "M",
        "ɴ": "N",
        "ᴏ": "O",
        "ɶ": "OE",
        "ᴐ": "O",
        "ᴕ": "OU",
        "ᴘ": "P",
        "ʀ": "R",
        "ᴎ": "N",
        "ᴙ": "R",
        "ꜱ": "S",
        "ᴛ": "T",
        "ⱻ": "E",
        "ᴚ": "R",
        "ᴜ": "U",
        "ᴠ": "V",
        "ᴡ": "W",
        "ʏ": "Y",
        "ᴢ": "Z",
        "á": "a",
        "ă": "a",
        "ắ": "a",
        "ặ": "a",
        "ằ": "a",
        "ẳ": "a",
        "ẵ": "a",
        "ǎ": "a",
        "â": "a",
        "ấ": "a",
        "ậ": "a",
        "ầ": "a",
        "ẩ": "a",
        "ẫ": "a",
        "ä": "a",
        "ǟ": "a",
        "ȧ": "a",
        "ǡ": "a",
        "ạ": "a",
        "ȁ": "a",
        "à": "a",
        "ả": "a",
        "ȃ": "a",
        "ā": "a",
        "ą": "a",
        "ᶏ": "a",
        "ẚ": "a",
        "å": "a",
        "ǻ": "a",
        "ḁ": "a",
        "ⱥ": "a",
        "ã": "a",
        "ꜳ": "aa",
        "æ": "ae",
        "ǽ": "ae",
        "ǣ": "ae",
        "ꜵ": "ao",
        "ꜷ": "au",
        "ꜹ": "av",
        "ꜻ": "av",
        "ꜽ": "ay",
        "ḃ": "b",
        "ḅ": "b",
        "ɓ": "b",
        "ḇ": "b",
        "ᵬ": "b",
        "ᶀ": "b",
        "ƀ": "b",
        "ƃ": "b",
        "ɵ": "o",
        "ć": "c",
        "č": "c",
        "ç": "c",
        "ḉ": "c",
        "ĉ": "c",
        "ɕ": "c",
        "ċ": "c",
        "ƈ": "c",
        "ȼ": "c",
        "ď": "d",
        "ḑ": "d",
        "ḓ": "d",
        "ȡ": "d",
        "ḋ": "d",
        "ḍ": "d",
        "ɗ": "d",
        "ᶑ": "d",
        "ḏ": "d",
        "ᵭ": "d",
        "ᶁ": "d",
        "đ": "d",
        "ɖ": "d",
        "ƌ": "d",
        "ı": "i",
        "ȷ": "j",
        "ɟ": "j",
        "ʄ": "j",
        "ǳ": "dz",
        "ǆ": "dz",
        "é": "e",
        "ĕ": "e",
        "ě": "e",
        "ȩ": "e",
        "ḝ": "e",
        "ê": "e",
        "ế": "e",
        "ệ": "e",
        "ề": "e",
        "ể": "e",
        "ễ": "e",
        "ḙ": "e",
        "ë": "e",
        "ė": "e",
        "ẹ": "e",
        "ȅ": "e",
        "è": "e",
        "ẻ": "e",
        "ȇ": "e",
        "ē": "e",
        "ḗ": "e",
        "ḕ": "e",
        "ⱸ": "e",
        "ę": "e",
        "ᶒ": "e",
        "ɇ": "e",
        "ẽ": "e",
        "ḛ": "e",
        "ꝫ": "et",
        "ḟ": "f",
        "ƒ": "f",
        "ᵮ": "f",
        "ᶂ": "f",
        "ǵ": "g",
        "ğ": "g",
        "ǧ": "g",
        "ģ": "g",
        "ĝ": "g",
        "ġ": "g",
        "ɠ": "g",
        "ḡ": "g",
        "ᶃ": "g",
        "ǥ": "g",
        "ḫ": "h",
        "ȟ": "h",
        "ḩ": "h",
        "ĥ": "h",
        "ⱨ": "h",
        "ḧ": "h",
        "ḣ": "h",
        "ḥ": "h",
        "ɦ": "h",
        "ẖ": "h",
        "ħ": "h",
        "ƕ": "hv",
        "í": "i",
        "ĭ": "i",
        "ǐ": "i",
        "î": "i",
        "ï": "i",
        "ḯ": "i",
        "ị": "i",
        "ȉ": "i",
        "ì": "i",
        "ỉ": "i",
        "ȋ": "i",
        "ī": "i",
        "į": "i",
        "ᶖ": "i",
        "ɨ": "i",
        "ĩ": "i",
        "ḭ": "i",
        "ꝺ": "d",
        "ꝼ": "f",
        "ᵹ": "g",
        "ꞃ": "r",
        "ꞅ": "s",
        "ꞇ": "t",
        "ꝭ": "is",
        "ǰ": "j",
        "ĵ": "j",
        "ʝ": "j",
        "ɉ": "j",
        "ḱ": "k",
        "ǩ": "k",
        "ķ": "k",
        "ⱪ": "k",
        "ꝃ": "k",
        "ḳ": "k",
        "ƙ": "k",
        "ḵ": "k",
        "ᶄ": "k",
        "ꝁ": "k",
        "ꝅ": "k",
        "ĺ": "l",
        "ƚ": "l",
        "ɬ": "l",
        "ľ": "l",
        "ļ": "l",
        "ḽ": "l",
        "ȴ": "l",
        "ḷ": "l",
        "ḹ": "l",
        "ⱡ": "l",
        "ꝉ": "l",
        "ḻ": "l",
        "ŀ": "l",
        "ɫ": "l",
        "ᶅ": "l",
        "ɭ": "l",
        "ł": "l",
        "ǉ": "lj",
        "ſ": "s",
        "ẜ": "s",
        "ẛ": "s",
        "ẝ": "s",
        "ḿ": "m",
        "ṁ": "m",
        "ṃ": "m",
        "ɱ": "m",
        "ᵯ": "m",
        "ᶆ": "m",
        "ń": "n",
        "ň": "n",
        "ņ": "n",
        "ṋ": "n",
        "ȵ": "n",
        "ṅ": "n",
        "ṇ": "n",
        "ǹ": "n",
        "ɲ": "n",
        "ṉ": "n",
        "ƞ": "n",
        "ᵰ": "n",
        "ᶇ": "n",
        "ɳ": "n",
        "ñ": "n",
        "ǌ": "nj",
        "ó": "o",
        "ŏ": "o",
        "ǒ": "o",
        "ô": "o",
        "ố": "o",
        "ộ": "o",
        "ồ": "o",
        "ổ": "o",
        "ỗ": "o",
        "ö": "o",
        "ȫ": "o",
        "ȯ": "o",
        "ȱ": "o",
        "ọ": "o",
        "ő": "o",
        "ȍ": "o",
        "ò": "o",
        "ỏ": "o",
        "ơ": "o",
        "ớ": "o",
        "ợ": "o",
        "ờ": "o",
        "ở": "o",
        "ỡ": "o",
        "ȏ": "o",
        "ꝋ": "o",
        "ꝍ": "o",
        "ⱺ": "o",
        "ō": "o",
        "ṓ": "o",
        "ṑ": "o",
        "ǫ": "o",
        "ǭ": "o",
        "ø": "o",
        "ǿ": "o",
        "õ": "o",
        "ṍ": "o",
        "ṏ": "o",
        "ȭ": "o",
        "ƣ": "oi",
        "ꝏ": "oo",
        "ɛ": "e",
        "ᶓ": "e",
        "ɔ": "o",
        "ᶗ": "o",
        "ȣ": "ou",
        "ṕ": "p",
        "ṗ": "p",
        "ꝓ": "p",
        "ƥ": "p",
        "ᵱ": "p",
        "ᶈ": "p",
        "ꝕ": "p",
        "ᵽ": "p",
        "ꝑ": "p",
        "ꝙ": "q",
        "ʠ": "q",
        "ɋ": "q",
        "ꝗ": "q",
        "ŕ": "r",
        "ř": "r",
        "ŗ": "r",
        "ṙ": "r",
        "ṛ": "r",
        "ṝ": "r",
        "ȑ": "r",
        "ɾ": "r",
        "ᵳ": "r",
        "ȓ": "r",
        "ṟ": "r",
        "ɼ": "r",
        "ᵲ": "r",
        "ᶉ": "r",
        "ɍ": "r",
        "ɽ": "r",
        "ↄ": "c",
        "ꜿ": "c",
        "ɘ": "e",
        "ɿ": "r",
        "ś": "s",
        "ṥ": "s",
        "š": "s",
        "ṧ": "s",
        "ş": "s",
        "ŝ": "s",
        "ș": "s",
        "ṡ": "s",
        "ṣ": "s",
        "ṩ": "s",
        "ʂ": "s",
        "ᵴ": "s",
        "ᶊ": "s",
        "ȿ": "s",
        "ɡ": "g",
        "ᴑ": "o",
        "ᴓ": "o",
        "ᴝ": "u",
        "ť": "t",
        "ţ": "t",
        "ṱ": "t",
        "ț": "t",
        "ȶ": "t",
        "ẗ": "t",
        "ⱦ": "t",
        "ṫ": "t",
        "ṭ": "t",
        "ƭ": "t",
        "ṯ": "t",
        "ᵵ": "t",
        "ƫ": "t",
        "ʈ": "t",
        "ŧ": "t",
        "ᵺ": "th",
        "ɐ": "a",
        "ᴂ": "ae",
        "ǝ": "e",
        "ᵷ": "g",
        "ɥ": "h",
        "ʮ": "h",
        "ʯ": "h",
        "ᴉ": "i",
        "ʞ": "k",
        "ꞁ": "l",
        "ɯ": "m",
        "ɰ": "m",
        "ᴔ": "oe",
        "ɹ": "r",
        "ɻ": "r",
        "ɺ": "r",
        "ⱹ": "r",
        "ʇ": "t",
        "ʌ": "v",
        "ʍ": "w",
        "ʎ": "y",
        "ꜩ": "tz",
        "ú": "u",
        "ŭ": "u",
        "ǔ": "u",
        "û": "u",
        "ṷ": "u",
        "ü": "u",
        "ǘ": "u",
        "ǚ": "u",
        "ǜ": "u",
        "ǖ": "u",
        "ṳ": "u",
        "ụ": "u",
        "ű": "u",
        "ȕ": "u",
        "ù": "u",
        "ủ": "u",
        "ư": "u",
        "ứ": "u",
        "ự": "u",
        "ừ": "u",
        "ử": "u",
        "ữ": "u",
        "ȗ": "u",
        "ū": "u",
        "ṻ": "u",
        "ų": "u",
        "ᶙ": "u",
        "ů": "u",
        "ũ": "u",
        "ṹ": "u",
        "ṵ": "u",
        "ᵫ": "ue",
        "ꝸ": "um",
        "ⱴ": "v",
        "ꝟ": "v",
        "ṿ": "v",
        "ʋ": "v",
        "ᶌ": "v",
        "ⱱ": "v",
        "ṽ": "v",
        "ꝡ": "vy",
        "ẃ": "w",
        "ŵ": "w",
        "ẅ": "w",
        "ẇ": "w",
        "ẉ": "w",
        "ẁ": "w",
        "ⱳ": "w",
        "ẘ": "w",
        "ẍ": "x",
        "ẋ": "x",
        "ᶍ": "x",
        "ý": "y",
        "ŷ": "y",
        "ÿ": "y",
        "ẏ": "y",
        "ỵ": "y",
        "ỳ": "y",
        "ƴ": "y",
        "ỷ": "y",
        "ỿ": "y",
        "ȳ": "y",
        "ẙ": "y",
        "ɏ": "y",
        "ỹ": "y",
        "ź": "z",
        "ž": "z",
        "ẑ": "z",
        "ʑ": "z",
        "ⱬ": "z",
        "ż": "z",
        "ẓ": "z",
        "ȥ": "z",
        "ẕ": "z",
        "ᵶ": "z",
        "ᶎ": "z",
        "ʐ": "z",
        "ƶ": "z",
        "ɀ": "z",
        "ﬀ": "ff",
        "ﬃ": "ffi",
        "ﬄ": "ffl",
        "ﬁ": "fi",
        "ﬂ": "fl",
        "ĳ": "ij",
        "œ": "oe",
        "ﬆ": "st",
        "ₐ": "a",
        "ₑ": "e",
        "ᵢ": "i",
        "ⱼ": "j",
        "ₒ": "o",
        "ᵣ": "r",
        "ᵤ": "u",
        "ᵥ": "v",
        "ₓ": "x"
    };

    String.prototype.latinise = function () {
        return this.replace(/[^A-Za-z0-9\[\] ]/g, function (a) {
            return Latinise.latin_map[a] || a
        })
    };
    String.prototype.latinize = String.prototype.latinise;
    String.prototype.isLatin = function () {
        return this == this.latinise()
    }

    return word.latinize();
}

