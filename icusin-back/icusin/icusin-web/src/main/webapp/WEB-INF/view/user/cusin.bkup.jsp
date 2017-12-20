<%@ page import="com.icusin.web.support.OSSHelper" %>
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

    <!-- Custom styles for this template -->
    <link href="/resources/public/assets/css/style.css" rel="stylesheet">
    <link href="/resources/public/assets/css/style-responsive.css" rel="stylesheet">

    <script src="/resources/public/assets/js/chart-master/Chart.js"></script>
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
            <h3><i class="fa fa-angle-right"></i>我的表亲<a class="btn btn-primary pull-right"
                                                        href="<%=UriConstant.ICUSIN_CUSIN_INFO_PREFIX_URI+UriConstant.ICUSIN_CUSIN_ADD_URI%>">添加表亲</a>
            </h3>
            <div class="row mt">
                <div class="col-lg-12">
                    <c:forEach items="${cusins.myCusins}" var="cusin" varStatus="status">

                        <c:if test="${status.index%3==0}">
                            <!-- 3RD ROW OF PANELS -->
                            <!-- Product Panel -->
                            <div class="row">
                        </c:if>

                        <!-- Spotify Panel -->
                        <div class="col-lg-4 col-md-4 col-sm-4 mb">
                            <div class="content-panel pn">
                                <div id="spotify"
                                        <c:if test="${cusin.base.cusinPhoto!=null}">
                                            style=" background: url(<%=OSSHelper.BUCKET_ICUSIN_IMG_OPEN_READ_URI_PRE_FIX%>/${cusin.base.cusinPhoto}.png) no-repeat center top;"
                                        </c:if>>
                                    <div class="sp-title">
                                        <h3>${cusin.base.cusinName}</h3>
                                    </div>
                                    <div class="play">
                                        <a class="btn btn-info">查看详情</a>
                                    </div>
                                </div>
                                <p class="followers"><i class="fa fa-user"></i> ${status.index+1}</p>
                            </div>
                        </div>

                        <c:if test="${(status.index+1)%3==0 || status.index==cusins.myCusins.size()-1}">
                            <!--/col-md-4-->
                            </div>
                            <!-- END 3RD ROW OF PANELS -->
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!--/wrapper -->
    </section>
    <!-- /MAIN CONTENT -->
    <!--main content end-->

    <!-- 底部导入 -->
    <%@ include file="../fix/footer.bkup.jsp" %>

</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="/resources/public/assets/js/jquery.js"></script>
<script src="/resources/public/assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="/resources/public/assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="/resources/public/assets/js/jquery.scrollTo.min.js"></script>
<script src="/resources/public/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="/resources/public/assets/js/jquery.sparkline.js"></script>

<!--common script for all pages-->
<script src="/resources/public/assets/js/common-scripts.js"></script>

<!--script for this page-->
<script src="/resources/public/assets/js/sparkline-chart.js"></script>


<script>
    //custom select box

    $(function () {
        $('select.styled').customSelect();
    });

</script>

</body>
</html>
