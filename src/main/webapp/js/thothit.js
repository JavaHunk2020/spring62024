//undefined is type which take only undefined
     var oepe=12;
     oepe="India";
     
     let pk1;
     let pk2 = undefined;
     
     if(pk1==pk2){
    	 console.log(pk1==pk2);
     }
     
     if(pk2 == undefined){
    	 console.log(typeof pk2);
     }
     
     let pk=null;
     if(pk===pk2){
    	 console.log(pk===pk2+"=============");
     }else{
    	 console.log("############################");
     }
     let imgObj=document.getElementById("imageId");
     imgObj.src="https://cdn-icons-png.freepik.com/512/9385/9385656.png";
     console.log(imgObj);
     
     imgObj.onclick= function() {
    	 alert("Do not click on me!!!!!!!!!");
    	 let textName=document.getElementById("pname");
    	 textName.style.backgroundColor  = "yellow";
    	 
    	 let divObj=document.getElementById("pkt");
    	 divObj.style.backgroundColor  = "black";
    	 
     }