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
                        <h3 class="box-title">订单编辑</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <%--<form class="form-horizontal" action="/user/save" method="post">--%>

                    <form:form cssClass="form-horizontal" action="/order/save" method="get" modelAttribute="order">
                    <form:hidden path="id"/>
                    <div class="box-body">
                        <div class="form-group">
                            <label for="uname" class="col-sm-2 control-label">购买者</label>

                            <div class="col-sm-10">
                                    <%--<input type="password" name="password" class="form-control" id="password"--%>
                                    <%--placeholder="密码">--%>
                                <form:input path="uname" class="form-control" readonly="true" placeholder="购买者"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">理财产品</label>

                            <div class="col-sm-10">
                                    <%--<input type="password" name="password" class="form-control" id="password"--%>
                                    <%--placeholder="密码">--%>
                                <form:input path="name" class="form-control" placeholder="理财产品"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="time" class="col-sm-2 control-label">周期</label>

                            <div class="col-sm-10">
                                    <%--<input type="password" name="password" class="form-control" id="password"--%>
                                    <%--placeholder="密码">--%>
                                <form:input path="time" class="form-control" placeholder="周期"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="money" class="col-sm-2 control-label">投资金额</label>

                            <div class="col-sm-10">
                                <form:input path="money" class="form-control" placeholder="投资金额"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="rate" class="col-sm-2 control-label">月利率</label>

                            <div class="col-sm-10">
                                <form:input path="rate" class="form-control" placeholder="月利率"/>
                            </div>
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
</body>
</html>
