public class Third {
    public static void main(String[] args) {
        System.out.println(animals(args[0],args[1],args[2]));
    }
    public static int animals (String a, String b, String c) {
        int d = Integer.parseInt (a);
        int e = Integer.parseInt (b);
        int f = Integer.parseInt (c);
        return d*2+e*4+f*4;    
    }
}