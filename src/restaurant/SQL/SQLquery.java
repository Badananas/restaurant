package restaurant.SQL;

import restaurant.JSON.Model.Order_list;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class SQLquery {

    JDBC conn = new JDBC();
    ResultSet result;

    public SQLquery() {
    }

    public int GetCount() throws SQLException {
        CreateSelect("Select COUNT(order_id) FROM orders");
        return result.getInt(1);
    }

    public void CreateStatement(String str) throws SQLException {
        conn.getStatement().executeUpdate(str);
    }

    public void CreateSelect(String str) throws SQLException {
        ResultSet result = conn.getStatement().executeQuery(str);
        this.result = result;
    }

    public int GetCost() throws SQLException {
        while (result.next()) {
            return result.getInt(1);
        }
        return -1;
    }

    public void GetLine() throws SQLException{
        while (result.next()) {
            System.out.println("Order ID = " + result.getInt(1) + "\n" + "waiter = " + result.getString(2) +
                    "\n" + "cost = " + result.getInt(3)+ "\n" + "soup = " + result.getString(4) +
                    "\n" + "main dish = " + result.getString(5) + "\n" + "salad = " + result.getString(6) +
                    "\n" + "dessert = " + result.getString(7) +
                    "\n" + "pizza name = " + result.getString(9) + "\n" + "pizza size = " + result.getString(8) +
                    "\n" + "burger cutlet = " + result.getString(11) + "\n" + "burger size = " + result.getString(10) +
                    "\n" + "coffee name = " + result.getString(13) + "\n" + "coffee size = " + result.getString(12));
        }
    }

    public void Send(Map<String, String> order) throws SQLException {
        SQLquery statement = new SQLquery();
        statement.CreateStatement("INSERT INTO orders (waiter, price)\n" +
                "VALUES ('"+ order.get("waiter") +"' , " + order.get("cost") + ");");
        statement.CreateStatement("INSERT INTO maindishes (soup, maindish, salad, dessert)\n" +
                "VALUES ('"+ order.get("soup") + "', '"+ order.get("mainDish") + "', " +
                "'"+ order.get("salad") + "', '" + order.get("dessert") + "');");
        statement.CreateStatement("INSERT INTO pizza (pizza_size, pizza_name)\n" +
                "VALUES ('"+ order.get("pizza_size") + "', '"+ order.get("pizza_name") + "');");
        statement.CreateStatement("INSERT INTO burger (burger_size, burger_cutlet)\n" +
                "VALUES ('"+ order.get("burger_size") + "', '"+ order.get("burger_name") + "');");
        statement.CreateStatement("INSERT INTO coffee (coffee_size, coffee_cutlet)\n" +
                "VALUES ('"+ order.get("coffee_size") + "', '"+ order.get("coffee_name") + "');");
    }
    public Order_list Get() throws SQLException{

        Order_list order = new Order_list();

        while(result.next()) {
            order.addObjectChecks();
            order.getChecks().get(order.getChecks().size()-1).setWaiter(result.getString(2));
            order.getChecks().get(order.getChecks().size()-1).setCost(result.getInt(3));
            order.getChecks().get(order.getChecks().size()-1).addObjectOrder();
            order.getChecks().get(order.getChecks().size()-1).getOrder().get(order.getChecks().get(order.getChecks().size()-1).getOrder().size()-1).setSoup(result.getString(4));
            order.getChecks().get(order.getChecks().size()-1).getOrder().get(order.getChecks().get(order.getChecks().size()-1).getOrder().size()-1).setMainDish(result.getString(5));
            order.getChecks().get(order.getChecks().size()-1).getOrder().get(order.getChecks().get(order.getChecks().size()-1).getOrder().size()-1).setSalad(result.getString(6));
            order.getChecks().get(order.getChecks().size()-1).getOrder().get(order.getChecks().get(order.getChecks().size()-1).getOrder().size()-1).setDessert(result.getString(7));
            order.getChecks().get(order.getChecks().size()-1).getOrder().get(order.getChecks().get(order.getChecks().size()-1).getOrder().size()-1).getAdditional().setPizza("name:", result.getString(9));
            order.getChecks().get(order.getChecks().size()-1).getOrder().get(order.getChecks().get(order.getChecks().size()-1).getOrder().size()-1).getAdditional().setPizza("size:", result.getString(8));
            order.getChecks().get(order.getChecks().size()-1).getOrder().get(order.getChecks().get(order.getChecks().size()-1).getOrder().size()-1).getAdditional().setBurger("name:", result.getString(11));
            order.getChecks().get(order.getChecks().size()-1).getOrder().get(order.getChecks().get(order.getChecks().size()-1).getOrder().size()-1).getAdditional().setBurger("size:", result.getString(10));
            order.getChecks().get(order.getChecks().size()-1).getOrder().get(order.getChecks().get(order.getChecks().size()-1).getOrder().size()-1).getAdditional().setCoffee("name:", result.getString(13));
            order.getChecks().get(order.getChecks().size()-1).getOrder().get(order.getChecks().get(order.getChecks().size()-1).getOrder().size()-1).getAdditional().setCoffee("size:", result.getString(12));
        }
        return order;
    }
}

