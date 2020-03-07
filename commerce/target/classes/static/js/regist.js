function setCookie(name,value)
{
    var Days = 30;
    var exp = new Date();
    exp.setTime(exp.getTime() + Days*24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
}

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
function submit() {
    var userName = document.getElementById('userName').value;
    var userPwd = document.getElementById('userPwd').value;
    var userPwdConfirm = document.getElementById('userPwdConfirm').value;
    var userRole;
    var inputs = document.getElementsByName("userRole");
    for (var i = 0; i < inputs .length; i++) {
        if (inputs [i].checked) {
            userRole = inputs[i].value;
        }
    }
    if(null==userName&&null==userPwd&&null==userPwdConfirm&&null==userRole){
        alert('请输入用户名或密码,或选择用户角色');
    }else {
        if(userPwd==userPwdConfirm){
            $.ajax({
                url:'register',
                method:'post',
                data:'userName='+userName+'&userPwd='+userPwd+'&userRole='+userRole,
                success:function (data) {
                    if(1==data){
                        setCookie("userName",userName);
                        alert('注册成功！')
                        window.location.href = '/login';
                    }else{
                        alert('注册失败！账号名重复');
                    }
                },
                error:function () {
                    console.log('ajax Fail!');
                }


            })
        }else{
            alert('两次输入密码不一致，请重新输入！');
        }
    }

}