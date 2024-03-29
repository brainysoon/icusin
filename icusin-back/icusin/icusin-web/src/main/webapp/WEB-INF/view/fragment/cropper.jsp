<%--
  Created by IntelliJ IDEA.
  User: brainy
  Date: 17-10-5
  Time: 下午9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!--剪切图片ｃｓｓ依赖-->
<link rel="stylesheet" href="/assets/css/amazeui.cropper.css">

<!--图片上传框-->
<div class="am-modal am-modal-no-btn up-frame-bj " tabindex="-1" id="img-cropper-model">
  <div class="am-modal-dialog up-frame-parent up-frame-radius">
    <div class="am-modal-hd up-frame-header">
      <label>剪切图片</label>
      <a href="javascript: void(0)" class="am-close am-close-spin" data-am-modal-close>&times;</a>
    </div>
    <div class="am-modal-bd  up-frame-body">
      <div class="am-g am-fl">
        <div class="am-form-group am-form-file">
          <div class="am-fl">
            <button type="button" class="am-btn am-btn-default am-btn-sm">
              <i class="am-icon-cloud-upload"></i> 选择要上传的图片
            </button>
          </div>
          <input type="file" id="inputImage">
        </div>
      </div>
      <div class="am-g am-fl">
        <div class="up-pre-before up-frame-radius">
          <img alt="" src="" id="image">
        </div>
        <div class="up-pre-after up-frame-radius">
        </div>
      </div>
      <div class="am-g am-fl">
        <div class="up-control-btns">
          <span class="am-icon-rotate-left" onclick="rotateimgleft()"></span>
          <span class="am-icon-rotate-right" onclick="rotateimgright()"></span>
          <span class="am-icon-check" id="up-btn-ok" url="admin/user/upload.action"></span>
        </div>
      </div>

    </div>
  </div>
</div>

<!--加载框-->
<div class="am-modal am-modal-loading am-modal-no-btn" tabindex="-1" id="my-modal-loading">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">正在上传...</div>
    <div class="am-modal-bd">
      <span class="am-icon-spinner am-icon-spin"></span>
    </div>
  </div>
</div>

<!--警告框-->
<div class="am-modal am-modal-alert" tabindex="-1" id="my-alert">
  <div class="am-modal-dialog">
    <div class="am-modal-hd">信息</div>
    <div class="am-modal-bd" id="alert_content">
      成功了
    </div>
    <div class="am-modal-footer">
      <span class="am-modal-btn">确定</span>
    </div>
  </div>
</div>

<!-- 头像剪切需要的依赖 -->
<script src="/assets/js/cropper.min.js"></script>
<script src="/assets/js/custom/img-cropper.js"></script>
<script src="/assets/js/plugins/blob/canvas-to-blob.js"></script>