package sample.managers;

import sample.bean.Member;
import sample.util.SqlUtil;
import sample.bean.User;

import java.sql.*;

/**
 * Created by Paul on 9/4/17.
 */
public class DBManager {

    private static DBManager instance;
    private Connection connection;
    private Statement statement;


    private DBManager(){
        initDB();
//        createUserTable();
//        createMemberTable();
    }

    public static DBManager getInstance(){
        if (instance == null){
            return new DBManager();
        }
        return instance;
    }

    private void initDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public User login(String userName, String password){
        try {

//            String loginSql = String.format("select username, password from user where username = %s and password = %s",userName, password);
            String loginSql = String.format("select * from user where username =" + SqlUtil.addQuotationForString(userName)
                    + " and password = " + SqlUtil.addQuotationForString(password));
            ResultSet resultSet = statement.executeQuery(loginSql);
            if (resultSet.next()){
                String usr = resultSet.getString("userName");
                String pw = resultSet.getString("password");
                String userId = resultSet.getString("userId");
                User user = new User(usr, pw, userId);
                return user;
            }else{
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insert(Member member){
        String insertSql = String.format("insert into member values ('%s' , '%s', '%s', '%s', '%s')",
                member.getMemberId(),member.getMemberName(), member.getGender(),member.getEmail(), member.getPhone());
        try {
            statement.executeUpdate(insertSql);
            test();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean searchMemberByEmail(String email){
        String sql = "select * from member where email like " + SqlUtil.addQuotationForString(email);
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                System.out.println("name : " + resultSet.getString("memberName"));
                System.out.println("email : " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * for first time create user table
     */
    public void createUserTable(){
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("drop table if exists user");
            statement.executeUpdate("create table user (userId varchar(20), userName varchar (20), password varchar(20))");
            statement.executeUpdate("insert into user Values('1', 'admin', 'admin')");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    /**
     * for first time create member table
     */
    public void createMemberTable(){
        try {
            statement.executeUpdate("drop table if exists member");
            statement.executeUpdate("create table member (memberId varchar(20), memberName varchar(20), gender char(8), email varchar(50), phone varchar(10))");
            statement.executeUpdate("insert into member values('1', 'paul', 'male', 'paul@gmail.com', '0402172555')");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    private void test(){
        ResultSet rs = null;
        try {
            rs = statement.executeQuery("select * from member");
            while(rs.next())
                 {
                     // read the result set
                     System.out.println("name = " + rs.getString("memberName"));
                     System.out.println("id = " + rs.getString("memberId"));
                     System.out.println("email = " + rs.getString("email"));
                     System.out.println("phone = " + rs.getString("phone"));
                 }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    // TODO: 9/4/17 implement db connection later
//     private void connectDB(){
//         try
//         {
//             // create a database connection
//             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
//             Statement statement = connection.createStatement();
//             statement.setQueryTimeout(30);  // set timeout to 30 sec.
//
//             statement.executeUpdate("drop table if exists person");
//             statement.executeUpdate("create table person (id integer, name Char(20))");
//             statement.executeUpdate("insert into person values(1, 'leo')");
//             statement.executeUpdate("insert into person values(2, 'yui')");
//             ResultSet rs = statement.executeQuery("select * from person");
//             while(rs.next())
//             {
//                 // read the result set
//                 System.out.println("name = " + rs.getString("name"));
//                 System.out.println("id = " + rs.getInt("id"));
//             }
//         }
//         catch(SQLException e)
//         {
//             // if the error message is "out of memory",
//             // it probably means no database file is found
//             System.err.println(e.getMessage());
//         }
//     }
}
