$(document).ready(function(){
    $.ajax({
        url : "../SessionData",
        type : "GET",
        success : function(data){
            var data = String(data);
            $('body').append("1Hello" + data);
            if(data.localeCompare("null")){
                $('body').append("2Hello" + data);
                //window.location.replace("http://www.w3schools.com");
            }
            else{
                $('body').append("3Hello" + data);
            }
        },
        error : function(error){
            alert("error");
        }
    })
});