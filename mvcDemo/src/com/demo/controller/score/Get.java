package com.demo.controller.score;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.pojo.JsonData;
import com.demo.pojo.Score;
import com.demo.service.ScoreServiceImpl;

@WebServlet("/com/demo/controller/score/Get")
public class Get extends HttpServlet {
  private static final long serialVersionUID = 1L;
  ScoreServiceImpl dto = new ScoreServiceImpl();
  Score pojo = new Score();

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //初始化
    request.setCharacterEncoding("utf-8");
    
    //1.(参)获取参数值，并保存到POJO对象
    //查询条件
    String param = request.getParameter("param");
    //param = new String(param.getBytes("iso-8859-1"),"utf-8");
    if (param != null && param.length() > 0){
      pojo.setCondition(" course.name like '%"+param+"%' or student.name like '%"+param+"%' or teacher.name like '%"+param+"%' ");
    }else{
      pojo.setCondition("");
    }
    
    //分页条件
    String offset = request.getParameter("offset");//起始页(bootstrap-table默认用这个名字)
    String limit = request.getParameter("limit");//每页记录数(bootstrap-table默认用这个名字)
    if (offset != null && offset.length() > 0){
      pojo.setLimit(" limit "+offset+","+limit);
    }else{
      pojo.setLimit("");
    }
    
    //排序条件
    String sort = request.getParameter("sort");//排序字段(bootstrap-table默认用这个名字)
    String order = request.getParameter("order");//排序方式(bootstrap-table默认用这个名字)
    if (sort != null && sort.length() > 0){
      pojo.setOrderBy(" order by "+sort+" "+order);
    }else{
      pojo.setOrderBy("");
    }
    
    //2.(调)调用ServiceDAO的方法，完成对应业务
    // System.out.println(pojo.toString());
    JsonData jd = dto.select(pojo);
    // System.out.println(jd.toString());
    
    //3.(存)将数据对象存储到request作用范围变量
    request.setAttribute("JsonData", jd);
    
    //4.(转)将业务转发到View层
    //利用JsonResultSet将记录数total与记录集rows拼接成“total=50,rows=[{},{}...{}]”格式
    RequestDispatcher rd = request.getRequestDispatcher("/com/demo/view/JSON");
    rd.forward(request, response);
  }
}