package mykotlin;

/**
 * Java에서 getter / setter 사용예제
 */
public class GoodsDeals {
    private String name;
    private int price;

    public GoodsDeals(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
