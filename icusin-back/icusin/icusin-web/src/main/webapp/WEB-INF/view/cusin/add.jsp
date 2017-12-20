<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../fix/import.jsp" %>
<!DOCTYPE html>
<html>
<head lang="en">

  <!-- 头部导入 -->
  <%@ include file="../fix/header.jsp" %>

  <title>添加表亲</title>

</head>
<body>

<!-- 顶部导入 -->
<%@ include file="../fix/top.jsp" %>

<!-- 头部 -->
<div class="header">
  <div class="am-g">
    <h1>添加表亲</h1>
  </div>
  <hr/>
</div>

<!-- 添加表亲表单 -->
<div class="am-g">
  <div class="am-u-lg-3 am-u-md-4 am-u-sm-centered">
    <form id="add-cusin-form" action="/cusin/add" method="post" class="am-form">

      <!-- 表亲名 -->
      <div class="am-form-group">
        <label for="cusinName">表亲名:</label>
        <input class="am-form-field" type="text" name="cusinName" id="cusinName" value="">
      </div>

      <!-- 性别 -->
      <div class="am-form-group">
        <label for="cusinSex">性别:</label>
        <label class="am-radio-inline">
          <input id="cusinSex" type="radio" value="0" name="cusinSex" checked> 男
        </label>
        <label class="am-radio-inline">
          <input type="radio" value="1" name="cusinSex"> 女
        </label>
      </div>

      <!-- 关系和权限 -->
      <div class="am-form-group">
        <div class="am-g am-g-fixed">
          <div class="am-u-md-6">
            <label for="cusinPerms">可见权限:</label>
            <select id="cusinPerms" name="cusinPerms">
              <option value="0">仅自己</option>
              <option value="1">仅自己表亲</option>
              <option value="2">所有人</option>
            </select>
            <span class="am-form-caret"></span>
          </div>
          <div class="am-u-md-6">
            <label for="relRefId">关系:</label>
            <select id="relRefId" name="relRefId">
              <c:forEach items="${addCusin.cusinRelBO.bases}" var="cusinRel">
                <option value="${cusinRel.id}">${cusinRel.relName}</option>
              </c:forEach>
            </select>
            <span class="am-form-caret"></span>
          </div>
        </div>
      </div>

      <!-- 生日 -->
      <div class="am-form-group">
        <label for="cusinBirthday">生日:</label>
        <input class="am-form-field" type="text" placeholder="点击选择日期"
               data-am-datepicker="{theme: 'success'}"
               name="cusinBirthday" id="cusinBirthday" readonly/>
      </div>

      <!-- 照片 -->
      <div class="am-form-group">
        <label for="cusinPhoto">照片:</label>
        <input class="am-form-field" id="cusinPhoto" name="cusinPhoto" value="" placeholder="上传照片" readonly>
      </div>

      <!-- 区域 -->
      <div class="am-form-group">
        <div class="am-inline">
          <label for="areaRefId">区域:</label>
          <div data-toggle="distpicker" class="am-g am-g-fixed">
            <div class="am-u-md-4">
              <select data-province="选择省"></select>
            </div>
            <div class="am-u-md-4">
              <select data-city="选择市"></select>
            </div>
            <div class="am-u-md-4">
              <select data-district="选择区" id="areaRefId" name="areaRefId"></select>
            </div>
          </div>
        </div>
      </div>

      <!--　详细地址　-->
      <div class="am-form-group">
        <label for="cusinAdd">详细地址:</label>
        <input class="am-form-field" type="text" name="cusinAdd" id="cusinAdd" value="">
      </div>

      <div class="am-cf">
        <input type="submit" name="" value="立即添加" class="am-btn am-btn-primary am-fl">
      </div>
    </form>

    <!--　登录协议　-->
    <hr>
    <p>添加表亲前请仔细阅读<a href="#">表亲网站协议</a></p>

  </div>
</div>

<!-- 底部导入 -->
<%@ include file="../fix/bottom.jsp" %>

<!-- 尾部导入 -->
<%@ include file="../fix/footer.jsp" %>

<!-- 图片上传的模态框 -->
<%@ include file="../fragment/cropper.jsp" %>

<!-- 校验 -->
<script src="/assets/js/plugins/validation/jquery.validate.js"></script>
<script src="/assets/js/custom/add-cusin-validation.js"></script>

<!-- 区域选择 -->
<script src="/assets/js/plugins/distpicker/distpicker.js"></script>

<script>

  $(document).ready(function () {

    // 初始化图片上传
    $("#cusinPhoto").click(function () {
      $("#img-cropper-model").modal({width: '600px'});
    });
    initCropper('<%=UriConstant.ICUSIN_UPLOAD_IMG%>', function (data) {

      $("#cusinPhoto").val(data.data);
    });

    // 初始化校验
    initCustomValidation();
  });

</script>

</body>
</html>
