<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
    </head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/ace.min.css">
    <link rel="stylesheet" href="css/ace-skins.min.css">
    <link rel="stylesheet" href="css/ace-responsive.min.css">
    <link rel="stylesheet" href="webuploader/webuploader.css">


  <style>
    body,html{
      width: 100%;
      height: 100%;
      background: #fff;
    }

    .modal{
      width: 800px;
      margin-left: -400px;
    }
    .form-control {
    display: block;
    width: 50%;
    height: 35px;
    line-height: 35px;
    margin-bottom: 20px;
    padding: 6px 12px;
    font-size: 14px;
    color: #555;
    background-color: #fff;
    background-image: none;
    border: 1px solid #ccc;
    border-radius: 4px;
    -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
    -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
    -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
 .thumbnail {
    float: left;
    position: relative;
    margin: 0 20px 20px 0;
    width: 110px;
    height: 110px;
    padding: 4px;
  }
  .file-item .info {
    position: absolute;
    left: 4px;
    bottom: 4px;
    right: 4px;
    height: 20px;
    line-height: 20px;
    text-indent: 5px;
    background: rgba(0, 0, 0, 0.6);
    color: white;
    overflow: hidden;
    white-space: nowrap;
    text-overflow: ellipsis;
    font-size: 12px;
    z-index: 10;
}
#filePicker {
    display: inline-block;

    vertical-align: middle;
    margin: 0 12px 0 0;
}
.imgList{
  width: 30px;
  height: 30px;
}
  .red{
      width: 73%;
      margin: auto;
  }
  </style>
    <body>


    <div id="main-content" class="clearfix">
  <div id="page-content" class="clearfix">

    <div class="page-header position-relative">
      <h1 style="color: #2679b5;">品牌商 <small><i class="icon-double-angle-right"></i> 商品分类&主图</small></h1>
    </div>
      <form class="form-search" action="queryByGname" method="post" id="form-search">
          	商品标题：
          <input type="text" class="input-medium search-query" name="gname">
          <button onclick="search()" class="btn btn-purple btn-small">Search <i class="icon-search icon-on-right"></i></button>
      </form>
      <h4 style="color:red">${content}</h4><br>
      <table id="table_bug_report" class="table table-striped table-bordered table-hover">
      <thead>
        <tr>
          <th class="center">
            <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
          </th>
          <th>商品标题</th>
          <th>分类</th>
          <th class="hidden-480">主图</th>
          <th class="hidden-480">状态</th>
          <th>操作</th>
        </tr>
      </thead>

      <tbody>
		<#list gclist as good>
		
        <tr>
          <td class="center">
            <label><input type="checkbox" class="input"><span class="lbl"></span></label>
            <input type="hidden" name="gid" value="${good.gid}" id="gid">
          </td>
          
          <td>${good.gname}</td>
          <td>${good.category.gc_category}</td>
          <td class="hidden-480"><img src="/Path/${(good.category.gc_picture)!}" alt="" class="imgList"></td>
         
          <td class="hidden-480">
          <#if good.category.gc_status==1><span class="label label-sm label-warning">待入仓</span> 
			　　<#elseif  good.category.gc_status==2><span class="label label-success">入仓中</span> 
			　　<#elseif  good.category.gc_status==3><span class="label label-inverse arrowed-in">待上架</span> 
			　　<#elseif  good.category.gc_status==4><span class="label label-sm label-info arrowed arrowed-righ">上架中</span> 
			  <#elseif  good.category.gc_status==5><span class="label label-sm  arrowed arrowed-righ">下架中</span> 
			  </#if>
          </td>
          <td>
            <div class="inline position-relative" >           
              <button class="btn btn-mini btn-info update" data-toggle="modal" data-target="#myModal" ><i class="icon-edit"></i></button>
              <button class="btn btn-mini btn-danger"><i class="icon-trash"></i></button>
             	<input type="hidden" value="${good.category.gc_id}" id="gcid" name="gc_id">
              <#if good.category.gc_status==1><button class="btn btn-mini btn-success" onclick="updateStatus(${good.category.gc_id},${good.category.gc_status})">入仓</button> 
			  <#elseif   good.category.gc_status==2><button class="btn btn-mini btn-success" onclick="updateStatus(${good.category.gc_id},${good.category.gc_status})">入仓完成</button> 
			  <#elseif   good.category.gc_status==3><button class="btn btn-mini btn-success" onclick="updateStatus(${good.category.gc_id},${good.category.gc_status})">上架</button>
			  <#elseif   good.category.gc_status==4><button class="btn btn-mini btn-success"onclick="updateStatus(${good.category.gc_id},${good.category.gc_status})">下架</button>  
			  </#if>
            </div>
          </td>
          
        </tr>
        
		</#list>
      </tbody>
    </table>
    <button class="btn btn-primary" data-toggle="modal" data-target="#myModal">新增</button>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">商品信息</h4>
      </div>
      <div class="modal-body" >
          <form class="form-horizontal"  >

            <div class="control-group">
              <p class="red">商品标题准确、简洁、完整</p>
              <label class="control-label" for="form-field-1">商品标题</label>
              <div class="controls" id="uptitle">              
                <select id="form-field-select-1">               
					<#list title as t>
						<option value="${t.gid}">${t.gname}</option>    	           
					</#list>
                </select> 
                <input type="hidden" name="gid1" class="input1" id="gid1">
                <input type="hidden" name="gid1" class="input2" id="gcid1">
                <input style="display:none" name="gname" id="upgname" readonly unselectable="on">             
              </div>
            </div>
            <div class="control-group">
                <p class="red">请先选择GMC借卖平台商品大类，此分类决定了您的商品在借卖平台中展示的位置</p>
              <label class="control-label" for="form-field-1">商品分类</label>
              <div class="controls">
                <select id="form-field-select-2" multiple="multiple">
                  <option value="日用品">日用品</option>
                   <option value="电器类">电器类</option>
                   <option value="食品类">食品类</option>
                   <option value="文具办公类">文具办公类</option>
                   <option value="医疗用品类">医疗用品类</option>
                   <option value="美妆类">美妆类</option>
                </select>
              </div>
            </div>		
            <div class="control-group">
              <label class="control-label" for="form-field-1">商品主图</label>
              <form action="upload" method="post" enctype="multipart/form-data">
               <div class="controls">
			  <input type="file" name="file" id="file">
			  		  
			  </div>
             </form>
            </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default cancel" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary save" data-dismiss="modal">保存</button>
      </div>
      
    </div>
  </div>
</div>
  </div></div>

    <script src="js/jquery-1.9.1.js"></script>
    <script src="webuploader/webuploader.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootbox.min.js"></script>
   <script type="text/javascript">
  $(function(){
   

        $('.btn-danger').click(function(){
        	var gid=$(this).parents("tr").children("td").eq(0).find("input[type=hidden]").val();
      		var gcid=$(this).parents("tr").children("td").eq(5).find("input[type=hidden]").val();
      		//alert(gid+"gcid"+gcid);
      		 $.ajax({
                type:'post',
                contentType:'application/json;charset=utf-8',
                url:'${PageContext.request.contextPath}/delCate',
                data:'{"gid":"'+gid+'","gcid":"'+gcid+'"}',
                success:function (data) {       
                	bootbox.alert(data);
                	window.location.reload();   		 
                }
            })      
            
        })
        
       $('.save').click(function(){
       		var formData=new FormData();
			formData.append("file",$("#file")[0].files[0]);
       		if($("#form-field-select-1").css('display')=='none'){
       			var gid=document.getElementById('gid1').value;
       			var gname=document.getElementById('upgname').value;
       			var gcid=document.getElementById('gcid1').value;
       			formData.append("gcid",gcid);//也可以传递其他字段
				formData.append("gname",gname);				
       			//alert(gid+"gengxinde "+gname+"有"+gcid);       			
       		}
         	else{
    			var gid=$("#form-field-select-1").find("option:selected").val(); 			
        	}
        	var category=$("#form-field-select-2").find("option:selected").text();
        	//alert("youmeiyou"+gid+"分类是"+category);
			formData.append("gid",gid);//也可以传递其他字段
			formData.append("category",category);
			$.ajax({
			    type:"post",
			    url:"/uploadImage",
			    data:formData,
			    contentType: false,
			    processData: false,
			    success:function(date){		    	
			    	window.location.reload();
			    }
			    
			})
        	
        })
        
      	$('.update').click(function(){
      		var gname=$(this).parents("tr").children("td").eq(1).html();
      		var category=$(this).parents("tr").children("td").eq(2).html(); 
      		var gid=$(this).parents("tr").children("td").eq(0).find("input[type=hidden]").val();
      		var gcid=$(this).parents("tr").children("td").eq(5).find("input[type=hidden]").val();
      		//alert(gname+"fenlei"+category+gid+"gcid"+gcid);
      		$("#form-field-select-1").css('display','none');
        	$("#upgname").show();  
        	$("#upgname").val(gname);       	
        	$("#form-field-select-2 option[value='"+category+"']").attr("selected", true);
        	$('.input1').val(gid);  
        	$('.input2').val(gcid);       	
      	})
        
        
  });
  
  		function search(){
			document.getElementById("form-search").submit();
	   }
	   
	   function updateStatus(gc_id,gc_status){  
	   	window.location.href="updateStatus?gc_id="+gc_id+"&gc_status="+gc_status;			
	   }
	   
	  function update(gid,gc_id,gname,gc_category){
	  	
        alert(gc_category+"是啥"+gname);   	
        
        window.location.href="update?gc_id="+gc_id+"&gc_status="+gc_status;			
      
	  }
	  
	  function deleteCategory(gid,gc_id){
	  	
	  }
	   
 </script>
    </body>
</html>
