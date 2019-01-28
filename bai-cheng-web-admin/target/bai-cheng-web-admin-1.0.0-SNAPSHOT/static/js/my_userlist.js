// 激活 iCheck
$('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
    checkboxClass: 'icheckbox_minimal-blue',
    radioClass: 'iradio_minimal-blue'
});
// $('input').on('ifChecked', function(event){
//     alert(event.type + ' callback');
// });
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
            "type": "GET",
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

//隐藏模态框
function btnModalClick() {
    $("#modal-default").modal("hide");
}
// $('#dataTable').DataTable();
$('#dataTable').DataTable({
    'paging'      : true,
    'lengthChange': false,
    'searching'   : false,
    'ordering'    : false,
    'info'        : true,
    'autoWidth'   : true
    //服务器模式
    // "serverSide": true,
    // "ajax": "xhr.php"
});