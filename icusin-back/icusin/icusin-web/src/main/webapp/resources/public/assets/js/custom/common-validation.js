//自定义密码验证
$.validator.addMethod("isUserShadow", function (value, element) {

    //密码正则表达式 6-16 位 合法字符
    //数字 + 字母，数字 + 特殊字符，字母 + 特殊字符，数字 + 字母 + 特殊字符组合，而且不能是纯数字，纯字母，纯特殊字符
    var REGEX_PASSWORD = /^(?![\d]+$)(?![a-zA-Z]+$)(?![^\da-zA-Z]+$).{6,16}$/;

    return this.optional(element) || REGEX_PASSWORD.test(value);
}, "必须为6-16位数字，字母，特殊字符且至少包含两种哦！");