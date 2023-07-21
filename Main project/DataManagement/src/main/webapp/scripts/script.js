$(document).ready(function (){
	
    $("#LoginValidation").on("click",function(){
        $.ajax({
            url : "../LoginValidation",
            type : "POST",
            data : {
                "username" : $('#Username').val() ,
                "password" : $('#Password').val()
            },
            success : function(event){
                if(event == "Correct Details"){
                    alert("Logged in");
                    window.location.href = "Datadisplay.html";

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
    	
    $("#AdminLoginServlet").on("click",function(){
        $.ajax({
            url : "../AdminLoginServlet",
            type : "POST",
            data : {
                "username" : $('#Username').val() ,
                "password" : $('#Password').val()
            },
            success : function(event){
                if(event == "Correct Details"){
                    alert("Logged in");
                    window.location.href = "Datadisplay.html";

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