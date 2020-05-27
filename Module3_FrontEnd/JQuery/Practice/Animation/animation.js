$(document).ready(function () {
    $("#hide").click(function () {
        $("h1").hide();
    });
    $("#show").click(function () {
        $("h1").show();
    });

    $("#move").click(function(){
        // var div = $("div");
        $("div").animate({left: '100px'}, "slow");
        $("div").animate({fontSize: '100px'}, "slow");
    });
});