<%--
  Created by IntelliJ IDEA.
  User: brainy
  Date: 17-9-23
  Time: 下午4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fix/import.jsp" %>
<div class="modal-container">
    <div class="modal-title">文章内容</div>
    <div class="modal-body">
        <p>${content.memoirContentBO.base.memoirContent}</p>
    </div>
    <div class="modal-footer"><a href="javascript:;" class="btn btn-primary" data-fancybox-close>关闭</a></div>
</div>