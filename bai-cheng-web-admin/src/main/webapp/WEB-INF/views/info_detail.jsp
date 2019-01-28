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
                    <dt><span class="">${information.infoName}</span></dt>
                </dl>
            </div>
            <div class="member_content">
                <ul>
                    <li><label class="label_name">公告名称：</label><span class="name">${information.infoName}</span></li>
                    <li><label class="label_name">公告类型：</label><span class="name">${information.infoType}</span></li>
                    <li><label class="label_name">创建时间：</label><span class="name">${information.infoCreated}</span></li>
                    <li><label class="label_name">公告内容：</label><span class="name">${information.infoContent}</span></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- /.content -->
<%--<jsp:include page="../includes/footer.jsp"/>--%>
