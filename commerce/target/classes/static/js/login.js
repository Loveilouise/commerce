function login() {
    var userName = document.getElementById('userName').value;
    var userPwd = document.getElementById('userPwd').value;
    // var userRole
    // var inputs = document.getElementsByName("userRole");
    // for (var i = 0; i < inputs .length; i++) {
    //     if (inputs [i].checked) {
    //         userRole = inputs[i].value;
    //     }
    //     }
    //     if(undefined!=userRole){
    //         console.log("userName:"+userName);
    //         console.log("userPwd:"+userPwd);
    //         console.log("userRole:"+userRole);
    //     }else {
    //     alert("请选择用户角色");
    //     }
        $.ajax({
            type:'post',
            url:'/userLogin',
            data:'userName='+userName+'&userPwd='+userPwd,
            success:function (data) {
                console.log("ajax suceess");
                if(0!=data&&1!=data&2!==data){
                    alert('登录失败，用户名或密码错误');
                }else{
                    alert('登陆成功');
                    setCookie('userName',userName);
                    setCookie('userRole',data);
                    window.location.href = '/index' ;

                }
            },
            error:function () {
                console.log("ajax fail");
            }
        })

}
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