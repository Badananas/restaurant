package restaurant.JSON.Model;

public class Order {

    private String soup;
    private String mainDish;
    private String salad;
    private String dessert;
    Additional additional = new Additional();


    public String getSoup() {
        return soup;
    }

    public void setSoup(String soup) {
        this.soup = soup;
    }

    public String getMainDish() {
        return mainDish;
    }

    public void setMainDish(String mainDish) {
        this.mainDish = mainDish;
    }

    public String getSalad() {
        return salad;
    }

    public void setSalad(String salad) {
        this.salad = salad;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }
    public Additional getAdditional() {
        return additional;
    }

    @Override
    public String toString() {
        return "Order{" +
                "additional=" + additional +
                ", soup='" + soup + '\'' +
                ", mainDish='" + mainDish + '\'' +
                ", salad='" + salad + '\'' +
                ", dessert='" + dessert + '\'' +
                '}';
    }
}
