import java.util.HashMap;

public class Cart {
    private HashMap<Integer,Product> productHashMap;

    public Cart() {
        this.productHashMap = new HashMap<>();
    }
    public void add(Product product){
        int id = product.getId();
        if(productHashMap.containsKey(id)){
            throw new RuntimeException("bomba");
        }else{
            productHashMap.put(id,product);
        }
    }

    public HashMap<Integer, Product> getProductHashMap() {
        return productHashMap;
    }
}
