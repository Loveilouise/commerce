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
            img{
                width: 200px;
                height: 200px;
            }
            .imglist{
                width: 100%;
                height: 250px;
                list-style: none;
                margin-left: 100px;

            }
            .imglist a{
                display: block;
                width: 100%;
                height: 100%;
            }
            .imglist img{
                float: left;
                margin-right: 20px;
            }
            .imglist .right,.imglist label{
                float: left;
            }
            .imglist label{
                width: 25px;
                height: 25px;
                margin-right: 10px;
            }
        </style>
    </head>
    <body>
        <div id="main-content" class="clearfix">
            <div id="page-content" class="clearfix" style="margin-top: 45px;">
             <div class="page-header position-relative">
              <h1 style="color: #2679b5;">借卖方<small><i class="icon-double-angle-right"></i> 心愿单</small></h1>
            </div>
            <button class="btn btn-success" onclick="del()"><i class="icon-trash icon-4x icon-only">delete</i></button>
            <ul>
            
             <#list wishlist as good>
                <li class="imglist">

                    <a href="/bvo-goodsdetail/${(good.gid)!}">
                    <label><input type="checkbox" value="${(good.gid)!}" class="input"><span class="lbl"></span></label>
                    <img src="/Path/${(good.category.gc_picture)!}"  alt="" />
                    <div class="right">
                        <p>${(good.gname)!}</p>
                        <p class="red">$<span>${(good.gprice)!}</span></p>
                        <p>sku：<span>${(good.gsku)!}</span></p>
                       
                    </div>
                    </a>

                </li>
             </#list>
               
            </ul>
            
            
        </div>
        </div>
        </body>
        <script type="text/javascript" src="../js/jquery-1.9.1.js"></script>
        <script type="text/javascript">
        function del(){

            var isc = "";
            $("#page-content input[type='checkbox']").each(function(){ //遍历全部checkbox

                if($(this).is(":checked"))   //如果被选中
                        isc += $(this).val() + ","; //获取被选中的值
                });
  
                if(isc.length > 0) //如果获取到
                    isc = isc.substring(0, isc.length - 1);  //把最后一个逗号去掉
      		//alert(isc);
              
      		$.ajax({
                type: "POST",
                url: "/delGoods",
                data: {"delgoods" : isc},                
                contentType : "application/x-www-form-urlencoded",
                success: function(){
                	window.location="/bvo-wishlist";
                }
            });
                    
                    
        	}
        </script>
    
</html>
