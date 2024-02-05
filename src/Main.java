import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Server server = new Server(1234);
        server.run();
//        int[] arr = {1,2,3,4,5,6};
//        System.out.println(binary_search(arr, 0, arr.length - 1, 7));
//
//
   }
    public static int binary_search(int[] arr,int lf,int rt,int x){
        if(lf>rt){
            return 0;
        }
        int m = (lf+rt) /2;
        if(arr[m] == x){
            return m;
        }
        if(lf==rt){
            return 0;
        }
        if(arr[m] > x){
            return binary_search(arr,lf,m-1,x);
        }
        return binary_search(arr,m+1,rt,x);
    }
    }
