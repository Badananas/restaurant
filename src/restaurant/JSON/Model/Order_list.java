package restaurant.JSON.Model;

import java.util.ArrayList;
import java.util.List;

public class Order_list {

    private List<Checks> checks = new ArrayList<>();

    public void addObjectChecks() {
        checks.add(new Checks());
    }

    public List<Checks> getChecks() {
        return checks;
    }

    @Override
    public String toString() {
        return "Order_list{" +
                "checks=" + checks +
                '}';
    }
}
