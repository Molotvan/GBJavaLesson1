import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("Сумма чисел от 1 до " + n + " равна " + triangleNumber(n));
        System.out.println("факториал 1 до " + n + " равен " + factorial(n));

    }
    public static int triangleNumber(int n){
        int sum = n;
        if(n>0){
            sum = sum + triangleNumber(n-1);
        }
        return sum;
    }
     public static int factorial(int n){
         int f = n;
         if(n>1){
             f = f * factorial(n-1);
         }
         return f;
     }
}
