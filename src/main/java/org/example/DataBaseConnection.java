package org.example;

import java.sql.*;

public class DataBaseConnection {

    private static String url = "jdbc:postgresql://localhost:5432/GenerationD21";
    private static String user = "postgres";
    private static String password = "Root12345";

    public static void AddProduct(String chatId, String productName, int productCount, long productCost, String orderDataTime) {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            String query = "insert into fast_food_order(user_chatid, product_name, product_count, product_cost, order_data_time) values ('" + chatId + "', '" + productName + "', " + productCount + ", " + productCost + ", '" + orderDataTime + "');";

            statement.execute(query);

            System.out.println(" Ma'lumot bazaga yozildi! ");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public static String ShowProduct(String chatId){
        String post = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from fast_food_order where user_chatid = '" + chatId + "'");

            while (resultSet.next()) {
                       post = "<b> Order id.....................: </b>" + resultSet.getInt(1) + "\n";
                post = post + "<b> User chat id.................: </b>" + resultSet.getLong(2) + "\n";
                post = post + "<b> Product name.................: </b>" + resultSet.getString(3) + "\n";
                post = post + "<b> Product count................: </b>" + resultSet.getInt(4) + "\n";
                post = post + "<b> Product price................: </b>" + resultSet.getLong(5) + "\n";
                post = post + "<b> Order data time..............: </b>" + resultSet.getString(6) + "\n";
                post = post + "\n";
            }
            return post;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
