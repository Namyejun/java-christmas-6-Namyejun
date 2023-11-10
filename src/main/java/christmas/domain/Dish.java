package christmas.domain;

public class Dish {
    private String name;
    private MenuSection section;
    private int price;
    private int count = 0;

    public Dish(String name, MenuSection section, int price) {
        this.name = name;
        this.section = section;
        this.price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalPrice() {
        return this.price * this.count;
    }
}
