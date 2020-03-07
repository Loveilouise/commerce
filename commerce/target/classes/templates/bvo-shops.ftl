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
        <script type="text/javascript" src="js/jquery-1.9.1.js"></script>

    </head>
    <style>
        body,html{
            width: 100%;
            height: 100%;
            background: #fff;
        }

        .content{
            width: 50%;
            margin:20px auto;
        }
        .shop{
            width: 80%;
            margin-top: 50px;

        }
    </style>
    <body>
<div id="main-content" class="clearfix">
  <div id="page-content" class="clearfix">
      <h3 class="header smaller lighter red">Add a new store</h3>
        <div class="content">
            <div class="gray shop">Set up API connection with your store by account authorisation</div>

            <button class="btn btn-primary btn-block shop" id="b">Amazon</button><br>
            <button class="btn btn-primary btn-block shop" id="b">eBay</button>

            <div class="goodsname hide control-group">
                <div><label>Store Name</label><input type="text" name="store_name"></div>
                <div><label>Seller ID</label><input type="text" name="sid" value="${Session["seller"].sid}" disabled="disabled"></div>
                <div><label>Marketplace ID</label><input type="text" name="marketplaceId"></div>
                <div><label>MWS Auth Token</label><input type="text" name="mws"></div>
                <div class="button save"><button class="btn" style="margin-right: 10px">cancel</button>
                <button class="btn btn-primary addshop">save</button></div>
            </div>
        </div>
    </div>
    </div>
    <script type="text/javascript">
    $(function(){
        $(".shop").click(function(event) {
        	var store_type=$(this).text();
            $(".goodscontent h3").text($(this).text());
            $(".shop").hide();
            $(".goodsname").show();
            $(".addshop").click(function(){
            	var store_name=$(" input[ name='store_name' ] ").val();
    			var marketplaceId=$(" input[ name='marketplaceId' ] ").val();
    			var mws=$(" input[ name='mws' ] ").val();
    			//alert(store_name+marketplaceId+mws+store_type);
    			$.ajax({
    	            type:'post',
    	            async:false,
    	            contentType:'application/json;charset=utf-8',
    	            url:'/addshopdetail',
    	            data:'{"store_name":"'+store_name+'","marketplaceId":"'+marketplaceId+'","mws":"'+mws+'","store_type":"'+store_type+'"}',
    	            success:function (data) {
    	                bootbox.alert("增加店铺信息成功");
    	            }
            })
        });
        
        $(".save").click(function(){
            window.location.href = "/bvo-goodsstoreAdd";
        })
    })
    })
    </script>
    </body>
</html>
