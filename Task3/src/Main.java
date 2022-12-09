import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(simpleNs(1000));
    }
    public static List<Integer> simpleNs(int n){
        List<Integer> simples = new ArrayList<>();
        simples.add(1);
        simples.add(2);
        int x = 3;
        while (x<=n){
            if (isSimple(x)){
                simples.add(x);
            }
            x++;
        }
        return simples;
    }

    public static boolean isSimple(int n){
        int x = n/2;
        while (x>1){
            if(n%x !=0){
                x--;
            }else {
                return false;}
        }
        return true;
    }
}
