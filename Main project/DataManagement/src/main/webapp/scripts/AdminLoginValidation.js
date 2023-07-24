$(document).ready(function (){
    $("#errors").hide();
    $("#AdminLoginServlet").on("click",function(){
        var userName = $('#Username').val();
        var password = $('#Password').val();
        if(userName.length != 0 && password.length != 0){
            $.ajax({
                url : "../AdminLoginServlet",
                type : "POST",
                data : {
                    "username" : userName ,
                    "password" : password
                },
                success : function(event){
                    var data = JSON.parse(event);
                    if(data["username"] === "true" && data["password"] === "true"){
                        $("#errors").hide();
                        window.location.href = "DA"
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
                        alert("user does not exist");
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