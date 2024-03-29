function initCropper(url, successCallBack) {
  'use strict';
  // 初始化
  var $image = $('#image');
  $image.cropper({
    aspectRatio: '1',
    autoCropArea: 0.8,
    preview: '.up-pre-after',

  });

  // 事件代理绑定事件
  $('.docs-buttons').on('click', '[data-method]', function () {

    var $this = $(this);
    var data = $this.data();
    var result = $image.cropper(data.method, data.option, data.secondOption);
    switch (data.method) {
      case 'getCroppedCanvas':
        if (result) {
          // 显示 Modal
          $('#cropped-modal').modal().find('.am-modal-bd').html(result);
          $('#download').attr('href', result.toDataURL('image/jpeg'));
        }
        break;
    }
  });


  // 上传图片
  var $inputImage = $('#inputImage');
  var URL = window.URL || window.webkitURL;
  var blobURL;

  if (URL) {
    $inputImage.change(function () {
      var files = this.files;
      var file;

      if (files && files.length) {
        file = files[0];

        if (/^image\/\w+$/.test(file.type)) {
          blobURL = URL.createObjectURL(file);
          $image.one('built.cropper', function () {
            // Revoke when load complete
            URL.revokeObjectURL(blobURL);
          }).cropper('reset').cropper('replace', blobURL);
          $inputImage.val('');
        } else {
          window.alert('Please choose an image file.');
        }
      }

      // Amazi UI 上传文件显示代码
      var fileNames = '';
      $.each(this.files, function () {
        fileNames += '<span class="am-badge">' + this.name + '</span> ';
      });
      $('#file-list').html(fileNames);
    });
  } else {
    $inputImage.prop('disabled', true).parent().addClass('disabled');
  }

  //绑定上传事件
  $('#up-btn-ok').on('click', function () {
    var $modal = $('#my-modal-loading');
    var $modal_alert = $('#my-alert');
    var img_src = $image.attr("src");
    if (img_src == "") {
      set_alert_info("没有选择上传的图片");
      $modal_alert.modal();
      return false;
    }

    $modal.modal();

    var canvas = $("#image").cropper('getCroppedCanvas');

    // 测试
    //利用Blob插件转换，成数据
    canvas.toBlob(function (blob) {
      //创建forme
      var form = new FormData();
      form.append('fileData', blob, 'avatar.jpg');
      var xmlHttp = new XMLHttpRequest();
      xmlHttp.open("POST", url); //注意跨域问题
      xmlHttp.send(form);
      xmlHttp.onreadystatechange = function () {
        if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {

          // 请求回来的数据
          var data = JSON.parse(xmlHttp.responseText);

          $modal.modal('close');
          set_alert_info(data.message);
          $modal_alert.modal();
          if (data.success) {

            //　上传成功回调
            successCallBack(data);

            // 关闭模态框
            $("#img-cropper-model").modal('close');
          }

        } else {
          $modal.modal('close');
          set_alert_info("上传文件失败了！");
          $modal_alert.modal();
        }
      };
    });
  });

}

function rotateimgright() {
  $("#image").cropper('rotate', 90);
}


function rotateimgleft() {
  $("#image").cropper('rotate', -90);
}

function set_alert_info(content) {
  $("#alert_content").html(content);
}


 
