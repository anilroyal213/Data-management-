$(document).ready(function(){
    $("form").on("submit",function(e){
        e.preventDefault();
        var myformData = new FormData(this);
        console.log($("#fileInput")[0].files[0])
        $.ajax({
            url : "../UploadData",
            type : "POST",
            processData: false,
            contentType: false,
            cache: false,
            data: myformData,
            enctype: 'multipart/form-data',
            success : function(response){
                alert("Response from server:" + response);
            },
            error : function(error){
                console.log(error);
                alert("Error:" + error);
            }
        });
    });
});