<%--
  Created by IntelliJ IDEA.
  User: brainy
  Date: 17-10-5
  Time: 上午10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js">
<head>

  <!-- 头部相关导入 -->
  <%@ include file="../fix/header.jsp" %>

  <title>回忆录详情</title>

</head>
<body>

<!-- 顶部导入 -->
<%@ include file="../fix/top.jsp" %>

<!--　内容　-->
<header class="am-g am-g-fixed am-text-center am-margin-top">
  <div class="am-u-sm-12 am-article">
    <h1 class="am-article-title">${memoirDetail.memoir.base.memoirTitle}</h1>
    <p class="am-article-meta">所属表亲：${memoirDetail.memoir.base.cusinName}</p>
  </div>
</header>

<hr class="am-article-divider"/>
<div class="am-g am-g-fixed">
  <div class="am-u-md-9 am-u-md-push-3">
    <div class="am-g">
      <div class="am-u-sm-11 am-u-sm-centered">
        <div class="am-cf am-article">

          <div>
            ${memoirDetail.memoir.base.memoirContent}
          </div>

          <!-- 导入评论 -->
          <%@ include file="../fragment/comment.jsp" %>
        </div>
      </div>
    </div>
  </div>
  <div class="am-u-md-3 am-u-md-pull-9 memoir-sidebar">
    <div class="am-offcanvas" id="sidebar">
      <div class="am-offcanvas-bar">
        <ul class="am-nav">
          <li><a href="#">永远的蝴蝶</a></li>
          <li class="am-nav-header">目录</li>
          <li><a href="#">文章赏析</a></li>
          <li><a href="#">读者评论</a></li>
        </ul>
      </div>
    </div>
  </div>
  <a href="#sidebar" class="am-btn am-btn-sm am-btn-success am-icon-bars am-show-sm-only memoir-button"
     data-am-offcanvas><span class="am-sr-only">侧栏导航</span></a>
</div>
<!-- 底部导入 -->
<%@ include file="../fix/bottom.jsp" %>

<!-- 尾部相应的导入 -->
<%@ include file="../fix/footer.jsp" %>
</body>
</html>
