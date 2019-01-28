<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <jsp:include page="../includes/header.jsp"/>
    <title>用户列表</title>
</head>
<body id="body">
<c:if test="${baseResult.status==200}">
    <div class="col-md-12">
        <div class="row">
            <div class="alert alert-${baseResult.status==200?"success":"danger"} alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    ${baseResult.message}
            </div>
        </div>
    </div>
</c:if>
<div class="page-content clearfix">
    <div id="Member_Ratings">
        <div class="d_Confirm_Order_style">
            <div class="search_style">
                <div class="title_names">搜索查询</div>
                <ul class="search_content clearfix">
                    <form action="/user/selectBySearch" method="post">
                    <li><label class="l_f">会员名称</label>
                        <input name="keyword" type="text" class="text_add" id="keyword" placeholder="输入关键字"
                               style=" width:400px"/>
                    </li>
                    <li style="width:90px;">
                        <button type="submit"  class="btn_search"><i class="icon-search"></i>查询
                        </button>
                    </li>
                    </form>
                </ul>
            </div>
            <!---->

            <div class="border clearfix">

                   <span class="l_f">
                    <a href="javascript:ovid()" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加用户</a>
                    <button onclick="deleteItem()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</button>
                   </span>
                    <span class="r_f">共：<b>${count}</b>条</span>
            </div>
            <!---->
            <div class="table_menu_list">
                <table class="table table-striped table-bordered table-hover" id="sample-table">
                    <thead>
                    <tr>
                        <th><input type="checkbox" class="minimal checkbox-master"></th>
                        <th>ID</th>
                        <th>用户名</th>
                        <th>密码</th>
                        <th>邮箱</th>
                        <th>电话</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${users}" var="user">
                        <tr>
                            <td><label><input type="checkbox" id="${user.uid}" class="ace"><span
                                    class="lbl"></span></label></td>
                            <td>${user.uid}</td>
                            <td><u style="cursor:pointer" class="text-primary"
                                   onclick="showDetail(${user.uid})">${user.username}</u></td>
                            <td>${user.password}</td>
                            <td>${user.email}</td>
                            <td>${user.phone}</td>
                            <td class="td-status">
                                <c:if test="${user.type==1}">
                                    <span class="label label-success radius">已启用</span>
                                </c:if>
                                <c:if test="${user.type==0}">
                                    <span class="label label-defaunt radius">已停用</span>
                                </c:if>
                            </td>
                            <td class="td-manage">
                                <c:if test="${user.type==1}">
                                    <a onClick="member_stop(this,${user.uid})" href="javascript:;" title="停用"
                                       class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a>
                                </c:if>
                                <c:if test="${user.type==0}">
                                    <a onClick="member_start(this,${user.uid})" href="javascript:;" title="启用"
                                       class="btn btn-xs"><i class="icon-ok bigger-120"></i></a>
                                </c:if>
                                <a title="编辑" href="javascript:;" onclick="location.href='/user/form?uid=${user.uid}'"
                                   class="btn btn-xs btn-info"><i class="icon-edit bigger-120"></i></a>
                                    <%--<button title="删除"  onclick="deleteById(${user.uid})"--%>
                                    <%--class="btn btn-xs btn-warning"><i class="icon-trash  bigger-120"></i></button>--%>
                                <a title="删除" href="javascript:;" onclick="member_del(${user.uid})"
                                   class="btn btn-xs btn-warning">
                                    <i class="icon-trash  bigger-120"></i></a>
                            </td>
                        </tr>
                    </c:forEach>

                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!--添加用户图层-->
<div class="add_menber" id="add_menber_style" style="display:none">

    <ul class=" page-content">
        <li><label class="label_name">用&nbsp;&nbsp;户 &nbsp;名：</label><span class="add_name">
            <input value="" id="username" required="required" name="username" type="text" class="text_add"/></span>
            <div class="prompt r_f"></div>
        </li>
        <li><label class="label_name">密&nbsp;&nbsp;码：</label><span class="add_name">
            <input name="password" id="password" type="text" required="required" class="text_add"/></span>
        <div class="prompt r_f"></div>
    </li>
        <li><label class="label_name">邮&nbsp;&nbsp;箱：</label><span class="add_name">
            <input name="email" id="email" type="email" required="required" class="text_add"/></span>
            <div class="prompt r_f"></div>
        </li>
        <li><label class="label_name">电&nbsp;&nbsp;话：</label><span class="add_name">
            <input name="phone" id="phone" type="text" required="required" class="text_add"/></span>
            <div class="prompt r_f"></div>
        </li>
        <li><label class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</label><span class="add_name">
     <label><input name="form-field-radio1" type="radio" value="1" checked="checked" class="ace"><span
             class="lbl">开启</span></label>&nbsp;&nbsp;&nbsp;
     <label><input name="form-field-radio1" type="radio" value="0" class="ace"><span
             class="lbl">关闭</span></label></span>
            <div class="prompt r_f"></div>
        </li>
    </ul>
</div>
<%--modal--%>
<div class="modal fade" id="modal-default">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modal-title">友情提醒</h4>
            </div>
            <div class="modal-body">
                <p id="modal-message"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn pull-left btn-primary" data-dismiss="modal">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<%--modal--%>
<jsp:include page="../includes/footer.jsp"/>
</body>
</html>

<script>
    // iCheck相关功能
    // 激活 iCheck
    $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
        checkboxClass: 'icheckbox_minimal-blue',
        radioClass: 'iradio_minimal-blue'
    });
    //全选、全不选
    _checkboxMaster = $(".checkbox-master");
    _checkbox = $("tbody").find("[type='checkbox']").not("[disabled]");
    _checkboxMaster.on("ifClicked", function (e) {
        // 当前状态已选中，点击后应取消选择
        if (e.target.checked) {
            _checkbox.iCheck("uncheck");
        }
        // 当前状态未选中，点击后应全选
        else {
            _checkbox.iCheck("check");
        }
    });

    function deleteItem() {
        var _idArray = new Array();
        _checkbox.each(function () {
            // 判断是否选中
            var delFlag = $(this).is(":checked");
            if (delFlag) {
                _idArray.push($(this).attr("id"));
            }
        });
        if (_idArray.length == 0) {
            $("#modal-message").html("请至少选择一个")
            $("#modal-default").modal("show");
        } else {
            $.ajax({
                "url": "/user/deletemulti",
                "type": "POST",
                "data": {"ids": _idArray.toString()},
                "dataType": "JSON",
                "success": function (data) {
                    window.location.reload();
                    alert(data.message);
                }
            });
            // $("#modal-message").html("是否删除选中项")
            // $("#modal-default").modal("show");
        }
    }

    jQuery(function ($) {
        var oTable1 = $('#sample-table').dataTable({
            "aaSorting": [[1, "desc"]],//默认第几个排序
            "bStateSave": true,//状态保存
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
                {"orderable": false, "aTargets": [0, 6, 7]}// 制定列不参与排序
            ]
        });


        $('table th input:checkbox').on('click', function () {
            aletr("框架");
            var that = this;
            $(this).closest('table').find('tr > td:first-child input:checkbox')
                .each(function () {
                    this.checked = that.checked;
                    $(this).closest('tr').toggleClass('selected');
                });

        });


        $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});

        function tooltip_placement(context, source) {
            var $source = $(source);
            var $parent = $source.closest('table')
            var off1 = $parent.offset();
            var w1 = $parent.width();

            var off2 = $source.offset();
            var w2 = $source.width();

            if (parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2)) return 'right';
            return 'left';
        }
    })
    /*用户-添加*/
    $('#member_add').on('click', function () {
        layer.open({
            type: 1,
            title: '添加用户',
            maxmin: true,
            shadeClose: true, //点击遮罩关闭层
            area: ['800px', ''],
            content: $('#add_menber_style'),
            btn: ['提交', '取消'],
            yes: function (index, layero) {
                var num = 0;
                var str = "";
                $(".add_menber input[type$='text']").each(function (n) {
                    if ($(this).val() == "") {

                        layer.alert(str += "" + $(this).attr("name") + "不能为空！\r\n", {
                            title: '提示框',
                            icon: 0,
                        });
                        num++;
                        return false;
                    }
                });
                if (num > 0) {
                    return false;
                }
                else {
                    var username = $("#username").val();
                    var password = $("#password").val();
                    var type = $("input[type='radio']:checked").val();
                    var email = $("#email").val();
                    var phone = $("#phone").val();
                    $.ajax({
                        "url": "/user/save",
                        "type": "GET",
                        "data": {"username": username, "password": password, "type": type,"email":email,"phone":phone},
                        "success": function (data) {
                            alert("添加成功！");
                            window.location.reload();
                        }
                    });
                    // layer.alert('添加成功！',{
                    //     title: '提示框',
                    //     icon:1,
                    // });
                    layer.close(index);
                }
            }
        });
    });

    /*用户-查看*/
    function showDetail(id) {
        $.ajax({
            "url": "/user/detail?uid=" + id,
            "type": "GET",
            "dataType": "HTML",
            "success": function (data) {
                // layer_show(data);
                $("#modal-message").html(data);
                $("#modal-title").html("用户详情");
                $("#modal-default").modal("show");
            }
        });
    }

    /*用户-编辑*/
    function member_edit(uid, username, password, type) {
        $("#username").val(user.username);
        $("#password").val(user.password);
        layer.open({
            type: 1,
            title: '修改用户信息',
            maxmin: true,
            shadeClose: false, //点击遮罩关闭层
            area: ['800px', ''],
            content: $('#add_menber_style'),
            btn: ['提交', '取消'],
            yes: function (index, layero) {
                var num = 0;
                var str = "";
                $(".add_menber input[type$='text']").each(function (n) {
                    if ($(this).val() == "") {

                        layer.alert(str += "" + $(this).attr("name") + "不能为空！\r\n", {
                            title: '提示框',
                            icon: 0,
                        });
                        num++;
                        return false;
                    }
                });
                if (num > 0) {
                    return false;
                }
                else {
                    layer.alert('添加成功！', {
                        title: '提示框',
                        icon: 1,
                    });
                    layer.close(index);
                }
            }
        });
    }

    /*用户-停用*/
    function member_stop(obj, id) {
        layer.confirm('确认要停用吗？', function (index) {
            $.ajax({
                "url": "/user/type?id=" + id,
            });

            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
            $(obj).remove();

            layer.msg('已停用!', {icon: 5, time: 1000});
        });
    }

    /*用户-启用*/
    function member_start(obj, id) {
        layer.confirm('确认要启用吗？', function (index) {
            $.ajax({
                "url": "/user/type?id=" + id,
            });
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="icon-ok bigger-120"></i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
            $(obj).remove();
            layer.msg('已启用!', {icon: 6, time: 1000});
        });
    }

    /*用户-删除*/
    function member_del(id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                "url": "/user/deleteById",
                "type": "POST",
                "data": {"id": id},
                // "dataType": "JSON",
                "success": function (data) {
                    // alert(data.message);
                    window.location.reload();
                }
            });
            // window.location.reload();
            layer.msg('已删除!', {icon: 1, time: 1000});
        });
    }

    function selectBySearch() {
        var keyword = $("#keyword").val();
        $.ajax({
            "url": "/user/selectBySearch",
            "type": "POST",
            "data": {"keyword": keyword},
            "dataType": "JSON",
            "success": function (data) {
                alert("你烫不烫");
                // alert(data.message);
                window.location.reload();
            }
        });
    }

    laydate({
        elem: '#start',
        event: 'focus'
    });

</script>