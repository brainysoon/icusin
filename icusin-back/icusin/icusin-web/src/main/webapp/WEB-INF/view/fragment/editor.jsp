<%--
  Created by IntelliJ IDEA.
  User: brainy
  Date: 17-10-6
  Time: 上午11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 导入ｊｓ依赖 -->
<script type="text/javascript" charset="utf-8" src="/assets/js/plugins/neditor/neditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="/assets/js/plugins/neditor/editor_api.js"></script>
<script type="text/javascript" charset="utf-8" src="/assets/js/plugins/neditor/zh-cn.js"></script>

<!-- 编辑器容器 -->
<div class="am-g am-g-fixed am-padding">

  <script id="editor" type="text/plain"></script>
</div>

<!-- 创建编辑器 -->
<script>

  var ue = UE.getEditor('editor', {
    autoHeight: false
  });
</script>