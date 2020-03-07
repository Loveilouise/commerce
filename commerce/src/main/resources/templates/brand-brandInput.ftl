<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/ace.min.css">
        <link rel="stylesheet" href="css/ace-skins.min.css">
        <link rel="stylesheet" href="css/ace-responsive.min.css">
        <link rel="stylesheet" type="text/css" href="webuploader/webuploader.css" />
        <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="webuploader/webuploader.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/bootbox.min.js"></script>

  <style>
  body,html{
      width: 100%;
      height: 100%;
    background: #fff;
  }

  </style>

    </head>
    <body>

    <div id="main-content" class="clearfix">
      <div id="page-content" class="clearfix">


    <div class="page-header position-relative">
              <h1 style="color: #2679b5;">品牌商 <small><i class="icon-double-angle-right"></i> 公司信息</small></h1>
            </div>
            <h3 style="line-height:40px;">公司信息</h3>
    <table id="table_bug_report" class="table table-striped table-bordered table-hover">
      <thead>
        <tr>
          <th>Company Name公司名称（中文）</th>
          <th>Company Name公司名称（英文）</th>
          <th>GMC Report Type品牌商认证类型</th>
          <th>GMC Report Url证书地址</th>
          <th>操作</th>
        </tr>
      </thead>

      <tbody>

        <tr>
          <td>${Session["company"].ccname}</td>
          <td>${Session["company"].cename}</td>
          <td>${Session["company"].ctype}</td>
          <td>${Session["company"].curl}</td>
          <td>
            <div class="inline position-relative">
              <button class="btn btn-mini btn-info" onclick="goEdit()"><i class="icon-edit"></i></button>
            </div>
          </td>
        </tr>

              </tbody>
    </table>

<h3 style="margin-top:40px;line-height:40px;">品牌信息</h3>
<!-- 品牌信息 -->
 <table id="table_bug_report" class="table table-striped table-bordered table-hover">
      <thead>
        <tr>
          <th class="center">
             <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
          </th>
          <th>品牌名称Brand Name</th>
          <th>品牌图片Brand Logo</th>
          <th>操作</th>
        </tr>
      </thead>
		
	  <#list brandList as bl>
      <tbody>

        <tr>
          <th class="center">
             <label><input type="checkbox" class="input"><span class="lbl"></span></label>
          </th>
          <td>${bl.bname}</td>
          <td><img src="${bl.blogo}"  width="160" alt="" /></td>
          <td>
            <div class="inline position-relative">
              <button id="editBrand" class="btn btn-mini btn-info" data-toggle="modal" onclick="editBrand(${bl.bid},'${bl.bname}','${bl.blogo}')" data-target="#myModal"><i class="icon-edit"></i></button>
              <button id="delBrand" class="btn btn-mini btn-danger" onclick="delBrand(${bl.bid})"><i class="icon-trash"></i></button>
            </div>
          </td>
        </tr>

       </tbody>
       </#list>
    </table>
<button class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="addBrand">新增</button>


    <!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
  
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">品牌信息</h4>
      </div>
      
      <div class="modal-body" >
          <form class="form-horizontal">

            <div class="control-group">
              <label class="control-label" for="form-field-1">品牌名称<br>Brand Name</label>
              <div class="controls">
                <input type="text" id="bname" >
              </div>
              <input type="hidden" id="blogo" >
              <input type="hidden" id="bid" >
            </div>

            <div class="control-group">
                <p class="red">(建议图片大小160*80的jpg/png格式)</p>
              <label class="control-label" for="form-field-1">品牌图片<br>Brand Logo</label>
              <div class="controls">
              
                   <span style="font-size:14px;"><div id="uploader-demo">
                  <!--用来存放item-->
                  <div id="thelist" class="uploader-list"></div>
                  
                  <div>
                   <div id="filePicker">选择图片</div>
                   <button id="ctlBtn" type="button" class="btn btn-default">开始上传</button>
                  </div>
                  </div>
                  </span>
                </div>
            </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" id="saveSuccess">保存</button>
      </div>
    </div>
  </div>
</div>
  </div>
    </div>

    <script>
    $(function(){
   /*init webuploader*/
   var $list=$("#thelist");   //这几个初始化全局的百度文档上没说明，好蛋疼。
   var $btn =$("#ctlBtn");   //开始上传
   var thumbnailWidth = 100;   //缩略图高度和宽度 （单位是像素），当宽高度是0~1的时候，是按照百分比计算，具体可以看api文档
   var thumbnailHeight = 100;

   var uploader = WebUploader.create({
       // 选完文件后，是否自动上传。
       auto: false,

       // swf文件路径
       swf: '/webupload/Uploader.swf',

       // 文件接收服务端。
       server: '/upload',

       // 选择文件的按钮。可选。
       // 内部根据当前运行是创建，可能是input元素，也可能是flash.
       pick:{id:'#filePicker'} ,
	   fileNumLimit: 8,
       // 只允许选择图片文件。
       accept: {
           title: 'Images',
           extensions: 'gif,jpg,jpeg,bmp,png',
           mimeTypes: 'image/*'
       },
       method:'POST',
   });
   // 当有文件添加进来的时候
   uploader.on( 'fileQueued', function( file ) {  // webuploader事件.当选择文件后，文件被加载到文件队列中，触发该事件。等效于 uploader.onFileueued = function(file){...} ，类似js的事件定义。
       var $li = $(
               '<div id="' + file.id + '" class="file-item thumbnail">' +
                   '<img>' +
                   '<div class="info">' + file.name + '</div>' +
               '</div>'
               ),
           $img = $li.find('img');
			$('#thelist').html('');

       // $list为容器jQuery实例
       $list.append( $li );

       // 创建缩略图
       // 如果为非图片文件，可以不用调用此方法。
       // thumbnailWidth x thumbnailHeight 为 100 x 100
       uploader.makeThumb( file, function( error, src ) {   //webuploader方法
           if ( error ) {
               $img.replaceWith('<span>不能预览</span>');
               return;
           }

           $img.attr( 'src', src );
       }, thumbnailWidth, thumbnailHeight );
   });
   // 文件上传过程中创建进度条实时显示。
   uploader.on( 'uploadProgress', function( file, percentage ) {
       var $li = $( '#'+file.id ),
           $percent = $li.find('.progress span');

       // 避免重复创建
       if ( !$percent.length ) {
           $percent = $('<p class="progress"><span></span></p>')
                   .appendTo( $li )
                   .find('span');
       }

       $percent.css( 'width', percentage * 100 + '%' );
   });

   // 文件上传成功，给item添加成功class, 用样式标记上传成功。
   uploader.on( 'uploadSuccess', function( file ,response) {
   		console.log(response)
   		$('#blogo').val(response._raw)
      
   });

   // 文件上传失败，显示上传出错。
   uploader.on( 'uploadError', function( file ) {
       var $li = $( '#'+file.id ),
           $error = $li.find('div.error');

       // 避免重复创建
       if ( !$error.length ) {
           $error = $('<div class="error"></div>').appendTo( $li );
       }

       $error.text('上传失败');
   });

   // 完成上传完了，成功或者失败，先删除进度条。
   uploader.on( 'uploadComplete', function( file ) {
       $( '#'+file.id ).find('.progress').remove();
   });
      $btn.on( 'click', function() {
        console.log("上传...");
        uploader.upload();
        console.log("上传成功");
      });
	
	  $("#addBrand").click( function() {
	    $('#bid').val('')
	  	$('#bname').val('')
	  	$('#thelist').html('');
      });
	 
	  $('#saveSuccess').click(function(){
	  		var blogo = $('#blogo').val()
	  		var bname = $('#bname').val()
	  		var bid = $('#bid').val()
	  		var url = null;
	  		if(bid){
	  		 url = '/updateBrand'
	  		}
	  		else{
	  		url = '/insertBrand'
	  		}
			var params = {
        		"blogo":blogo,
        		"bname":bname,
        		"bid":bid
    		};
	  		$.post(url,params,function(result){
            	//跳转到indexUI对应的页面
            	alert("保存成功");
            	window.location.href = "brand-brandInput";
        		return false;//防止刷新时重复提交
    		});
      })
      $('.ace-checkbox-2').change(function(){
          if($('.ace-checkbox-2').prop('checked')){
            $('.input').prop('checked',true);
          }else{
            $('.input').prop('checked',false);
          }
       })


  });
  
  	function editBrand(bid,bname,blogo){
	  		$('#bid').val(bid)
	  		$('#thelist').html('');
	  		$('#bname').val(bname)
	  		$('#blogo').val(blogo)
    }
	function delBrand(bid){
		
		var url = '/delCompanyBrand'
		var params = {
    		"bid": bid
		};
	  	$.get(url,params,function(result){
            	//跳转到indexUI对应的页面
            	alert("删除成功");
            	window.location.href = "brand-brandInput";
        		return false;//防止刷新时重复提交
    	});
	}
    function goEdit(){
        window.location.href = "brand-addbrand";
      }
    </script>
    </body>
</html>
