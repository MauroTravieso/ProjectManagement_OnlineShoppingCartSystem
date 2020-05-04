$(document).ready(function () {

    $("#sameadr").change(function() {
        if(this.checked) {
            $("#billing").hide();
        } else {
            $('#billing').show();
        }
    });

    function qteChanged() {
        console.log("changed")
    }

});