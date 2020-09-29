<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/25
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax的get请求案例</title>
    <script>
        //创建xmlHttpRequest对象的一个全局变量
         var xhr;
         //当浏览器加载完毕之后调用函数
        window.onload=function (ev) {

            //获取按钮元素 绑定一个鼠标单击事件调用函数
            document.getElementById("btn").onclick=function (ev1) {
                //获取文本框内数据
                var info=document.getElementById("info").value;

                //alert(info);
                //获取xmlHttprequest对象;
                if (window.XMLHttpRequest) {
                    xhr=new XMLHttpRequest()
                }else{
                    //判断浏览器是否支持xmlHTTPtequest对象
                    xhr=new  ActiveXObject("Mirsoft.XMLHttp")


                }
                //给xhr绑定回调函数
                xhr.onreadystatechange=callback;
                //获取连接 是否开启一步通信
                xhr.open("get","<%=application.getContextPath() %>/ajax?info="+info,true);
                //发送消息给服务器
                xhr.send(null);


            }
        }
            function callback() {
                //判断状态信息 是否已经获取完毕响应信息
                if (xhr.readyState == 4){
                    //判断http的状态码
                    if (xhr.status == 200){
                        //证明响应获取完毕一切正常 可以获取响应信息了
                        var s=xhr.responseText;
                        document.getElementById("myDiv").innerHTML=s;
                    }

                }
            }

    </script>
</head>
<body>
<input type="text" name="info" id="info">
<button id="btn">我是按钮 </button>
<div id="myDiv"> 我是一个div </div>
</body>
</html>
