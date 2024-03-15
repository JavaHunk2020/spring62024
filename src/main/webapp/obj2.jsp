<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
   function opex(){
	   alert("inside window1!!!");
   }
   email="nk@gmail.com";
   var pk=100;
   console.log(pk)
   console.log(window.pk)
   let pk1 = {};
   console.log(pk1); //Object
   pk1.apple="Nagendra";
   pk1.email="nagendra.kumar@gmail.com";
   pk1.mango="Mr.";
   
   pk1.showData = function() {
	   console.log(this.apple);  
	   console.log(this.email);
	   console.log(this.mango);
	   console.log(this.india); //undefined  
   };
   console.log("-----------1----------");
   pk1.showData();
   
   pk1.pkShowData = function() {
	   console.log(email);// ReferenceError ->> 
	   console.log(mango);
	   console.log(tindia);
   };
  
   console.log("----------2-----------");
   pk1.pkShowData();
   //window - title , name, ptitle
   pk1.arrowShowData = () => {
	   console.log(this.mango); // this will point to window object or outer function
	   console.log(this.apple);  
	   console.log(this.email);
   };
   console.log("----------3-----------");
   pk1.arrowShowData();
   
   
</script>
</head>
<body>
  <h1>JAVASCRIPT IS WORKING</h1>
</body>
</html>