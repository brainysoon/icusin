<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fix/import.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">

  <!-- 头部导入 -->
  <%@ include file="fix/header.jsp" %>

  <title>登录表亲</title>

</head>
<body>

<!-- 顶部导入 -->
<%@ include file="fix/top.jsp" %>

<!-- 头部 -->
<div class="header">
  <div class="am-g">
    <h1>表亲网</h1>
    <p>一个综合的人际关系网站！</p>
  </div>
  <hr/>
</div>

<!-- 登录表单 -->
<div class="am-g">
  <div class="am-u-lg-3 am-u-md-4 am-u-sm-centered">
    <!-- 登录错误提示信息 -->
    <div class="am-alert am-alert-danger" id="error-info" data-am-alert hidden>
      <button type="button" class="am-close">&times;</button>
      <p>${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</p>
    </div>

    <h3>登录</h3>
    <hr>
    <form id="login-form" action="/login" method="post" class="am-form">
      <div class="am-form-group">
        <label for="username">账号/邮箱/手机号:</label>
        <input class="am-form-field" type="text" name="username" id="username" value="">
      </div>
      <div class="am-form-group">
        <label for="password">密码:</label>
        <input class="am-form-field" type="password" name="password" id="password" value="">
      </div>
      <div class="am-form-group">
        <label for="remember">
          <input id="remember" name="remember" type="checkbox" value="true" checked>
          记住我
        </label>
      </div>
      <div class="am-cf">
        <input type="submit" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl">
        <input type="submit" name="" value="忘记密码 ^_^? " class="am-btn am-btn-default am-btn-sm am-fr">
      </div>
    </form>

    <!--　登录协议　-->
    <hr>
    <p>登录前请仔细阅读<a href="#">表亲网站协议</a></p>

  </div>
</div>

<!-- 底部导入 -->
<%@ include file="fix/bottom.jsp" %>

<!-- 尾部导入 -->
<%@ include file="fix/footer.jsp" %>

<!-- 校验 -->
<script src="/assets/js/plugins/validation/jquery.validate.js"></script>
<script src="/assets/js/custom/login-validation.js"></script>
<script src="/assets/js/custom/common-validation.js"></script>

<script>

  // 文档就绪
  $(document).ready(function () {

    //　是否有错误提示
    if (location.search.indexOf('error') !== -1) {
      $("#error-info").show();
    } else {
      $("#error-info").hide();
    }

    // 初始化校验
    initCustomValidation();
  });

</script>

</body>
</html>
