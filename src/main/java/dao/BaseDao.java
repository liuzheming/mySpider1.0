package dao;

import org.apache.commons.dbutils.QueryRunner;

import java.sql.*;

/**
 * Description: MySQL连接管理类
 * <p>
 * Created by lzm on 2017/12/5.
 */
public class BaseDao {


    protected QueryRunner qr = QueryFactory.getQR();

    private final static String driver = "com.mysql.cj.jdbc.Driver";

    private final static String url = "jdbc:mysql://127.0.0.1:3306/spider?characterEncoding=utf8&useSSL=false";

    private final static String username = "spider";

    private final static String password = "spider";

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    Connection getConn() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String... args) {

        try {
            PreparedStatement ps = new BaseDao().getConn().prepareStatement("SELECT * FROM app_info");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("appName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
