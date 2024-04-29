/**
 * 获取用户当前浏览器的名称、(基于)内核版本号、（自身浏览器厂商的）内核版本号、浏览器所处的操作系统版本信息
 * 系统版本 只测试了 Windows 系统  ，IE 浏览器 只测试了 IE9-IE 最新版
 * Safari 浏览器仅测试了 Windows 版
 * 浏览器更新快，有些代码可能会失效
 */
(function ($) {
  var BrowserMatch = {
    init: function () {
      this.browser = this.getBrowser().browser || "未知浏览器"; //获取浏览器名
      this.version = this.getBrowser().version || "未知浏览器版本号"; //获取浏览器版本
      this.OS = this.getOS() + " " + this.getDigits() || "未知操作系统"; //系统版本号
    },
    getOS: function () { //判断所处操作系统
      var sUserAgent = navigator.userAgent.toLowerCase();

      var isWin = (navigator.platform == "Win32") || (navigator.platform == "Win64") || (navigator.platform == "wow64");

      var isMac = (navigator.platform == "Mac68K") || (navigator.platform == "MacPPC") || (navigator.platform == "Macintosh") || (navigator.platform == "MacIntel");
      if (isMac) return "Mac";
      var isUnix = (navigator.platform == "X11") && !isWin && !isMac;
      if (isUnix) return "Unix";
      var isLinux = (String(navigator.platform).indexOf("Linux") > -1);
      var bIsAndroid = sUserAgent.toLowerCase().match(/android/i) == "android";
      if (isLinux) {
        if (bIsAndroid) return "Android";
        else return "Linux";
      }
      if (isWin) {
        var isWin2K = sUserAgent.indexOf("Windows nt 5.0") > -1 || sUserAgent.indexOf("Windows 2000") > -1;
        if (isWin2K) return "Win2000";
        var isWinXP = sUserAgent.indexOf("Windows nt 5.1") > -1 || sUserAgent.indexOf("Windows XP") > -1;
        if (isWinXP) return "WinXP";
        var isWin2003 = sUserAgent.indexOf("Windows nt 5.2") > -1 || sUserAgent.indexOf("Windows 2003") > -1;
        if (isWin2003) return "Win2003";
        var isWinVista = sUserAgent.indexOf("Windows nt 6.0") > -1 || sUserAgent.indexOf("Windows Vista") > -1;
        if (isWinVista) return "WinVista";
        var isWin7 = sUserAgent.indexOf("Windows nt 6.1") > -1 || sUserAgent.indexOf("Windows 7") > -1;
        if (isWin7) return "Win7";
        var isWin8 = sUserAgent.indexOf("windows nt 6.2") > -1 || sUserAgent.indexOf("Windows 8") > -1;
        if (isWin8) return "Win8";
        var isWin10 = sUserAgent.indexOf("windows nt 10.0") > -1 || sUserAgent.indexOf("Windows 10") > -1;
        if (isWin10) return "Win10";
      }
      return "其他";
    },
    getDigits: function () { //判断当前操作系统的版本号
      var sUserAgent = navigator.userAgent.toLowerCase();
      var is64 = sUserAgent.indexOf("win64") > -1 || sUserAgent.indexOf("wow64") > -1;
      if (is64) {
        return "64位";
      } else {
        return "32位";
      }
    },
    getBrowser: function () { // 获取浏览器名
      var rMsie = /(msie\s|trident\/7)([\w\.]+)/;
      var rTrident = /(trident)\/([\w.]+)/;
      var rEdge = /(chrome)\/([\w.]+)/; //IE
      var rFirefox = /(firefox)\/([\w.]+)/; //火狐
      var rOpera = /(opera).+version\/([\w.]+)/; //旧Opera
      var rNewOpera = /(opr)\/(.+)/; //新Opera 基于谷歌
      var rChrome = /(chrome)\/([\w.]+)/; //谷歌
      var rUC = /(chrome)\/([\w.]+)/; //UC
      var rMaxthon = /(chrome)\/([\w.]+)/; //遨游
      var r2345 = /(chrome)\/([\w.]+)/; //2345
      var rQQ = /(chrome)\/([\w.]+)/; //QQ
      //var rMetasr =  /(metasr)\/([\w.]+)/;//搜狗
      var rSafari = /version\/([\w.]+).*(safari)/;

      var ua = navigator.userAgent.toLowerCase();

      var matchBS, matchBS2;

      //IE 低版
      matchBS = rMsie.exec(ua);
      if (matchBS != null) {
        matchBS2 = rTrident.exec(ua);
        if (matchBS2 != null) {
          switch (matchBS2[2]) {
            case "4.0":
              return {
                browser:
                    "Microsoft IE",
                version: "IE: 8" //内核版本号
              };
              break;
            case "5.0":
              return {
                browser:
                    "Microsoft IE",
                version: "IE: 9"
              };
              break;
            case "6.0":
              return {
                browser:
                    "Microsoft IE",
                version: "IE: 10"
              };
              break;
            case "7.0":
              return {
                browser:
                    "Microsoft IE",
                version: "IE: 11"
              };
              break;
            default:
              return {
                browser:
                    "Microsoft IE",
                version: "Undefined"
              };
          }
        } else {
          return {
            browser: "Microsoft IE",
            version: "IE:" + matchBS[2] || "0"
          };
        }
      }
      //IE最新版
      matchBS = rEdge.exec(ua);
      if ((matchBS != null) && (!(window.attachEvent))) {
        return {
          browser: "Microsoft Edge",
          version: "Chrome/" + matchBS[2] || "0"
        };
      }
      //UC浏览器
      matchBS = rUC.exec(ua);
      if ((matchBS != null) && (!(window.attachEvent))) {
        return {
          browser: "UC",
          version: "Chrome/" + matchBS[2] || "0"
        };
      }
      //火狐浏览器
      matchBS = rFirefox.exec(ua);
      if ((matchBS != null) && (!(window.attachEvent))) {
        return {
          browser: "火狐",
          version: "Firefox/" + matchBS[2] || "0"
        };
      }
      //Oper浏览器
      matchBS = rOpera.exec(ua);
      if ((matchBS != null) && (!(window.attachEvent))) {
        return {
          browser: "Opera",
          version: "Chrome/" + matchBS[2] || "0"
        };
      }
      //遨游
      matchBS = rMaxthon.exec(ua);
      if ((matchBS != null) && (!(window.attachEvent))) {
        return {
          browser: "遨游",
          version: "Chrome/" + matchBS[2] || "0"
        };
      }
      //2345浏览器
      matchBS = r2345.exec(ua);
      if ((matchBS != null) && (!(window.attachEvent))) {
        return {
          browser: "2345",
          version: "Chrome/ " + matchBS[2] || "0"
        };
      }
      //QQ浏览器
      matchBS = rQQ.exec(ua);
      if ((matchBS != null) && (!(window.attachEvent))) {
        return {
          browser: "QQ",
          version: "Chrome/" + matchBS[2] || "0"
        };
      }
      //Safari（苹果）浏览器
      matchBS = rSafari.exec(ua);
      if ((matchBS != null) && (!(window.attachEvent)) && (!(window.chrome)) && (!(window.opera))) {
        return {
          browser: "Safari",
          version: "Safari/" + matchBS[1] || "0"
        };
      }
      //谷歌浏览器
      matchBS = rChrome.exec(ua);
      if ((matchBS != null) && (!(window.attachEvent))) {
        matchBS2 = rNewOpera.exec(ua);
        if (matchBS2 == null) {
          return {
            browser: "谷歌",
            version: "Chrome/" + matchBS[2] || "0"
          };
        } else {
          return {
            browser: "Opera",
            version: "opr/" + matchBS2[2] || "0"
          };
        }
      }
    }
  };
  BrowserMatch.init();
  console.log("当前浏览器：" + BrowserMatch.browser + "\n浏览器版本：" + BrowserMatch.version + "\n当前操作系统：" + BrowserMatch.OS);
})(jQuery);


/**
 * 判断浏览器内核(不合适的浏览器内核，容易影响用户体验)
 */
function judgeRenderer() {
  if (navigator.userAgent.indexOf("MSIE") > 0) {// MSIE内核
    return "MSIE";
  }
  if (navigator.userAgent.indexOf("Firefox") > 0) {// Firefox内核
    return "Firefox";
  }
  if (navigator.userAgent.indexOf("Opera") > 0) {// Opera内核
    return "Opera";
  }
  if (navigator.userAgent.indexOf("Safari") > 0) {// Safari内核
    return "Safari";
  }
  if (navigator.userAgent.indexOf("Camino") > 0) {// Camino内核
    return "Camino";
  }
  if (navigator.userAgent.indexOf("Gecko") > 0) {// Gecko(IE)内核
    return "Gecko";
  }
}


/**
 * 获取本机IP
 */
function getIP(onNewIP) {
  var myPeerConnection = window.RTCPeerConnection || window.mozRTCPeerConnection || window.webkitRTCPeerConnection;//兼容firefox和chrome
  var pc = new myPeerConnection({
        iceServers: []
      }),
      noop = function () {
      },
      localIPs = {},
      ipRegex = /([0-9]{1,3}(\.[0-9]{1,3}){3}|[a-f0-9]{1,4}(:[a-f0-9]{1,4}){7})/g, key;

  //迭代
  function iterateIP(ip) {
    if (!localIPs[ip]) onNewIP(ip);
    localIPs[ip] = true;
  }

  //创建虚拟数据通道
  pc.createDataChannel("");

  //创建并设置提供本地描述
  pc.createOffer().then(function (sdp) {
    sdp.sdp.split('\n').forEach(function (line) {
          if (line.indexOf('candidate') < 0) {
            return;
          }
          line.match(ipRegex).forEach(iterateIP);
        }
    );

    //抛出异常
    pc.setLocalDescription(sdp, noop, noop);
  }).catch(function (reason) {
    console.log("处理连接故障");
  });

  //sten候选事件
  pc.onicecandidate = function (ice) {
    if (!ice || !ice.candidate || !ice.candidate.candidate || !ice.candidate.candidate.match(ipRegex)) {
      return;
    }
    ice.candidate.candidate.match(ipRegex).forEach(iterateIP);
  }
}


/**
 * 判断浏览器是否禁用Cookie，不开启无法正常使用
 */
function judgeCookie() {
  var str = "";
  var dt = new Date();
  dt.setSeconds(dt.getSeconds() + 60);
  document.cookie = "cookietest=1; expires=" + dt.toGMTString();
  var cookiesEnabled = document.cookie.indexOf("cookietest=") != -1;
  if (!cookiesEnabled) {
    str = ('此电脑的浏览器禁用了Cookie，请手动开启，否则无法正常使用！');
  }
  return str;
}


/**
 * <summary>创建cookies</summary>
 */
function setCookie(name, value) {
  var Days = 30;
  var exp = new Date();
  exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
  //document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/" + ";SameSite=none";
  document.cookie = name + "=" + escape(value) + ";expires=" + exp.toGMTString() + ";path=/";
}


/**
 * <summary>读取cookies</summary>
 */
function getCookie(name) {
  var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
  if (arr = document.cookie.match(reg)) {
    return unescape(arr[2]);
  } else {
    return null;
  }
}


/**
 * <summary>删除cookies</summary>
 */
function delCookie(name) {
  var exp = new Date();
  exp.setTime(exp.getTime() - 1);
  var cval = getCookie(name);
  if (cval != null) {
    document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString() + ";path=/";
  }
}


/**
 * <summary>清除cookies</summary>
 */
function clearCookie() {
  var myDate = new Date();
  myDate.setTime(-1000);//设置时间
  var data = document.cookie;
  var dataArray = data.split("; ");
  for (var i = 0; i < dataArray.length; i++) {
    var varName = dataArray[i].split("=");
    document.cookie = varName[0] + "=''; expires=" + myDate.toGMTString() + ";path=/";
  }
}


/**
 * <summary>在URL后增加一个时间戳</summary>
 * <param name="url">传入的url
 */
function urlAddStamp(url) {
  var timestamp = (new Date()).valueOf();//获取当前毫秒的时间戳
  //var timestamp = new Date().getTime();//同上
  //var timestamp = Date.parse(new Date());//同上，但毫秒改成000显示
  if (url.indexOf("?") >= 0) {
    url += "&timestamp=" + timestamp;
  } else {
    url += "?timestamp=" + timestamp;
  }
  return url;
}


/**
 * <summary>获取本机日期</summary>
 * 月份日期均2位显示
 * 2020-05-07
 */
function getLocalDate() {
  var date = new Date()
  var yy = date.getFullYear()
  var mm = (date.getMonth() + 101).toString().substring(1, 3)
  var dd = (date.getDate() + 100).toString().substring(1, 3)
  var now = yy + "-" + mm + "-" + dd
  return now
}


/**
 * <summary>获取本机时间</summary>
 * 日期和时间均2位显示
 * 2000-05-07 08:03:09
 */
function getLocalDateTime() {
  var date = new Date()
  var yy = date.getFullYear()
  var mm = (date.getMonth() + 101).toString().substring(1, 3)
  var dd = (date.getDate() + 100).toString().substring(1, 3)
  var hh = (date.getHours() + 100).toString().substring(1, 3)
  var m = (date.getMinutes() + 100).toString().substring(1, 3)
  var ss = (date.getSeconds() + 100).toString().substring(1, 3)
  var now = yy + "-" + mm + "-" + dd + " " + hh + ":" + m + ":" + ss
  return now
}


/**
 * <summary>本机时间加减日期</summary>
 * <param name="n">传需要加减的年数
 * 正数：后移；负数：前移
 */
function localDateTimeAddDay(n) {
  var date = new Date()
  date.setDate(date.getDate() + n)
  var yy = date.getFullYear()
  var mm = (date.getMonth() + 101).toString().substring(1, 3)
  var dd = (date.getDate() + 100).toString().substring(1, 3)
  var hh = (date.getHours() + 100).toString().substring(1, 3)
  var m = (date.getMinutes() + 100).toString().substring(1, 3)
  var ss = (date.getSeconds() + 100).toString().substring(1, 3)
  var now = yy + "-" + mm + "-" + dd + " " + hh + ":" + m + ":" + ss
  return now
}


/**
 * <summary>本机时间加减月份</summary>
 * <param name="n">传需要加减的年数
 * 正数：后移；负数：前移
 */
function localDateTimeAddMonth(n) {
  var date = new Date()
  date.setMonth(date.getMonth() + n)
  var yy = date.getFullYear()
  var mm = (date.getMonth() + 101).toString().substring(1, 3)
  var dd = (date.getDate() + 100).toString().substring(1, 3)
  var hh = (date.getHours() + 100).toString().substring(1, 3)
  var m = (date.getMinutes() + 100).toString().substring(1, 3)
  var ss = (date.getSeconds() + 100).toString().substring(1, 3)
  var now = yy + "-" + mm + "-" + dd + " " + hh + ":" + m + ":" + ss
  return now
}


/**
 * <summary>本机时间加减年份</summary>
 * <param name="n">传需要加减的年数
 * 正数：后移；负数：前移
 */
function localDateTimeAddYear(n) {
  var date = new Date()
  date.setFullYear(date.getFullYear() + n)
  var yy = date.getFullYear()
  var mm = (date.getMonth() + 101).toString().substring(1, 3)
  var dd = (date.getDate() + 100).toString().substring(1, 3)
  var hh = (date.getHours() + 100).toString().substring(1, 3)
  var m = (date.getMinutes() + 100).toString().substring(1, 3)
  var ss = (date.getSeconds() + 100).toString().substring(1, 3)
  var now = yy + "-" + mm + "-" + dd + " " + hh + ":" + m + ":" + ss
  return now
}


/**
 * <summary>字符串格式化</summary>
 * 用法：String.format("x={0},y={1}",x,y);
 */
String.format = function (src) {
  if (arguments.length == 0) return null;
  var args = Array.prototype.slice.call(arguments, 1);
  return src.replace(/\{(\d+)\}/g, function (m, i) {
    return args[i];
  });
};


/**
 * <summary>获得序列，如id序列</summary>
 * <param name="array">传入的id序列
 * <param name="key">返回的id序列
 */
function getKeySerialize(array, key) {
  var keys = new Array();
  for (var i in array) {
    keys.push(array[i][key]);
  }
  return keys.toString();
}


/**
 * <summary>禁止连续点击</summary>
 * <summary>防止按钮重复点击提交</summary>
 */
$(function () {
  var clicktag = 0;
  $(".easyui-linkbutton").click(function () {
    if (clicktag == 0) {
      clicktag = 1;
      setTimeout(function () {
        clicktag = 0
      }, 1000);
    } else {
      $.messager.alert('提示', '请勿频繁点击！', 'info');
    }
  });
});


/**
 * <summary>导出csv</summary>
 * <param name="JSONData">表格数据(JSON格式)
 * <param name="fileName">导出文件名
 * <param name="ReportTitle">表头
 * <param name="ShowTitle">是否显示表头(true|false)
 */
function JSON2CSV(JSONData, fileName, ReportTitle, ShowTitle) {
  var arrData = typeof JSONData != 'object' ? JSON.parse(JSONData) : JSONData;
  var CSV = '';
  CSV += ReportTitle + '\r\n\n';
  if (ShowTitle) {
    var row = "";
    for (var index in arrData[0]) {
      row += index + ',';
    }
    row = row.slice(0, -1);
    CSV += row + '\r\n';
  }
  for (var i = 0; i < arrData.length; i++) {
    var row = "";
    for (var index in arrData[i]) {
      row += '"' + arrData[i][index] + '",';
    }
    row.slice(0, row.length - 1);
    CSV += row + '\r\n';
  }
  if (CSV == '') {
    return;
  }
  var uri = 'data:text/csv;charset=utf-8,\uFEFF' + encodeURI(CSV);//解决导出乱码
  var link = document.createElement("a");
  link.href = uri;
  link.style = "visibility:hidden";
  link.download = fileName + ".csv";
  document.body.appendChild(link);
  link.click();
  document.body.removeChild(link);
}


/**
 * <summary>导出xls</summary>
 * <param name="url">请求路径
 * <param name="data">请求参数
 * <param name="fileName">导出文件名
 */
function download2xls(url, data, fileName) {
  var xhr = new XMLHttpRequest();
  xhr.open('POST', url, true);     // 请求方式，看具体接口情况决定
  xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8'); // 内容类型，看具体接口情况决定
  xhr.withCredentials = true;
  xhr.responseType = "blob";  // 返回类型blob
  // * 加载 loading 动画 *
  var load = new Loading();
  load.init();
  load.start();
  // 定义请求完成的处理函数，请求前也可以增加加载框/禁用下载按钮逻辑
  xhr.onload = function () {
    // 请求完成
    if (this.status === 200) {
      // 返回200
      var blob = this.response;
      var reader = new FileReader();
      reader.readAsDataURL(blob);  // 转换为base64，可以直接放入ahref
      reader.onload = function (e) {
        // 转换完成，创建一个a标签用于下载
        var a = document.createElement('a');
        a.download = fileName;
        a.href = e.target.result;
        // $("body").append(a);  // 修复firefox中无法触发click
        a.click();
        // $(a).remove();
      }
    }
  };
  xhr.onerror = function () {
    console.log("下载失败")
  };
  // 发送ajax请求
  xhr.send(JSON.stringify(data));
  load.stop();     // * 取消loading动画 *
}


