
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Register</title>
</head>

<body>

   
   
   
<h1>Patient Appointment Registration Form</h1>
<form name = "myForm" action="myservlet" method="post" >
patient name: <input name="pname" type = "text"/><br>
patient age: <input name="age" type = "text" required><br>
date of appointment: <input name = "date" type = "date" required><br>
select a timeslot: 
<br>
<%= session.getAttribute("noslot") %>
<input type="radio" name="timeslot" value = 1> 10:00am to 11:00am<br>
<input type="radio" name="timeslot" value = 2> 11:00am to 12:00pm<br>
<input type="radio" name="timeslot" value = 3> 2:00pm to 3:00pm<br>
<input type="radio" name="timeslot" value = 4>3:00pm to 4:00pm<br>
  
</form>
<script src="myjs.js"></script>
</body>
</html>