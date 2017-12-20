<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fix/import.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">

  <!-- 头部导入 -->
  <%@ include file="../fix/header.jsp" %>

  <title>添加回忆录</title>

</head>
<body>

<!-- 顶部导入 -->
<%@ include file="../fix/top.jsp" %>

<!-- 头部 -->
<div class="header">
  <div class="am-g">
    <h1>添加回忆录</h1>
  </div>
  <hr/>
</div>

<!-- 添加回忆录表单 -->
<div class="am-g">
  <div class="am-u-md-10 am-u-lg-10 am-u-sm-10 am-u-sm-centered">
    <form id="add-memoir-form" action="/memoir/add" method="post" class="am-form">

      <!-- 回忆录标题 -->
      <div class="am-form-group">
        <div class="am-g am-g-fixed">
          <div class="am-u-md-10">
            <label for="memoirTitle">标题:</label>
            <input class="am-form-field" type="text" name="memoirTitle" id="memoirTitle" value="">
          </div>
        </div>
      </div>

      <!-- 回忆录简介 -->
      <div class="am-form-group">
        <div class="am-g am-g-fixed">
          <div class="am-u-md-10">
            <label for="memoirDigest">简介:</label>
            <textarea class="am-form-field" type="password"
                      rows="6" name="memoirDigest" id="memoirDigest" value=""></textarea>
          </div>
        </div>
      </div>

      <!-- 分类和所属表亲 -->
      <div class="am-form-group">
        <div class="am-g am-g-fixed">
          <div class="am-u-md-6">
            <div class="am-form-group">
              <label for="catgRefId">分类:</label>
              <select id="catgRefId" name="catgRefId">
                <option value="0">默认分类</option>
              </select>
            </div>
          </div>
          <div class="am-u-md-6">
            <label for="cusinRefId">所属表亲:</label>
            <select name="cusinRefId" id="cusinRefId">
              <c:forEach items="${addMemoirVO.myCusins}" var="item">
                <option value="${item.base.id}">${item.base.cusinName}</option>
              </c:forEach>
            </select>
          </div>
        </div>
      </div>

      <!-- 回忆录内容 -->
      <div class="am-form-group text-center">
        <label for="content">内容：</label>
        <!--　编辑器导入　-->
        <input type="hidden" id="content" name="content">
        <%@ include file="../fragment/editor.jsp" %>
      </div>
      <div class="am-cf">
        <input type="submit" name="" value="立即添加" onclick="bindContentToInput()" class="am-btn am-btn-primary am-fl">
      </div>
    </form>

    <!--　登录协议　-->
    <hr>
    <p>添加回忆录前请仔细阅读<a href="#">表亲网站协议</a></p>

  </div>
</div>

<!-- 底部导入 -->
<%@ include file="../fix/bottom.jsp" %>

<!-- 尾部导入 -->
<%@ include file="../fix/footer.jsp" %>

<!-- 校验 -->
<script src="/assets/js/plugins/validation/jquery.validate.js"></script>
<script src="/assets/js/custom/add-memoir-validation.js"></script>

<script>

  // 将文档的内容绑定到制定的input
  function bindContentToInput() {

    $("#content").val(ue.getContent());
  }

  // 文档就绪
  $(document).ready(function () {

    // 初始化校验
    initCustomValidation();
  });

</script>

</body>
</html>
