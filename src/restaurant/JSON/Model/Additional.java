package restaurant.JSON.Model;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

public class Additional {

    @SerializedName("Pizza")
    private Map<String, String> pizza = new HashMap<>();
    @SerializedName("Burger")
    private Map<String, String> burger = new HashMap<>();
    @SerializedName("Coffee")
    private Map<String, String> coffee = new HashMap<>();

    public String getPizzaSize() {
        return pizza.get("size");
    }

    public String getPizzaName() {
        return pizza.get("name");
    }

    public void setPizza(String str01, String str02) {
        pizza.put(str01, str02);
    }

    public String getBurgerSize() {
        return burger.get("size");
    }

    public String getBurgerName() {
        return burger.get("cutlet");
    }

    public void setBurger(String str01, String str02) {
        burger.put(str01, str02);
    }

    public String getCoffeeSize() {
        return coffee.get("size");
    }

    public String getCoffeeName() {
        return coffee.get("cutlet");
    }

    public void setCoffee(String str01, String str02) {
        coffee.put(str01, str02);
    }

    @Override
    public String toString() {
        return "Additional{" +
                "pizza=" + pizza +
                ", burger=" + burger +
                ", coffee=" + coffee +
                '}';
    }
}
