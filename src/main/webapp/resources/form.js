/**
 * Created by on 15.07.2014.
 */
$("#add11").click( function() {

    // NOT working
    var data = {a: harvestForms("a"),
        b: harvestForms("b")};
    // working
    var data1 = { aOne: "a1", aTwo: "a2", bOne: "b1", bTwo: "b2"};
    // working
    var data2 = {};
    harvestForms1(data2, "a");
    harvestForms1(data2, "b");
    // working
    var data3 = $("form#a").serialize() + "&" + $("form#b").serialize();
    console.log(data3);
    $.post("add1", data3)
        .done (function (data) {
        displayResult(data);
    })
        .fail(function (data) {
            $("#messages").empty().append(data);
        });
});

// NOT working - demonstrates how to handle an error
$("#params").click( function() {
    var data1 = { };
    $.post("urlparams?c=1&d=2", data1)
        .done (function (data) {
        displayResult(data);
    })
        .fail(function(jqXHR, textStatus, errorThrown) {
            $("#messages").empty().text(jqXHR.status + " " + jqXHR.statusText + " " +textStatus);
            if(jqXHR.status == 404) {
                console.log(jqXHR.responseText);
            }
        });
});

$("#add12").click( function() {
    var b = harvestForms("b");
    var c = $("form#b").serialize();
    console.log(c);
    $.post("add1", c)
        .done (function (data) {
        displayResult(data);
    })
        .fail(function (data) {
            $("#messages").empty().append(data);
        });
});

$("#add21").click( function() {
    var a = JSON.stringify(harvestForms("a"));
    var b = JSON.stringify(harvestForms("b"));
    var data = { a: a, b: b};

    $.ajax({
        type: "post",
        url: "add21",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (result) {
            displayResult(result);
        },
        error: function (result) {
            console.log("error!"+result);
        }
    });
});

$("#add22").click( function() {
    var a = JSON.stringify(harvestForms("a"));

    $.ajax({
        type: "post",
        url: "add22",
        contentType: "application/json",
        data: a,
        success: function (result) {
            displayResult(result);
        },
        error: function (result) {
            console.log("error!");
        }
    });
});

$("#add23").click( function() {
    var a = JSON.stringify(harvestForms("a"));
    var b = JSON.stringify(harvestForms("b"));
    var data = { a: a, b: b};

    $.ajax({
        type: "post",
        url: "add23",
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (result) {
            displayResult(result);
        },
        error: function (result) {
            console.log("error!");
        }
    });
});

displayResult = function(data) {
    console.log("display result"+$(data).find("#messages"));
    $result = $("<div/>");
    $result.append(data);
    var n = $($result).find("#formDiv").length;
    var d = $(data).find("div").length;
    if( $( $result ).find( '#formDiv').length > 0 ) {
        $result.find("input ~ span").prev().addClass("error");
        //.css({"border":"1px solid #c33020"});
        $("#formDiv").replaceWith($($result).find("#formDiv"));
    } else {
        $(".error").removeClass("error");
        $("#messages").replaceWith($(data).find("#messages"));
        $("#result").replaceWith($(data).find("#result"));
        $("input ~ span").remove();
    }
};

harvestForms = function(formID) {
    var input = {};
    $("form#" +formID).find("input, textarea, select").each(function() {
        input[this.name]= $(this).val();
    });
    return input;
};

harvestForms1 = function(input, formID) {
    $("form#" +formID).find("input, textarea, select").each(function() {
        input[this.name]= $(this).val();
    });
    return input;
};
