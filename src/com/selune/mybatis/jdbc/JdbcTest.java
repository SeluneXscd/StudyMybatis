package com.selune.mybatis.jdbc;

import java.sql.*;

/**
 * @Author: Selune
 * @Date: 5/31/19 2:16 PM
 */

public class JdbcTest {

    /** 驱动名 */
    private static final String dirver = "com.mysql.jdbc.Driver";

    /** url */
    private static final String url = "jdbc:mysql://seluneadminout.mysql.rds.aliyuncs" +
            ".com:3306/test?characterEncoding=UTF-8";

    /** username */
    private static final String username = "root";

    /** password */
    private static final String password = "XYP@1224susu";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(dirver);
            connection = DriverManager.getConnection(url, username, password);
            String sql = "select * from user_";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (null == resultSet) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null == preparedStatement) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null == connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
