$( "#toggleform" ).on( "click", function() {
    $('#hideform').toggle();
});

$( "#creditcardform" ).on( "click", function() {
    $('#creditcardhideform').toggle();
    $('#paypalform').toggle();

});

$( "#paypalform" ).on( "click", function() {
    $('#paypalhideform').toggle();
    $('#creditcardform').toggle();
});

$( "#toggleDetails" ).on( "click", function() {
    $('#detailsHideFom').toggle();
});

$( "#termsAndConditionsCheckbox" ).on( "click", function() {
    $('#buttonToHide').toggle();
});