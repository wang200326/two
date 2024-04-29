package com.demo.controller.index;

import com.demo.pojo.JsonData;
import com.demo.pojo.User;
import com.demo.service.IndexServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/com/demo/controller/index/Login")
public class Login extends HttpServlet {
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
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String str = "";
    if (username == null || username.equals("")) {
      return;
    }else{
      str +=" and username = '"+username+"'";
    }
    if (password == null || password.equals("")) {
      return;
    }else{
      str +=" and `password` = '"+password+"'";
    }
    //System.out.println(str);
    pojo.setCondition(str);

    //2.(调)调用ServiceDAO的方法，完成对应业务
    // System.out.println(pojo.toString());
    JsonData jd = dto.login(pojo);
    // System.out.println(jd.toString());
    
    //3.(存)将数据对象存储到request作用范围变量
    request.setAttribute("JsonData", jd);

    //登录业务中，这里多做一步处理
    long i = jd.getTotal();
    if(i==0){ jd.setMsg("账号或密码错误！"); }
    else if(i>1){ jd.setMsg("重复的账号，请联系管理员！"); }
    else{
      // 把一些关键信息存入session
      HttpSession se = request.getSession();
      List li = jd.getRows();
      User user = (User)li.get(0);
      se.setAttribute("username",user.getUserName());
      se.setAttribute("nickname",user.getNickName());
      se.setAttribute("password",user.getPassword());
      se.setAttribute("role",user.getRole());
    }

    //4.(转)将业务转发到View层
    //利用JsonResultSet将记录数total与记录集rows拼接成“total=50,rows=[{},{}...{}]”格式
    RequestDispatcher rd = request.getRequestDispatcher("/com/demo/view/JSON");
    rd.forward(request, response);
  }
}