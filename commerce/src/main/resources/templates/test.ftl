<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ftl</title>
</head>
<body>
     ${content}
     
     
     
     var data = {
					"gid" : $("#gid").val()
				}
    		
  				$.ajax({
    				url: "/getGood",
    				type: "POST",
    				data: JSON.stringify(data),
    				cache:false,
    				dataType: "json",
    				success: function(data){
    				},
    				error:function(err){
    				}
  				});
			}
    
    
    $(function () {

		var text = $("#page-content input[type='text']");
		var gcounts = $("#page-content input[type='checkbox']");

		
		gcounts.each(function(){	
			
			var flag = 1;	
			text.hide();
			$(this).click(function () {
				if(flag==1){
					text.show();  //要拿到当前选取的checkbox对应的text
        	  		flag=0;
        	  
				}else{
        	  
					text.hide();
        	  		flag=1;
				}
			})       	  
		}) 
    	}) 
    
     
    
     
     
     
     onmouseout="getCounts(${astore.store_id})"
     
     
     
     $("#page-content input[type='text']").each( function(){
        	   $(this).getCounts(store_id){   
           
        	   		if (document.getElementById("gcounts"+store_id).style.display == "inline") {
        		   		var  cost = 0;
        		   		cost = cost + document.getElementById("gcounts"+store_id).value;
        	   		}
        		
        	   }
        	   
           })
           alert(cost); 
     
     
</body>
</html>