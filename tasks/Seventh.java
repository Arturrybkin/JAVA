public class Seventh {
    public static void main(String[] args) {
        System.out.println(addUpTo(args[0]));
    }
    public static int addUpTo(String a) {
        int b = Integer.parseInt (a);
        int sum = 0;
        for (int i=0; i <= b; i++) {
            sum = sum+i;
        }
        return sum;
    }
}