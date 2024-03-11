<!DOCTYPE html>
<%@page import="com.vistal.tech.dto.SignupDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
   
   <a href="logout"> 
       <button type="button" class="btn btn-primary">Logout</button>
   </a>
   <br/>
    <b> Username :  ${sessionScope.ssignup.username}</b>
     <br/> 
    <b> Email :  ${ssignup.email}</b>
    <br/> 
    <b>Gender :  ${ssignup.gender}</b> 
   <hr/>
    <table class="table table-bordered">
    <thead>
      <tr>
        <th>Username
           <a href="sortByAttribute?orderBy=asc&attributeName=username">
             <button type="reset" class="btn btn-success">A</button>
           </a>
            <a href="sortByAttribute?orderBy=desc&attributeName=username">
             <button type="reset" class="btn btn-warning">D</button>
             </a>
        
        </th>
        <th>Password</th>
        <th>Email
        <a href="sortByAttribute?orderBy=asc&attributeName=email">
             <button type="reset" class="btn btn-success">A</button>
           </a>
            <a href="sortByAttribute?orderBy=desc&attributeName=email">
             <button type="reset" class="btn btn-warning">D</button>
             </a>
        </th>
           <th>Gender</th>
           <th>Action</th>
      </tr>
    </thead>
    <tbody>
  <%  
  List<SignupDTO> signups=(List<SignupDTO>)request.getAttribute("signups");
  if(signups==null){
	  signups =new ArrayList<>();
  }
      for(SignupDTO signup : signups){
    	 %>
      <tr>
        <td><%=signup.getUsername()%></td>
        <td><%=signup.getPassword()%></td>
        <td><%=signup.getEmail()%></td>
         <td><%=signup.getGender()%></td>
           <th>  
           <a href="deleteSignup?uname=<%=signup.getUsername()%>">
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
