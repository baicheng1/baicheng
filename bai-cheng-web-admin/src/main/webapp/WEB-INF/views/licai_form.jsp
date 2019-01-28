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
                        <h3 class="box-title">${product.pid==null?"新增":"编辑"}产品</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <%--<form class="form-horizontal" action="/user/save" method="post">--%>

                    <form:form cssClass="form-horizontal" action="/licai/save" method="get" modelAttribute="product">
                        <form:hidden path="pid"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="pname" class="col-sm-2 control-label">产品名称</label>

                                <div class="col-sm-10">

                                    <form:input path="pname" class="form-control" placeholder="产品名称"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">类型</label>

                                <div class="col-sm-10">

                                    <input name="ptype" type="radio" value="1" ${product.ptype==1?"checked":""} class="ace">
                                    <span class="lbl">活期</span>
                                    <input name="ptype" type="radio" value="0" ${product.ptype==0?"checked":""} class="ace">
                                    <span class="lbl">定期</span>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="startprice" class="col-sm-2 control-label">起投金额</label>

                                <div class="col-sm-10">

                                    <form:input path="startprice" class="form-control" placeholder="起投金额"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="time" class="col-sm-2 control-label">投资周期</label>
                                <div class="col-sm-10">
                                    <form:input path="time" class="form-control" placeholder="投资周期"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="returnrate" class="col-sm-2 control-label">收益率</label>
                                <div class="col-sm-10">
                                    <form:input path="returnrate" class="form-control" placeholder="收益率"/>
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
