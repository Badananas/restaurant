package restaurant.JSON;

import com.google.gson.Gson;
import restaurant.JSON.Model.*;
import restaurant.SQL.SQLquery;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FromJSON {

    public void FromJson() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Укажите путь к файлу");
        try (FileReader file = new FileReader(scan.nextLine())) {
            Gson gson = new Gson();
            Order_list pars = gson.fromJson(file, Order_list.class);
            Pars(pars);
        } catch (IOException e) {
            System.out.println("Файл не найден.");
        }
    }

    public void Pars(Order_list pars) throws SQLException {
        Map<String, String> order = new HashMap<>();
        SQLquery query = new SQLquery();
        for (Checks var01 : pars.getChecks()) {
            order.put("cost", Integer.toString(var01.getCost()));
            order.put("waiter", var01.getWaiter());
            for (Order var02 : var01.getOrder()) {
                order.put("soup", var02.getSoup());
                order.put("mainDish", var02.getMainDish());
                order.put("salad", var02.getSalad());
                order.put("dessert", var02.getDessert());
                order.put("pizza_size", var02.getAdditional().getPizzaSize());
                order.put("pizza_name", var02.getAdditional().getPizzaName());
                order.put("burger_size", var02.getAdditional().getBurgerSize());
                order.put("burger_name", var02.getAdditional().getBurgerName());
                order.put("coffee_size", var02.getAdditional().getCoffeeSize());
                order.put("coffee_name", var02.getAdditional().getCoffeeName());
            }
            query.Send(order);
        }
        System.out.println("\nГотово!\n");
    }

}
