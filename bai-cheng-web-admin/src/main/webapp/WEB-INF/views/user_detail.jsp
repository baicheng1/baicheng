<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row form-horizontal">
    <div class="box-body">
        <div class="member_show">
            <div class="member_jbxx clearfix">
                <img class="img" src="/static/assets/images/user.png">
                <%--<dl  class="right_xxln">--%>
                <dl>
                    <dt><span class="">${user.username}</span></dt>
                    <dd class="" style="margin-left:0">这家伙很懒，什么也没有留下</dd>
                </dl>
            </div>
            <div class="member_content">
                <ul>
                    <li><label class="label_name">用户名：</label><span class="name">${user.username}</span></li>
                    <li><label class="label_name">密码：</label><span class="name">${user.password}</span></li>
                    <li><label class="label_name">邮箱：</label><span class="name">${user.email}</span></li>
                    <li><label class="label_name">电话：</label><span class="name">${user.phone}</span></li>
                    <li><label class="label_name">状态：</label><span class="name">${user.type==1?"启用":"停用"}</span></li>

                </ul>
            </div>
        </div>
    </div>
</div>
<!-- /.content -->
<%--<jsp:include page="../includes/footer.jsp"/>--%>
