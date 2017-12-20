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

    <!-- DateTimePicker -->
    <link href="/resources/public/assets/css/bootstrap-datetimepicker.css" rel="stylesheet">

    <!-- FileInput Plugins -->
    <link href="/resources/public/assets/css/fileinput.css" rel="stylesheet">
    <link href="/resources/public/assets/themes/explorer/theme.css" media="all" rel="stylesheet" type="text/css"/>
</head>

<body>

<!-- **********************************************************************************************************************************************************
MAIN CONTENT
*********************************************************************************************************************************************************** -->

<div id="login-page">
    <div class="container">

        <form class="form-cusin-add"
              action="<%=UriConstant.ICUSIN_CUSIN_INFO_PREFIX_URI+UriConstant.ICUSIN_CUSIN_ADD_URI%>"
              method="post">
            <h2 class="form-login-heading">添加表亲</h2>
            <div class="login-wrap">
                <div class="form-group">
                    <input class="form-control" name="cusinName" placeholder="表亲名" autofocus>
                    <span class="help-block"></span>
                </div>
                <div class="row">
                    <div class="form-group col-xs-4">
                        <div class="form-inline">
                            <label>性别: &nbsp;</label>
                            <select class="form-control" name="cusinSex">
                                <option value="0">男</option>
                                <option value="1">女</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group col-xs-8">
                        <div class="form-inline">
                            <label>可见权限:&nbsp;</label>
                            <select class="form-control" name="cusinPerms">
                                <option value="0">仅自己</option>
                                <option value="1">仅自己表亲</option>
                                <option value="2">所有人</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="input-group date form_date" data-date="1996-01-15"
                         data-date-format="yyyy年 MM月 dd日"
                         data-link-field="dtp_input2" data-link-format="yyyy-MM-dd">
                        <input class="form-control" size="16" value="" placeholder="生日" readonly>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                    </div>
                    <input type="hidden" id="dtp_input2" name="cusinBirthday" value="1996-01-15"/><br/>
                </div>
                <div class="form-group">
                    <div class="input-group">
                        <input class="form-control" id="cusinPhoto" name="cusinPhoto" value="" placeholder="上传照片"
                               data-toggle="modal" data-target="#uploadPhoto" readonly>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-upload"></span></span>
                    </div>
                    <span class="help-block"></span>
                </div>
                <div class="form-inline mt-2 mb-4">
                    <div data-toggle="distpicker">区域:&nbsp;
                        <select class="form-control" data-province="选择省"></select>
                        <select class="form-control" data-city="选择市"></select>
                        <select class="form-control" data-district="选择区" name="cusinRefArea"></select>
                    </div>

                    <span class="help-block"></span>
                </div>
                <div class="form-group">
                    <input class="form-control" name="cusinAdd" placeholder="详细地址" autofocus>
                    <span class="help-block"></span>
                </div>
                <button class="btn btn-theme btn-block">立即添加</button>
                <hr>
                <div class="registration">
                    添加之前请仔细阅读<br/>
                    <a class="" href="#">
                        表亲隐私协议
                    </a>
                </div>
            </div>
        </form>

    </div>
</div>

<!-- 上传头像model -->
<div class="modal fade" id="uploadPhoto" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">上传照片</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <label for="input-b9">选择图片</label>
                <div class="file-loading">
                    <input id="input-b9" name="fileData" multiple type="file">
                </div>
                <div id="kartik-file-errors"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<!-- js placed at the end of the document so the pages load faster -->
<script src="/resources/public/assets/js/jquery.js"></script>
<script src="/resources/public/assets/js/bootstrap.min.js"></script>

<!--BACKSTRETCH-->
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="text/javascript" src="/resources/public/assets/js/jquery.backstretch.min.js"></script>

<!-- DateTimePicker -->
<script src="/resources/public/assets/js/bootstrap-datetimepicker.js"></script>
<script src="/resources/public/assets/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>

<!-- DistPicker -->
<script src="/resources/public/assets/js/distpicker.js"></script>

<!-- FileInput Plugins -->
<script src="/resources/public/assets/js/plugins/sortable.js" type="text/javascript"></script>
<script src="/resources/public/assets/js/fileinput.js" type="text/javascript"></script>
<script src="/resources/public/assets/js/locales/zh.js" type="text/javascript"></script>
<script src="/resources/public/assets/themes/explorer/theme.js" type="text/javascript"></script>
<script>
    $.backstretch("/resources/public/assets/img/login-bg.jpg", {speed: 500});

    $('.form_date').datetimepicker({
        language: 'zh-CN',
        weekStart: 1,
        todayBtn: 1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });

    $(document).on('ready', function () {

        // 配置照片上传
        $("#input-b9").fileinput({
            showPreview: true,
            showUpload: true,
            elErrorContainer: '#kartik-file-errors',
            allowedFileExtensions: ["jpg", "png", "gif", "jpeg"],
            language: 'zh',
            uploadUrl: '<%=UriConstant.ICUSIN_UPLOAD_IMG%>'
        });

        // 照片上传完成事件
        $('#input-b9').on('fileuploaded', function (event, data, previewId, index) {

            // 获得后台处理过的图片名称
            $("#cusinPhoto").val(data.response.data);
        });
    });
</script>

</body>
</html>
