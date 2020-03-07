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
            .goods-header{
                overflow: hidden;
            }
            .goods-header-left{
                width: 30%;
                float: left;
            }
            .goods-header-right{
                width: 60%;
                float: left;
                margin-left:20px;
            }
            .goods-header-left img{
                width: 100%;
            }

        </style>
    </head>
    <body>

        <div id="main-content" class="clearfix">
            <div id="page-content" class="clearfix">

            <div class="goods-header">
                <div class="goods-header-left"><img src="/Path/${(good.category.gc_picture)!}" alt="" /></div>
                <div class="goods-header-right">
                    <p>${(good.gname)!}</p>
                    <p class="red">$<span>${(good.gprice)!}</span></p>
                    <p>sku：<span>${(good.gsku)!}</span></p>
                    <p>商品型号：<span>${(good.model)!}</span></p>
                    <p>现有库存：<span>${(good.gcounts)!}</span></p>
                    <p>保修期：<span>${(good.maintain)!}</span></p>

                    <button class="btn btn-primary"><a style="color:#fff" href="/bvo-goodsstorechoose/${(good.gid)!}">Dropship Now</a></button>
                    <button class="btn btn-primary"><a style="color:#fff" href="/bvo-wishlist/${(good.gid)!}" >Add to Wish List</a></button>
                </div>
            </div>

                <h4 class="lighter">Item Description</h4>
                <div class="tabbable">
                    <ul class="nav nav-tabs" id="myTab">
                        <li class="active"><a data-toggle="tab" href="#ebay"> ebay description</a></li>
                        <li class=""><a data-toggle="tab" href="#Amazon">Amazon description</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="ebay" class="tab-pane active">
                            ${(good.edescription)!}
                        </div>
                        <div id="Amazon" class="tab-pane">
                            ${(good.adescription)!}
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </body>
    
    <script src="../js/jquery-1.9.1.js"></script>
    <script type="text/javascript">

    </script>
    <script src="../js/bootstrap.min.js"></script>
</html>
