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
  <style>
    body,html{
      width: 100%;
      height: 100%;
      background: #fff;
    }


  </style>
    <body>
<div id="main-content" class="clearfix">
  <div id="page-content" class="clearfix">


    <div class="page-header position-relative">
      <h1 style="color: #2679b5;">品牌商<small><i class="icon-double-angle-right"></i> 商品信息录入</small></h1>
    </div>
    <form class="form-search" action="goodQuery" method="post" >
      商品标题：
      <input type="text" class="input-medium search-query" name="gname">
      <button type="submit" class="btn btn-purple btn-small">Search <i class="icon-search icon-on-right"></i></button>
    </form>
    <h4 style="color:red">${content}</h4><br>
    <table id="table_bug_report" class="table table-striped table-bordered table-hover">
      <thead>
        <tr>
          <th class="center">
            <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
          </th>
          <th>商品标题</th>
          <th>商品价格</th>
          <th>库存</th>
          <th>sku</th>

          <th>操作</th>
        </tr>
      </thead>

      <tbody>
	 <#list goodlist as good>
        <tr>
          <td class="center">
            <label><input type="checkbox" class="input"><span class="lbl"></span></label>
          </td>
          <td><a href="#">${good.gname}</a></td>
          <td>${good.gprice}</td>
          <td class="hidden-480">${good.gcounts}</td>
          <td class="hidden-phone">${good.gsku}</td>
			
          <td>
          	<input type="hidden" value="${good.gid}" name="gid">
            <div class="inline position-relative" >
              <button class="btn btn-mini btn-info "  onclick="update(${good.gid})"><i class="icon-edit"></i></button>
              <button class="btn btn-mini btn-danger" name="${good.gid}"><i class="icon-trash"></i></button>
            </div>
          </td>
        </tr>
		
		</#list>
       

              </tbody>
    </table>

<button class="btn btn-primary" onclick="gotoadd()">新增</button>

  </div></div>
    <script src="js/jquery-1.9.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootbox.min.js"></script>
    <script>
      $(function(){
        $('.ace-checkbox-2').change(function(){
          if($('.ace-checkbox-2').prop('checked')){
            $('.input').prop('checked',true);
          }else{
            $('.input').prop('checked',false);
          }
        })


        $('.btn-danger').click(function(){
        	var value=$(this).attr("name");
            
            $.ajax({
                type:'post',
                contentType:'application/json;charset=utf-8',
                url:'${PageContext.request.contextPath}/delete',
                data:'{"gid":"'+value+'"}',
                success:function (data) {
                	if(data=="删除成功！"){
                		location.reload(true);	 
                	}
                	
                	bootbox.alert(data);   
                }
            })      
        })

})
		function gotoadd() {
		 
		  window.location.href = "brand-productInput-attr2.ftl";
		}
		
		function search(){
		document.getElementById("goodQuery").submit();
		} 
		
		function update(gid){
			window.location.href="update?gid="+gid;	
		}

    </script>
    </body>
</html>
