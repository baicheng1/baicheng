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
                        <h3 class="box-title">${information.id==null?"新增":"编辑"}公告</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <%--<form class="form-horizontal" action="/user/save" method="post">--%>

                    <form:form cssClass="form-horizontal" action="/info/save" method="get" modelAttribute="information">
                        <form:hidden path="id"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="infoName" class="col-sm-2 control-label">资讯名称</label>

                                <div class="col-sm-10">

                                    <form:input path="infoName" class="form-control" placeholder="资讯名称"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="infoUrl" class="col-sm-2 control-label">链接</label>

                                <div class="col-sm-10">
                                    <form:input path="infoUrl" class="form-control" placeholder="链接"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="infoType" class="col-sm-2 control-label">资讯类型</label>

                                <div class="col-sm-10">
                                    <select id="infoType" name="infoType" class="form-control">
                                        <%--<c:forEach items="${infoTypes}" var="infoType">--%>
                                            <%--<option value="${infoType}" ${information.infoType==infoType?"selected":""}>${infoType}</option>--%>
                                        <%--</c:forEach>--%>
                                        <option value="1" ${information.infoType==infoType?"selected":""}>
                                            期货
                                        </option>
                                            <option value="2" ${information.infoType==infoType?"selected":""}>
                                                股票
                                            </option>
                                            <option value="3" ${information.infoType==infoType?"selected":""}>
                                                财经
                                            </option>
                                    </select>
                                </div>
                            </div>
                        </div>
                            <div class="form-group">
                                <label for="infoContent" class="col-sm-2 control-label">资讯内容</label>

                                <div class="col-sm-10">
                                    <form:input path="infoContent" class="form-control" placeholder="资讯内容"/>
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
