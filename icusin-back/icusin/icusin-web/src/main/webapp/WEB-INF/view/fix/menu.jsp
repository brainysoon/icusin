<%--
  Created by IntelliJ IDEA.
  User: brainy
  Date: 17-9-21
  Time: 下午10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">

            <p class="centered"><a href="profile.html"><img src="/resources/public/assets/img/avatar.png"
                                                            class="img-circle"
                                                            width="60"></a></p>
            <h5 class="centered">${profile.userNickname}</h5>

            <li class="mt">
                <a
                        <c:if test="${menu.currentMenuName=='profile'}">class="active"</c:if>
                        href="<%=UriConstant.ICUSIN_USER_INFO_PREFIX_URI+UriConstant.ICUSIN_USER_PROFILE_URI%>">
                    <i class="fa fa-user"></i>
                    <span>个人中心</span>
                </a>
            </li>

            <li class="mt">
                <a
                        <c:if test="${menu.currentMenuName=='cusin'}">class="active"</c:if>
                        href="<%=UriConstant.ICUSIN_USER_INFO_PREFIX_URI+UriConstant.ICUSIN_USER_CUSIN_URI%>">
                    <i class="fa fa-users"></i>
                    <span>我的表亲</span>
                </a>
            </li>

            <li class="mt">
                <a
                        <c:if test="${menu.currentMenuName=='memoir'}">class="active"</c:if>
                        href="<%=UriConstant.ICUSIN_USER_INFO_PREFIX_URI+UriConstant.ICUSIN_USER_MEMOIR_URI%>">
                    <i class="fa fa-tags"></i>
                    <span>我的自传</span>
                </a>
            </li>
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->