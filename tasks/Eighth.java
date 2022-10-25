public class Eighth {
    public static void main(String[] args) {
        System.out.println(nextEdge(args[0],args[1]));
    }
    public static int nextEdge(String a, String b) {
        int c = Integer.parseInt (a);
        int d = Integer.parseInt (b);
        
        return c+d-1 ;
    }
}