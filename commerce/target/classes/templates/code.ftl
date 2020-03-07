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
    <!--<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/css/bootstrap.min.css">-->
    <!--<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/popper.js/1.15.0/umd/popper.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>-->
  <style>
    body,html{
      width: 100%;
      height: 100%;
      background: #fff;
    }

    /*解决bootstrap样式失效问题*/
    .pagination {
      display: inline-block;
      padding-left: 0;
      margin: 20px 0;
      border-radius: 4px;
    }
    .pagination > li {
      display: inline;
    }
    .pagination > li > a,
    .pagination > li > span {
      position: relative;
      float: left;
      padding: 6px 12px;
      margin-left: -1px;
      line-height: 1.42857143;
      color: #337ab7;
      text-decoration: none;
      background-color: #fff;
      border: 1px solid #ddd;
    }
    .pagination > li:first-child > a,
    .pagination > li:first-child > span {
      margin-left: 0;
      border-top-left-radius: 4px;
      border-bottom-left-radius: 4px;
    }
    .pagination > li:last-child > a,
    .pagination > li:last-child > span {
      border-top-right-radius: 4px;
      border-bottom-right-radius: 4px;
    }
    .pagination > li > a:hover,
    .pagination > li > span:hover,
    .pagination > li > a:focus,
    .pagination > li > span:focus {
      z-index: 2;
      color: #23527c;
      background-color: #eee;
      border-color: #ddd;
    }
    .pagination > .active > a,
    .pagination > .active > span,
    .pagination > .active > a:hover,
    .pagination > .active > span:hover,
    .pagination > .active > a:focus,
    .pagination > .active > span:focus {
      z-index: 3;
      color: #fff;
      cursor: default;
      background-color: #337ab7;
      border-color: #337ab7;
    }
    .pagination > .disabled > span,
    .pagination > .disabled > span:hover,
    .pagination > .disabled > span:focus,
    .pagination > .disabled > a,
    .pagination > .disabled > a:hover,
    .pagination > .disabled > a:focus {
      color: #777;
      cursor: not-allowed;
      background-color: #fff;
      border-color: #ddd;
    }
    .pagination-lg > li > a,
    .pagination-lg > li > span {
      padding: 10px 16px;
      font-size: 18px;
      line-height: 1.3333333;
    }
    .pagination-lg > li:first-child > a,
    .pagination-lg > li:first-child > span {
      border-top-left-radius: 6px;
      border-bottom-left-radius: 6px;
    }
    .pagination-lg > li:last-child > a,
    .pagination-lg > li:last-child > span {
      border-top-right-radius: 6px;
      border-bottom-right-radius: 6px;
    }
    .pagination-sm > li > a,
    .pagination-sm > li > span {
      padding: 5px 10px;
      font-size: 12px;
      line-height: 1.5;
    }
    .pagination-sm > li:first-child > a,
    .pagination-sm > li:first-child > span {
      border-top-left-radius: 3px;
      border-bottom-left-radius: 3px;
    }
    .pagination-sm > li:last-child > a,
    .pagination-sm > li:last-child > span {
      border-top-right-radius: 3px;
      border-bottom-right-radius: 3px;
    }

  </style>
    <body>
 <div id="main-content" class="clearfix">
  <div id="page-content" class="clearfix">

    <div class="page-header position-relative">
              <h1 style="color: #2679b5;">数据字典管理</h1>
            </div>
    <table id="table_bug_report" class="table table-striped table-bordered table-hover">
      <thead>
        <tr>
          <th class="center">
            <label><input type="checkbox" class="ace-checkbox-2"><span class="lbl"></span></label>
          </th>
          <th>字典序号</th>
          <th>字典类型</th>
          <th>用途描述</th>
          <th>编码</th>
          <th>编码值</th>
          <th>操作</th>
        </tr>
      </thead>

      <tbody id="tb_tbody">

        <!--<tr>
          <td class="center">
            <label><input type="checkbox" class="input"><span class="lbl"></span></label>
          </td>

          <td>1</td>
          <td>SEX</td>
          <td>性别</td>
          <td>1</td>
          <td>男</td>
          <td>
            <div class="inline position-relative">
              <button class="btn btn-mini btn-info"  data-toggle="modal" data-target="#myModal2"><i class="icon-edit"></i></button>
              <button class="btn btn-mini btn-danger"><i class="icon-trash"></i></button>
            </div>
          </td>
        </tr>-->

        <!--<tr>
          <td class="center">
            <label><input type="checkbox" class="input"><span class="lbl"></span></label>
          </td>

          <td>SEX</td>
          <td>性别</td>
          <td>0</td>
          <td>女</td>
          <td>
            <div class="inline position-relative" >
              <button class="btn btn-mini btn-info" data-toggle="modal" data-target="#myModal"><i class="icon-edit"></i></button>
              <button class="btn btn-mini btn-danger"><i class="icon-trash"></i></button>
            </div>
          </td>
        </tr>-->

        <!--<tr>
          <td class="center">
            <label><input type="checkbox" class="input"><span class="lbl"></span></label>
          </td>

          <td>AGE</td>
          <td>年龄</td>
          <td>2</td>
          <td>26</td>
          <td>
            <div class="inline position-relative" >
              <button class="btn btn-mini btn-info" data-toggle="modal" data-target="#myModal"><i class="icon-edit"></i></button>
              <button class="btn btn-mini btn-danger"><i class="icon-trash"></i></button>
            </div>
          </td>
        </tr>-->


      </tbody>
    </table>

<button class="btn btn-primary" data-toggle="modal" data-target="#myModal">新增</button>


<!-- Modal新增 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">数据字典信息</h4>
      </div>
      <div class="modal-body" >
          <form class="form-horizontal">

            <div class="control-group">
              <label class="control-label" for="form-field-1">字典类型</label>
              <div class="controls">
                <input type="text" id="form-field-1" name="dictionary_type" >
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="form-field-1">用途描述</label>
              <div class="controls">
                 <input type="text" id="form-field-1" name="dictionary_description">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="form-field-1">编码</label>
              <div class="controls">
                <input type="text" id="form-field-1" name="code">
              </div>
            </div>
            <div class="control-group">
              <label class="control-label" for="form-field-1">编码值</label>
              <div class="controls">
                <input type="text" id="form-field-1" name="code_value">
              </div>
            </div>

        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
        <button id="addnew" type="button" class="btn btn-primary" data-dismiss="modal">保存</button>
      </div>
    </div>
  </div>
</div>


<!--Modal修改-->
    <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <h4 class="modal-title" id="myModalLabel">数据字典信息</h4>
          </div>
          <div class="modal-body" >
            <form class="form-horizontal">

              <div class="control-group">
                <label class="control-label" for="form-field-1">字典id</label>
                <div class="controls">
                  <input type="text" id="form-field-1" name="dictionary_id2" disabled>
                </div>
              </div>

              <div class="control-group">
                <label class="control-label" for="form-field-1">字典类型</label>
                <div class="controls">
                  <input type="text" id="form-field-1" name="dictionary_type2">
                </div>
              </div>
              <div class="control-group">
                <label class="control-label" for="form-field-1">用途描述</label>
                <div class="controls">
                  <input type="text" id="form-field-1" name="dictionary_description2">
                </div>
              </div>
              <div class="control-group">
                <label class="control-label" for="form-field-1">编码</label>
                <div class="controls">
                  <input type="text" id="form-field-1" name="code2">
                </div>
              </div>
              <div class="control-group">
                <label class="control-label" for="form-field-1">编码值</label>
                <div class="controls">
                  <input type="text" id="form-field-1" name="code_value2">
                </div>
              </div>

            </form>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            <button type="button" class="btn btn-info" data-dismiss="modal" onclick="updateDataDictionary()">更新</button>
          </div>
        </div>
      </div>
    </div>
    <!--分页条-->
    <div>
      <nav class="pull-right">
        <ul class="pagination pagination-lg" id="paging_toolbar">
          <!--<li><a href="#" aria-label="Previous"><span aria-hidden="true">上一页</span></a></li>
          <li class="active"><a href="#">1<span class="sr-only">(current)</span></a></li>
          <li class=""><a href="#">2<span class="sr-only">(current)</span></a></li>
          <li class=""><a href="#">3<span class="sr-only">(current)</span></a></li>
          <li class=""><a href="#">4<span class="sr-only">(current)</span></a></li>
          <li class=""><a href="#">5<span class="sr-only">(current)</span></a></li>
          <li class="disabled"><a href="#" aria-label="Previous"><span
                  aria-hidden="true">下一页</span></a></li>-->
        </ul>
      </nav>

    </div>

  </div></div>
    <!--<script src="js/jquery-3.3.1.js"></script>-->
   <script src="js/jquery-1.9.1.js"></script>
   <script src="js/bootstrap.min.js"></script>
   <script src="js/bootbox.min.js"></script>
    <script>


      $(function(){

        /*发送ajax请求：请求到数据库的信息*/
        /*$.ajax({

          type:'get',
          url:'/queryAll',
          /!*success代表回调函数，*!/
          success:function (data) {

            /!*data 为前端返回的查询结果*!/
            //console.log(data)

            for (var i=0;i<data.length;i++){

              //alert(data[i].dictionary_description);

              /!*生成表格行：显示到表格中*!/
              var trTxt = "";


              trTxt += '<tr>' +
                      '<td class="center">' +
                      '<label><input type="checkbox" class="input"><span class="lbl"></span></label>' +
                      '</td>' +
                      '<td>'+data[i].dictionary_id+'</td>' +
                      '<td>'+data[i].dictionary_type+'</td>' +
                      '<td>'+data[i].dictionary_description+'</td>' +
                      '<td>'+data[i].code+'</td>' +
                      '<td>'+data[i].code_value+'</td>' +
                      '<td>' +
                      '<div class="inline position-relative" >' +
                      '<button class="btn btn-mini btn-info" data-toggle="modal" data-target="#myModal2" onclick="showDataDictionary('+data[i].dictionary_id+')"><i class="icon-edit"></i></button>' +
                      '<button class="btn btn-mini btn-danger" onclick="deleteDataDictionary('+data[i].dictionary_id+')"><i class="icon-trash"></i></button>' +
                      '</div>' +
                      '</td>' +
                      '</tr>';

              $("#tb_tbody").append(trTxt);






            }

          }

        });*/

        loadPage(1);


        /*点击保存按钮增加信息*/
        $("#addnew").click(function () {

          //获取表单参数
          var dictionary_id = $('input[name = dictionary_id]').val();
          var dictionary_type = $('input[name = dictionary_type]').val();
          var dictionary_description = $('input[name = dictionary_description]').val();
          var code = $('input[name = code]').val();
          var code_value = $('input[name = code_value]').val();

          //按钮的点击事件
          $.ajax({

            type:"post",
            url:"/addNewDataDictionary",
            contentType :'application/json;charset=UTF-8',
            data:'{"dictionary_type":"'+dictionary_type+'","dictionary_description":"'+dictionary_description+'","code":"'+code
                    +'","code_value":"'+code_value+'"}',
            success:function (data) {

              //获取前端的处理结果
              if (data.code === "200"){

                bootbox.alert(data.msg);
                /*window.location.href = "/code.html";*/
                window.location.href = window.location.href;
                window.location.reload();

              }else
                bootbox.alert(data.msg);

            }

          });

        });




        /*处理全选全不选按钮*/
        $('.ace-checkbox-2').change(function(){
          if($('.ace-checkbox-2').prop('checked')){
            $('.input').prop('checked',true);
          }else{
            $('.input').prop('checked',false);
          }
        });





})

      /*点击按钮删除记录*/
      /*将其绑定在按钮上面*/
      function deleteDataDictionary(id) {

        $.ajax({

          type:"post",
          url:"/deleteDataDictionary",
          contentType :'application/json;charset=UTF-8',
          data:'{"dictionary_id":"'+id+'"}',
          success:function (data) {

            if(data.code === "200"){

              bootbox.alert(data.msg);
              window.location.href = window.location.href;
              window.location.reload();
            }else {

              bootbox.alert(data.msg);


            }
          }


        });

      }




      /*修改时，模态框中先显示出来原来的值，然后改变属性值，从而修改*/
      /*参数id从前端的编辑按钮获取*/
      function showDataDictionary(id) {

        //获取表单参数

        $.ajax({

          type:"post",
          url:"/showDataDictionary",
          contentType :'application/json;charset=UTF-8',
          data:'{"dictionary_id":"'+id+'"}',
          success:function (result) {

            //获取前端的处理结果
            if (result.code === "200"){

              $('input[name = dictionary_id2]').val(id);
              $('input[name = dictionary_type2]').val(result.data.dictionary_type);
              $('input[name = dictionary_description2]').val(result.data.dictionary_description);
              $('input[name = code2]').val(result.data.code);
              $('input[name = code_value2]').val(result.data.code_value);



            }//if
            else
              bootbox.alert(result.msg);

            }//else




        })

      }


      /**
       * 加载分页数据
       * @param currentPage 当前分页
       */
      function loadPage(currentPage) {

        $.ajax({

          type:"post",
          url:"/queryAllDataDictionary",
          contentType :'application/json;charset=UTF-8',
          data:'{"currentPage":"'+currentPage+'"}',
          success:function (result) {


            console.log(result.code === 200);
            console.log(result.data[0].dictionary_description);
            console.log(result.msg);
            console.log(result.data.length);

            /*服务器响应成功*/



            if (result.code === "200"){

              //遍历生成表格行
              var trTxt = "";
              for (var i=0;i<result.data.length;i++){

                /*生成表格行：显示到表格中*/

                console.log("进入循环");

                /*获取到data中的数据字典对象*/
                var datadictionary = result.data[i];
                console.log(datadictionary);


                trTxt += '<tr>' +
                        '<td class="center">' +
                        '<label><input type="checkbox" class="input"><span class="lbl"></span></label>' +
                        '</td>' +
                        '<td>'+datadictionary.dictionary_id+'</td>' +
                        '<td>'+datadictionary.dictionary_type+'</td>' +
                        '<td>'+datadictionary.dictionary_description+'</td>' +
                        '<td>'+datadictionary.code+'</td>' +
                        '<td>'+datadictionary.code_value+'</td>' +
                        '<td>' +
                        '<div class="inline position-relative" >' +
                        '<button class="btn btn-mini btn-info" data-toggle="modal" data-target="#myModal2" onclick="showDataDictionary('+datadictionary.dictionary_id+')"><i class="icon-edit"></i></button>' +
                        '<button class="btn btn-mini btn-danger" onclick="deleteDataDictionary('+datadictionary.dictionary_id+')"><i class="icon-trash"></i></button>' +
                        '</div>' +
                        '</td>' +
                        '</tr>';



              }//for

              $("#tb_tbody").html(trTxt);

              //分页条
              var $paging_toolbar = $("#paging_toolbar");
              var paging_toolbarTxt = "<li class='disabled'><a href='#'>第" + result.page.currentPage + "页 / 共" + result.page.pageTotal + "页</a></li>";

              //如果当前是第一页，那么【上一页】按钮不可点击
              if (currentPage === 1) {

                paging_toolbarTxt += "<li class='disabled'><a href='#'>上一页</a></li>";
              }
              else {

                paging_toolbarTxt += "<li onclick='loadPage(" + (currentPage - 1) + ")'><a href='#'>上一页</a></li>";
              }

              //遍历生成页码
              for (var i = 1; i <= result.page.pageTotal; i++) {

                //设置当前的页数显示高亮
                if (result.page.currentPage === i) {

                  paging_toolbarTxt += "<li onclick='loadPage(" + i + ")' class='active'><a href='#'>" + i + "</a></li>";
                }
                else {

                  paging_toolbarTxt += "<li onclick='loadPage(" + i + ")' ><a href='#'>" + i + "</a></li>";
                }
              }

              //如果当前是最后一页，那么【下一页】按钮不可点击
              if (currentPage === result.page.pageTotal) {

                paging_toolbarTxt += "<li class='disabled'><a href='#'>下一页</a></li>";
              }
              else {

                paging_toolbarTxt += "<li onclick='loadPage(" + (currentPage + 1) + ")'><a href='#'>下一页</a></li>";
              }

              $paging_toolbar.html(paging_toolbarTxt);


            }
            else {

              bootbox.alert("获取数据字典列表失败！");
            }
          }

        })


      }


      /*绑定在按钮上：根据id来修改信息*/
      function updateDataDictionary() {

        //获取表单参数
        var dictionary_id = $('input[name = dictionary_id2]').val();
        var dictionary_type = $('input[name = dictionary_type2]').val();
        var dictionary_description = $('input[name = dictionary_description2]').val();
        var code = $('input[name = code2]').val();
        var code_value = $('input[name = code_value2]').val();

        console.log(dictionary_id);
        console.log(dictionary_type);
        console.log(dictionary_description);
        console.log(code);
        console.log(code_value);

        $.ajax({

          type:"post",
          url:"/updateDataDictionary",
          contentType :'application/json;charset=UTF-8',
          data:'{"dictionary_id":"'+dictionary_id+'","dictionary_type":"'+dictionary_type+'","dictionary_description":"'+dictionary_description+'","code":"'+code+'","code_value":"'+code_value+'"}',
          success:function (data) {

            //获取前端的处理结果
            if (data.code === "200"){

              bootbox.alert(data.msg);
              window.location.href=window.location.href;
              window.location.reload();

            }else
              bootbox.alert(data.msg);

          }

        })

      }



    </script>
    </body>
</html>
