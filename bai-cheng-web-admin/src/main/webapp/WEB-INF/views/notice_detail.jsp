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
                    <dt><span class="">${notice.noticeName}</span></dt>
                </dl>
            </div>
            <div class="member_content">
                <ul>
                    <li><label class="label_name">公告名称：</label><span class="name">${notice.noticeName}</span></li>
                    <li><label class="label_name">公告类型：</label><span class="name">${notice.noticeType==0?"定期公告":"其他公告"}</span></li>
                    <li><label class="label_name">创建时间：</label><span class="name">${notice.noticeCreated}</span></li>
                    <li><label class="label_name">公告内容：</label><span class="name">${notice.noticeContent}</span></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- /.content -->
<%--<jsp:include page="../includes/footer.jsp"/>--%>
