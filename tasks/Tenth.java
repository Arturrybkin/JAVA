import java.util.Scanner;
public class Tenth {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter a,b,c");
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            System.out.println(abcmath(a,b,c));
        }
    }
    public static boolean abcmath(int a, int b, int c) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum = sum + a + a;
        }
        return sum%c == 0;
    }
}