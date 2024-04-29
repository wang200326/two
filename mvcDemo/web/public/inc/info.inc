<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  

<div class="container-fluid" style="margin-top:40px;">
<div class="row">
  <article class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
    <h3 class="article-title">项目功能</h3>
    <blockquote>
      <h4>系统大部分功能都写在这里，仅供参考</h4>
      <p>1、public</p>
        <p><small>注册：模态框，实现多表关联添加</small></p>
        <p><small>登录：模态框，实现数据查询；实现Session和Cookie</small></p>
        <p><small>首页：学员风采，实现数据的随机查询</small></p>
        <p><small>风采详情：实现对Storage的读取</small></p>
      <p>2、user</p>
        <p><small>修改头像：将图片上传到文件服务器，实现Token</small></p>
        <p><small>修改密码：实现单表修改</small></p>
        <p><small>student操作：实现单表修改；实现多表增删查；实现数据导出</small></p>
        <p><small>score操作：实现单表增删改；实现多表查询；实现统计图表</small></p>
      <p>3、admin</p>
        <p><small>一个基于Bootstrap的admin界面，没有实现具体功能！</small></p>
        <p><small>重点关注user中多表的增删改查，这才是关键！</small></p>
    </blockquote>
  </article>
  
  <article class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
    <h3 class="article-title">前端代码</h3>
    <blockquote>
      <h4>代码划分规范，千人千面，仅供参考</h4>
      <p>1、html：html页面，建议按角色划分目录</p>
        <p><small>admin：管理员页面</small></p>
        <p><small>user：普通用户页面</small></p>
      <p>2、res：公共资源库，存放各类静态资源</p>
        <p><small>css：通用外部样式单</small></p>
        <p><small>js：通用脚本</small></p>
        <p><small>img：通用图片</small></p>
        <p><small>font：通用字体</small></p>
        <p><small>json：通用json文件</small></p>
        <p><small>doc：通用文档</small></p>
        <p><small>tpl：通用模板</small></p>
      <p>3、tool：工具库</p>
        <p><small>jquery：jquery函数库</small></p>
        <p><small>bootstrap：bootstrap框架</small></p>
        <p><small>icomoon：icomoon矢量图标库</small></p>
        <p><small>以及其他第三方扩展组件、插件、工具、库均放在这里</small></p>
      <p>4、index.html：索引页，即项目首页</p>
    </blockquote>
  </article>
  
  <article class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
    <h3 class="article-title">后端代码</h3>
    <blockquote>
      <h4>MVC分层，这学期你就给我按这套路来</h4>
      <p>1、com.demo.pojo：存放各种实体类</p>
      <p>2、com.demo.vo：存放各种值对象</p>
      <p>3、com.demo.dao：数据访问层(持久层)</p>
        <p><small>存放数据库逻辑的接口及实现类</small></p>
      <p>4、com.demo.service：业务层</p>
        <p><small>存放业务逻辑的接口及实现类</small></p>
      <p>5、com.demo.controller：控制层</p>
        <p><small>存放用于request的servlet</small></p>
      <p>6、com.demo.view：视图层</p>
        <p><small>存放用于response的servlet</small></p>
      <p>7、其他文件及包</p>
      <p><small>config.properties：存放连接数据库所需参数</small></p>
      <p><small>com.demo.util：存放各类实用工具</small></p>
      <p><small>com.demo.filter：存放各类过滤器</small></p>
      <p><small>com.demo.listener：存放各类监听器</small></p>
      <p><small>com.test：存放单元测试代码</small></p>
    </blockquote>
  </article>

</div>
</div>