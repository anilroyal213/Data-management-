$(document).ready(function (){
    $.ajax({
        url : "../SessionData",
        type : "GET",
        success : function(event){
            var data = JSON.parse(event);
            if(data["redirect"] === "true"){
                window.location.href = "User_Login_page.html"
            }
            else{
                $('#usernameDisplay').append("Hello "+data["name"] + " !");
            }
        },
        error : function(error){
            alert("error");
        }
    })
    $("#uploadData").on("click",function(){
        window.location.href = "UploadingData.html";
    });
    $("#viewUploadedData").on("click",function(){
        // $("#pageContentsContainer").hide();
        $.ajax({
            url : "../ViewUploadedData",
            type : "GET",
            success : function(response){
                $("#pageContentsView").text(response);
            },
            error : function(){
                $("#pageContentsView").text("error");
            }
        })

    });
    $("#viewHistory").on("click",function(){
        // $("#pageContentsContainer").hide();
        $.ajax({
            url : "../ViewHistory",
            type : "GET",
            success : function(response){
                $("#pageContentsView").text(response);
            },
            error : function(){
                $("#pageContentsView").text("error");
            }
        })

    });
});