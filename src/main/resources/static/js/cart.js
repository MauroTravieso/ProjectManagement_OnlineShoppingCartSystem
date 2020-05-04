$(document).ready(function() {

    /*$('#up').on('change keyup', function(){
       window.location.reload();
    });*/

    $('.quantityChange').change(function () {
        const url = '/user/updateline/'+this.title+'/'+this.value;
        const data = this.value;
        $.ajax({
            type : 'GET',
            url : url,
            contentType: "application/json",
            dataType: "json",
            success:function(results){
                console.log(results);
            },
            error: function (e) {
                console.log(e.responseJSON);
            }
        });
    });
});


