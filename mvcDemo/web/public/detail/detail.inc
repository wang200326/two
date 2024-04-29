<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<div class="row" style="margin:20px 0px 0px 20px">

  <!-- 左侧相片 -->
  <aside class="col-md-4">
    <div class="sidebar-box">
      <div class="list-group list-group-root" style="text-align:center">
        <h3 id="h3_userName"></h3>
        <h4 id="h4_nickName"></h4>
        <img id="img_imgURL" src="" alt="..." style="width:100%" />
      </div>
    </div>
  </aside>
  
  <!-- 右侧详情 -->
  <div class="col-md-8">
    <article>
      <h2 class="article-title">学员简介</h2>
      <p class="article-meta">Edited by <a href="javascript:void(0)">张三</a></p>
      <p>如果俺说俺叫张三，你信么?</p>
      <p>唉，俺爹娘给俺取名怎么就这么不上心！不说了，说多都是泪……</p>
      <p>俺告诉你，左边的学号、姓名、照片，那都是假的！对，都是俺瞎编的！</p>
      <p>哼，还写进了数据库，你说牛不牛！</p>
      <p>不过，这边的肺腑之言虽然没存进数据库，但都是真的！</p>
      <p>他们非要俺写个人简介，就俺这点文化，还能写啥？</p>
      <p>就这一点，俺绝对是遗传了祖辈们的优秀基因，俺就是 ———— 人中哈士奇！</p>

      <p style="color:#606060;font-weight:bolder">证书情况</p>
      <ul>
        <li>全国大学生英语考试(CET四级)</li>
        <li>全国计算机等级考试(NCRE二级)</li>
        <li>1+x中级(web前端)</li>
        <li>计算机软件资格考试中级(软件设计师)</li>
        <li>计算机软件资格考试高级(系统架构设计师)</li>
      </ul>

      <p style="color:#606060;font-weight:bolder">精通技能</p>
      <ul>
          <li>PS , AI , 精通配色 …</li>
          <li>HTML5 , CSS3 , JavaScript , jQuery , JSON , AJAX …</li>
          <li>Angular.js , Vue.js , React.js , Node.js …</li>
          <li>ASP , JSP , PHP , C , C++ , C# , Java …</li>
          <li>Spring , Spring Boot , Spring MVC , Spring Cloud …</li>
          <li>MySQL, SQL Server, Oracle , Redis , MongoDB …</li>
      </ul>
      <a id="btn_back" href="javascript:void(0)" class="btn btn-md btn-secondary">返回</a>
    </article>
  </div>
</div>