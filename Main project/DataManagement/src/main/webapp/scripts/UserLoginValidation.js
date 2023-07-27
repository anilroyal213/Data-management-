$(document).ready(function (){
    $("#errors").hide();
    $("#LoginValidation").on("click",function(){
        var userName = $('#Username').val().trim();
        var password = $('#Password').val().trim();
        if(userName.length >= 8 && password.length >=8){
            $.ajax({
                url : "../LoginValidation",
                type : "POST",
                data : {
                    "username" : userName ,
                    "password" : password
                },
                success : function(event){
                    var data = JSON.parse(event);
                    if(data["username"] === "true" && data["password"] === "true" && data["type"] === "user"){
                        $("#errors").hide();
                        window.location.href = "UserDashBoard.html"
                        return;
                    }
                    else if(data["username"] === "true" && data["password"] === "false"){
                        $("#errors").text("Password wrong");
                        $("#errors").show();
                        //alert("Password wrong");
                        return;
                    }
                    else{
                        $("#errors").text("Username does not exist");
                        $("#errors").show();
                    }
                },
                error : function(err){
                    alert("error");
                    }
                })
            }
            else{
                if(userName.length < 8){
                    $("#errors").text("Enter Username with more than 7 charaters");
                    $("#errors").show();
                    return;
                }
                if(password.length < 8){
                    $("#errors").text("Enter password with more than 7 charaters");
                    $("#errors").show();
                    return;
                }
            }
        });
});