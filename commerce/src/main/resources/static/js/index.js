function getCookie(name){
    var strcookie = document.cookie;//获取cookie字符串
    var arrcookie = strcookie.split("; ");//分割
    //遍历匹配
    for ( var i = 0; i < arrcookie.length; i++) {
        var arr = arrcookie[i].split("=");
        if (arr[0] == name){
            return arr[1];
        }
    }
    return "";
}
var userName = getCookie("userName");
console.log("userName:"+userName);
document.getElementById("userName").innerText = userName;
var userRole = getCookie("userRole");
if(0==userRole){
	$("#menuFrame").attr("src","code.ftl");
	document.getElementById('nav-list').innerHTML = "" +
        "<li>\n" +
        "\n" +
        "            <a href=\"code.ftl\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-picture\"></i>\n" +
        "\n" +
        "                <span>数据字典管理</span>\n" +
        "\n" +
        "\n" +
        "\n" +
        "            </a>\n" +
        "\n" +
        "        </li>\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "        <li>\n" +
        "\n" +
        "            <a href=\"parameter.ftl\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-th\"></i>\n" +
        "\n" +
        "                <span>参数管理</span>\n" +
        "\n" +
        "\n" +
        "\n" +
        "            </a>\n" +
        "\n" +
        "        </li>\n" +
        "\n" +
        "        <li>\n" +
        "\n" +
        "            <a href=\"admin-withdraw-audit\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-th\"></i>\n" +
        "\n" +
        "                <span>admin-充值提现审核</span>\n" +
        "\n" +
        "            </a>\n" +
        "\n" +
        "        </li>"
}
if(1==userRole){
	$("#menuFrame").attr("src","brand-addbrand.ftl");
    document.getElementById('nav-list').innerHTML ="<li>\n" +
        "\n" +
        "            <a href=\"brand-addbrand.ftl\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-dashboard\"></i>\n" +
        "\n" +
        "                <span>品牌商-我的信息</span>\n" +
        "\n" +
        "\n" +
        "\n" +
        "            </a>\n" +
        "\n" +
        "        </li>\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "        <li>\n" +
        "\n" +
        "            <a href=\"brand-productInput-attr.ftl\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-text-width\"></i>\n" +
        "\n" +
        "                <span>品牌商-商品录入</span>\n" +
        "\n" +
        "\n" +
        "\n" +
        "            </a>\n" +
        "\n" +
        "        </li>\n" +
        "        <li>\n" +
        "\n" +
        "            <a href=\"brand-productInput-pic.ftl\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-text-width\"></i>\n" +
        "\n" +
        "                <span>品牌商-商品主图</span>\n" +
        "\n" +
        "\n" +
        "\n" +
        "            </a>\n" +
        "\n" +
        "        </li>\n" +
        "\n" +
        "\n" +
        "        <li>\n" +
        "\n" +
        "            <a href=\"brand-orderlist.ftl\" class=\"dropdown-toggle\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-file\"></i>\n" +
        "\n" +
        "                <span>品牌商-订单管理</span>\n" +
        "\n" +
        "\n" +
        "            </a>\n" +
        "\n" +
        "        </li>\n" +
        "\n" +
        "\n" +
        "        <li>\n" +
        "\n" +
        "            <a href=\"brand-wallerAcountRegister.ftl\" class=\"dropdown-toggle\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-desktop\"></i>\n" +
        "\n" +
        "                <span>品牌商-钱包</span>\n" +
        "            </a>\n" +
        "\n" +
        "\n" +
        "        </li>"
}
if (2==userRole){
	$("#menuFrame").attr("src","bvo-myInfo.ftl");
    document.getElementById("nav-list").innerHTML ="<li>\n" +
        "\n" +
        "            <a href=\"/bvo-myInfo\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-list\"></i>\n" +
        "\n" +
        "                <span>借卖方-我的信息</span>\n" +
        "\n" +
        "\n" +
        "\n" +
        "            </a>\n" +
        "\n" +
        "        </li>\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "        <li>\n" +
        "\n" +
        "            <a href=\"/bvo-goodsstoreAdd\" class=\"dropdown-toggle\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-edit\"></i>\n" +
        "\n" +
        "                <span>借卖方-店铺管理</span>\n" +
        "            </a>\n" +
        "\n" +
        "\n" +
        "        </li>\n" +
        "\n" +
        "\n" +
        "        <li>\n" +
        "\n" +
        "            <a href=\"bvo-index.ftl\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-list-alt\"></i>\n" +
        "\n" +
        "                <span>借卖方-商品浏览</span>\n" +
        "\n" +
        "\n" +
        "\n" +
        "            </a>\n" +
        "\n" +
        "        </li>\n" +
        "\n" +
        "\n" +
        "        <li>\n" +
        "\n" +
        "            <a href=\"bvo-wishlist.ftl\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-list-alt\"></i>\n" +
        "\n" +
        "                <span>借卖方-心愿单</span>\n" +
        "\n" +
        "\n" +
        "\n" +
        "            </a>\n" +
        "\n" +
        "        </li>\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "\n" +
        "        <li>\n" +
        "\n" +
        "            <a href=\"bvo-orderlist.ftl\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-calendar\"></i>\n" +
        "\n" +
        "                <span>借卖方-订单管理</span>\n" +
        "\n" +
        "\n" +
        "\n" +
        "            </a>\n" +
        "\n" +
        "        </li>\n" +
        "        <li>\n" +
        "\n" +
        "            <a href=\"bvo-gmcwallerAcount.ftl\" target=\"menuFrame\">\n" +
        "\n" +
        "                <i class=\"icon-calendar\"></i>\n" +
        "\n" +
        "                <span>借卖方-我的钱包</span>\n" +
        "\n" +
        "\n" +
        "\n" +
        "            </a>\n" +
        "\n" +
        "        </li>"
}