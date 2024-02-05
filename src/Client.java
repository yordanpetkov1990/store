import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",1234)){
            BufferedReader bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter pf = new PrintWriter(socket.getOutputStream(),true);
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            while(!input.equals("exit")){

                pf.println(input);
                String s = bf.readLine();
                System.out.println(s);
                switch (s){
                    case "case 1":
                        System.out.println("Enter product name");
                        pf.println(scan.nextLine());
                        System.out.println(bf.readLine());
                        break;
                    case "case 2":
                        pf.println(scan.nextLine());
                        System.out.println(bf.readLine());
                        break;
                    case "case 3":
                        String s1 = bf.readLine();
                        while (s1 != null){
                            System.out.println(s1);
                            s1 = bf.readLine();
                        }
                        break;
                }
                input= scan.nextLine();
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
