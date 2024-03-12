<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
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
   <img src="https://cdn-icons-png.freepik.com/512/9385/9385656.png" style="height: 166px;"/>
   <img src="https://cdn-icons-png.freepik.com/512/9385/9385656.png" style="height: 166px;"/>
    <br/>
    <span style="color:red;font-size: 18px;font-weight: bold;">${message} ${param.username}</span>
    <c:if test="${empty param.username}">
    <form action="forgetPassword" method="post">
        <div class="form-group">
        <label>Username/Email :</label> 
        <input type="text" name="username" class="form-control" style="width: 40%">
        </div>
         <div class="form-group" style="margin-top: 10px;">
          <button type="submit" class="btn btn-primary">Send Link</button>
             
        </div>
    </form>
    </c:if>
     <hr/>
     <a href="auth">
             <button type="button" class="btn btn-warning">Back</button>
             </a>
     
    </div>

</body>
</html>
