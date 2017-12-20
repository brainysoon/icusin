<%--
  Created by IntelliJ IDEA.
  User: brainy
  Date: 17-9-21
  Time: 下午10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--header start-->
<header class="am-topbar am-topbar-fixed-top">
  <div class="am-container">
    <h1 class="am-topbar-brand">
      <a href="#">表亲网</a>
    </h1>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-secondary am-show-sm-only"
            data-am-collapse="{target: '#collapse-head'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="collapse-head">
      <ul class="am-nav am-nav-pills am-topbar-nav">
        <li class="am-active"><a href="#">首页</a></li>
        <li><a href="/cusin">表亲</a></li>
        <li><a href="#">回忆录</a></li>
      </ul>

      <!-- 判断是否登录 -->
      <c:choose>
        <c:when test="${profile!=null}">
          <div class="am-topbar-right">
            <div class="am-dropdown" data-am-dropdown="{boundary: '.am-topbar'}">
              <button class="am-btn am-btn-secondary am-topbar-btn am-btn-sm am-dropdown-toggle"
                      data-am-dropdown-toggle>${profile.userNickname} <span class="am-icon-caret-down"></span></button>
              <ul class="am-dropdown-content">
                <li><a href="/user/profile">个人中心</a></li>
                <li><a href="/user/cusin">我的表亲</a></li>
                <li><a href="/user/memoir">我的回忆录</a></li>
                <hr>
                <li><a href="/logout">退出登录</a></li>
              </ul>
            </div>
          </div>
        </c:when>
        <c:otherwise>
          <div class="am-topbar-right">
            <a class="am-btn am-btn-secondary am-topbar-btn am-btn-sm" href="/user/register"><span
                    class="am-icon-pencil"></span> 注册
            </a>
          </div>

          <div class="am-topbar-right">
            <a class="am-btn am-btn-primary am-topbar-btn am-btn-sm" href="/login"><span
                    class="am-icon-user"></span> 登录
            </a>
          </div>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
</header>
<!--header end-->

<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a
href="http://browsehappy.com/" target="_blank">升级浏览器</a>
以获得更好的体验！</p>
<![endif]-->