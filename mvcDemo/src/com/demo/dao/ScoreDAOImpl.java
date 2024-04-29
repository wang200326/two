package com.demo.dao;

import java.sql.*;
import java.util.ArrayList;

import com.demo.pojo.Course;
import com.demo.pojo.Score;
import com.demo.pojo.Student;
import com.demo.pojo.Teacher;
import com.demo.pojo.User;
import com.demo.vo.ScoreCount;
import com.demo.vo.ScoreVO;

public class ScoreDAOImpl implements ScoreDAO {
  private Connection conn = null;
  private PreparedStatement pst = null;
  /**
   * 定义无参构造函数
   */
  public ScoreDAOImpl() {
    super();
  }
  /**
   * 定义带参构造函数，实例化的时候完成连接的注入
   */
  public ScoreDAOImpl(Connection conn) {
    super();
    this.conn = conn;
  }
  
  /**
   * 查询记录
   */
  @Override
  public ArrayList<Score> select(Score pojo) throws SQLException {
    try{
      String sql = "select score, "
      	         + "  score.id as id, "
      	         + "  score.term as term, "
      	         + "  score.state as state, "
      	         + "  student.sequence as student_sequence, "
      	         + "  student.name as student_name, "
      	         + "  teacher.sequence as teacher_sequence, "
      	         + "  teacher.name as teacher_name, "
      	         + "  course.sequence as course_sequence, "
      	         + "  course.name as course_name "
      	         + "from score "
      	         + " inner join student on student.id = score.studentId "
      	         + " inner join teacher on teacher.id = score.teacherId "
      	         + " inner join course on course.id = score.courseId "
                 + " where 1=1 ";
      //查询
      String condition = pojo.getCondition();
      if(condition != null && ! condition.equals("")){
        sql += " and " + condition;
      }
      //排序
      String orderBy = pojo.getOrderBy();
      if(orderBy != null && ! orderBy.equals("")){
        sql += orderBy;
      }
      //分页
      String limit = pojo.getLimit();
      if(limit != null && ! limit.equals("")){
        sql += limit;
      }
      //System.out.println(sql);
      pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      // 注意：由于是多表查询，这里不再使用POJO对象来存放数据了，我们改用VO对象
      ArrayList<Score> al = new ArrayList<Score>();
      while(rs.next()){
        //添加Score信息
        Score po = new Score();
        po.setId(rs.getInt("id"));
        po.setScore(rs.getInt("score"));
        po.setTerm(rs.getString("term"));
        po.setState(rs.getString("state"));
        
        Student s = new Student();
        s.setName(rs.getString("student_name"));
        po.setStudent(s);
        
        Teacher t = new Teacher();
        t.setName(rs.getString("teacher_name"));
        po.setTeacher(t);
        
        Course c = new Course();
        c.setName(rs.getString("course_name"));
        po.setCourse(c);
        //将以上全部信息添加到集合
        al.add(po);
      }
      return al;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }
    
  /**
   * 统计记录数
   */
  @Override
  public int count(Score score) throws SQLException {
    try{
      String sql = "select count(*) as cnt ";
	        sql += "from score ";
	        sql += "  inner join student on student.id = score.studentId ";
	        sql += "  inner join teacher on teacher.id = score.teacherId ";
	        sql += "  inner join course on course.id = score.courseId ";
	        sql += "where 1=1 ";
      String condition = score.getCondition();
      if(condition!=null && !condition.equals("")){
        sql+=" and " + condition;
      }
      //System.out.println(sql);
      pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      rs.next();
      int cnt = rs.getInt("cnt");
      return cnt;
    }catch(Exception e){
      e.printStackTrace();
      return -1;
    }
  }

  /**
   * 统计分数段
   */
  @Override
  public ArrayList<ScoreCount> scoreCount(ScoreCount pojo) throws SQLException {
    try{
      String sql = "select "
  	             + "  sum(case when score between 90 and 100 then 1 else 0 end) as 优秀, "
  	             + "  sum(case when score between 80 and 89 then 1 else 0 end) as 良好, "
  	             + "  sum(case when score between 70 and 79 then 1 else 0 end) as 中等, "
  	             + "  sum(case when score between 60 and 69 then 1 else 0 end) as 及格, "
  	             + "  sum(case when score<60 then 1 else 0 end) as 不及格  "
  	             + "from score "
  	             + "where 1=1 ";
      //查询
      String condition = pojo.getCondition();
      if(condition != null && ! condition.equals("")){
        sql += " and " + condition;
      }
      // System.out.println(sql);
      pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      ArrayList<ScoreCount> al = new ArrayList<ScoreCount>();
      while(rs.next()){
        ScoreCount po = new ScoreCount();
        po.setA(rs.getInt("优秀"));
        po.setB(rs.getInt("良好"));
        po.setC(rs.getInt("中等"));
        po.setD(rs.getInt("及格"));
        po.setE(rs.getInt("不及格"));
        al.add(po);
      }
      return al;
    }catch(Exception e){
      e.printStackTrace();
      return null;
    }
  }

}
