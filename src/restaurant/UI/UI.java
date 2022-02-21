package restaurant.UI;

import restaurant.JSON.FromJSON;
import restaurant.JSON.ToJSON;
import restaurant.SQL.JDBC;
import restaurant.SQL.SQLquery;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class UI {

    public UI() {
    }

    public void StartProject() throws SQLException, IOException {

        Scanner scan = new Scanner(System.in);

        JDBC conn = new JDBC();

        conn.Connection();

        System.out.println("*Start app*\n");

        while (true) {
            SQLquery query = new SQLquery();
            System.out.println( "Взаимодействие с приложением происходит за счёт выбора цифры, которая " +
                                "соответствует нужной вам категории\n" +
                                "1. Занести заказ в БД через JSON файл\n" +
                                "2. Экспортировать данные из БД в JSON файл\n" +
                                "3. Выставить счёт\n" +
                                "4. Найти запись по ID\n" +
                                "5. Удалить запись по ID\n" +
                                "6. Закрыть приложение");
            switch (scan.nextLine()) {
                case "1":
                    FromJSON fromJSON = new FromJSON();
                    fromJSON.FromJson();
                    break;
                case "2":
                    ToJSON toJSON = new ToJSON();
                    toJSON.ConvertToJson("select orders.order_id, waiter, price, soup, maindish, salad, dessert, pizza_size, pizza_name, burger_size, burger_cutlet, coffee_size, coffee_cutlet \n" +
                                            "from orders \n" +
                                            "JOIN maindishes ON orders.order_ID = maindishes.order_ID\n" +
                                            "JOIN pizza ON orders.order_ID = pizza.order_ID\n" +
                                            "JOIN burger ON orders.order_ID = burger.order_ID\n" +
                                            "JOIN coffee ON orders.order_ID = coffee.order_ID\n"
                    );
                    break;
                case "3":
                    System.out.println("Введите ID заказа");
                    int i = scan.nextInt();
                    query.CreateSelect("SELECT price FROM orders WHERE order_ID = " + i);
                    System.out.println("Цена заказа по ID " + i + " составляет " + query.GetCost());
                    break;
                case "4":
                    System.out.println("Введите ID заказа");
                    query.CreateSelect("select orders.order_id, waiter, price, soup, maindish, salad, dessert, pizza_size, " +
                                           "pizza_name, burger_size, burger_cutlet, coffee_size, coffee_cutlet \n" +
                                           "from orders \n" +
                                           "JOIN maindishes ON orders.order_ID = maindishes.order_ID\n" +
                                           "JOIN pizza ON orders.order_ID = pizza.order_ID\n" +
                                           "JOIN burger ON orders.order_ID = burger.order_ID\n" +
                                           "JOIN coffee ON orders.order_ID = coffee.order_ID\n" +
                                           "WHERE orders.order_id = " + scan.nextInt());
                    query.GetLine();
                    System.out.println("\nГотово!");
                    break;
                case "5":
                    System.out.println("Введите ID заказа");
                    query.CreateStatement("DELETE FROM Orders WHERE order_ID = " + scan.nextInt());
                    System.out.println("\nГотово!");
                    break;
                case "6":
                    scan.close();
                    return;
            }
        }
    }
}