$(document).ready(function() {
    $(".errors").hide();
    $("#buttonForRegistration").click(function(e) {
        e.preventDefault(); // Prevent form submission before validation
        $(".errors").hide();

        // Variables to store validation status
        let isNameValid = validateName();
        let isEmailValid = validateEmail();
        let isDateOfBirthValid = validateDateOfBirth();
        let isPersonAgeValid = validatePersonAge();
        let isPhoneNumberValid = validatePhoneNumber();
        let isUsernameValid = validateUsername();
        let isPasswordValid = validatePassword();
        let isConfirmPasswordValid = validateConfirmPassword();

        // Check each validation status
        if (!isNameValid) {
            $("#namecheck").show();
            return;
        }
        if (!isEmailValid) {
            $("#emailcheck").show();
            return;
        }
        if (!isDateOfBirthValid) {
            $("#dateOfBirthcheck").show();
            return;
        }
        if (!isPersonAgeValid) {
            $("#personAgecheck").show();
            return;
        }
        if (!isPhoneNumberValid) {
            $("#phoneNumnercheck").show();
            return;
        }
        if (!isUsernameValid) {
            $("#userNamecheck").show();
            return;
        }
        if (!isPasswordValid) {
            $("#passWordcheck").show();
            return;
        }
        if (!isConfirmPasswordValid) {
            $("#confirmPasswordcheck").show();
            return;
        }
        if( isNameValid && isEmailValid && isDateOfBirthValid && isPersonAgeValid && isPhoneNumberValid && isUsernameValid && isPasswordValid && isConfirmPasswordValid){
            $.ajax({
                url : "views/userRegistrationData",
                type : "POST",
                data : {
                   "name" : $("#name").val().trim(),
                    "email" : $("#email").val().trim(),
                    "DOB" : $("#dateOfBirth").val().trim(),
                    "Age" : $("#personAge").val().trim(),
                    "PhNo" : $("#phoneNumner").val().trim(),
                    "username" : $("#userName").val().trim(),
                    "password" : $("#passWord").val().trim()
                },
                success : function(event){
                    alert("data passed" + event);
                },
                error : function(error){
                    alert("error")
                }
            });
        }
        // If all validations pass, you can proceed with form submission
    });

    function validateName() {
        let nameValue = $("#name").val().trim();
        return nameValue !== "" && nameValue !== null && nameValue !== undefined;
    }

    function validateEmail() {
        let emailValue = $("#email").val().trim();
        if (emailValue === "" || emailValue === null || emailValue === undefined) {
            return false;
        }
        let regex = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
        return regex.test(emailValue);
    }

    function validateDateOfBirth() {
        let dobValue = $("#dateOfBirth").val().trim();
        return dobValue !== "" && dobValue !== null && dobValue !== undefined;
    }

    function validatePersonAge() {
        let ageValue = $("#personAge").val().trim();
        return ageValue !== "" && ageValue !== null && ageValue !== undefined;
    }

    function validatePhoneNumber() {
        let phoneNumberValue = $("#phoneNumner").val().trim();
        return phoneNumberValue !== "" && phoneNumberValue !== null && phoneNumberValue !== undefined;
    }

    function validateUsername() {
        let usernameValue = $("#userName").val().trim();
        return (
            usernameValue !== "" &&
            usernameValue !== null &&
            usernameValue !== undefined &&
            usernameValue.length >= 8 &&
            usernameValue.length <= 25
        );
    }

    function validatePassword() {
        let passwordValue = $("#passWord").val().trim();
        return (
            passwordValue !== "" &&
            passwordValue !== null &&
            passwordValue !== undefined &&
            passwordValue.length >= 8 &&
            passwordValue.length <= 25
        );
    }

    function validateConfirmPassword() {
        let confirmPasswordValue = $("#confirmPassword").val().trim();
        let passwordValue = $("#passWord").val().trim();
        return confirmPasswordValue === passwordValue;
    }
});
