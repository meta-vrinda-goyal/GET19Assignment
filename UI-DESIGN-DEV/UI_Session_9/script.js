var input, flag = true;
function validate(fullName) {
    // let fullName = (<HTMLInputElement>document.getElementById("full_name")).value;
    var validFullName = /^[A-Z a-z]+$/;
    var min = 2;
    //check full name if it's length is less than 2 or contains non numeric
    if ((fullName.length < min)) {
        document.getElementById("error").style.display = "block";
        document.getElementById("error").innerHTML = "Name should be of minimum 2 characters!!";
        flag = false;
        return false;
    }
    if (!(fullName.match(validFullName))) {
        document.getElementById("error").style.display = "block";
        document.getElementById("error").innerHTML = "Name should be only alphabetic!!";
        flag = false;
        return false;
    }
    // else {
    return true;
    // }
}
function validateName() {
    input = document.getElementById("full_name");
    input.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            var fullName = document.getElementById("full_name").value;
            if (validate(fullName)) {
                document.getElementById("error").style.display = "none";
                document.getElementById("gender-div").style.display = "block";
                document.getElementById("welcome-heading").innerHTML = "Welcome " + document.getElementById("full_name").value;
                document.getElementById("label").innerHTML = "Please select your gender";
                document.getElementById("full_name").style.display = "none";
            }
        }
    });
}
var i;
for (i = 1; i <= 2; i++) {
    input = document.getElementsByTagName("label")[i];
    input.addEventListener("click", function (event) {
        document.getElementById("email").style.display = "block";
        document.getElementById("welcome-heading").style.display = "none";
        document.getElementById("label").innerHTML = "Please enter your email";
        document.getElementById("gender-div").style.display = "none";
    });
}
function validateEmail() {
    input = document.getElementById("email");
    var email = document.getElementById("email").value;
    var atposition = email.indexOf("@");
    var dotposition = email.lastIndexOf(".");
    //check email if @ is at first position or dot is just after @ or dot does not has 2 or more succeding characters
    if (atposition < 1 || dotposition < atposition + 2 || dotposition + 2 >= email.length) {
        document.getElementById("error").style.display = "block";
        document.getElementById("error").innerHTML = "Please enter a valid e-mail address";
        return false;
    }
    else {
        document.getElementById("error").style.display = "none";
        input.addEventListener("keyup", function (event) {
            if (event.keyCode === 13) {
                document.getElementById("password").style.display = "block";
                document.getElementById("confirm_password").style.display = "block";
                document.getElementById("label").innerHTML = "Please enter your password";
                document.getElementById("email").style.display = "none";
            }
        });
    }
}
function passwordStrength(pass) {
    var validPassword = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
    if (pass.length < 8) {
        // document.getElementById("password").style.border = "block";
        document.getElementById("password").style.border = "blockthick solid #0000FF";
        document.getElementById("password").style.borderColor = "red";
    }
    else if (!(pass.match(validPassword))) {
        document.getElementById("password").style.borderColor = "orange";
    }
    else if ((pass.match(validPassword))) {
        document.getElementById("password").style.borderColor = "green";
    }
    if (!(pass.match(validPassword))) {
        document.getElementById("error").style.display = "block";
        document.getElementById("error").innerHTML = "Password should contain 1 capital letter and should be alphanumeric!!";
        return false;
    }
}
function validatePassword() {
    var validPassword = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
    input = document.getElementById("confirm_password");
    var confirm_password = document.getElementById("confirm_password").value;
    var password = document.getElementById("password").value;
    //check if password meets condition
    //check if password and confirm password are equal
    if (password != confirm_password) {
        document.getElementById("error").style.display = "none";
        document.getElementById("error").style.display = "block";
        document.getElementById("error").innerHTML = "passwords do not match!!";
        return false;
    }
    else {
        document.getElementById("error").style.display = "none";
        input.addEventListener("keyup", function (event) {
            if (event.keyCode === 13) {
                document.getElementById("contact").style.display = "block";
                document.getElementById("label").innerHTML = "Please enter your contact number";
                document.getElementById("password").style.display = "none";
                document.getElementById("confirm_password").style.display = "none";
            }
        });
    }
}
function validateContact() {
    input = document.getElementById("contact");
    var contact = document.getElementById("contact").value;
    //check if contact is numeric or not and length is smaller than 8 
    if (isNaN(Number(contact))) {
        document.getElementById("error").style.display = "block";
        document.getElementById("error").innerHTML = "Contact should be numeric";
        return false;
    }
    if (contact.length < 9) {
        document.getElementById("error").style.display = "block";
        document.getElementById("error").innerHTML = "Contact should be of length 8 or more";
        return false;
    }
    else {
        document.getElementById("error").style.display = "none";
        input.addEventListener("keyup", function (event) {
            if (event.keyCode === 13) {
                document.getElementById("organization").style.display = "block";
                document.getElementById("submit-organization").style.display = "block";
                document.getElementById("label").innerHTML = "Please select your organization";
                document.getElementById("contact").style.display = "none";
            }
        });
    }
}
for (i = 6; i < 10; i++) {
    document.getElementsByClassName("form-control")[i].style.backgroundColor = "#C7EA46";
    document.getElementsByClassName("form-control")[i].style.borderColor = "green";
}
function submitOrganization() {
    var organization = document.getElementById("organization").value;
    if (organization.match("Select Organization")) {
        alert("Please select an organization");
    }
    else {
        document.getElementById("outer-div").style.backgroundColor = "#C7EA46";
        document.getElementById("welcome-heading").style.display = "block";
        document.getElementById("welcome-heading").innerHTML = "Congratulations you are successfully registered.<br> Your employee ID is " + 'E19/1221';
        document.getElementById("vehicle_name").style.display = "block";
        document.getElementById("label").innerHTML = "Please enter your vehicle name";
        document.getElementById("organization").style.display = "none";
        document.getElementById("submit-organization").style.display = "none";
    }
}
function validateVehicleName() {
    var vehicle_name = document.getElementById("vehicle_name").value;
    if (vehicle_name.length < 3) {
        document.getElementById("error").style.display = "block";
        document.getElementById("error").innerHTML = "Vehicle name should be greater than 3";
        return false;
    }
    else {
        input = document.getElementById("vehicle_name");
        input.addEventListener("keyup", function (event) {
            if (event.keyCode === 13) {
                document.getElementById("welcome-heading").style.display = "none";
                document.getElementById("typeOfVehicle").style.display = "block";
                document.getElementById("submit-vehicleType").style.display = "block";
                document.getElementById("label").innerHTML = "Please let us know the type of " + document.getElementById("vehicle_name").value;
                document.getElementById("vehicle_name").style.display = "none";
            }
        });
    }
}
function submitVehicleType() {
    var type = document.getElementById("typeOfVehicle").value;
    if (type.match('Select Type')) {
        alert("please select a vehicle type");
    }
    else {
        document.getElementById("welcome-heading").style.display = "none";
        document.getElementById("vehicleNumber").style.display = "block";
        document.getElementById("label").innerHTML = "Please enter your " + document.getElementById("typeOfVehicle").value + " number";
        document.getElementById("typeOfVehicle").style.display = "none";
        document.getElementById("submit-vehicleType").style.display = "none";
    }
}
function validateVehicleNumber() {
    var vehicleNumber = document.getElementById("vehicleNumber").value;
    if (vehicleNumber.length < 2 || vehicleNumber.length > 11) {
        document.getElementById("error").style.display = "block";
        document.getElementById("error").innerHTML = "Vehicle number should be of length 10 characters";
        return false;
    }
    else {
        document.getElementById("error").style.display = "none";
        input = document.getElementById("vehicleNumber");
        input.addEventListener("keyup", function (event) {
            if (event.keyCode === 13) {
                document.getElementById("vehicleIdentification").style.display = "block";
                document.getElementById("label").innerHTML = "Please describe your " + document.getElementById("vehicle_name").value;
                document.getElementById("vehicleNumber").style.display = "none";
            }
        });
    }
}
var j;
for (j = 10; j < 12; j++) {
    document.getElementsByClassName("form-control")[j].style.backgroundColor = "#5DB7E6";
    document.getElementsByClassName("form-control")[j].style.borderColor = "blue";
}
function addIdentification() {
    input = document.getElementById("vehicleIdentification");
    input.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            document.getElementById("outer-div").style.backgroundColor = "#5DB7E6";
            document.getElementById("welcome-heading").style.display = "block";
            document.getElementById("welcome-heading").innerHTML = "Congratulations your vehicle has been added successfully.";
            document.getElementById("label").innerHTML = "Please select your currency type ";
            document.getElementById("typeOfCurrency").style.display = "block";
            document.getElementById("submit-currencyType").style.display = "block";
            document.getElementById("vehicleIdentification").style.display = "none";
        }
    });
}
function submitCurrencyType() {
    var type = document.getElementById("typeOfCurrency").value;
    if (type.match('--Select-Type--')) {
        alert("please select a currency type");
    }
    else {
        document.getElementById("priceTable").style.display = "block";
        document.getElementById("submit-table").style.display = "block";
        var table = document.getElementById("priceTable");
        var vehicleType = document.getElementById("typeOfVehicle").value;
        switch (vehicleType) {
            case "Cycle":
                table.rows[1].cells[1].innerHTML = convertCurrency(5);
                table.rows[2].cells[1].innerHTML = convertCurrency(100);
                table.rows[3].cells[1].innerHTML = convertCurrency(500);
                break;
            case "MotorCycle":
                table.rows[1].cells[1].innerHTML = convertCurrency(10);
                table.rows[2].cells[1].innerHTML = convertCurrency(200);
                table.rows[3].cells[1].innerHTML = convertCurrency(1000);
                break;
            case "Four Wheelers":
                table.rows[1].cells[1].innerHTML = convertCurrency(20);
                table.rows[2].cells[1].innerHTML = convertCurrency(500);
                table.rows[3].cells[1].innerHTML = convertCurrency(3500);
                break;
        }
        function convertCurrency(INRPrice) {
            var currencyType = document.getElementById("typeOfCurrency").value;
            if (currencyType == "USD") {
                return (0.014 * INRPrice).toFixed(2);
            }
            else if (currencyType == "YEN") {
                return (1.47 * INRPrice).toFixed(2);
            }
            else {
                return INRPrice;
            }
        }
        document.getElementById("welcome-heading").style.display = "none";
        document.getElementById("typeOfCurrency").style.display = "none";
        document.getElementById("submit-currencyType").style.display = "none";
        document.getElementById("label").innerHTML = "Pricing details are as follows";
    }
}
function submitTable() {
    document.getElementById("priceTable").style.display = "none";
    document.getElementById("submit-table").style.display = "none";
    document.getElementById("submit-PlanType").style.display = "block";
    document.getElementById("planType").style.display = "block";
    document.getElementById("label").innerHTML = "Please select your plan type ";
}
function submitPlanType() {
    var type = document.getElementById("planType").value;
    if (type.match('--Select-Type--')) {
        alert("please select a plan");
    }
    else {
        document.getElementById("submit-PlanType").style.display = "none";
        document.getElementById("priceTable").style.display = "none";
        document.getElementById("planType").style.display = "none";
        document.getElementById("typeOfCurrency").style.display = "none";
        var table = document.getElementById("priceTable");
        var planType = document.getElementById("planType").value;
        switch (planType) {
            case "Daily":
                document.getElementById("label").innerHTML = "Your plan price is " + table.rows[1].cells[1].innerHTML + " " + document.getElementById("typeOfCurrency").value;
                break;
            case "Monthly":
                document.getElementById("label").innerHTML = "Your plan price is " + table.rows[2].cells[1].innerHTML + " " + document.getElementById("typeOfCurrency").value;
                break;
            case "Yearly":
                document.getElementById("label").innerHTML = "Your plan price is " + table.rows[3].cells[1].innerHTML + " " + document.getElementById("typeOfCurrency").value;
                break;
        }
    }
}
