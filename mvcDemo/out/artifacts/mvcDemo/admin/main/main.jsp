<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<% String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <base href="<%=url%>">
  <title>后台管理</title>
  <!-- 元数据 -->
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/><!-- 解析字符集 -->
  <meta name="robots" content="none"/><!-- 页面不被检索 -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"><!-- IE兼容 -->
  <meta name="renderer" content="webkit|ie-comp|ie-stand"><!-- 国产浏览器高速模式 -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"><!-- 页面自适应 -->
  <!-- 禁用浏览器缓存 -->
  <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
  <META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
  <META HTTP-EQUIV="Expires" CONTENT="0">
  <!-- 通用图标-->
  <link rel="Shortcut Icon" type="image/x-icon" href="res/img/logo.ico">
  <link rel="Bookmark" type="image/x-icon" href="res/img/logo.ico"/>
  <!-- fontawesome -->
  <link rel="stylesheet" type="text/css" href="tool/fontawesome-free/css/fonts.googleapis.css">
  <link rel="stylesheet" type="text/css" href="tool/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" type="text/css" href="tool/ion-rangeslider/css/ionicons.min.css">
  <!-- theme -->
  <link rel="stylesheet" type="text/css" href="res/css/adminlte.min.css">
  <link rel="stylesheet" type="text/css" href="tool/overlayScrollbars/css/OverlayScrollbars.min.css">
  <!-- iconfont -->
  <link rel="stylesheet" type="text/css" href="tool/iconfont/style.css">
  <!-- jquery -->
  <script type="text/javascript" src="tool/jquery/jquery.min.js"></script>
  <script type="text/javascript" src="tool/jquery-ui/jquery-ui.min.js"></script>
  <!-- MD5 -->
  <script type="text/javascript" src="res/js/md5.js"></script>
  <!-- loading -->
  <link rel="stylesheet" type="text/css" href="tool/loading/loading.css">
  <script type="text/javascript" src="tool/loading/loading.js"></script>
  <!-- loading2 -->
  <link rel="stylesheet" type="text/css" href="tool/jquery-loading/loading.css">
  <!-- jquery-messager -->
  <link rel="stylesheet" type="text/css" href="tool/jquery-messager/jquery.fix-messager.css">
  <script type="text/javascript" src="tool/jquery-messager/jquery.fix-messager.js"></script>
  <!-- jquery-confirm -->
  <link rel="stylesheet" type="text/css" href="tool/jquery-confirm/dist/jquery-confirm.min.css">
  <script type="text/javascript" src="tool/jquery-confirm/dist/jquery-confirm.min.js"></script>
  <!-- bootstrap-table -->
  <link rel="stylesheet" type="text/css" href="tool/bootstrap-table-develop/dist/bootstrap-table.min.css">
  <script type="text/javascript" src="tool/bootstrap-table-develop/dist/bootstrap-table.min.js"></script>
  <script type="text/javascript" src="tool/bootstrap-table-develop/dist/locale/bootstrap-table-zh-CN.min.js"></script>
  <!-- Ueditor -->
  <script type="text/javascript" src="tool/ueditor/ueditor.config.js"></script>
  <script type="text/javascript" src="tool/ueditor/_examples/editor_api.js"></script>
  <script type="text/javascript" src="tool/ueditor/lang/zh-cn/zh-cn.js"></script>
  <!-- hightCharts -->
  <script type="text/javascript" src="tool/highcharts/code/highcharts.js"></script>

</head>

<body>
<!--
    oncontextmenu="return false" ：禁止右键
    onselectstart="return false" : 禁止选取
    oncut = "return false" : 禁止剪切
    oncopy = "return false" : 禁止复制
    onpaste = "return false" : 禁止粘贴
-->
<div class="wrapper">

  <!-- 顶部导航 -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- 顶部左侧按钮 -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="javascript:void(0)" role="button">
          <i class="fas fa-bars"></i>
          <span id="span_title" style="font-size:20px;font-weight:700;margin-left:11px;">教学管理 - <small>首页</small></span>
        </a>
      </li>
      <li class="nav-item d-none d-sm-inline-block" style="margin-top: -10px;"></li>
    </ul>

    <!-- 顶部右侧按钮 -->
    <ul class="navbar-nav ml-auto">

      <!-- 顶部全屏按钮 -->
      <li class="nav-item">
        <a class="nav-link" data-widget="fullscreen" href="javascript:void(0)" role="button"><i
            class="fas fa-expand-arrows-alt"></i></a>
      </li>

      <!-- 顶部个人菜单 -->
      <li class="nav-item dropdown">
        <!-- 用户图标 -->
        <a class="nav-link" data-toggle="dropdown" href="javascript:void(0)">
          <i id="i_nickName" class="far fa-user"></i>
        </a>
        <!-- 下拉菜单 -->
        <div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
          <!-- 个人中心 -->
          <a href="javascript:void(0)" class="dropdown-item">
            <div class="media">
              <img src="res/img/user.png" alt="User Avatar" class="img-size-50 mr-3 img-circle">
              <div class="media-body">
                <h3 class="dropdown-item-title">个人中心<span class="float-right text-sm text-muted"><i class="fas fa-star"></i></span></h3>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i>个人信息</p>
              </div>
            </div>
          </a>

          <div class="dropdown-divider"></div>
          <!-- 修改密码 -->
          <a id="a_changePwd" href="javascript:void(0)" class="dropdown-item">
            <div class="media">
              <img src="res/img/pwd.png" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">修改密码<span class="float-right text-sm text-muted"><i
                    class="fas fa-star"></i></span></h3>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i>修改个人密码</p>
              </div>
            </div><!-- Message End -->
          </a>

          <div class="dropdown-divider"></div>
          <!-- 注销 -->
          <a id="a_invalide" href="javascript:void(0)" class="dropdown-item">
            <div class="media">
              <img src="res/img/exit.png" alt="User Avatar" class="img-size-50 img-circle mr-3">
              <div class="media-body">
                <h3 class="dropdown-item-title">注销<span class="float-right text-sm text-danger"><i
                    class="fas fa-star"></i></span></h3>
                <p class="text-sm text-muted"><i class="far fa-clock mr-1"></i>退出离开</p>
              </div>
            </div><!-- Message End -->
          </a>
        </div>
      </li>

    </ul>
  </nav><!-- /.navbar -->

  <!-- 左侧导航 -->
  <aside class="main-sidebar sidebar-dark-primary">
    <!-- Brand Logo -->
    <a id="a_homePage" href="javascript:void(0)" class="brand-link">
      <img src="res/img/head.png" alt="Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text" style="font-weight: 700;letter-spacing: 1px">后台管理系统</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">

          <!-- 菜单1 -->
          <li class="nav-item menu-open">
            <a href="javascript:void(0)" class="nav-link">
              <i class="icon-viewlist"></i>
              <p>&ensp;基础信息<i class="right fas fa-angle-left"></i></p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a id="a_basic_course" href="javascript:void(0)" class="nav-link">
                  <i class="icon-clipboard4"></i>
                  <p>&ensp;课程管理</p>
                </a>
              </li>
              <li class="nav-item">
                <a id="a_basic_teacher" href="javascript:void(0)" class="nav-link">
                  <i class="icon-bussinessman"></i>
                  <p>&ensp;教师管理</p>
                </a>
              </li>
              <li class="nav-item">
                <a id="a_basic_student" href="javascript:void(0)" class="nav-link">
                  <i class="icon-users6"></i>
                  <p>&ensp;学生管理</p>
                </a>
              </li>
            </ul>
          </li>

          <!-- 菜单2 -->
          <li class="nav-item menu-open">
            <a href="javascript:void(0)" class="nav-link">
              <i class="icon-viewlist"></i>
              <p>&ensp;成绩管理<i class="fas fa-angle-left right"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a id="a_score_manage" href="javascript:void(0)" class="nav-link">
                  <i class="icon-check-square2"></i>
                  <p>&ensp;成绩录入</p>
                </a>
              </li>
              <li class="nav-item">
                <a id="a_score_count" href="javascript:void(0)" class="nav-link">
                  <i class="icon-viewlist"></i>
                  <p>&ensp;成绩统计</p>
                </a>
              </li>
            </ul>
          </li>

        </ul>
      </nav>
    </div><!-- /.sidebar-menu -->
  </aside><!-- /.sidebar -->

  <!-- 主体内容 -->
  <div id="div_content"></div>

  <!-- 右侧底部 -->
  <footer class="main-footer">
    <div class="float-right d-none d-sm-block">
      <b>Version</b> 1.3.2
    </div>
    <strong>Copyright &copy; 2000 <a href="http://www.jju.edu.cn/" target="_blank">GeekCN</a>.</strong> All rights
    reserved.
  </footer>

</div><!-- ./wrapper -->


<!-- 修改密码模态框 -->
<div class="modal fade" id="pwdChange" tabindex="-1" role="dialog" aria-labelledby="userEditLabel"
     data-backdrop="static">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">

      <div class="modal-header">
        <h6 class="modal-title" id="userEditLabel">修改密码</h6>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span></button>
      </div>

      <div class="modal-body">
        <form id="fm_pwd">
          <input type="hidden" class="form-control" id="userEdit_id" name="id">
          <div class="row">
            <div class="col-sm-12">
              <div class="form-group">
                <label for="pwd_old">原密码</label>
                <input type="password" class="form-control" id="pwd_old" name="pwd_old" placeholder="原密码">
              </div>
            </div>
            <div class="col-sm-12">
              <div class="form-group">
                <label for="pwd_new" style="color:#c00000">新密码</label>
                <input type="password" class="form-control" id="pwd_new" name="pwd_new" placeholder="新密码">
              </div>
            </div>
            <div class="col-sm-12">
              <div class="form-group">
                <label for="pwd_repeat" style="color:#c00000">重复密码</label>
                <input type="password" class="form-control" id="pwd_repeat" name="pwd_repeat" placeholder="重复密码">
              </div>
            </div>
          </div>

        </form>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button id="btn_pwd_save" type="button" class="btn btn-primary">保存</button>
      </div>

    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal fade -->


<!-- Bootstrap 4 -->
<script type="text/javascript" src="tool/bootstrap/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="tool/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- ckeditor -->
<script type="text/javascript" src="tool/ckeditor/ckeditor.js"></script>
<!-- daterangepicker -->
<link rel="stylesheet" href="tool/daterangepicker/daterangepicker.css">
<script type="text/javascript" src="tool/daterangepicker/moment.min.js"></script>
<script type="text/javascript" src="tool/daterangepicker/daterangepicker.js"></script>
<!-- overlayScrollbars -->
<script type="text/javascript" src="tool/overlayScrollbars/js/jquery.overlayScrollbars.min.js"></script>
<!-- AdminLTE App -->
<script type="text/javascript" src="res/js/adminlte.js"></script>
<!-- loading2 -->
<script type="text/javascript" src="tool/jquery-loading/loading.js"></script>
<!-- 相关脚本 -->
<script type="text/javascript" src="res/js/util.js"></script>
<script type="text/javascript" src="res/js/md5.js"></script>
<script type="text/javascript" src="admin/main/main.js"></script>
</body>
</html>