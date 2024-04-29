//页面未加载完毕之前显示loadingHtml内容
var loadingHtml = "<div id=\"loading\" style=\"width:100%;height:100%;margin:0px;padding:0px;overflow:hidden;position:absolute;left:0px;top:0px;z-index:10000000;background-color:#fff;\">"
        +'<div id="loading-center"><div class="sk-circle">'
        +'<div class="sk-circle1 sk-child"></div>'
        +'<div class="sk-circle2 sk-child"></div>'
        +'<div class="sk-circle3 sk-child"></div>'
        +'<div class="sk-circle4 sk-child"></div>'
        +'<div class="sk-circle5 sk-child"></div>'
        +'<div class="sk-circle6 sk-child"></div>'
        +'<div class="sk-circle7 sk-child"></div>'
        +'<div class="sk-circle8 sk-child"></div>'
        +'<div class="sk-circle9 sk-child"></div>'
        +'<div class="sk-circle10 sk-child"></div>'
        +'<div class="sk-circle11 sk-child"></div>'
        +'<div class="sk-circle12 sk-child"></div>'
      +'</div>正在加载，请稍侯...</div></div>';
document.write(loadingHtml);
//监听加载状态改变
document.onreadystatechange = completeLoading;
//加载完毕时移除loading效果
function completeLoading() {
  if (document.readyState == "complete") {
    setTimeout(function(){$("#loading").remove();},500);
  }
}