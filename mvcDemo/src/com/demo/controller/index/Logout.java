package com.demo.controller.index;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/com/demo/controller/index/Logout")
public class Logout extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    PrintWriter out = response.getWriter();
    response.setContentType("text/html;charset=utf-8");
    boolean success = true;
    String msg = "注销成功";
    try {
      HttpSession se = request.getSession();
      se.invalidate();
    }
    catch (Exception e){
      success = false;
      msg = "注销失败，请重试！";
    }
    finally {
      out.print("{\"success\":"+success+",\"msg\":\""+msg+"\"}");
    }
  }
}