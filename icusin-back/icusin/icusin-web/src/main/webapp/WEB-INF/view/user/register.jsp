<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fix/import.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">

  <!-- 头部导入 -->
  <%@ include file="../fix/header.jsp" %>

  <title>免费注册表亲</title>

</head>
<body>

<!-- 顶部导入 -->
<%@ include file="../fix/top.jsp" %>

<!-- 头部 -->
<div class="header">
  <div class="am-g">
    <h1>表亲网</h1>
    <p>一个综合的人际关系网站！</p>
  </div>
  <hr/>
</div>

<!-- 注册表单 -->
<div class="am-g">
  <div class="am-u-lg-3 am-u-md-4 am-u-sm-centered">

    <h3>注册</h3>
    <hr>
    <form id="register-form" action="/user/register" method="post" class="am-form">
      <div class="am-form-group">
        <label for="userAccount">账号:</label>
        <input class="am-form-field" type="text" name="userAccount" id="userAccount" value="">
      </div>
      <div class="am-form-group">
        <label for="userEmail">邮箱:</label>
        <input class="am-form-field" type="text" name="userEmail" id="userEmail" value="">
      </div>
      <div class="am-form-group">
        <label for="userShadow">密码:</label>
        <input class="am-form-field" type="password" name="userShadow" id="userShadow" value="">
      </div>
      <div class="am-form-group">
        <label for="reUserShadow">确认密码:</label>
        <input class="am-form-field" type="password" name="reUserShadow" id="reUserShadow" value="">
      </div>
      <div class="am-cf">
        <input type="submit" name="" value="立即注册" class="am-btn am-btn-primary am-btn-sm">
      </div>
    </form>

    <!--　登录协议　-->
    <hr>
    <p>登录前请仔细阅读<a href="#">表亲网站协议</a></p>

  </div>
</div>

<!-- 底部导入 -->
<%@ include file="../fix/bottom.jsp" %>

<!-- 尾部导入 -->
<%@ include file="../fix/footer.jsp" %>

<!-- 校验 -->
<script src="/assets/js/plugins/validation/jquery.validate.js"></script>
<script src="/assets/js/custom/register-validation.js"></script>
<script src="/assets/js/custom/common-validation.js"></script>

<script>

  // 文档就绪
  $(document).ready(function () {

    // 初始化校验
    initCustomValidation();
  });

</script>

</body>
</html>
