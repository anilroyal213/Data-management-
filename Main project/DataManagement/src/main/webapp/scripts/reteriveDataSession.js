$(document).ready(function(){
    $.ajax({
        url : "../SessionData",
        type : "GET",
        success : function(event){
            var data = JSON.parse(event);
            if(data["redirect"] === "true"){
                window.location.href = "User_Login_page.html"
            }
            else{
                $('#usernameDisplay').append(data["name"]);
            }
        },
        error : function(error){
            console.log("error");
        }
    })
});