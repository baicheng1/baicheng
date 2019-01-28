<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link href="/static/assets/assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/static/assets/css/style.css"/>
    <link href="/static/assets/assets/css/codemirror.css" rel="stylesheet">
    <link rel="stylesheet" href="/static/assets/assets/css/ace.min.css"/>
    <link rel="stylesheet" href="/static/assets/assets/css/font-awesome.min.css"/>
    <!--[if IE 7]>
    <link rel="stylesheet" href="/static/assets/assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="/static/assets/assets/css/ace-ie.min.css"/>
    <![endif]-->
    <script src="/static/assets/assets/js/jquery.min.js"></script>
    <title>用户查看</title>
</head>
<body>
<div class="member_show">
    <div class="member_content">
        <!-- Main row -->
        <div class="row">
            <div class="col-md-12">
                <!-- Horizontal Form -->
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">${notice.id==null?"新增":"编辑"}公告</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <%--<form class="form-horizontal" action="/user/save" method="post">--%>

                    <form:form cssClass="form-horizontal" action="/notice/save" method="get" modelAttribute="notice">

                       <form:hidden path="id" />
                    <%--<input name="id"  value="" type="hidden">--%>

                        <div class="box-body">
                            <div class="form-group">
                                <label for="jiJinId" class="col-sm-2 control-label">基金代码</label>

                                <div class="col-sm-10">
                                        <select id="jiJinId" name="jiJinId" class="form-control">
                                        <c:forEach items="${jiJinId_ids}" var="jijinid_id">
                                            <option value="${jijinid_id}" ${notice.jiJinId==jijinid_id?"selected":""}>${jijinid_id}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="noticeName" class="col-sm-2 control-label">公告名称</label>

                                <div class="col-sm-10">
                                        <%--<input type="password" name="password" class="form-control" id="password"--%>
                                        <%--placeholder="密码">--%>
                                    <form:input path="noticeName" class="form-control" placeholder="公告名称"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="noticeUrl" class="col-sm-2 control-label">链接</label>

                                <div class="col-sm-10">
                                        <%--<input type="password" name="password" class="form-control" id="password"--%>
                                        <%--placeholder="密码">--%>
                                    <form:input path="noticeUrl" class="form-control" placeholder="链接"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">公告类型</label>

                                <div class="col-sm-10">
                                        <%--<input type="password" name="password" class="form-control" id="password"--%>
                                        <%--placeholder="密码">--%>
                                    <input name="noticeType" type="radio" value="0" ${notice.noticeType==0?"checked":""} class="ace">
                                    <span class="lbl">定期公告</span>
                                    <input name="noticeType" type="radio" value="1" ${notice.noticeType==1?"checked":""} class="ace">
                                    <span class="lbl">其他公告</span>
                                </div>
                            </div>
                        </div>
                            <div class="form-group">
                                <label for="noticeContent" class="col-sm-2 control-label">公告内容</label>

                                <div class="col-sm-10">
                                        <%--<input type="password" name="password" class="form-control" id="password"--%>
                                        <%--placeholder="密码">--%>
                                    <form:input path="noticeContent" class="form-control" placeholder="公告内容"/>
                                </div>
                            </div>

                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer">
                            <button type="button" onclick="history.go(-1)" class="btn btn-default">返回</button>
                            <button type="submit" class="btn btn-info pull-right">提交</button>
                        </div>
                        <!-- /.box-footer -->
                    </form:form>
                </div>
            </div>
        </div>
        <!-- /.row (main row) -->
    </div>
</div>
</body>
</html>
