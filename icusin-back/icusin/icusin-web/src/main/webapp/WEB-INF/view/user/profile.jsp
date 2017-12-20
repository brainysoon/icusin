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

  <title>个人中心</title>

</head>
<body>

<!-- 顶部导入 -->
<%@ include file="../fix/top.jsp" %>

<!--　内容　-->
<div class="am-g am-g-fixed am-margin-top">

  <!-- 侧边栏信息 -->
  <div class="am-u-md-4">
    <div class="am-panel-group">

      <!-- 基本信息 -->
      <div class="am-panel am-panel-default">
        <div class="am-panel-hd">基本信息</div>
        <div class="am-panel-bd">

          <!-- 头像 -->
          <div class="am-g am-text-center">
            <img src="/assets/i/avatar.png" class="am-circle">
          </div>

          <!-- 其他信息 -->
          <ul class="am-list am-list-static am-list-border">
            <li>昵称：</li>
            <li>账号：</li>
            <li>邮箱：</li>
            <li>号码：</li>
            <li>等级：</li>
            <li>积分：</li>
          </ul>
        </div>
      </div>

      <!-- 详细信息 -->
      <div class="am-panel am-panel-default">
        <div class="am-panel-hd">详细信息</div>
        <div class="am-panel-bd">
          <ul class="am-list am-list-static am-list-border">
            <li>姓名：</li>
            <li>生日：</li>
            <li>职业：</li>
            <li>地址：</li>
          </ul>
        </div>
      </div>
    </div>
  </div>

  <!-- 回忆录 -->
  <div class="am-u-md-8">

    <div class="am-panel-group">
      <div class="am-panel am-panel-default">

        <div class="am-panel-hd">与我相关的回忆录</div>

        <div class="am-panel-bd">
          <!-- 评论容器 -->
          <ul class="am-comments-list am-comments-list-flip">

            <li class="am-comment">
              <a href="#">
                <img src="/assets/i/avatar.png" alt="" class="am-comment-avatar" width="48" height="48"/>
              </a>

              <div class="am-comment-main">
                <header class="am-comment-hd">
                  <h3 class="am-comment-title">回忆录标题</h3>
                  <div class="am-comment-meta">
                    <a href="#" class="am-comment-author">某人</a>
                    发表于
                    <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30
                    </time>
                  </div>
                </header>

                <div class="am-comment-bd">
                  回忆录内容
                </div>
              </div>
            </li>
          </ul>
        </div>
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
