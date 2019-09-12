/**
 * 
 */

var dailyInINR;
var monthlyInINR;
var yearlyInINR;
var dailyPrice;
var monthlyPrice;
var yearlyPrice;
var priceInINRDaily;
var priceInINRMonthly;
var priceInINRYearly;
var priceInINR;

/* set table values with specific prices according to vehicle type */
function registerVehicle(type) {
	
	if (type == "Cycle") { 
    	
    	table.rows[1].cells[1].innerHTML = 5;
        dailyInINR = 5;
        document.getElementById("MonthlyPrice").innerHTML = 100;
        monthlyInINR = 100;
        document.getElementById("YearlyPrice").innerHTML = 500;
        yearlyInINR = 500;
    } 
    
    if (type == "MotorCycle") {
        document.getElementById("DailyPrice").innerHTML = 10;
        dailyInINR = 10;
        document.getElementById("MonthlyPrice").innerHTML = 200;
        monthlyInINR = 200;
        document.getElementById("YearlyPrice").innerHTML = 1000;
        yearlyInINR = 1000;
    }
    if (type == "Four Wheelers") {
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
}
function changeCurrency(priceType) {
    if (priceType == "USD") {
    	//document.write(dailyInINR);
        document.getElementById("DailyPrice").innerHTML = 0.014 * dailyInINR;
        dailyPrice = 0.014 * dailyInINR;
        priceInINRDaily = dailyInINR;
        document.getElementById("MonthlyPrice").innerHTML = 0.014 * monthlyInINR;
        monthlyPrice = 0.014 * monthlyInINR;
        priceInINRMonthly = monthlyInINR;
        document.getElementById("YearlyPrice").innerHTML = 0.014 * yearlyInINR;
        yearlyPrice = 0.014 * yearlyInINR;
        priceInINRYearly = yearlyInINR;
    }
    if (priceType == "YEN") {
        document.getElementById("DailyPrice").innerHTML = 1.47 * dailyInINR;
        dailyPrice = 1.47 * dailyInINR;
        priceInINRDaily = dailyInINR;
        document.getElementById("MonthlyPrice").innerHTML = 1.47 * monthlyInINR;
        monthlyPrice = 1.47 * monthlyInINR;
        priceInINRMonthly = monthlyInINR;
        document.getElementById("YearlyPrice").innerHTML = 1.47 * yearlyInINR;
        yearlyPrice = 1.47 * yearlyInINR;
        priceInINRYearly = yearlyInINR;
        
    }
    if (priceType == "INR") {
        document.getElementById("DailyPrice").innerHTML = dailyInINR;
        dailyPrice = dailyInINR;
        priceInINRDaily = dailyInINR;
        document.getElementById("MonthlyPrice").innerHTML = monthlyInINR;
        monthlyPrice = monthlyInINR;
        priceInINRMonthly = monthlyInINR;
        document.getElementById("YearlyPrice").innerHTML = yearlyInINR;
        yearlyPrice = yearlyInINR;
        priceInINRYearly = yearlyInINR;
    }
}
var price; //final price to be shown
/* set final price according to plan selected */
function getPriceFunction(value) {
    if (value == "Daily") {
        price = dailyPrice;
        priceInINR = priceInINRDaily;
        //document.write(priceInINR);
    }
    if (value == "Monthly") {
        price = monthlyPrice;
        priceInINR = priceInINRMonthly;
    }
    if (value == "Yearly") {
        price = yearlyPrice;
        priceInINR = priceInINRYearly;
    }
}
function getPassFunction() {
	//document.write(priceInINR);
	document.getElementById("priceInINR").value = priceInINR;
	document.getElementById("price").value = price;
}
