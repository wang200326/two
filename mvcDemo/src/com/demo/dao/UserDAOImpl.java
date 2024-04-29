package com.demo.dao;

import java.sql.*;
import java.util.ArrayList;

import com.demo.pojo.User;

public class UserDAOImpl implements UserDAO {
  
  private Connection conn = null;
  private PreparedStatement pst = null;
  
  /**
   * 无参构造函数
   */
  public UserDAOImpl() {
    super();
  }
  
  /**
   * 建议定义一个带参的构造函数
   * 实例化的时候，完成连接的注入
   */
  public UserDAOImpl(Connection conn) {
    super();
    this.conn = conn;
  }
  
  /**
   * 查询记录
   */
  @Override
  public ArrayList<User> select(User pojo) throws SQLException {
    try{
      String sql = "select "
                 + "  user.id as id, "
                 + "  user.userName as userName, "
                 + "  user.nickName as nickName, "
                 + "  user.password as password, "
                 + "  user.role as role, "
                 + "  user.imgURL as imgURL, "
                 + "  student.sequence as sequence, "
                 + "  student.name as name, "
                 + "  student.gender as gender, "
                 + "  student.birthday as birthday, "
                 + "  student.card as card, "
                 + "  student.nation as nation, "
                 + "  student.nativePlace as nativePlace, "
                 + "  student.political as political "
                 + "from user "
                 + "  inner join student on student.userId = user.id "
                 + "union all "
                 + "select "
                 + "  user.id as id, "
                 + "  user.userName as userName, "
                 + "  user.nickName as nickName, "
                 + "  user.password as password, "
                 + "  user.role as role, "
                 + "  user.imgURL as imgURL, "
                 + "  teacher.sequence as sequence, "
                 + "  teacher.name as name, "
                 + "  teacher.gender as gender, "
                 + "  teacher.birthday as birthday, "
                 + "  teacher.card as card, "
                 + "  teacher.nation as nation, "
                 + "  teacher.nativePlace as nativePlace, "
                 + "  teacher.political as political "
                 + "from user "
                 + "  inner join teacher on teacher.userId = user.id "
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
      ArrayList<User> al = new ArrayList<User>();//封装数据并返回给Service层
      while(rs.next()){
        //将User相关信息保存到po对象的各个属性中
        User po = new User();//持久层对象，用于调用POJO类的方法
        po.setId(rs.getInt("id"));
        po.setUserName(rs.getString("userName"));
        po.setNickName(rs.getString("nickName"));
        po.setPassword(rs.getString("password"));
        po.setRole(rs.getString("role"));
        po.setImgURL(rs.getString("imgURL"));
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

  @Override
  public ArrayList<User> loginCheck(User pojo) throws SQLException {
    try{
      // 简单的做法：String sql = "select id,userName,nickName,password from user";
      String sql = "select * from ("
          + "  select "
          + "  user.id as id, "
          + "  user.userName as userName, "
          + "  user.nickName as nickName, "
          + "  user.`password` as `password`, "
          + "  user.role as role, "
          + "  user.imgURL as imgURL, "
          + "  student.sequence as sequence, "
          + "  student.name as name, "
          + "  student.gender as gender, "
          + "  student.birthday as birthday, "
          + "  student.card as card, "
          + "  student.nation as nation, "
          + "  student.nativePlace as nativePlace, "
          + "  student.political as political "
          + "from user "
          + "  left join student on student.userId = user.id "
          + "where role='学生' "
          + "union "
          + "select "
          + "  user.id as id, "
          + "  user.userName as userName, "
          + "  user.nickName as nickName, "
          + "  user.`password` as `password`, "
          + "  user.role as role, "
          + "  user.imgURL as imgURL, "
          + "  teacher.sequence as sequence, "
          + "  teacher.name as name, "
          + "  teacher.gender as gender, "
          + "  teacher.birthday as birthday, "
          + "  teacher.card as card, "
          + "  teacher.nation as nation, "
          + "  teacher.nativePlace as nativePlace, "
          + "  teacher.political as political "
          + "from user "
          + "  left join teacher on teacher.userId = user.id "
          + "where role='教师' "
          + "union "
          + "select "
          + "  id as id, "
          + "  userName as userName, "
          + "  nickName as nickName, "
          + "  `password` as `password`, "
          + "  role as role, "
          + "  imgURL as imgURL, "
          + "  null as sequence, "
          + "  null as name, "
          + "  null as gender, "
          + "  null as birthday, "
          + "  null as card, "
          + "  null as nation, "
          + "  null as nativePlace, "
          + "  null as political "
          + "from user "
          + "where role='管理员' "
          + "  ) as temp "
          + "where 1=1 ";
      // 查询
      String condition = pojo.getCondition();
      if(condition != null && ! condition.equals("")){
        sql += condition;
      }

      // System.out.println(sql);
      pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      ArrayList<User> al = new ArrayList<User>();//封装数据并返回给Service层
      while(rs.next()){
        //将User相关信息保存到po对象的各个属性中
        User po = new User();//持久层对象，用于调用POJO类的方法
        po.setId(rs.getInt("id"));
        po.setUserName(rs.getString("userName"));
        po.setNickName(rs.getString("nickName"));
        po.setPassword(rs.getString("password"));
        po.setRole(rs.getString("role"));
        po.setImgURL(rs.getString("imgURL"));
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
   * 随机查询3条记录数
   */
  @Override
  public ArrayList<User> selectRnd(User pojo) throws SQLException {
    try{
      String sql = "select id,userName,nickName,role,imgURL,rand() as rnd from user ";
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
      pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      ArrayList<User> al = new ArrayList<User>();//封装数据并返回给Service层
      while(rs.next()){
        //将User相关信息保存到po对象的各个属性中
        User po = new User();//持久层对象，用于调用POJO类的方法
        po.setId(rs.getInt("id"));
        po.setUserName(rs.getString("userName"));
        po.setNickName(rs.getString("nickName"));
        po.setRole(rs.getString("role"));
        po.setImgURL(rs.getString("imgURL"));
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
  public int count(User pojo) throws SQLException {
    try{
      String sql = "select count(*) as cnt from user where 1=1 ";
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
  public int insert(User pojo) throws SQLException {
    try{
      String sql = "insert into "
                 + "user(userName,nickName,password,role,imgURL) "
                 + "values(?,?,?,?,?) ";
      pst = conn.prepareStatement(sql);
      pst.setString(1, pojo.getUserName());
      pst.setString(2, pojo.getNickName());
      pst.setString(3, pojo.getPassword());
      pst.setString(4, pojo.getRole());
      pst.setString(5, pojo.getImgURL());
      //System.out.println(sql);
      pst.executeUpdate();
      //用last_insert_id()获取新插入记录的id,用于更新student或teacher表的userId字段
      sql ="select last_insert_id()";
      pst = conn.prepareStatement(sql);
      ResultSet rs = pst.executeQuery();
      rs.next();
      int id = rs.getInt(1);
      return id;
    }catch(Exception e){
      e.printStackTrace();
      return -1;
    }
  }
  
  /**
   * 更新部分记录
   * 修改昵称：nickName
   * 修改密码：password
   * 修改头像：imgURL
   */
  @Override
  public int update(User pojo) throws SQLException {
    try{
      int cnt = 0;
      String sql = "update user set ";

      if(pojo.getNickName() != null && !pojo.getNickName().equals("")){
        sql += "nickName='"+pojo.getNickName()+"',";
        cnt++;
      }
      
      if(pojo.getPassword() != null && !pojo.getPassword().equals("")){
        sql += "password='"+pojo.getPassword()+"',";
        cnt++;
      }
      
      if(pojo.getImgURL() != null && !pojo.getImgURL().equals("")){
        sql += "imgURL='"+pojo.getImgURL()+"',";
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
  public int delete(User User) throws SQLException {
    try{
      // 删除一般就这样写了，大多数情况下，我们只是删除一条记录
      // 即便是批量删除，大多时候也是前端选中n条记录，把ids传给后台来处理
      String sql = "delete from user where id=?";
      pst = conn.prepareStatement(sql);
      pst.setInt(1, User.getId());
      //System.out.println(sql);
      int i = pst.executeUpdate();
      return i;
    }catch(Exception e){
      e.printStackTrace();
      return -1;
    }
  }

}
