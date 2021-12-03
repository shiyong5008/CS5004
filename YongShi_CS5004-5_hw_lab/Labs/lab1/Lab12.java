import java.util.Scanner;
public class Lab12 {
    public static void main(String[] args) {
        System.out.println("pls input 2 int:");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        sc.close();
        int c = a + b;
        System.out.println(c);
    }
}