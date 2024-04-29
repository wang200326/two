package com.demo.dao;

import java.sql.*;
import java.util.ArrayList;

import com.demo.pojo.Student;
import com.demo.pojo.User;

public class StudentDAOImpl implements StudentDAO {
  
  private Connection conn = null;
  private PreparedStatement pst = null;
  
  /**
   * 无参构造函数
   */
  public StudentDAOImpl() {
    super();
  }
  
  /**
   * 建议定义一个带参的构造函数
   * 实例化的时候，完成连接的注入
   */
  public StudentDAOImpl(Connection conn) {
    super();
    this.conn = conn;
  }
  
  /**
   * 查询记录
   */
  @Override
  public ArrayList<Student> select(Student pojo) throws SQLException {
    try{
      String sql = "select "
                 + "  student.id as id, "
                 + "  student.sequence as sequence, "
                 + "  student.name as name, "
                 + "  student.gender as gender, "
                 + "  student.birthday as birthday, "
                 + "  student.card as card, "
                 + "  student.nation as nation, "
                 + "  student.nativePlace as nativePlace, "
                 + "  student.political as political, "
                 + "  student.userId as userId, "
                 + "  user.userName as userName, "
                 + "  user.nickName as nickName, "
                 + "  user.password as password, "
                 + "  user.role as role, "
                 + "  user.imgURL as imgURL "
                 + "from student inner join user on student.userId = user.id "
                 + "where 1=1 ";
      // 查询
      String condition = pojo.getCondition();
      if(condition != null && ! condition.equals("")){
        sql += " and " + condition;
      }
      // 排序
      String orderBy = pojo.getOrderBy();
      if(orderBy != null && ! orderBy.equals("")){
        sql += orderBy;
      }
      // 分页
      String limit = pojo.getLimit();
      if(limit != null && ! limit.equals("")){
        sql += limit;
      }
      // System.out.println(sql);
      pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      ArrayList<Student> al = new ArrayList<Student>();//封装数据并返回给Service层
      while(rs.next()){
        //将student相关信息保存到po对象的各个属性中
        Student po = new Student();//持久层对象，用于调用POJO类的方法
        po.setId(rs.getInt("id"));
        po.setSequence(rs.getString("sequence"));
        po.setName(rs.getString("name"));
        po.setGender(rs.getString("gender"));
        po.setBirthday(rs.getString("birthday"));
        po.setCard(rs.getString("card"));
        po.setNation(rs.getString("nation"));
        po.setNativePlace(rs.getString("nativePlace"));
        po.setPolitical(rs.getString("political"));
        po.setUserId(rs.getInt("userId"));
        //将user相关信息保存到po对象的user属性中(记住：多表操作时候，我们在DAO层的做法，都用这个套路)
        User p = new User();
        p.setUserName(rs.getString("userName"));
        p.setNickName(rs.getString("nickName"));
        p.setPassword(rs.getString("password"));
        p.setRole(rs.getString("role"));
        p.setImgURL(rs.getString("imgURL"));
        po.setUser(p);
        //将以上全部信息添加到集合
        al.add(po);
      }
      // System.out.println(al.toString());
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
  public int count(Student pojo) throws SQLException {
    try{
      String sql = "select count(*) as cnt from student where 1=1 ";
      String condition = pojo.getCondition();
      if(condition!=null && !condition.equals("")){
        sql+=" and " + condition;
      }
      // System.out.println(sql);
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
   * 插入记录
   */  
  @Override
  public int insert(Student pojo) throws SQLException {
    try{
      String sql = "insert into "
                 + "student(sequence,name,gender,birthday,card,nation,nativePlace,political,userId) "
                 + "values(?,?,?,?,?,?,?,?,?) ";
      pst = conn.prepareStatement(sql);
      pst.setString(1, pojo.getSequence());
      pst.setString(2, pojo.getName());
      pst.setString(3, pojo.getGender());
      pst.setString(4, pojo.getBirthday());
      pst.setString(5, pojo.getCard());
      pst.setString(6, pojo.getNation());
      pst.setString(7, pojo.getNativePlace());
      pst.setString(8, pojo.getPolitical());
      pst.setInt(9, pojo.getUserId());
      //System.out.println(sql);
      int i = pst.executeUpdate();
      return i;
    }catch(Exception e){
      e.printStackTrace();
      return -1;
    }
  }
  
  /**
   * 更新部分记录
   */
  @Override
  public int update(Student pojo) throws SQLException {
    try{
      int cnt = 0;
      String sql = "update student set ";

      if(pojo.getSequence() != null && !pojo.getSequence().equals("")){
        sql += "sequence='"+pojo.getSequence()+"',";
        cnt++;
      }
      
      if(pojo.getName() != null && !pojo.getName().equals("")){
        sql += "name='"+pojo.getName()+"',";
        cnt++;
      }
      
      if(pojo.getGender() != null && !pojo.getGender().equals("")){
        sql += "gender='"+pojo.getGender()+"',";
        cnt++;
      }
      
      if(pojo.getBirthday() != null && !pojo.getBirthday().equals("")){
        sql += "birthday='"+pojo.getBirthday()+"',";
        cnt++;
      }
      
      if(pojo.getCard() != null && !pojo.getCard().equals("")){
        sql += "card='"+pojo.getCard()+"',";
        cnt++;
      }
      
      if(pojo.getNation() != null && !pojo.getNation().equals("")){
        sql += "nation='"+pojo.getNation()+"',";
        cnt++;
      }
      
      if(pojo.getNativePlace() != null && !pojo.getNativePlace().equals("")){
        sql += "nativePlace='"+pojo.getNativePlace()+"',";
        cnt++;
      }
      
      if(pojo.getPolitical() != null && !pojo.getPolitical().equals("")){
        sql += "political='"+pojo.getPolitical()+"',";
        cnt++;
      }
      
      if(cnt > 0){
        sql = sql.substring(0,sql.length()-1);//去掉最后一个逗号
        sql += " where id=?";
      }
      
      pst = conn.prepareStatement(sql);
      pst.setInt(1, pojo.getId());
      //System.out.println(sql);
      int i = pst.executeUpdate();
      return i;
    }catch(Exception e){
      e.printStackTrace();
      return -1;
    }
  }
  
  /**
   * 删除记录
   */
  @Override
  public int delete(Student student) throws SQLException {
    try{
      // 删除一般就这样写了，大多数情况下，我们只是删除一条记录
      // 即便是批量删除，大多时候也是前端选中n条记录，把ids传给后台来处理
      String sql = "delete from student where id=?";
      pst = conn.prepareStatement(sql);
      pst.setInt(1, student.getId());
      //System.out.println(sql);
      int i = pst.executeUpdate();
      return i;
    }catch(Exception e){
      e.printStackTrace();
      return -1;
    }
  }
}
