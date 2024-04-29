<div class="content-wrapper" style="margin-top: 10px;">
  <section class="content">
    <div class="container-fluid">
      <div class="row">
        <div class="col-12">
          <div class="card">

            <div class="card-header">
              <!-- 表格工具栏 -->
              <div id="tb_student" class="toolbar">
                <form class="form-inline">
                  <input type="text" class="form-control" style="width:250px" placeholder="学号|姓名" id="searchName">
                  <button type="button" class="btn btn-success" id="btn_search"><span class="icon-search"></span> 查询</button>
                  <button type="button" class="btn btn-success" id="btn_insert"><span class="icon-add"></span> 添加</button>
                  <button type="button" class="btn btn-success" id="btn_export"><span class="icon-download11"></span> 导出</button>
                </form>
              </div>
            </div>

            <div class="card-body">
              <!-- 数据表格 -->
              <table id="tbl_student" class="table table-bordered table-striped"></table>
            </div><!-- /.card-body -->

          </div><!-- /.card -->
        </div><!-- /.col -->
      </div><!-- /.row -->
    </div><!-- /.container-fluid -->
  </section><!-- /.content -->
</div><!-- /.content-wrapper -->


<!-- 详情模态框 -->
<div class="modal fade" id="studentInfo" tabindex="-1" role="dialog" aria-labelledby="studentInfoLabel" data-backdrop="static">
  <div class="modal-dialog" role="document">
    <div class="modal-content">

      <div class="modal-header">
        <h6 class="modal-title" id="studentInfoLabel">用户详情</h6>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span></button>
      </div>

      <div class="modal-body">
        <h5 style="margin:15px"><strong>学号：</strong><span id="studentInfo_sequence"></span></h5>
        <h5 style="margin:15px"><strong>姓名：</strong><span id="studentInfo_name"></span></h5>
        <h5 style="margin:15px"><strong>性别：</strong><span id="studentInfo_gender"></span></h5>
        <h5 style="margin:15px"><strong>身份证号：</strong><span id="studentInfo_card"></span></h5>
        <h5 style="margin:15px"><strong>出生日期：</strong><span id="studentInfo_birthday"></span></h5>
        <h5 style="margin:15px"><strong>民族：</strong><span id="studentInfo_nation"></span></h5>
        <h5 style="margin:15px"><strong>籍贯：</strong><span id="studentInfo_nativePlace"></span></h5>
        <h5 style="margin:15px"><strong>政治面貌：</strong><span id="studentInfo_political"></span></h5>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
      </div>

    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal fade -->


<!-- 编辑模态框 -->
<div class="modal fade" id="studentEdit" tabindex="-1" role="dialog" aria-labelledby="studentEditLabel" data-backdrop="static">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">

      <div class="modal-header">
        <h6 class="modal-title" id="studentEditLabel">编辑用户</h6>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span></button>
      </div>

      <div class="modal-body">
        <form id="fm_studentEdit">
          <input type="hidden" class="form-control" id="studentEdit_id" name="id">
          <div class="row">
            <div class="col-sm-6">
              <div class="form-group">
                <label for="studentEdit_sequence" style="color:#c00000">学号</label>
                <input type="text" class="form-control" id="studentEdit_sequence" name="sequence" placeholder="请输入学号">
              </div>
            </div>
            <div class="col-sm-6">
              <div class="form-group">
                <label for="studentEdit_name" style="color:#c00000">姓名</label>
                <input type="text" class="form-control" id="studentEdit_name" name="name" placeholder="请输入姓名">
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-sm-6">
              <div class="form-group">
                <label for="studentEdit_gender">性别</label>
                <select class="form-control" id="studentEdit_gender" name="gender"></select>
              </div>
            </div>
            <div class="col-sm-6">
              <div class="form-group">
                <label for="studentEdit_card">身份证号</label>
                <input type="text" class="form-control" id="studentEdit_card" name="card" placeholder="请输入身份证号">
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-sm-6">
              <div class="form-group">
                <label for="studentEdit_birthday">出生日期</label>
                <input type="date" class="form-control" id="studentEdit_birthday" name="birthday" placeholder="请选择出生日期">
              </div>
            </div>
            <div class="col-sm-6">
              <div class="form-group">
                <label for="studentEdit_nation">民族</label>
                <select class="form-control" id="studentEdit_nation" name="nation"></select>
              </div>
            </div>
          </div>

          <div class="row">
            <div class="col-sm-6">
              <div class="form-group">
                <label for="studentEdit_nativePlace">籍贯</label>
                <input type="text" class="form-control" id="studentEdit_nativePlace" name="nativePlace" placeholder="请输入籍贯">
              </div>
            </div>
            <div class="col-sm-6">
              <div class="form-group">
                <label for="studentEdit_political">政治面貌</label>
                <select class="form-control" id="studentEdit_political" name="political"></select>
              </div>
            </div>
          </div>

        </form>
      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button id="btn_studentEdit_save" type="button" class="btn btn-primary">保存</button>
      </div>

    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal fade -->

<!-- 表格相关脚本 -->
<script type="text/javascript" src="admin/basic/student/student.js"></script>