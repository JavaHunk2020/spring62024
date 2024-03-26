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
   console.log(pk2['102']);
  
 
   
</script>
</head>
<body>

</body>
</html>