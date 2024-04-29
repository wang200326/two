/**
 * 页面加载时，读取Storage
 */
$(function(){
  var info = window.sessionStorage.getItem("info");
  var json = JSON.parse(info);
  $("#h3_userName").html(json.userName);
  $("#h4_nickName").html(json.nickName);
  $("#img_imgURL").attr("src",json.imgURL);
})

/**
 * 点击返回时，清除Storage
 */
$(function(){
  $("#btn_back").click(function(){
    window.localStorage.clear();
    window.location.href = "index.jsp";
  })
})