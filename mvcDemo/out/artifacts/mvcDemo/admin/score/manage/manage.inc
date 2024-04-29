<div class="content-wrapper" style="margin-top: 10px;">

    <div class="container-fluid">
      <div class="row">
        <div class="col-12">
          <div class="card">

            <div class="card-header">
              <!-- 表格工具栏 -->
              <div id="tb_score" class="toolbar">
                <form class="form-inline">
                  <div class="form-group">
                    <input id="txt_score_name" type="text" class="form-control" placeholder="学生名|教师名|课程名">
                    <a id="btn_score_search" class="btn btn-md btn-success" href="javascript:void(0)"><span class="icon-clipboard"></span>查找</a>
                  </div>
                </form>
              </div>
            </div>

            <div class="card-body">
              <!-- 数据表格 -->
              <table id="tbl_score" class="table table-bordered table-striped"></table>
            </div><!-- /.card-body -->

          </div><!-- /.card -->
        </div><!-- /.col -->
      </div><!-- /.row -->
    </div><!-- /.container-fluid -->

</div><!-- /.content-wrapper -->



<!-- 表格相关脚本 -->
<script type="text/javascript" src="admin/score/manage/manage.js"></script>