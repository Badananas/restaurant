package restaurant.SQL;

import java.sql.*;

public class JDBC {

    private static Connection connection;
    private static Statement statement;

    public JDBC() {

    }

    public void Connection() throws SQLException {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Драйвер не найден");
            return;
        }
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/restaurant", "restaurant_admin", "12345");
            System.out.println("Подключение к базе данных прошло успешно");
        } catch (SQLException e) {
            System.out.println("Подклюючение к базе данных не состоялось.");
            return;
        }
        statement = connection.createStatement();
    }

    public Statement getStatement() {
        return statement;
    }

}

