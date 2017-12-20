<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fix/import.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>

    <!-- 头部相同的部分采用导入 -->
    <%@ include file="../fix/header.jsp" %>

    <!-- Bootstrap core CSS -->
    <link href="/resources/public/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/resources/public/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>

    <!-- Custom styles for this template -->
    <link href="/resources/public/assets/css/style.css" rel="stylesheet">
    <link href="/resources/public/assets/css/style-responsive.css" rel="stylesheet">
</head>

<body>

<!-- **********************************************************************************************************************************************************
MAIN CONTENT
*********************************************************************************************************************************************************** -->

<div id="login-page">
    <div class="container">

        <form class="form-login" id="register-form" action="/user/register" method="post">
            <h2 class="form-login-heading">注册</h2>
            <div class="login-wrap">
                <div class="form-group">
                    <input class="form-control" name="userAccount" placeholder="账号" autofocus>
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <input class="form-control" name="userEmail" placeholder="邮箱" autofocus>
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <input class="form-control" id="userShadow" name="userShadow" type="password" placeholder="密码"
                           autofocus>
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" name="reUserShadow"
                           placeholder="确认密码">
                    <span class="help-block"></span>
                </div>
                <button class="btn btn-theme btn-block">立即注册</button>
                <hr>
                <div class="registration">
                    注册之前请仔细阅读<br/>
                    <a class="" href="#">
                        网站协议
                    </a>
                </div>
            </div>
        </form>

    </div>
</div>

<!-- js placed at the end of the document so the pages load faster -->
<script src="/resources/public/assets/js/jquery.js"></script>
<script src="/resources/public/assets/js/bootstrap.min.js"></script>

<!-- 校验 -->
<script src="/resources/public/assets/js/plugins/validation/jquery.validate.js"></script>
<script src="/resources/public/assets/js/custom/common-validation.js"></script>
<script src="/resources/public/assets/js/custom/register-validation.js"></script>

<!--BACKSTRETCH-->
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="text/javascript" src="/resources/public/assets/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("/resources/public/assets/img/login-bg.jpg", {speed: 500});

    // 初始化校验
    initCustomValidation();
</script>

</body>
</html>
