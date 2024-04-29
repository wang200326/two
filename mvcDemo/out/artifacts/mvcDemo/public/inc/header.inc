<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<!-- 顶部导航 -->
<nav class="navbar navbar-expand-md navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="javascript:void(0)">
      <img src="res/img/logo.ico"/>
      <label>教学管理系统 </label>
      <span>MVC Demo</span>
    </a>

    <div id="div_login" style="display:block">
      <ul class="navbar-nav justify-content-end" id="navbar_login" >
        <li class="nav-item">
          <a class="nav-link" class="btn btn-primary btn-md" data-toggle="modal" data-target="#loginModal" href="javascript:void(0);">登录</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" class="btn btn-primary btn-md" data-toggle="modal" data-target="#registModal" href="javascript:void(0);">注册</a>
        </li>
      </ul>
    </div>

    <div id="div_info" style="display:none">
      <div class="dropdown" id="navbar_info">
        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
          <span id="span_info" class="glyphicon glyphicon-user" aria-hidden="true"> 欢迎您【张三】 </span>
        </button>
        <ul class="dropdown-menu" aria-labelledby="a_info">
          <li>
            <a id="a_self" href="javascript:void(0)">
              <span style="margin:10px 0px" class="glyphicon glyphicon-cog" aria-hidden="true"> 个人中心 </span>
            </a>
          </li>
          <li>
            <a id="a_exit" href="javascript:void(0)">
              <span style="margin:10px 0px" class="glyphicon glyphicon-log-out" aria-hidden="true"> 退出 </span>
            </a>
          </li>
        </ul>
      </div>
    </div>

  </div>
</nav>

<!-- 登录模态框 -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
<div class="modal-dialog" role="document">
  <div class="modal-content">
    <div class="modal-header">
      <h4 class="modal-title" id="loginModalLabel">登录</h4>
    </div>
    <div class="modal-body">
      <form>
        <div class="input-group">
          <span class="glyphicon glyphicon-user" aria-hidden="true" style="margin-top:6px;margin-right:10px;"></span>
          <input type="text" id="txt_userName" name="userName" class="form-control" placeholder="Please Input UserName">
        </div>
        <div class="input-group" style="margin-top:20px;">
          <span class="glyphicon glyphicon-lock" aria-hidden="true" style="margin-top:6px;margin-right:10px;"></span>
          <input type="password" id="txt_password" name="password" class="form-control" placeholder="Please Input Password">
        </div>

      </form>
    </div>
    <div class="modal-footer">
      <a id="a_login" class="btn btn-md btn-success" href="javascript:void(0)">登录</a>
      <a class="btn btn-md btn-primary" data-dismiss="modal" href="javascript:void(0)">关闭</a>
    </div>
  </div>
</div>
</div>

<!-- 注册模态框 -->
<div class="modal fade" id="registModal" tabindex="-1" role="dialog" aria-labelledby="registModalLabel">
<div class="modal-dialog" role="document">
  <div class="modal-content">
    <div class="modal-header">
      <h4 class="modal-title" id="registModalLabel">注册</h4>
    </div>
    <div class="modal-body">
      <h5>类似student和teacher的添加操作，有兴趣的同学，自行实现</h5>
    </div>
    <div class="modal-footer">
      <a id="a_regist" class="btn btn-md btn-success" href="javascript:void(0)">注册</a>
      <a class="btn btn-md btn-primary" data-dismiss="modal" href="javascript:void(0)">关闭</a>
    </div>
  </div>
</div>
</div>



<script>
  $(document).ready(function(){
    <!-- 页面加载时，判断是否已登录 -->
    if(getCookie("userName") == null ){
      $("#div_login").css("display","block");
      $("#div_info").css("display","none");
    }else{
      $("#div_login").css("display","none");
      $("#div_info").css("display","block");
    }

    <!-- 用户登录 -->
    $("#a_login").click(function(){
      var username = $("#txt_userName").val();
      var password = $("#txt_password").val();
      if (username == "" || username == null || username.length == 0) {
          $.showMessage('用户名不能为空');
          return;
      }
      if (password == "" || password == null || password.length == 0) {
          $.showMessage('密码不能为空');
          return;
      }
      $.post(
        "com/demo/controller/index/Login",
        {"username": username, "password": password},
        function(data){
          var json = JSON.parse(data);
          if(json.success){
            loginJudge(json);
          }else{
            $.showMessage(json.msg);
          }
      });
    });

    <!-- 个人中心 -->
    $("#a_self").click(function(){
        $.showMessage('自己实现，我没空！');
    });

    <!-- 退出 -->
    $("#a_exit").click(function(){
        $.post(
          "com/demo/controller/index/Logout",
          function(data){
            var json = JSON.parse(data);
            if(json.success){
              clearCookie();
              $("#div_login").css("display","block");
              $("#div_info").css("display","none");
              window.location.href = "index.jsp";
            }else{
              $.showMessage(json.msg);
            }
          });

    });

  })

  /*
   * 登录判断
   */
  function loginJudge(json){
      if(json.total==1){
          var userName = json.rows[0].userName;
          var nickName = json.rows[0].nickName;
          var role = json.rows[0].role;
          // 保存cookie
          setCookie("userName",userName);
          setCookie("nickName",nickName);
          setCookie("role",role);
          // 跳转
          switch (role){
              case "管理员":
              case "教师":
                  window.location.href = "admin/main/main.jsp";
                  break;
              case "学生":
                  $("#div_login").css("display","none");
                  $("#div_info").css("display","block");
                  $("#span_info").html(" 欢迎您【"+nickName+"】 ");
                  $('#loginModal').modal('hide')
                  break;
              default:
                  break;
          }
      }
      else{
          $.showMessage(json.msg);
      }

  }
</script>