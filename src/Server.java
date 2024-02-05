import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.stream.Collectors;

public class Server {
    private static List<Product> productList = new ArrayList<>();

    private int port;

    public Server(int port) {
        this.port = port;
        productList.addAll(List.of(
                new Product("sirene",20,"lidl"),
                new Product("sirene",20,"djanet"),
                new Product("kashval",30,"lidl"),
                new Product("baklava",10,"bila")
        ));
    }
    public void run(){
        try(ServerSocket serverSocket = new ServerSocket(port)){
            while (true){
                Socket socket = serverSocket.accept();

                Thread clientHandler = new Thread(() ->{
                    try {
                        BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter pf = new PrintWriter(socket.getOutputStream(), true);
                        Cart cart = new Cart();
                        while (true) {
                            String clientInput = bf.readLine();
                            if (!clientInput.equals("1") && !clientInput.equals("2") && !clientInput.equals("3")) {
                                return;
                            }
                            switch (clientInput) {
                                case "1":
                                    pf.println("case 1");
                                    String productName = bf.readLine();
                                    List<Product> productsByStore = new ArrayList<>();
                                    productList.stream().filter(product -> product.getName().equals(productName)).forEach(productsByStore::add);
                                    if (productsByStore.size() != 0) {
                                        pf.println(productsByStore);
                                    } else {
                                        System.out.println("no such element");
                                    }
                                    break;
                                case "2":
                                    pf.println("case 2");
                                    String id = bf.readLine();
                                    try {
                                        int integerVALUEOFID = Integer.parseInt(id);
                                        Optional<Product> byId = getById(integerVALUEOFID);
                                        byId.ifPresent(cart::add);
                                        pf.println("Successfully addded");
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                    }

                                    break;
                                case "3":
                                    pf.println("case 3");
                                    Map<String, List<Product>> collect = cart.getProductHashMap().values().stream().collect(Collectors.groupingBy(Product::getStore));
                                    pf.println(collect);
//                                    collect.values().forEach(pf::println);

                                    break;
                            }
                        }

                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }

                });
                clientHandler.start();
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static Optional<Product> getById(int id){
       return productList.stream().filter(product -> product.getId() == id).findFirst();
    }
}
