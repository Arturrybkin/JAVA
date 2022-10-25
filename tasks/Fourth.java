public class Fourth {
    public static void main(String[] args) {
        System.out.println(profitableGamble(args[0],args[1],args[2]));
    }
    public static boolean profitableGamble (String a, String b, String c) {
        float d = Float.parseFloat (a);
        int e = Integer.parseInt (b);
        int f = Integer.parseInt (c);
        return d*e>f;    
    }
}