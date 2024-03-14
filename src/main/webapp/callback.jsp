<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
    
    let pd = function(num) {
    	         return 2*num*num;
             }
  
    let pda1 = (num) => {
        return 2*num*num;
    }
    let pda2 = (num)=>2*num*num;
    let pda3 = num=>2*num*num;
    
    let result=topFunction(1,function(num) {
                                let innerResult= 2*num*num;
                                return  innerResult;
                            });
    console.log(result);
    
    result=topFunction(2,num=>2*num*num);
    console.log(result);
    
    function topFunction(top , callback){
    	if(top==1){
    		return callback(4);
    	}
    	else if(top==2){
    		return callback(5);
    	}
    	return -1;
    }
</script>
</head>
<body>

</body>
</html>