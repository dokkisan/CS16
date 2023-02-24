package cs15;

import java.sql.*;

public class Application {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/pcbang";
        String userName = "pcbang_manager";
        String password = "qwer1234";

        Connection connection = DriverManager.getConnection(url, userName, password);
        System.out.println("DB 연결 성공!");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from pc_table");

        while (resultSet.next()) {
            String seat_number = resultSet.getString(2);    // columnIndex는 1부터 시작
            System.out.println(seat_number);
        }

        resultSet.close();
        statement.close();
        connection.close();
    }
}
