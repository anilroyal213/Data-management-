$(document).ready(function(){
    $.ajax({
        url : "../SessionData",
        type : "GET",
        success : function(event){
            var data = JSON.parse(event);
            if(data["redirect"] === "true"){
                window.location.href = "DataManagement/views/User_Login_page.html"
            }
            else{
                $('#usernameDisplay').append(data["username"]);
            }
        },
        error : function(error){
            alert("error");
        }
    })
});