public class Product {
    private static int id_ic = 1;
    private int id;
    private String name;
    private double price;
    private String store;

    public Product(String name, double price, String store) {
        this.id = id_ic;
        id_ic++;
        this.name = name;
        this.price = price;
        this.store = store;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", store='" + store + '\'' +
                '}';
    }
    public int getId() {
        return id;
    }



    public void setStore(String store) {
        this.store = store;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStore() {
        return store;
    }
}
