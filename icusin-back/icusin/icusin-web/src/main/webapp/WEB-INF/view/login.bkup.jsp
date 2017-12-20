<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fix/import.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>

    <!-- 头部相同的部分采用导入 -->
    <%@ include file="fix/header.jsp" %>

    <!-- 标题　-->
    <title>登录表亲</title>

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

        <!-- 登录表单 -->
        <form id="login-form" class="form-login" action="/login" method="post">
            <h2 class="form-login-heading">立即登陆</h2>
            <input id="_rem" type="hidden" name="_rem" value="">
            <div class="login-wrap">
                <div class="form-group">
                    <input class="form-control" name="username" placeholder="账号/邮箱/手机号" autofocus>
                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <input type="password" name="password" class="form-control" placeholder="密码">
                    <span class="help-block"></span>
                </div>
                <div class="form-inline">
                    <div class="form-group">
                        <input class="form-control" type="checkbox" name="remember" value="true">
                        <label>记住我</label>
                    </div>
                    <div class="pull-right">
                        <a data-toggle="modal" href="login.bkup.jsp#myModal">忘记密码?</a>
                    </div>
                </div>
                <div class="form-group">
                    <button class="btn btn-theme btn-block" id="loginBtn"><i class="fa fa-lock"></i>
                        登陆
                    </button>
                    <span class="help-block"
                          id="loginHint">${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</span>
                </div>
                <hr>
                <div class="registration">
                    现在还没有账号？<br/>
                    <a class=""
                       href="<%=UriConstant.ICUSIN_USER_INFO_PREFIX_URI+
                       UriConstant.ICUSIN_USER_REGISTER_URI%>">
                        免费注册
                    </a>
                </div>
            </div>

            <!-- Modal -->
            <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal"
                 class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title">忘记密码 ?</h4>
                        </div>
                        <div class="modal-body">
                            <p>填入你的邮箱，我们将重置密码的链接发送到你的邮箱，请注意查收！</p>
                            <input name="email" placeholder="注册邮箱" autocomplete="off"
                                   class="form-control placeholder-no-fix">
                        </div>
                        <div class="modal-footer">
                            <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
                            <button class="btn btn-theme" type="button">提交</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- modal -->

        </form>

    </div>
</div>

<!-- js placed at the end of the document so the pages load faster -->
<script src="/resources/public/assets/js/jquery.js"></script>
<script src="/resources/public/assets/js/bootstrap.min.js"></script>

<!-- cookie -->
<script src="/resources/public/assets/js/js.cookie.js"></script>

<!-- 校验 -->
<script src="/resources/public/assets/js/plugins/validation/jquery.validate.js"></script>
<script src="/resources/public/assets/js/custom/login-validation.js"></script>

<!--BACKSTRETCH-->
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="text/javascript" src="/resources/public/assets/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("/resources/public/assets/img/login-bg.jpg", {speed: 500});

    // 文档准备就绪
    $(document).ready(function () {

        //　是否有错误提示
        if (location.search.indexOf('error') !== -1) {
            $("#loginBtn").closest('.form-group').addClass('has-error');
        } else {
            $("#loginHint").remove();
        }

        //　自动登录
        $("#_rem").val(Cookies.get('_rem'));

        // 初始化自定义校验
        initCustomValidation();
    });
</script>
</body>
</html>
