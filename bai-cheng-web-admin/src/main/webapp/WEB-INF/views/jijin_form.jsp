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
                        <h3 class="box-title">${jiJin.id==null?"新增":"编辑"}基金</h3>
                    </div>
                    <!-- /.box-header -->
                    <!-- form start -->
                    <%--<form class="form-horizontal" action="/user/save" method="post">--%>

                    <form:form cssClass="form-horizontal" action="/jijin/save" method="get" modelAttribute="jiJin">
                        <form:hidden path="id"/>
                        <div class="box-body">
                            <div class="form-group">
                                <label for="order" class="col-sm-2 control-label">默认排序</label>

                                <div class="col-sm-10">

                                    <select name="order">
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="type" class="col-sm-2 control-label">基金类型</label>

                                <div class="col-sm-10">

                                    <form:input path="type" class="form-control" placeholder="基金类型"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="name" class="col-sm-2 control-label">基金名称</label>

                                <div class="col-sm-10">

                                    <form:input path="name" class="form-control" placeholder="基金名称"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">申购状态</label>

                                <div class="col-sm-10">

                                    <input name="apply" type="radio" value="1" ${jiJin.apply==1?"checked":""} class="ace">
                                    <span class="lbl">允许</span>
                                    <input name="apply" type="radio" value="0" ${jiJin.apply==0?"checked":""} class="ace">
                                    <span class="lbl">禁止</span>
                                </div>
                            </div>


                            <div class="form-group">
                                <label for="serviceCharge" class="col-sm-2 control-label">手续费</label>
                                <div class="col-sm-10">
                                    <form:input path="serviceCharge" class="form-control" placeholder="收益率"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="url" class="col-sm-2 control-label">网页链接</label>
                                <div class="col-sm-10">
                                    <form:input path="url" class="form-control" placeholder="网页链接"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="unitNetvalue" class="col-sm-2 control-label">单位净值</label>
                                <div class="col-sm-10">
                                    <form:input path="unitNetvalue" class="form-control" placeholder="单位净值"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="cumulativeNetvalue" class="col-sm-2 control-label">累计净值</label>
                                <div class="col-sm-10">
                                    <form:input path="cumulativeNetvalue" class="form-control" placeholder="累计净值"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="week" class="col-sm-2 control-label">一周涨幅</label>
                                <div class="col-sm-10">
                                    <form:input path="week" class="form-control" placeholder="一周涨幅"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="onemonth" class="col-sm-2 control-label">一月涨幅</label>
                                <div class="col-sm-10">
                                    <form:input path="onemonth" class="form-control" placeholder="一月涨幅"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="threemonths" class="col-sm-2 control-label">三月涨幅</label>
                                <div class="col-sm-10">
                                    <form:input path="threemonths" class="form-control" placeholder="三月涨幅"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sixmonths" class="col-sm-2 control-label">六月涨幅</label>
                                <div class="col-sm-10">
                                    <form:input path="sixmonths" class="form-control" placeholder="六月涨幅"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="year" class="col-sm-2 control-label">一年涨幅</label>
                                <div class="col-sm-10">
                                    <form:input path="year" class="form-control" placeholder="一年涨幅"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="threeyear" class="col-sm-2 control-label">三年涨幅</label>
                                <div class="col-sm-10">
                                    <form:input path="threeyear" class="form-control" placeholder="三年涨幅"/>
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
