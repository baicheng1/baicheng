<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">--%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <jsp:include page="../includes/header.jsp"/>
    <title>公告列表</title>
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
                    <form action="/notice/selectBySearch" method="post">
                    <li><label class="l_f">关键字</label>
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
                    <a href="/notice/form" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加公告</a>
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
                        <th>基金编号</th>
                        <th>公告名称</th>
                        <th>公告内容</th>
                        <th>公告类型</th>
                        <th>创建时间</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${notices}" var="notice">
                        <tr>
                            <td><label><input type="checkbox" id="${notice.id}" class="ace"><span
                                    class="lbl"></span></label></td>
                            <td>${notice.id}</td>
                            <td>${notice.jiJinId}</td>
                            <td><u style="cursor:pointer" class="text-primary"
                                   onclick="showDetail(${notice.id})">${notice.noticeName}</u></td>
                            <td class="text-l">${notice.noticeContent}</td>
                            <td>${notice.noticeType}</td>
                            <td>${notice.noticeCreated}

                            </td>
                            <td class="td-manage">
                                <a title="编辑" href="javascript:;" onclick="location.href='/notice/form?id=${notice.id}'"
                                   class="btn btn-xs btn-info"><i class="icon-edit bigger-120"></i></a>
                                <a title="删除" href="javascript:;" onclick="member_del(${notice.id})"
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
<%--modal--%>
<div class="modal fade" id="modal-common">
    <%--<div class="modal-dialog">--%>
    <div style="width: 600px ;margin: 30px auto">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modal-common-title">
                    <%--标题--%>
                </h4>
            </div>
            <div class="modal-body">
                <p id="modal-common-detail">
                    <%--内容--%>
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" onclick="modalClick()" class="btn btn-primary">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<%--modal--%>
<div class="modal fade" id="modal-default">
    <%--<div class="modal-dialog">--%>
    <div style="width: 600px ;margin: 30px auto">
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
                <button type="button" class="btn pull-right btn-primary" data-dismiss="modal">确定</button>
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
<%--引入日期工具类--%>
<script src="/static/js/datetime.js"></script>
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
                "url": "/notice/deletemulti",
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

    /*公告-查看*/
    function showDetail(id) {
        $.ajax({
            "url": "/notice/detail?id=" + id,
            "type": "GET",
            "dataType": "HTML",
            "success": function (data) {
                // layer_show(data);
                $("#modal-common-detail").html(data);
                $("#modal-common-title").html("公告详情");
                $("#modal-common").modal("show");
            }
        });
    }


    /*公告-删除*/
    function member_del(id) {
        layer.confirm('确认要删除吗？', function (index) {
            $.ajax({
                "url": "/notice/deleteById",
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
    //隐藏模态框
    function modalClick() {
        $("#modal-common").modal("hide");
    }
    laydate({
        elem: '#start',
        event: 'focus'
    });

</script>