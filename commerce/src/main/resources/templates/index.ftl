<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>index</title>
</head>

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-responsive.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/ace.min.css">
    <link rel="stylesheet" href="css/ace-skins.min.css">
    <link rel="stylesheet" href="css/ace-responsive.min.css">

    <style>
        #sidebar{
            left: 0;
            margin-top: 0;
        }
        body,html{
            width: 100%;
            height: 100%;
        }
        .blue{
            color:blue;
        }

    </style>

<body>
<div class="navbar navbar-inverse">
    <div class="navbar-inner" style="background:#0099CC;">
        <div class="container-fluid">
            <a class="brand">
                <small><i class="icon-leaf"></i> gmcbrand</small>
            </a>

            <ul class="nav ace-nav pull-right">

                <li class="light-blue user-profile">
                    <a class="user-menu dropdown-toggle" href="javascript:;" data-toggle="dropdown">
                        <img alt="LRJ" src="image/avatar.jpg" class="nav-user-photo">
                        <span id="user_info"><small>Welcome</small> <span id="userName">gmcbrand</span></span>
                        <i class="icon-caret-down"></i>
                    </a>
                    <ul id="user_menu" class="pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">


                        <li><a href="login"><i class="icon-off"></i> 退出</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>
<div id="sidebar">
    <div id="sidebar-shortcuts">

        <div id="sidebar-shortcuts-large">

            <button class="btn btn-small btn-success"><i class="icon-signal"></i></button>

            <button class="btn btn-small btn-info"><i class="icon-pencil"></i></button>

            <button class="btn btn-small btn-warning"><i class="icon-group"></i></button>

            <button class="btn btn-small btn-danger"><i class="icon-cogs"></i></button>

        </div>

        <div id="sidebar-shortcuts-mini">

            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>

        </div>

    </div><!-- #sidebar-shortcuts -->



    <ul class="nav nav-list" id="nav-list">















    </ul><!--/.nav-list-->



    <div id="sidebar-collapse"><i class="icon-double-angle-left"></i></div>
</div>
<iframe id="menuFrame" name="menuFrame" src="brand-addbrand.html" frameborder="no" width="100%" height="100%">
</iframe>
</body>
<script src="js/jquery-1.9.1.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript"  src="static/js/index.js"></script>
<script>
    $('.nav-list li ').click(function () {
        $(this).addClass('blue').siblings().removeClass('blue');
    })
</script>
</html>