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
    <div class="member_jbxx clearfix">
        <img class="img" src="/static/assets/images/user.png">
        <dl class="right_xxln">
            <dt><span class="">${user.username}</span></dt>
            <dd class="" style="margin-left:0">这家伙很懒，什么也没有留下</dd>
        </dl>
    </div>
    <div class="member_content">
        <!-- Main row -->
        <div class="row">
            <div class="col-md-12">
                <!-- Horizontal Form -->
                <div class="box box-info">
                    <div class="box-header with-border">
                        <h3 class="box-title">${user.uid==null?"新增":"编辑"}用户</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <%--<form class="form-horizontal" action="/user/save" method="post">--%>

                    <form:form cssClass="form-horizontal" action="/user/save" method="get" modelAttribute="user">
                        <form:hidden path="uid"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="username" class="col-sm-2 control-label">用户名</label>

                                <div class="col-sm-10">
                                        <%--<input type="text" name="username" class="form-control" id="username"--%>
                                        <%--placeholder="姓名">--%>
                                    <form:input path="username" class="form-control" placeholder="用户名"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="col-sm-2 control-label">密码</label>

                                <div class="col-sm-10">
                                        <%--<input type="password" name="password" class="form-control" id="password"--%>
                                        <%--placeholder="密码">--%>
                                    <form:password path="password" class="form-control" placeholder="密码"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="col-sm-2 control-label">邮箱</label>

                                <div class="col-sm-10">
                                        <%--<input type="password" name="password" class="form-control" id="password"--%>
                                        <%--placeholder="密码">--%>
                                    <form:input path="email" class="form-control" placeholder="邮箱"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="phone" class="col-sm-2 control-label">电话</label>

                                <div class="col-sm-10">
                                        <%--<input type="password" name="password" class="form-control" id="password"--%>
                                        <%--placeholder="密码">--%>
                                    <form:input path="phone" class="form-control" placeholder="电话"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">状态</label>

                                <div class="col-sm-10">
                                        <%--<input type="password" name="password" class="form-control" id="password"--%>
                                        <%--placeholder="密码">--%>
                                            <input name="type" type="radio" value="1" ${user.type==1?"checked":""} class="ace">
                                            <span class="lbl">开启</span>
                                            <input name="type" type="radio" value="0" ${user.type==0?"checked":""} class="ace">
                                            <span class="lbl">关闭</span>
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
