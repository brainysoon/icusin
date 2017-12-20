//自定义验证账户
$.validator.addMethod("isAccount", function (value, element) {

  // 账户名(英文，数字，下划线，不能以数字开头)
  var REGEX_ACCOUNT = /^[A-Za-z_][A-Za-z0-9_]*$/;

  return this.optional(element) || REGEX_ACCOUNT.test(value);
}, "请输入正确的账号！");


// 初始化校验
function initCustomValidation() {

  // 注册form 进行校验
  $("#register-form").validate({
    submitHandler: function (form) {
      form.submit();
    },
    rules: {
      userAccount: {
        required: true,
        isAccount: true
      },
      userEmail: {
        required: true,
        email: true
      },
      userShadow: {
        required: true,
        isUserShadow: true
      },
      reUserShadow: {
        required: true,
        equalTo: "#userShadow"
      }
    },
    messages: {
      userAccount: {
        required: "请输入账号哦！"
      },
      userEmail: {
        required: "请输入邮箱哦！",
        email: "请输入正确的邮箱哦！"
      },
      userShadow: {
        required: "请输入密码哦！"
      },
      reUserShadow: {
        required: "请再次确认密码哦！",
        equalTo: "两次密码必须一样哦！"
      }
    },
    highlight: function (e) {
      $(e).closest(".am-form-group").removeClass("am-form-success").addClass("am-form-error");
    },
    success: function (e) {
      $(e).closest(".am-form-group").removeClass("am-form-error").addClass("am-form-success");
      e.remove();
    }
  })
  ;
}