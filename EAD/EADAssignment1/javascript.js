function registerEmployee() {

    var fullName = document.getElementById("full_name").value;
    var validFullName = /[A-Z a-z]+$/;
    var min = 2;
    //check full name if it's length is less than 2 or contains non numeric
    if ((fullName.length < min) || !(fullName.match(validFullName))) {
        alert("Length of name should be minimum 2 and should not be numeric");
        return false;
    }

    var email = document.registerForm.email.value;
    var atposition = email.indexOf("@");
    var dotposition = email.lastIndexOf(".");
    //check email if @ is at first position or dot is just after @ or dot does not has 2 or more succeding characters
    if (atposition < 1 || dotposition < atposition + 2 || dotposition + 2 >= email.length) {
        alert("Please enter a valid e-mail address");
        return false;
    }

    var contact = document.registerForm.contact.value;
    //check if contact is numeric or not and length is smaller than 8 
    if (isNaN(contact) || contact.length < 9) {
        alert("Not a valid number");
        return false;
    }

    var password = document.registerForm.password.value;
    var validPassword = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$/;
    //check if password meets condition
    if (!(password.match(validPassword))) {
        alert("Password!!");
        return false;
    }

    var password1 = document.registerForm.password.value;
    var confirm_password = document.registerForm.confirm_password.value;
    //check if password and confirm password are equal
    if (password1 != confirm_password) {
        alert("password do not match!");
        return false;
    }
    var elem = document.querySelector('#add_vehicle');
    elem.style.visibility = 'visible';
    var empId = 'E19/1230';
    var successfulReg = document.getElementById("employee_registration");
    document.getElementById("emp_Id").value = empId;
    successfulReg.innerHTML = "Congrats!! You are successfully registered. Your registration ID is" + " " + empId;
}

var dailyInINR;
var monthlyInINR;
var yearlyInINR;
var dailyPrice;
var monthlyPrice;
var yearlyPrice;
/* set table values with specific prices according to vehicle type */
function registerVehicle(type) {
    if (type == "cycle") {
        document.getElementById("DailyPrice").innerHTML = 5;
        dailyInINR = 5;
        document.getElementById("MonthlyPrice").innerHTML = 100;
        monthlyInINR = 100;
        document.getElementById("YearlyPrice").innerHTML = 500;
        yearlyInINR = 500;
    }
    if (type == "motorCycle") {
        document.getElementById("DailyPrice").innerHTML = 10;
        dailyInINR = 10;
        document.getElementById("MonthlyPrice").innerHTML = 200;
        monthlyInINR = 200;
        document.getElementById("YearlyPrice").innerHTML = 1000;
        yearlyInINR = 1000;
    }
    if (type == "fourWheeler") {
        document.getElementById("DailyPrice").innerHTML = 20;
        dailyInINR = 20;
        document.getElementById("MonthlyPrice").innerHTML = 500;
        monthlyInINR = 500;
        document.getElementById("YearlyPrice").innerHTML = 3500;
        yearlyInINR = 3500;
    }
    dailyPrice = dailyInINR;
    monthlyPrice = monthlyInINR;
    yearlyPrice = yearlyInINR;
    var elem = document.querySelector('#divForPass');
    elem.style.visibility = 'visible';
    document.getElementById("add_vehicle").innerHTML = "Your Vehicle has been added!!"
}
/* changes currency into selected currency */
function changeCurrency(priceType) {
    if (priceType == "USD") {
        document.getElementById("DailyPrice").innerHTML = 0.014 * dailyInINR;
        dailyPrice = 0.014 * dailyInINR;
        document.getElementById("MonthlyPrice").innerHTML = 0.014 * monthlyInINR;
        monthlyPrice = 0.014 * monthlyInINR;
        document.getElementById("YearlyPrice").innerHTML = 0.014 * yearlyInINR;
        yearlyPrice = 0.014 * yearlyInINR;
    }
    if (priceType == "YEN") {
        document.getElementById("DailyPrice").innerHTML = 1.47 * dailyInINR;
        dailyPrice = 1.47 * dailyInINR;
        document.getElementById("MonthlyPrice").innerHTML = 1.47 * monthlyInINR;
        monthlyPrice = 1.47 * monthlyInINR;
        document.getElementById("YearlyPrice").innerHTML = 1.47 * yearlyInINR;
        yearlyPrice = 1.47 * yearlyInINR;
    }
    if (priceType == "INR") {
        document.getElementById("DailyPrice").innerHTML = dailyInINR;
        dailyPrice = dailyInINR;
        document.getElementById("MonthlyPrice").innerHTML = monthlyInINR;
        monthlyPrice = monthlyInINR;
        document.getElementById("YearlyPrice").innerHTML = yearlyInINR;
        yearlyPrice = yearlyInINR;
    }
}
var price; //final price to be shown
/* set final price according to plan selected */
function getPriceFunction(value) {
    if (value == "Daily") {
        price = dailyPrice;
    }
    if (value == "Monthly") {
        price = monthlyPrice;
    }
    if (value == "Yearly") {
        price = yearlyPrice;
    }
}
function getPassFunction() {
    document.getElementById("divForPass").innerHTML = "Your pass price is " + price;
}