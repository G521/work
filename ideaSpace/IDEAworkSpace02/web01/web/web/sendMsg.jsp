<%--
  Created by IntelliJ IDEA.
  User: Void
  Date: 2020/1/8
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title></title>
    <script type="text/javascript">
        function post() {
            var xmlhttp;
            var uname = document.getElementById("uname");
            var pwd = document.getElementById("pwd");
            if (window.XMLHttpRequest) {
                xmlhttp = new XMLHttpRequest();
            } else {
                xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
            }
            xmlhttp.onreadystatechange = function () {
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    document.getElementById("result1").innerHTML = xmlhttp.responseText;
                }
                xmlhttp.open("get", "web?uname="+uname+"", true);
                xmlhttp.send();
            }
        }
    </script>
</head>
<body>
<div id="div1">
    <form action="" onkeyup="post()" method="get">
        名字：<input type="text" name="name" id="uname" value="" />
        密码： <input type="password" name="pwd" id="psd" value="" />
        <input type="submit" value="登录"/>
    </form>
</div>
<div id="div2">
    <h6><span id="result1">

			</span></h6>
</div>
</body>
</html>