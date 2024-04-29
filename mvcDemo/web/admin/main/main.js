/*----------------页面加载相关代码----------------*/

/**
 * 判断是否登录
 * 未登录，则跳转到首页
 */
$(document).ready(function () {

  // 判断是否登录：未登录则跳转到首页
  var userName = getCookie("userName");
  if (userName == null) {
    window.location.href = "index.jsp";
  }

  // 判断是否管理员：不是则跳转到首页
  var role = getCookie("role");
  if (role != "管理员" && role != "教师") {
    window.location.href = "index.jsp";
  }

  // 显示用户昵称
  var nickName = getCookie("nickName");
  $("#i_nickName").html("【"+nickName+"】");

  //加载第一个页面
  $("#div_content").load("admin/homePage/homePage.inc");

});


/*----------------页面按钮相关代码----------------*/
$(document).ready(function () {

  // 注销
  $("#a_invalide").click(function () {
    $.confirm({
      title: '提示!',
      content: '确定要离开吗？',
      buttons: {
        formSubmit: {
          text: '确定',
          btnClass: 'btn-green',
          action: function () {
            clearCookie();
            window.location.href = "index.jsp";
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
  })

  // 修改密码
  $("#a_changePwd").click(function () {
    $("#fm_pwd")[0].reset()
    $("#pwdChange").modal("show")
  })

  // 修改密码：保存
  $("#btn_pwd_save").click(function () {
    var pwd_old = $("#pwd_old").val()
    var pwd_new = $("#pwd_new").val()
    var pwd_repeat = $("#pwd_repeat").val()

    // 错误判断
    if (pwd_old == "" || pwd_old == null || pwd_old.trim().length == 0) {
      $.showMessage("原密码不能为空！");
      return;
    }

    var pwd = getCookie("password")
    if (md5(pwd_old) != pwd) {
      $.showMessage("原密码不正确！");
      return;
    }

    if (pwd_new == "" || pwd_new == null || pwd_new.trim().length == 0) {
      $.showMessage("新密码不能为空！");
      return;
    }

    if (pwd_repeat == "" || pwd_repeat == null || pwd_repeat.trim().length == 0) {
      $.showMessage("重复密码不能为空！");
      return;
    }

    if (pwd_old == pwd_new) {
      $.showMessage("新密码与原密码一致！");
      return;
    }

    if (pwd_new != pwd_repeat) {
      $.showMessage("两次输入密码不一致！");
      return;
    }

    // 修改密码
    $.post(
        "com/controller/user/Update",
        {id: getCookie("userId"), password: pwd_new},
        function (data) {
          var json = JSON.parse(data)
          if (json.success) {
            $.showMessage("密码修改成功");
            $("#pwdChange").modal("hide")
          }
        })

  })

});


/*----------------左侧导航相关代码----------------*/

// 定义一个用于loading的公共加载对象，所有页面切换和部分按钮（如查询、导出、保存）点击的时候，加载loading动画
var load = new Loading();

$(document).ready(function () {

  // 点击按钮触发loading动画
  $(".nav-treeview .nav-link").click(function () {
    load.init();
    load.start();
  })

  // 首页
  $("#a_homePage").click(function () {
    $("#span_title").html("教学管理 - <small>首页</small>");
    $("#div_content").load("admin/homePage/homePage.inc");
  });

  // 课程管理
  $("#a_basic_course").click(function () {
    $("#span_title").html("基础信息 - <small>课程管理</small>");
    $("#div_content").load("admin/basic/course/course.inc");
    $(".nav-link").css("color", "#c2c7d0");
    $("#a_basic_course").css("color", "#f0f000");
  });

  // 教师管理
  $("#a_basic_teacher").click(function () {
    $("#span_title").html("基础信息 - <small>教师管理</small>");
    $("#div_content").load("admin/basic/teacher/teacher.inc");
    $(".nav-link").css("color", "#c2c7d0");
    $("#a_basic_teacher").css("color", "#f0f000");
  });

  // 学生管理
  $("#a_basic_student").click(function () {
    $("#span_title").html("基础信息 - <small>学生管理</small>");
    $("#div_content").load("admin/basic/student/student.inc");
    $(".nav-link").css("color", "#c2c7d0");
    $("#a_basic_student").css("color", "#f0f000");
  });

  // 成绩录入
  $("#a_score_manage").click(function () {
    $("#span_title").html("成绩管理 - <small>成绩录入</small>");
    $("#div_content").load("admin/score/manage/manage.inc");
    $(".nav-link").css("color", "#c2c7d0");
    $("#a_score_manage").css("color", "#f0f000");
  });

  // 成绩统计
  $("#a_score_count").click(function () {
    $("#span_title").html("成绩管理 - <small>成绩统计</small>");
    $("#div_content").load("admin/score/count/count.inc");
    $(".nav-link").css("color", "#c2c7d0");
    $("#a_score_count").css("color", "#f0f000");
  });


});