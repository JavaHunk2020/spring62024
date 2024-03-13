<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello</title>

 <script>
 
     function omega(){
    	 function owp(){
    	 }
     }
 
     //ANONYMOUS FUNCTION  
	 let oww=function(num) {
	 	let sum=1;
	 	for(let x=2;x<=num;x++){
	 		sum=sum*x;
	 	}
	 	return sum;
	 }
	 console.log(oww); //printing the definition of the function 
	 console.log(oww(4)); // calling  the function
	 
	 //ARROW FUNCTION
	 let owwx=(num) => {
		 	let sum=1;
		 	for(let x=2;x<=num;x++){
		 		sum=sum*x;
		 	}
		 	return sum;
		 }
	 
	 console.log(owwx); //printing the definition of the function 
	 console.log(owwx(5)); // calling  the function
	
  
	//NORMAL FUNCTION OR NAMED FUNCTION
    function fact(num) {
    	let sum=1;
    	for(let x=2;x<=num;x++){
    		sum=sum*x;
    	}
    	return sum;
    }
   
    gk =100;
    var pk =103;
    let po= 101;
    const cps=102;
   // cps=cps+1;
    console.log("Ahahah");
    console.log("Ahahah");
    console.warn(window.gk);
    let result=fact(3);
    console.log(result);
   // console.warn(window.po);
 </script>

</head>
<body>

</body>
</html>