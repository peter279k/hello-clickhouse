package hello;

import java.sql.*;
import java.util.*;
import com.clickhouse.jdbc.*;

public class HelloDB {
	public static void main(String[] args) {
            String url = "jdbc:ch:https://play.clickhouse.com:443";
            Properties properties = new Properties();
            properties.setProperty("user", "explorer");
            properties.setProperty("password", "");
            properties.setProperty("client_name", "Agent #1");

            try {
                ClickHouseDataSource dataSource = new ClickHouseDataSource(url, properties);
                Connection conn = dataSource.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("show databases");
                while (rs.next()) {
                    System.out.println(rs.getString("name"));
		}
            } catch (SQLException e) {
                 e.printStackTrace();
                 System.out.println("Cannot connect the ClickHouse DB server");
	    }
	}
}
