// 初始化校验
function initCustomValidation() {

  // 登录form 进行校验
  $("#add-cusin-form").validate({
    submitHandler: function (form) {
      form.submit();
    },
    rules: {
      cusinName: {
        required: true,
        minlength: 2
      },
      cusinBirthday: {
        required: true,
      }
    },
    messages: {
      cusinName: {
        required: "请输入表亲名哦！",
        minlength: "名字最小两个字哦！"
      },
      cusinBirthday: {
        required: "请选择生日哦！"
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