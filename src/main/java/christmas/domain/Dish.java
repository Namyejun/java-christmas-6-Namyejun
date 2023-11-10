package christmas.domain;

public class Dish {
    private String name;
    private DishSection section;
    private int price;
    private int count = 0;

    public Dish(String name, DishSection section, int price) {
        this.name = name;
        this.section = section;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPrice() {
        return this.price * this.count;
    }
}
