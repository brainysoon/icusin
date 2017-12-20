<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="fix/import.jsp" %>
<html lang="zh">
<head>

    <!-- 头部相同的部分采用导入 -->
    <%@ include file="fix/header.jsp" %>

    <!-- Bootstrap core CSS -->
    <link href="/resources/public/assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="/resources/public/assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="/resources/public/assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="/resources/public/assets/js/gritter/css/jquery.gritter.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/public/assets/lineicons/style.css">

    <!-- Custom styles for this template -->
    <link href="/resources/public/assets/css/style.css" rel="stylesheet">
    <link href="/resources/public/assets/css/style-responsive.css" rel="stylesheet">

    <script src="/resources/public/assets/js/chart-master/Chart.js"></script>
</head>

<body>

<section id="container">

    <!-- 顶部导入 -->
    <%@ include file="fix/navbar.jsp" %>

    <!-- **********************************************************************************************************************************************************
    MAIN CONTENT
    *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">

            <div class="row">

                <div class="col-lg-9 ds">

                </div>

                <!-- **********************************************************************************************************************************************************
                RIGHT SIDEBAR CONTENT
                *********************************************************************************************************************************************************** -->
                <div class="col-lg-3 ds">
                    <!--COMPLETED ACTIONS DONUTS CHART-->
                    <h3>最新表亲</h3>

                    <!-- First Action -->
                    <div class="desc">
                        <div class="thumb">
                            <span class="badge bg-theme"><i class="fa fa-clock-o"></i></span>
                        </div>
                        <div class="details">
                            <p>
                                <muted>2017年-10月-03日</muted>
                                <br/>
                                <a href="/resources/public/#">表亲</a> 标题<br/>
                            </p>
                        </div>
                    </div>

                    <!-- USERS ONLINE SECTION -->
                    <h3>最新回忆录</h3>
                    <!-- First Member -->
                    <div class="desc">
                        <div class="thumb">
                            <img class="img-circle" src="/resources/public/assets/img/ui-divya.jpg" width="35px"
                                 height="35px" align="">
                        </div>
                        <div class="details">
                            <p><a href="/resources/public/#">表亲</a><br/>
                                <muted>详情</muted>
                            </p>
                        </div>
                    </div>

                </div><!-- /col-lg-3 -->
            </div>
            <!--/row -->
        </section>
    </section>

    <!-- 底部导入 -->
    <%@ include file="fix/footer.bkup.jsp" %>
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="/resources/public/assets/js/jquery.js"></script>
<script src="/resources/public/assets/js/jquery-1.8.3.min.js"></script>
<script src="/resources/public/assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="/resources/public/assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="/resources/public/assets/js/jquery.scrollTo.min.js"></script>
<script src="/resources/public/assets/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="/resources/public/assets/js/jquery.sparkline.js"></script>


<!--common script for all pages-->
<script src="/resources/public/assets/js/common-scripts.js"></script>

<script type="text/javascript" src="/resources/public/assets/js/gritter/js/jquery.gritter.js"></script>
<script type="text/javascript" src="/resources/public/assets/js/gritter-conf.js"></script>

<!--script for this page-->
<script src="/resources/public/assets/js/sparkline-chart.js"></script>
<script src="/resources/public/assets/js/zabuto_calendar.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        var unique_id = $.gritter.add({
            // (string | mandatory) the heading of the notification
            title: '欢迎来到表亲网!',
            // (string | mandatory) the text inside the notification
            text: '你可以免费注册和登录表亲网哦，体验更多功能!!!',
            // (string | optional) the image to display on the left
            image: '/resources/public/assets/img/avatar.png',
            // (bool | optional) if you want it to fade out on its own or just sit there
            sticky: true,
            // (int | optional) the time you want it to be alive for before fading out
            time: '1',
            // (string | optional) the class name you want to apply to that specific message
            class_name: 'my-sticky-class'
        });

        return false;
    });
</script>

<script type="application/javascript">
    $(document).ready(function () {
        $("#date-popover").popover({html: true, trigger: "manual"});
        $("#date-popover").hide();
        $("#date-popover").click(function (e) {
            $(this).hide();
        });

        $("#my-calendar").zabuto_calendar({
            action: function () {
                return myDateFunction(this.id, false);
            },
            action_nav: function () {
                return myNavFunction(this.id);
            },
            ajax: {
                url: "show_data.php?action=1",
                modal: true
            },
            legend: [
                {type: "text", label: "Special event", badge: "00"},
                {type: "block", label: "Regular event",}
            ]
        });
    });


    function myNavFunction(id) {
        $("#date-popover").hide();
        var nav = $("#" + id).data("navigation");
        var to = $("#" + id).data("to");
        console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
    }
</script>
</body>
</html>
