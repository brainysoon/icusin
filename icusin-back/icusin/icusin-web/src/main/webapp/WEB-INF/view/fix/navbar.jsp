<%--
  Created by IntelliJ IDEA.
  User: brainy
  Date: 17-10-3
  Time: 下午10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">

        <!-- brand and collapse -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#navbar-expand" aria-expanded="false">
                <span class="sr-only">打开菜单</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Icusin</a>
        </div>

        <!--　Collect the nav links, forms, and other content for toggling　-->
        <div class="collapse navbar-collapse" id="navbar-expand">
            <ul class="nav navbar-nav navbar-right">
                <li class="active"><a href="#">表亲<span class="sr-only"></span></a></li>
                <li><a href="#">回忆录</a></li>
                <c:choose>
                    <c:when test="${profile==null}">
                        <li><a href="#">登录</a></li>
                    </c:when>
                    <c:otherwise>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"
                               aria-expanded="false">用户<span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">个人中心</a></li>
                                <li><a href="#">设置</a></li>
                                <li><a href="#">退出</a></li>
                            </ul>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>