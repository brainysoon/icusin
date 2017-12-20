<%@ page import="com.icusin.web.support.OSSHelper" %><%--
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

  <title>我的表亲</title>

</head>
<body>

<!-- 顶部导入 -->
<%@ include file="../fix/top.jsp" %>

<!-- 内容 -->
<div class="am-g am-g-fixed am-margin-top">
  <div class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <div class="am-g am-g-fixed am-cf am-padding">
        我的表亲
        <a class="am-btn am-btn-primary am-btn-sm am-fr" href="/cusin/add">
          <i class="am-icon-plus"></i> 添加表亲</a>
      </div>
    </div>
    <div class="am-panel-bd">
      <div class="am-g am-g-fixed">
        <c:forEach items="${cusins.myCusins}" var="cusin">

          <div class="am-u-md-4">
            <div class="am-thumbnail">
              <img src="<%=OSSHelper.BUCKET_ICUSIN_IMG_OPEN_READ_URI_PRE_FIX%>/${cusin.base.cusinPhoto}.png" alt=""/>
              <div class="am-thumbnail-caption">
                <h3>表亲名：${cusin.base.cusinName}</h3>
                <p>关系：${cusin.base.relName}</p>
                <p>
                  <button class="am-btn am-btn-primary">查看详情</button>
                </p>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
</div>

<!-- 底部导入 -->
<%@ include file="../fix/bottom.jsp" %>

<!-- 尾部相应的导入 -->
<%@ include file="../fix/footer.jsp" %>
</body>
</html>
