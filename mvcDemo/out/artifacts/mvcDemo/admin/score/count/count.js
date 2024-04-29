/*------------------定义全局变量------------------*/
console.log("建议把全局变量都定义在最上方，并写好注释");

/*------------------页面初始化相关代码------------------*/

/**
 * 加载全部课程统计的结果
 */
$(document).ready(function(){
    $.get(
        "/mvcDemo/com/demo/controller/score/GetCount",
        function(data){
            var result = JSON.parse(data);
            var arr = new Array();
            arr[0] = result.rows[0].e;//不及格
            arr[1] = result.rows[0].d;//及格
            arr[2] = result.rows[0].c;//中等
            arr[3] = result.rows[0].b;//良好
            arr[4] = result.rows[0].a;//优秀
            var title = "全部课程";
            var subTitle = "各分数段统计";
            setCharts(title,subTitle,arr);
            // 结束loading动画
            setTimeout(function () {
                load.stop();
            }, 1000)
        }
    );
});


/*------------------相关代码------------------*/

/**
 * 生成图表
 */
function setCharts(title,subTitle,arr){
    Highcharts.chart('highchart_count', {
        chart: {
            type: 'column'
        },
        title: {
            text: title
        },
        subtitle: {
            text: subTitle
        },
        xAxis: {
            categories: ['不及格', '及格', '中等', '良好', '优秀']
        },
        yAxis: {
            title: {
                text: '人数'
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                },
                enableMouseTracking: false
            }
        },
        series: [{
            name: '人数',
            data: arr
        }]
    })
}

/**
 * 初始化下拉列表
 */
$(document).ready(function(){
    // 生成combobox，这里写成读取JSON文件
    // 如果需要读取数据库，请自行去后台编写/com/demo/controller/score/Get接口
    $.get(
        "/mvcDemo/res/json/course.json",
        function(data){
            var str = "";
            for(var i in data){
                str += "<option value='"+data[i].id+"'>";
                str += data[i].name;
                str += "</option>";
            }
            $("#select_course").html(str);
        }
    );
});

/**
 * 下拉列表绑定事件
 */
$(document).ready(function(){
    $('#select_course').change(function(){
        var param = $(this).children('option:selected').val();
        var paramStr = $(this).children('option:selected').text();
        $.get(
            "/mvcDemo/com/demo/controller/score/GetCount",
            {"param":param},
            function(data){
                var result = JSON.parse(data);
                var arr = new Array();
                arr[0] = result.rows[0].e;//不及格
                arr[1] = result.rows[0].d;//及格
                arr[2] = result.rows[0].c;//中等
                arr[3] = result.rows[0].b;//良好
                arr[4] = result.rows[0].a;//优秀
                var title = "《"+paramStr+"》成绩统计";
                var subTitle = "各分数段统计";
                setCharts(title,subTitle,arr);
            }
        );
    })
})
