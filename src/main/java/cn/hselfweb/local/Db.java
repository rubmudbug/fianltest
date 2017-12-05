package cn.hselfweb.local;

import java.sql.*;

public class Db {


    private String driver = "com.mysql.jdbc.Driver";
    //URL指向要访问
    private String url;
    //MySQL配置时的用户名
    private String user;
    //MySQL配置时的密码
    private String password;
    //遍历查询结果集
    private Connection connection;
    private Statement statement;

    /**
     * @param url      连接数据库
     * @param user     用户名
     * @param password 密码
     */
    public Db(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    /**
     * 链接sql
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void connect() throws ClassNotFoundException, SQLException {
        //声明Connection对象
        Class.forName(driver);
        //1.getConnection()方法，连接MySQL数据库！！
        connection = DriverManager.getConnection(url, user, password);
        if (!connection.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        statement = connection.createStatement();
    }

    /**
     * 打印数据库
     *
     * @throws SQLException
     */
    public void DbPrint() throws SQLException {
        ResultSet rs = statement.executeQuery("SELECT * FROM student.student");
        System.out.println("执行结果如下所示:");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("id" + "\t" + "name" + "\t" + "sex" + "\t" + "hight" + "\t" + "birthday" + "\t" + "native_place");
        System.out.println("----------------------------------------------------------------------------------------------");
        int id;
        String name = null;
        String sex;
        double hight;
        Date birthday;
        String native_place;
        while (rs.next()) {
            id = rs.getInt("id");
            name = rs.getString("name");
            sex = rs.getString("sex");
            hight = rs.getDouble("hight");
            birthday = rs.getDate("birthday");
            native_place = rs.getString("native_place");
            //输出结果
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + hight + "\t" + birthday + "\t" + native_place);
            System.out.println("----------------------------------------------------------------------------------------------");
        }
        rs.close();
        connection.close();
    }

    /**
     * sql查询
     *
     * @param sql
     * @return
     */
    public ResultSet DbQuery(String sql) throws SQLException {
        return statement.executeQuery(sql);
    }

    /**
     * 插入语句
     *
     * @param sql
     * @return 判断是否正常
     * @throws SQLException
     */
    public int DbInsert(String sql) throws SQLException {
        return statement.executeUpdate(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
    }
}
