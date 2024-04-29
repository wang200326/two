/* =============== 定义全局变量 =============== */
console.log("建议把全局变量都定义在最上方，并写好注释");

var urlType;    // 用于判断用户点击的是添加还是编辑：add-添加; update-编辑;


/* =============== 页面加载相关代码 =============== */

$(document).ready(function () {

  // 判断是否登录：未登录，则跳转到首页
  if (getCookie("studentName") == null) {
    //window.location.href = "index.jsp";
  }

  // 初始化数据表格
  $('#tbl_student').bootstrapTable({
    columns: [
      {checkbox: true},
      {field:'sequence',title:'学号',align:'center',valign:'middle',sortable:true,width:'120'},
      {field:'name',title:'姓名',align:'center',valign:'middle',sortable:true,width:'100'},
      {field:'gender',title:'性别',align:'center',valign:'middle',width:'80'},
      {field:'card',title:'身份证号',align:'center',valign:'middle',width:'160'},
      {field:'birthday',title:'出生日期',align:'center',valign:'middle',width:'100'},
      {field:'nation',title:'民族',align:'center',valign:'middle',width:'100'},
      {field:'nativePlace',title:'籍贯',align:'center',valign:'middle',width:'160'},
      {field:'political',title:'政治面貌',align:'center',valign:'middle',width:'160'},
      {field:'operate', title: '操作', align: 'center', valign: 'middle', width: '200', formatter: operateFormatter, events: operateEvents}
    ],
    queryParams: function (params) {
      /**
       * 如果需要修改默认参数，请在这里完成
       return {
                "page": params.offset,
                "size": params.limit,
                "sort": params.sort,
                "asc": params.order,
            }
       */
      return params
    },
    classes: 'table table-bordered table-striped table-condensed table-hover',
    method: 'get',  //bootstrap 默认的内置请求方式
    url: "com/demo/controller/student/Get",    //要请求数据的文件路径
    sortName: 'id', //默认排序列
    queryParamsType: 'limit',   //查询参数组织方式
    sidePagination: 'server',   //指定服务器端分页
    pagination: true,   //是否分页，即分页按钮
    pageSize: 10,   //单页记录数
    pageList: [10, 20, 50, 100],   //分页步进值
    paginationHAlign: 'right',  //分页条水平对齐
    paginationVAlign: 'bottom', //分页条垂直对齐
    singleSelect: true, //只能选中一行
    clickToSelect: true,    //点击选中行
    toolbar: '#tb_student',    //自定义工具栏对齐方式
    locale: 'zh-CN',    //支持中文
    onLoadSuccess: function (data) {
      // $.showMessage('数据加载成功！');
      setTimeout(function () {
        load.stop();
      }, 1000)
    },
    onLoadError: function (status, res) {
      $.showMessage('数据加载失败，请重试！');
      setTimeout(function () {
        load.stop();
      }, 1000)
    }
  });

});



/* =============== 表格工具栏相关代码 =============== */

$(document).ready(function () {

  //查询
  $("#btn_search").click(function () {
    var url = "com/demo/controller/student/Get?param=";
    var param = $("#searchName").val();
    url += param;
    $('#tbl_student').bootstrapTable("refresh", {"url": url})
  })

  //添加
  $("#btn_insert").click(function () {
    $("#studentEditLabel").html("新增用户");
    urlType = "add";
    $("#fm_studentEdit")[0].reset();
    $("#studentEdit").modal("show");
  })

  //导出
  $("#btn_export").click(function () {
    var url = "com/demo/controller/student/Export?param=";
    var param = $("#searchName").val();
    url += param;
    window.location.href = url;

    var curLoad = new Loading();
    curLoad.init();
    curLoad.start();
    setTimeout(function () {
      curLoad.stop();
    }, 3000)

  })

});


/* =============== 表格操作列相关代码 =============== */

/**
 * 渲染operate列
 */
function operateFormatter(value, row, index) {
  return [
    '<a title="查看详情" class="getInfo btn btn-sm btn-info" style="margin-right:4px;"><span class="icon-document"></span></a>',
    '<a title="编辑" class="editRow btn btn-sm btn-warning" style="margin-right:4px;"><span class="icon-edit"></span></a>',
    '<a title="删除" class="deleteRow btn btn-sm btn-danger"><span class="icon-delete"></span></a>'
  ].join('')
}

/**
 * 事件绑定
 */
window.operateEvents = {
  // 查看详情
  'click .getInfo': function (e, value, row, index) {
    getInfo(row);
  },
  // 编辑
  "click .editRow": function (e, value, row, index) {
    editRow(row);
  },
  // 删除
  "click .deleteRow": function (e, value, row, index) {
    deleteRow(row);
  }
}

/**
 * 查看详情
 */
function getInfo(row) {
  $("#studentInfo_sequence").text(row.sequence);
  $("#studentInfo_name").text(row.name);
  $("#studentInfo_gender").text(row.gender);
  $("#studentInfo_card").text(row.card);
  $("#studentInfo_birthday").text(row.birthday);
  $("#studentInfo_nation").text(row.nation);
  $("#studentInfo_nativePlace").text(row.nativePlace);
  $("#studentInfo_political").text(row.political);
  $("#studentInfo").modal("show");
}

/**
 * 编辑
 */
function editRow(row) {
  $("#studentEditLabel").html("编辑用户");
  urlType = "update";
  $("#studentEdit").modal("show");
  //赋值
  $("#studentEdit_id").val(row.id);
  $("#studentEdit_sequence").val(row.sequence);
  $("#studentEdit_name").val(row.name);
  $("#studentEdit_gender").val(row.gender);
  $("#studentEdit_card").val(row.card);
  $("#studentEdit_birthday").val(row.birthday);
  $("#studentEdit_nation").val(row.nation);
  $("#studentEdit_nativePlace").val(row.nativePlace);
  $("#studentEdit_political").val(row.political);
  $("#studentEdit_department").html("");
}

/**
 * 删除
 */
function deleteRow(row) {
  $.confirm({
    title: '警告!',
    content: '确定要删除【' + row.name + '】吗？',
    buttons: {
      formSubmit: {
        text: '确定',
        btnClass: 'btn-red',
        action: function () {
          $.post(
              "com/demo/controller/student/Delete",
              {"id": row.id},
              function (data) {
                var json = JSON.parse(data)
                if (json.success) {
                  $.showMessage(json.msg)
                }
                var param = $("#searchName").val()
                var url = "com/demo/controller/student/Get?param=" + param
                $('#tbl_student').bootstrapTable("refresh", {"url": url})
              })
        }
      },
      cancel: {
        text: '取消',
        btnClass: 'btn-gray',
        action: function () {
          // $.showMessage("取消")
        }
      }
    }
  });
}


/* =============== studentEdit弹出层相关代码 =============== */

$(document).ready(function () {

  /**
   * 初始化性别下拉框
   */
  $(document).ready(function(){
    $.get(
        'res/json/gender.json',
        function (data) {
          var opt = "";
          for (var i in data) {
            opt += '<option value="' + data[i].id + '">' + data[i].text + '</option>';
          }
          $("#studentEdit_gender").append(opt);
        }
    );
  });

  /**
   * 初始化民族下拉框
   */
  $(document).ready(function(){
    $.get(
        'res/json/nation.json',
        function (data) {
          var opt = "";
          for (var i in data) {
            opt += '<option value="' + data[i].id + '">' + data[i].text + '</option>';
          }
          $("#studentEdit_nation").append(opt);
        }
    );
  });

  /**
   * 初始化政治面貌下拉框
   */
  $(document).ready(function(){
    $.get(
        'res/json/political.json',
        function (data) {
          var opt = "";
          for (var i in data) {
            opt += '<option value="' + data[i].id + '">' + data[i].text + '</option>';
          }
          $("#studentEdit_political").append(opt);
        }
    );
  });

  //保存
  $("#btn_studentEdit_save").click(function () {

    var studentSequence = $("#studentEdit_sequence").val();
    studentSequence = studentSequence.replace(/^\s*|\s*$/g, "");
    if (studentSequence == null || studentSequence == "" || studentSequence.length == 0) {
      $.showMessage("学号不能为空！");
      return;
    }

    var studentName = $("#studentEdit_name").val();
    studentName = studentName.replace(/^\s*|\s*$/g, "");
    if (studentName == null || studentName == "" || studentName.length == 0) {
      $.showMessage("姓名不能为空！");
      return;
    }

    var url = ""
    if (urlType == "add") {
      url = "com/demo/controller/student/Insert";
    } else {
      url = "com/demo/controller/student/Update?id=";
      url += $("#studentEdit_id").val()
    }
    var param = $("#fm_studentEdit").serialize()
    $.post(url, param, function (data) {
      var json = JSON.parse(data)
      if (json.success) {
        $.showMessage(json.msg);
        $("#studentEdit").modal("hide");
        var param = $("#searchName").val();
        var url = "com/demo/controller/student/Get?param=" + param;
        $('#tbl_student').bootstrapTable("refresh", {"url": url})
      }
    })
  })

});


/* =============== 复用代码 =============== */

// 获取"部门"下拉列表
function getDepartmentList(unitId) {
  $("#studentEdit_department").html("");
  $.get(
      "com/demo/controller/department/Get?param=" + unitId,
      function (data) {
        var json = JSON.parse(data);
        var opt = "";
        for (var i in json.rows) {
          opt += '<option value="' + json.rows[i].id + '">' + json.rows[i].name + '</option>';
        }
        $("#studentEdit_department").append(opt);
      }
  )
}