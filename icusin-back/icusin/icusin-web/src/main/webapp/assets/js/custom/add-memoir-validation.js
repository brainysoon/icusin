// 初始化校验
function initCustomValidation() {

  // 登录form 进行校验
  $("#add-memoir-form").validate({
    submitHandler: function (form) {
      form.submit();
    },
    rules: {
      memoirTitle: {
        required: true,
      },
      memoirDigest: {
        required: true,
      }
    },
    messages: {
      memoirTitle: {
        required: "请输入标题哦！",
      },
      memoirDigest: {
        required: "请输入简介哦！"
      }
    },
    highlight: function (e) {
      $(e).closest(".am-form-group").removeClass("am-form-success").addClass("am-form-error");
    },
    success: function (e) {
      $(e).closest(".am-form-group").removeClass("am-form-error").addClass("am-form-success");
      e.remove();
    }
  });
}