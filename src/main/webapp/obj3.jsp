<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
   let pk1 = {};
   pk1.name="Nagendra";
   pk1.email="nagendra.kumar@gmail.com";
   pk1.title="Mr.";
   console.log(pk1);
   
   let pk2 = {"name":"Nagendra",email:"nagendra.kumar@gmail.com",title:"Mr.",102:"ole@ew"};
   console.log(pk2);
   console.log(pk2.name);
   console.log(pk2['name']);
   //console.log(pk2.102);
   console.log(pk2['102']);
   
   function Customer(name,email,title) {
	   this.name=name;
	   this.email=email;
	   this.title=title;
	   this.mocha=function() {
		   console.log(this.name);
		   console.log(this.email);
		   console.log(this.title);
		   console.log(this.pk);
	   }
	   
	   this.gk= function() {
		   console.log(name);
		   console.log(email);
		   console.log(title);
		  // console.log(pk);
	   }
   }
   
   //Here we calling it as normal function = >>> window.Customer();
  // window.Customer();
   //Customer();
   //function constructor
   let pk3=new Customer('Jhon','john@gmail.com','Miss');
   pk3.mocha();
   pk3.gk();
   //let pk4=new Customer('Omega','omega@gmail.com','Mr');
   
   
</script>
</head>
<body>

</body>
</html>