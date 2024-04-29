

/**
 * <summary>创建cookies</summary>
 */
function setCookie(name,value){
  var Days = 30;
  var exp = new Date(); 
  exp.setTime(exp.getTime() + Days*24*60*60*1000);
  document.cookie = name + "="+ escape(value) + ";expires=" + exp.toGMTString()+";path=/";
}

/**
 * <summary>读取cookies</summary>
 */
function getCookie(name){
  var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
  if(arr=document.cookie.match(reg)){
    return unescape(arr[2]);
  }else{
    return null;
  } 
}

/**
 * <summary>删除cookies</summary>
 */
function delCookie(name){
  var exp = new Date();
  exp.setTime(exp.getTime() - 1);
  var cval=getCookie(name);
  if(cval!=null){
    document.cookie= name + "="+cval+";expires="+exp.toGMTString()+";path=/";
  } 
}

/**
 * <summary>清除cookies</summary>
 */  
function clearCookie(){  
  var myDate=new Date();    
  myDate.setTime(-1000);//设置时间    
  var data=document.cookie;    
  var dataArray=data.split("; ");    
  for(var i=0;i<dataArray.length;i++){ 
    var varName=dataArray[i].split("=");    
    document.cookie=varName[0]+"=''; expires="+myDate.toGMTString()+";path=/";    
  }    
}

/**
 * <summary>在URL后增加一个时间戳</summary>
 */
function AddStamp(url){
  var timestamp =(new Date()).valueOf();//获取当前毫秒的时间戳
  //var timestamp = new Date().getTime();//同上
  //var timestamp = Date.parse(new Date());//同上，但毫秒改成000显示
  if(url.indexOf("?")>= 0){url += "&timestamp=" + timestamp;}
  else{url += "?timestamp=" + timestamp;}
  return url;
}

/**
 * <summary>判断浏览器内核</summary>
 */
function judgeRenderer(){
  if(navigator.userAgent.indexOf("MSIE")>0) {// MSIE内核        
    return "MSIE"; 
  }
  if(navigator.userAgent.indexOf("Firefox")>0){// Firefox内核       
    return "Firefox"; 
  }
  if(navigator.userAgent.indexOf("Opera")>0){// Opera内核       
    return "Opera"; 
  }
  if(navigator.userAgent.indexOf("Safari")>0) {// Safari内核       
    return "Safari";  
  } 
  if(navigator.userAgent.indexOf("Camino")>0){// Camino内核       
    return "Camino"; 
  } 
  if(navigator.userAgent.indexOf("Gecko")>0){// Gecko(IE)内核      
    return "Gecko"; 
  } 
}