package restaurant.JSON.Model;

import java.util.ArrayList;
import java.util.List;

public class Checks {

    private String waiter;
    private int cost;
    private List<Order> order = new ArrayList<>();

    public void addObjectOrder() {
        order.add(new Order());
    }

    public String getWaiter() {
        return waiter;
    }

    public void setWaiter(String waiter) {
        this.waiter = waiter;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<Order> getOrder() {
        return order;
    }



    @Override
    public String toString() {
        return "Checks{" +
                "waiter='" + waiter + '\'' +
                ", cost=" + cost +
                ", order=" + order +
                '}';
    }
}
