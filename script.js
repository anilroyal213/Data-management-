console.log("working");
$(document).ready(function (){
    console.log("working");
    $("#submitButton").on("click",function(){
        $.ajax({
            url : "http://localhost:8080/DemoServlet/sampleservlet",
            type : "POST",
            datatype : 'json',
            data : {
                "username" : $('#Username').val() ,
                "password" : $('#password').val()
            },
            contentType : 'application/json',
            mimeType: 'application/json',
            success : function(event){
                alert("sucess" + event);
            },
            error : function(err){
                alert("error");
            }
        })
    });
});