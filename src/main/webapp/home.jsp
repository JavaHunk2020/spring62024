<!DOCTYPE html>
<%@page import="com.vistal.tech.DataStore"%>
<%@page import="com.vistal.tech.SignupDTO"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Map"%>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<header style="height: 30px;background-color: yellow;">
</header>
  
<div class="container mt-5">
   <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1GtS6rw7uVqzApVGZfwED3c0Tc-w23xDMiQ&usqp=CAU" style="height: 166px;"/>
   <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1GtS6rw7uVqzApVGZfwED3c0Tc-w23xDMiQ&usqp=CAU" style="height: 166px;"/>
   <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1GtS6rw7uVqzApVGZfwED3c0Tc-w23xDMiQ&usqp=CAU" style="height: 166px;"/>
    <br/>
    
    <h1>WECLOME TO MY HOME!!!!!!!!!!!!!!!!!</h1>
    <h1>HOME TO HOME</h1>
    <a href="auth"> 
       <button type="button" class="btn btn-primary">Login</button>
   </a>
   <br/>
    <b> Hello !!!!!! ${param.username}</b> 
   <hr/>
    <table class="table table-bordered">
    <thead>
      <tr>
        <th>Username</th>
        <th>Password</th>
        <th>Email</th>
           <th>Gender</th>
           <th>Action</th>
      </tr>
    </thead>
    <tbody>
  <%  
  Map<String,SignupDTO> mapData=DataStore.getMap();
      for(Entry<String,SignupDTO> entry : mapData.entrySet()){
    	 %>
      <tr>
        <td><%=entry.getValue().getUsername()%></td>
        <td><%=entry.getValue().getPassword()%></td>
        <td><%=entry.getValue().getEmail()%></td>
         <td><%=entry.getValue().getGender()%></td>
           <th>  
           <a href="deleteSignup?uname=<%=entry.getValue().getUsername()%>">
           <button type="reset" class="btn btn-danger">Delete</button>
           </a>
           </th>
      </tr>
      <%
      } %>
    
     
    </tbody>
  </table>
</div>

</body>
</html>
