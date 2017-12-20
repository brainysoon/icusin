<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fix/import.jsp" %>
<!DOCTYPE html>
<html lang="zh">
<head>

    <!-- 头部相同的部分采用导入 -->
    <%@ include file="../fix/header.jsp" %>

    <!-- Bootstrap core CSS -->
    <link href="/resources/public/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/resources/public/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>

    <!-- Custom styles for this template -->
    <link href="/resources/public/assets/css/style.css" rel="stylesheet">
    <link href="/resources/public/assets/css/style-responsive.css" rel="stylesheet">
</head>

<body>

<!-- **********************************************************************************************************************************************************
MAIN CONTENT
*********************************************************************************************************************************************************** -->

<div id="login-page">
    <div class="container">

        <form class="form-memoir-add"
              action="<%=UriConstant.ICUSIN_MEMOIR_INFO_PREFIX_URI+UriConstant.ICUSIN_MEMOIR_ADD_URI%>" method="post">
            <h2 class="form-login-heading">添加自传</h2>
            <div class="login-wrap">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="form-group">
                            <input class="form-control" name="memoirTitle" placeholder="标题" autofocus>
                            <span class="help-block"></span>
                        </div>
                        <div class="form-group form-inline">
                            <div class="row">
                                <div class="form-inline col-xs-6">
                                    <label>分类:&nbsp;</label>
                                    <select class="form-control" name="catgRefId">
                                        <option value="0">默认分类</option>
                                    </select>
                                </div>
                                <div class="form-inline col-xs-6">
                                    <label>所属表亲</label>
                                    <select class="form-control" name="cusinRefId">
                                        <c:forEach items="${addMemoirVO.myCusins}" var="item">
                                            <option value="${item.base.id}">${item.base.cusinName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <span>简介:&nbsp;</span>
                            <textarea class="form-control" name="memoirDigest" rows="5"
                                      placeholder="请在这儿输入简介"></textarea>
                            <span class="help-block"></span>
                        </div>
                        <button class="btn btn-theme btn-block">立即添加</button>
                    </div>
                    <div class="col-lg-8">
                        <div class="form-group">
                            <label>内容:&nbsp;</label>
                            <textarea class="form-control" name="content" placeholder="请在这里输入自传内容" rows="20"></textarea>
                        </div>
                    </div>
                </div>
                <hr>
                <div class="registration">
                    添加之前请仔细阅读<br/>
                    <a class="" href="#">
                        网站自传协议
                    </a>
                </div>
            </div>
        </form>

    </div>
</div>

<!-- js placed at the end of the document so the pages load faster -->
<script src="/resources/public/assets/js/jquery.js"></script>
<script src="/resources/public/assets/js/bootstrap.min.js"></script>

<!--BACKSTRETCH-->
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="text/javascript" src="/resources/public/assets/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("/resources/public/assets/img/login-bg.jpg", {speed: 500});
</script>

</body>
</html>
