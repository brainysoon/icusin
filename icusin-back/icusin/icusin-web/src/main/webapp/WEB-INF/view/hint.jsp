<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fix/import.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>

    <!-- 头部相同的部分采用导入 -->
    <%@ include file="fix/header.jsp" %>

    <!-- Bootstrap core CSS -->
    <link href="/resources/public/assets/css/bootstrap.css" rel="stylesheet">
    <!-- FONT AWESOME CSS -->
    <link href="/resources/public/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <!--GOOGLE FONT -->
    <link href='http://fonts.googleapis.com/css?family=Nova+Flat' rel='stylesheet' type='text/css'>
    <!-- custom CSS here -->
    <link href="/resources/public/assets/css/style.css" rel="stylesheet"/>
</head>
<body style="background-color: #B396FF;">
<div class="container error-theme">

    <div class="row pad-top text-center">
        <div class="col-md-6 col-md-offset-3 text-center">
            <h1> ${hint.hint} </h1>
        </div>
    </div>

    <div class="row text-center">
        <div class="col-md-8 col-md-offset-2">

            <h3>
                <c:choose>
                    <c:when test="${hint==null}">
                        <i class="fa fa-lightbulb-o fa-5x"></i>
                    </c:when>
                    <c:otherwise>
                        <i class="fa ${hint.hintIcon} fa-5x"></i>
                    </c:otherwise>
                </c:choose>
            </h3>
            <a href="${hint.backLink}" class="btn btn-primary btn-theme">${hint.backTitle}</a>
        </div>
    </div>
</div>
<!-- /.container -->


<!--Core JavaScript file  -->
<script src="/resources/public/assets/js/jquery-1.8.3.min.js"></script>
<!--bootstrap JavaScript file  -->
<script src="/resources/public/assets/js/bootstrap.min.js"></script>
</body>
</html>
