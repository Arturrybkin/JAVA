public class Second {
    public static void main(String[] args) {
    System.out.println(triArea(args[0],args[1]));
    }
    public static int triArea (String a, String b) {
        int c = Integer.parseInt (a);
        int d = Integer.parseInt (b);
        return (c*d)/2;
    }
}