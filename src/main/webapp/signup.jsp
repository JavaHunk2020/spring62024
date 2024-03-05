<!DOCTYPE html>
<html lang="en">
<head>
  <title>Signup</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<header style="height: 30px;background-color: yellow;">
</header>
  
<div class="container mt-5">
   <img src="https://tse3.mm.bing.net/th?id=OIP.Oe7l4Ac1_-0CbDh7H5Ca8AHaHa&pid=Api&P=0&h=180" style="height: 166px;"/>
   <img src="https://tse3.mm.bing.net/th?id=OIP.Oe7l4Ac1_-0CbDh7H5Ca8AHaHa&pid=Api&P=0&h=180" style="height: 166px;"/>
   <img src="https://tse3.mm.bing.net/th?id=OIP.Oe7l4Ac1_-0CbDh7H5Ca8AHaHa&pid=Api&P=0&h=180" style="height: 166px;"/>
    <br/>
    <span style="color:red;font-size: 18px;font-weight: bold;">${message}</span>
    <form action="signup" method="post">
        <div class="form-group">
        <label>Username :</label> 
        <input type="text" name="username" class="form-control" style="width: 40%">
        </div>
        
        <div class="form-group">
        <label>Password :</label> 
        <input type="password" name="password" class="form-control" style="width: 40%">
        </div>
        
         <div class="form-group">
        <label>Email :</label> 
        <input type="email" name="email" class="form-control" style="width: 40%">
        </div>
         <div class="form-group">
        <label>Gender :</label> 
        <select  name="gender" class="form-control" style="width: 40%">
             <option>Male</option>
             <option>Female</option>
        </select>
        </div>
        
        
     <div class="form-group" style="margin-top: 10px;">
          <button type="submit" class="btn btn-primary">Signup</button>
           <button type="reset" class="btn btn-warning">Clear</button>
            <a href="auth">
             <button type="button" class="btn btn-success">Sign In</button>
             </a>
        </div>
    </form> 
     
 
</div>

</body>
</html>
