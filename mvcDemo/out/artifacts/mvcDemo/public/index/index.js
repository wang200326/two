
/**
 * 页面加载时，渲染“学员风采”
 */
$(function(){
  $.get("com/demo/controller/index/RndUser",function(data){
    var json = JSON.parse(data);
    if(json.success){
      var temp = "";
      for(var i in json.rows){
        var info = JSON.stringify(json.rows[i]);
        temp += "<div class='col-md-4'>";
        temp += "  <div class='card text-center'>";
        temp += "    <img class='card-img-top' src="+json.rows[i].imgURL+" alt='...'>";
        temp += "    <div class='card-body'>";
        temp += "      <p class='card-text'>"+json.rows[i].userName+" | "+json.rows[i].nickName+"</p>";
        temp += "      <a href='javascript:redirectory("+info+")' class='btn btn-secondary'>查看详情</a>";
        temp += "    </div>";
        temp += "  </div>";
        temp += "</div>";
      }
      $("#div_userRnd").html(temp);
    }
  });
})

/**
 * 点击“查看详情”时，将当前用户的信息保存到Storage
 * 
 */
function redirectory(data){
  //存Storage
  //需要注意的是：Storage中不能存对象，
  //所以，我们需要把data转换为字符串格式再存储
  //读取的时候，我们再转成JSON对象
  var info = JSON.stringify(data)
  window.sessionStorage.setItem("info",info);
  //跳转页面
  window.location.href="public/detail/detail.jsp";
}