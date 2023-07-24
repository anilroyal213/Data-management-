$(document).ready(function (){
    $("#errors").hide();
    $("#LoginValidation").on("click",function(){
        var userName = $('#Username').val();
        var password = $('#Password').val();
        if(userName.length != 0 && password.length != 0){
            $.ajax({
                url : "../LoginValidation",
                type : "POST",
                data : {
                    "username" : userName ,
                    "password" : password
                },
                success : function(event){
                    var data = JSON.parse(event);
                    if(data["username"] === "true" && data["password"] === "true"){
                        $("#errors").hide();
                        return;
                    }
                    else if(data["username"] === "true" && data["password"] === "false"){
                        $("#errors").text("Password wrong");
                        $("#errors").show();
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
            if(userName.length == 0){
                $("#errors").text("Enter a valid username");
                $("#errors").show();
                return;
            }
            if(password.length == 0){
                $("#errors").text("Enter a valid password");
                $("#errors").show();
                return;
            }
        }

    });
});