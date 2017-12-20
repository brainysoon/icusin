//自定义验证账户
$.validator.addMethod("isUserName", function (value, element) {

  // 邮箱正则表达式
  var REGEX_EMAIL = /\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;

  // 手机正则表达式
  var REGEX_MOBILE = /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/;

  // 账户名(英文，数字，下划线，不能以数字开头)
  var REGEX_ACCOUNT = /^[A-Za-z_][A-Za-z0-9_]*$/;

  return this.optional(element) || REGEX_EMAIL.test(value) ||
      REGEX_MOBILE.test(value) || REGEX_ACCOUNT.test(value);
}, "请输入正确的账号/邮箱/手机号！");


// 初始化校验
function initCustomValidation() {

  // 登录form 进行校验
  $("#login-form").validate({
    submitHandler: function (form) {
      form.submit();
    },
    rules: {
      username: {
        required: true,
        isUserName: true
      },
      password: {
        required: true,
        isUserShadow: true
      }
    },
    messages: {
      username: {
        required: "请输入账号哦！"
      },
      password: {
        required: "请输入密码哦！"
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