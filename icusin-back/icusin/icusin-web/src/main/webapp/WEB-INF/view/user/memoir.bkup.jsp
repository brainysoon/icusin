<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fix/import.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <!-- 头部相同的部分采用导入 -->
    <%@ include file="../fix/header.jsp" %>

    <!-- Bootstrap core CSS -->
    <link href="/resources/public/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/resources/public/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="/resources/public/assets/css/jquery.fancybox.css" rel="stylesheet"/>
    <!-- Custom styles for this template -->
    <link href="/resources/public/assets/css/style.css" rel="stylesheet">
    <link href="/resources/public/assets/css/style-responsive.css" rel="stylesheet">

    <script src="/resources/public/assets/js/jquery.js"></script>
</head>

<body>

<section id="container">

    <!-- 顶部导入 -->
    <%@ include file="../fix/top.jsp" %>

    <!-- 侧边栏菜单导入 -->
    <%@ include file="../fix/menu.jsp" %>

    <!-- **********************************************************************************************************************************************************
    MAIN CONTENT
    *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper site-min-height">
            <h3><i class="fa fa-angle-right"></i> 我的自传
                <a href="<%=UriConstant.ICUSIN_MEMOIR_INFO_PREFIX_URI+UriConstant.ICUSIN_MEMOIR_ADD_URI%>"
                   class="btn btn-primary pull-right">添加自传</a>
            </h3>
            <c:forEach items="${memoirs.memoirInfoBO.bases}" var="item" varStatus="status">
                <c:if test="${status.index%3==0}">
                    <div class="row mt">
                </c:if>
                <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 desc">
                    <div class="project-wrapper">
                        <div class="project">
                            <div class="photo-wrapper">
                                <div class="photo">
                                    <a class="fancybox" data-fancybox data-type="ajax"
                                       data-src="/memoir/content/${item.contentRefId}"
                                       href="javascript:;">
                                        <div class="img-responsive">
                                            <div class="container memoir-container">
                                                <h3>${item.memoirTitle}</h3>
                                                <blockquote>
                                                    <p>${item.memoirDigest}</p>
                                                </blockquote>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                                <div class="overlay"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- col-lg-4 -->
                <c:if test="${(status.index+1)%3==0||memoirs.memoirInfoBO.bases.size()-1==status.index}">
                    </div>
                    <!-- /row -->
                </c:if>
            </c:forEach>
        </section>
        <!--/wrapper -->
    </section><!-- /MAIN CONTENT -->

    <!-- 底部导入 -->
    <%@ include file="../fix/footer.bkup.jsp" %>
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="/resources/public/assets/js/jquery.fancybox.js"></script>
<script src="/resources/public/assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="/resources/public/assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="/resources/public/assets/js/jquery.scrollTo.min.js"></script>
<script src="/resources/public/assets/js/jquery.nicescroll.js" type="text/javascript"></script>


<!--common script for all pages-->
<script src="/resources/public/assets/js/common-scripts.js"></script>

<!--script for this page-->
<script>
    //custom select box

    $(function () {
        $("select.styled").customSelect();
    });

</script>

</body>
</html>
