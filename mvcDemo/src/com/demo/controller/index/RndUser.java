package com.demo.controller.index;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.pojo.JsonData;
import com.demo.pojo.User;
import com.demo.service.IndexServiceImpl;

@WebServlet("/com/demo/controller/index/RndUser")
public class RndUser extends HttpServlet {
  private static final long serialVersionUID = 1L;
  IndexServiceImpl dto = new IndexServiceImpl();
  User pojo = new User();

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
    pojo.setLimit(" limit 0,3 ");//分页条件
    pojo.setOrderBy(" order by rnd ");//排序条件

    //2.(调)调用ServiceDAO的方法，完成对应业务
    // System.out.println(pojo.toString());
    JsonData jd = dto.selectRnd(pojo);
    // System.out.println(jd.toString());
    
    //3.(存)将数据对象存储到request作用范围变量
    request.setAttribute("JsonData", jd);
    
    //4.(转)将业务转发到View层
    //利用JsonResultSet将记录数total与记录集rows拼接成“total=50,rows=[{},{}...{}]”格式
    RequestDispatcher rd = request.getRequestDispatcher("/com/demo/view/JSON");
    rd.forward(request, response);
  }
}