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
   <img src="imglogin.png" style="height: 166px;"/>
   <img src="imglogin.png" style="height: 166px;"/>
   <img src="imglogin.png" style="height: 166px;"/>
    <br/>
    <span style="color:red;font-size: 18px;font-weight: bold;">${message}</span>
    <form action="auth" method="post">
        <div class="form-group">
        <label>Username :</label> 
        <input onkeypress="clearMessage();" type="text" id="username" name="username" class="form-control" style="width: 40%">
        <span id="usernameErrorMessage" style="color:red;font-size: 18px;">
        </span>
        </div>
        
        <div class="form-group">
        <label>Password :</label> 
        <input onkeypress="clearMessage();" type="password" id="password" name="password" class="form-control" style="width: 40%">
        
        <span id="passwordErrorMessage" style="color:red;font-size: 18px;">
        </span>
        </div>
     <div class="form-group" style="margin-top: 10px;">
          <button type="button" class="btn btn-primary" onclick="validate();">Signin</button>
           <button type="reset" class="btn btn-warning">Clear</button>
              <a href="signup">
             <button type="button" class="btn btn-success">Signup</button>
             </a>
             
              <a href="forgetPassword">
             <button type="button" class="btn btn-warning">Forget Password</button>
             </a>
        </div>
    </form> 
     
 
</div>

<script type="text/javascript">
       function validate(){
    	    let usernameObj=document.getElementById("username");
    	    let uname=usernameObj.value;
    	    if(uname.length==0){
    	    	document.getElementById("usernameErrorMessage").innerHTML="Username cannot be blank";
    	    	usernameObj.focus();
    	    	return;
    	    }
    	    
    	    let passwordObj=document.getElementById("password");
    	    let password=passwordObj.value;
    	    if(password.length==0){
    	    	document.getElementById("passwordErrorMessage").innerHTML="Password cannot be blank";
    	    	passwordObj.focus();
    	    	return;
    	    }
    	    
    	    //Submitting form through JavaScript
    	    document.forms[0].submit();
    	    
       }
       function clearMessage(){
    	   document.getElementById("usernameErrorMessage").innerHTML="";
    	   document.getElementById("passwordErrorMessage").innerHTML="";
       }
</script>
</body>
</html>
