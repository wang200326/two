/**
 * 公共变量
 */


/* =============== 页面加载相关代码 =============== */

$(document).ready(function () {

  // 判断是否登录：未登录，则跳转到首页
  if (getCookie("userName") == null) {
    window.location.href = "index.jsp";
  }

  // 统计任务数
  $.get(
      "res/json/cnt.json",
      function (data) {
        if (data.success) {
          var arr = data.rows
          // 学生数
          $("#student_number").text(numFormat(arr[0].number))
          // 教师数
          $("#teacher_number").text(numFormat(arr[1].number))
          // 课程数
          $("#course_number").text(numFormat(arr[2].number))
          // 成绩数
          $("#score_number").text(numFormat(arr[3].number))
        }
      }
  )

  // 数字格式化（加千分位分隔符）
  function numFormat(num) {
    var res = num.toLocaleString()
    //var res = new Intl.NumberFormat('ja-JP').format(num)
    //var res = num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, '$1,')
    return res;
  }

  // 点击“学生数”块中的“查看详情”按钮
  $(document).ready(function () {
    $("#a_student").click(function () {
      $("#div_content").load("admin/basic/student/student.inc");
    });
  });

  // 点击“教师数”块中的“查看详情”按钮
  $(document).ready(function () {
    $("#a_teacher").click(function () {
      $("#div_content").load("admin/basic/teacher/teacher.inc");
    });
  });

  // 点击“课程数”块中的“查看详情”按钮
  $(document).ready(function () {
    $("#a_course").click(function () {
      $("#div_content").load("admin/basic/course/course.inc");
    });
  });

  // 点击“成绩数”块中的“查看详情”按钮
  $(document).ready(function () {
    $("#a_score").click(function () {
      $("#div_content").load("admin/score/manager/manage.inc");
    });
  });

  // 初始化表格
  $(document).ready(function () {
    $('#tbl_position').bootstrapTable({
      columns: [
        {field:'position',title:'职位',align:'center',valign:'middle',width:'100'},
        {field:'short',title:'英文缩写',align:'center',valign:'middle',width:'40'},
        {field:'full',title:'英文全称',align:'center',valign:'middle',width:'80'},
        {field:'duty',title:'主要职责',align:'center',valign:'middle',width:'200'}
      ],
      classes: 'table table-bordered table-striped table-condensed table-hover',
      method: 'get',  //bootstrap 默认的内置请求方式
      url: "res/json/position.json",    //要请求数据的文件路径
      sortName: 'id', //默认排序列
      queryParamsType: 'limit',   //查询参数组织方式
      sidePagination: 'server',   //指定服务器端分页
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

});