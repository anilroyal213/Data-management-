$(document).ready(function (){
	
    $("#submitButton").on("click",function(){
        $.ajax({
            url : "http://localhost:8080/DataManagement/LoginValidation",
            type : "POST",
            data : {
                "username" : $('#Username').val() ,
                "password" : $('#Password').val()
            },
            success : function(event){
                if(event == "Correct Details"){
                    alert("Logged in");
                    window.location.href = "/welcome.html";

                }
                else if(event == "Password Wrong"){
                    alert("Password Wrong")
                }
                else{
                    alert("Username and password both are wrong");
                }
            },
            error : function(err){
                alert("error");
            }
        })
    });
});