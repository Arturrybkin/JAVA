public class Fifth {
    public static void main(String[] args) {
        System.out.println(operation(args[0],args[1],args[2]));
    }
    public static String operation (String a, String b, String c) {
        int d = Integer.parseInt (a);
        int e = Integer.parseInt (b);
        int f = Integer.parseInt (c);
        if (e+f == d)
            return "added";
        else if (e-f == d) 
            return "subtracted";
        else if (e*f == d) 
            return "multiplyed";
        else if (e/f == d) 
            return "div";
        else
            return "none";
    }
}