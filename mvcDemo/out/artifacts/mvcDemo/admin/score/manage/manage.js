/*------------------定义全局变量------------------*/
console.log("建议把全局变量都定义在最上方，并写好注释");

/*------------------页面初始化相关代码------------------*/

/**
 * 初始化数据表格
 */
$(document).ready(function(){
    $('#tbl_score').bootstrapTable({
        columns: [
            {checkbox: true},
            {field:'student.name',title:'学生姓名',align:'center',valign:'middle',sortable:true,width:'100'},
            {field:'teacher.name',title:'任课教师',align:'center',valign:'middle',width:'100'},
            {field:'course.name',title:'课程名',align:'center',valign:'middle',width:'160'},
            {field:'term',title:'学期',align:'center',valign:'middle',width:'120'},
            {field:'score',title:'成绩',align:'center',valign:'middle',sortable:true,width:'60'},
            {field:'state',title:'考试状态',align:'center',valign:'middle',width:'100'}
        ],
        queryParams: function (params) {
            return params;
        },
        classes:'table table-bordered table-striped table-condensed table-hover',
        method:'get',//bootstrap默认的内置请求方式
        url:"/mvcDemo/com/demo/controller/score/Get",//要请求数据的文件路径
        sortName:'id',//默认排序列
        queryParamsType:'limit',//查询参数组织方式
        sidePagination:'server',//指定服务器端分页
        pagination:true,//是否分页，即分页按钮
        pageSize:10,//单页记录数
        pageList:[10,50,100,200],//分页步进值
        paginationHAlign:'right',//分页条水平对齐
        paginationVAlign:'bottom',//分页条垂直对齐
        singleSelect:true,//只能选中一行
        clickToSelect:true,//点击选中行
        toolbar:'#tb_score',//自定义工具栏对齐方式
        locale:'zh-CN',//支持中文
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


/*------------------表格tbl_score相关代码------------------*/

/**
 * 查找按钮
 */
$(document).ready(function(){
    $("#btn_score_search").click(function(){
        var param = $("#txt_score_name").val();
        $.get(
            "/mvcDemo/com/demo/controller/score/Get",
            {"param":param},
            function(data){
                var rs = JSON.parse(data);
                $('#tbl_score').bootstrapTable('load',rs.rows);//加载数据
            }
        );
    });
});