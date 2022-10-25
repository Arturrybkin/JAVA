public class First {
    public static void main(String[] args) {
        System.out.println(remainder(args[0],args[1]));
    }
    public static int remainder(String a, String b) {
        int c = Integer.parseInt (a);
        int d = Integer.parseInt (b);
        return c%d;
    }
}
