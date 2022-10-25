public class Sixth {
    public static void main(String[] args) {
        System.out.println(ctoa(args[0]));
    }
    public static int ctoa(String a) {
        char ch = a.toCharArray()[0];
        int ascii = ch;
        return ascii;
    }
}