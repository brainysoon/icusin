<%@ page import="com.icusin.common.constant.ConfigConsts" %><%--
  Created by IntelliJ IDEA.
  User: brainy
  Date: 17-9-21
  Time: 下午10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--footer start-->
<footer class="site-footer">
    <div class="text-center">
        &copy; 2017 版权所有 <a href="<%=ConfigConsts.HTTPS_WWW_SERVER_ADD%>" target="_blank"
                            title="<%=ConfigConsts.WWW_SERVER_NAME_ZH%>"><%=ConfigConsts.WWW_SERVER_NAME_ZH%>
    </a>
        - <%=ConfigConsts.WWW_SERVER_SLOGAN%>
        <a href="top#" class="go-top">
            <i class="fa fa-angle-up"></i>
        </a>
    </div>
</footer>
<!--footer end-->