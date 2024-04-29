package com.demo.controller.student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.pojo.JsonData;
import com.demo.pojo.Student;
import com.demo.service.StudentServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
//import net.sf.json.JSONObject;

@WebServlet("/com/demo/controller/student/Export")
public class Export extends HttpServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }
    
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
	// 初始化
    response.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
    StudentServiceImpl dto = new StudentServiceImpl();//数据传输层对象，用于调用业务层方法
    Student pojo = new Student(); //持久层对象，用于参数传递
	
	// 1.(参)指定参数值
    String[] title = {"序号","学号","姓名","性别","出生日期","证件号","民族","籍贯","政治面貌"};//定义标题
    String fileName = "学生表"+System.currentTimeMillis()+".xls";//定义工作簿名，即xls文件名
    String sheetName = "student";//定义工作表名，即sheet名
    
    // 2.(调)调用ServiceDAO的方法，获取导出数据
    JsonData jd = dto.select(pojo);
    // 2.1 将ArrayList转换为JSON数组jsonArray
    JSONArray jsonArray = JSONArray.fromObject(jd.getRows());
    // 2.2 定义二维数组content，预备存储ArrayList中的各数据
    // 一维宽度jsonArray.size()，二维宽度title.length
    String[][] content = new String [jsonArray.size()][title.length];
    // 2.3 定义一个JSON对象jsonObject，用于遍历jsonarray时，将其中的每个对象转换为JSON对象并临时保存
    JSONObject jsonObj = null;
    // 开始遍历
    for(int i = 0;i < jsonArray.size(); i ++){
      jsonObj = jsonArray.getJSONObject(i);//遍历jsonarray数组，把每一个对象转成json对象
      // 获取需要导出的信息
      content[i][0] = jsonObj.get("id").toString();
      content[i][1] = jsonObj.get("sequence").toString();
      content[i][2] = jsonObj.get("name").toString();
      content[i][3] = jsonObj.get("gender").toString();
      content[i][4] = jsonObj.get("birthday").toString();
      content[i][5] = jsonObj.get("card").toString();
      content[i][6] = jsonObj.get("nation").toString();
      content[i][7] = jsonObj.get("nativePlace").toString();
      content[i][8] = jsonObj.get("political").toString();
    }
    
    // 3.(存)参数保存到POJO对象,将POJO对象存储到request作用范围变量
    request.setAttribute("title", title);
    request.setAttribute("fileName", fileName);
    request.setAttribute("sheetName", sheetName);
    request.setAttribute("content", content);
    
    // 4.(转)将业务转发到View
    RequestDispatcher rd = request.getRequestDispatcher("/com/demo/view/Excel");
    rd.forward(request, response);
  }
  
}
