<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pass Detail Page</title>
<style>
#add_vehicle {
	visibility: hidden;
}
</style>
<script>
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
</script>
</head>
<body align = "center">
<div id="divForPass">
        <h2>Select your plan </h2>
        <br><br>
        <form name="PassForm" action = "PassDetailServlet" method="GET">
        <input type="button" value="Click here to Get Price Details" id="getPrice" onclick="registerVehicle('<%= request.getAttribute("typeOfVehicle") %>')" />
        
        
        <br><br>
        <!-- <script> registerVehicle(<%= request.getAttribute("typeOfVehicle") %>) </script> -->
        <table border="5px" align="center" id="table">
            <tr>
                <th>Plan</th>
                <th>Price in INR</th>
            </tr>
            <tr>
                <td>Daily</td>
                <td id="DailyPrice"></td>
            </tr>
            <tr>
                <td>Monthly</td>
                <td id="MonthlyPrice"></td>
            </tr>
            <tr>
                <td>Yearly</td>
                <td id="YearlyPrice"></td>
            </tr>
        </table><br><br>
        <select id="priceType" onchange="changeCurrency(priceType.value)">
            <option disabled selected>--Choose desired currency--</option>
            <option>INR</option>
            <option>USD</option>
            <option>YEN</option>
            </option>
        </select>
        <br>
        <br>
        <label><input type="radio" id="pricePlan" name="pricePlan" value="Daily"
                onchange="getPriceFunction(this.value)">Daily</label>
        <label><input type="radio" id="pricePlan" name="pricePlan" value="Monthly"
                onchange="getPriceFunction(this.value)">Monthly</label>
        <label><input type="radio" id="pricePlan" name="pricePlan" value="Yearly"
                onchange="getPriceFunction(this.value)">Yearly</label>
        <br>
        <br>
        <input type="button" value="getPass" id="getPass" onclick="getPassFunction()">
       	<br><br>
        <label>Your price is</label> 
        <input type="text"  name="price" id="price" size="5%">
        <input type="text"  name="priceInINR" id="priceInINR" style="visibility: hidden;">
         <input type="text"  name="regId" id="regId" value="<%= request.getAttribute("emp_Id") %>" style="visibility: hidden;">
        <!-- <table><tr>
        <td name="price" id="priceFinal"></td>
        </tr></table> -->
		<br><br>
       <input type="submit" value="submit" id="submit" >
       
       </form>

</body>
</html>