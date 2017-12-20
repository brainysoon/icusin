<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

  <title>我的回忆录</title>

</head>
<body>

<!-- 顶部导入 -->
<%@ include file="../fix/top.jsp" %>

<!--　内容　-->
<div class="am-g am-g-fixed am-margin-top">
  <div class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <div class="am-g am-g-fixed am-cf am-padding">
        我的回忆录
        <a class="am-btn am-btn-primary am-btn-xs am-fr" href="/memoir/add">
          <i class="am-icon-plus"></i> 添加回忆录</a>
      </div>
    </div>
    <div class="am-panel-bd">
      <ul class="am-list am-list-static am-list-border">
        <c:forEach items="${memoirs.memoirInfoBO.bases}" var="memoir">
          <li>
            <h3 class="am-article-title">
              <a href="#">${memoir.memoirTitle}</a>
            </h3>
            <h4 class="am-article-meta">撰写于： <fmt:formatDate value="${memoir.gmtCreate}" pattern="yyyy-MM-dd HH:mm:ss"/>
              上次修改时间：<fmt:formatDate value="${memoir.gmtModified}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </h4>

            <div class="am-g am-padding">
                ${memoir.memoirDigest}
            </div>
            <div class="am-g am-padding">
              <a class="am-btn am-btn-primary" href="/memoir/detail/${memoir.id}">查看详情</a>
            </div>
          </li>
        </c:forEach>
      </ul>
    </div>
  </div>
</div>

<!-- 底部导入 -->
<%@ include file="../fix/bottom.jsp" %>

<!-- 尾部相应的导入 -->
<%@ include file="../fix/footer.jsp" %>
</body>
</html>
