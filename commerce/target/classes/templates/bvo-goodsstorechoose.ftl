<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">

        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="../css/font-awesome.min.css">
        <link rel="stylesheet" href="../css/ace.min.css">
        <link rel="stylesheet" href="../css/ace-skins.min.css">
        <link rel="stylesheet" href="../css/ace-responsive.min.css">

        <style type="text/css">
            body,html{
                width: 100%;
                height: 100%;
                background: #fff;
            }
            .shoplist{
                padding: 20px;
                border: 1px solid #ccc;
                border-radius: 10px;

            }
             .shoplist span{
                 font-size: 24px;
                 line-height: 40px !important;
             }
            .shoplist span:before{
                height: 20px !important;
                line-height: 20px !important;
                width: 20px ;
            }
            .upc{
                margin-top: 20px;
            }
			.form-control{
				margin-bottom: 0px !important;
				margin-left: 20px !important;
			}
	
        </style>
    </head>
    <body>
    <div id="main-content" class="clearfix">
          <div id="page-content" class="clearfix">

          	
              <h3 class="header smaller lighter blue">eBay</h3>
              <div class="controls shoplist ebay" >


				<#list ebaylist as estore>
                  	<label class="form-group">                		
                      	<input name="form-field-checkbox" value="${estore.store_id}" onclick="checkbox(${estore.store_id}),getCounts()" class="ace-checkbox-2" type="checkbox"/>
                      	<span class="lbl"> ${estore.store_name}</span>    
                      	<input class="form-control" id="gcounts${estore.store_id}" onchange="getCounts()" type="text" placeholder="请输入购买数量" style="display:none" />

 	        	
                  	</label>
                  </#list>
               

              </div>

              <h3 class="header smaller lighter blue">Amazon</h3>
              <div class="controls shoplist amazon" >

				  <#list amazonlist as astore>
                  	<label class="form-group">                		
                      	<input name="form-field-checkbox" value="${astore.store_id}" onclick="checkbox(${astore.store_id}),getCounts()" class="ace-checkbox-2" type="checkbox"/>
                      	<span class="lbl"> ${astore.store_name}</span>   
                      	<input class="form-control" id="gcounts${astore.store_id}" onchange="getCounts()"  type="text" placeholder="请输入购买数量" style="display:none"/>                	
                  	</label>
                  </#list>

              </div>
              <div class="controls upc hide">UPC: ${good.upc}</div>
              <div style="text-align: right;margin-top: 20px;"><button class="btn btn-primary" onclick="push()">Push</button></div>
        	
      			<input id="hiddenGid" type="hidden" value="${good.gid}"/>
          </div>
  </div>
    </body>
    
    
    <script src="../js/jquery-1.9.1.js"></script>


    <script>

      function push(){
        //alert("推送成功");
         
        var gid = $("#hiddenGid").val();
        
        var idsstr = "";
        var isc = "";
        $("#page-content input[type='checkbox']").each(function(){ //遍历全部checkbox
            idsstr += $(this).val() + ","; //获取所有checkbox的值
            if($(this).is(":checked"))   //如果被选中
                    isc += $(this).val() + ","; //获取被选中的值
            });
            if(idsstr.length > 0) //如果获取到
                idsstr = idsstr.substring(0, idsstr.length - 1); //把最后一个逗号去掉
            if(isc.length > 0) //如果获取到
                isc = isc.substring(0, isc.length - 1); //把最后一个逗号去掉
  		
          var value=getCounts();
          //alert(value);
                
          
            $.ajax({
                type: "POST",
                url: "/pushGoods",
                data: JSON.stringify({stores : isc , gid : gid, value : value}),                
                contentType : "application/json;charsetset=UTF-8",
                dataType: "text",
                success: function(data){
                 alert(data);
                }
            });
               


		
  		
      } 
      
      
      
      
      
      
      
      
      
      
      $(function () {
          var checkbox = $('.amazon input[type=checkbox]');
         checkbox.change(function () {
             if($(" .amazon input[type='checkbox']:checked").length>0){
                 $('.upc').show();
             }else{
                 $('.upc').hide();
             }
         })
      })
     
      
     function  checkbox(store_id){	//获得当前点击的checkbox的id

    	 if (document.getElementById("gcounts"+store_id).style.display == "none") {
			document.getElementById("gcounts"+store_id).style.display= "inline";  
    	 } else{
			document.getElementById("gcounts"+store_id).style.display= "none";
			document.getElementById("gcounts"+store_id).value="";
    	 }
      }

      
      
    
  	function getCounts(){ 
	  
	  
		var  cost = "0";
		var  value = parseInt(cost);
		$("#page-content input[type='text']").each(function(){

			
		
				if (this.style.display == "inline") {
		
				value = value + parseInt($(this).val());
	
			}
		});
		
		return value;
	 }
      
	 
    </script>
</html>
