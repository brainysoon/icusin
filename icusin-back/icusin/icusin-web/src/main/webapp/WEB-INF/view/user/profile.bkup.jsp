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
