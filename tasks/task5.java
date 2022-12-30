

import java.lang.Math;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class task5 {
    public static void main(String[] args) throws NoSuchAlgorithmException{
        System.out.println(encrypt("Hello"));
        System.out.println(decrypt(new int [] {72, 33, -73, 84, -12, -3, 13, -13, -68 }));
        System.out.println(canMove("Rook", "A8", "H8"));
        System.out.println(canMove("Bishop", "A7", "G1"));
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(canComplete("butlz", "beautiful")); 
        System.out.println(sumDigProd(16, 28));
        System.out.println(sameVowelGroup(new String [] {"toe", "ocelot", "maniac"}));
        System.out.println(validateCard(1234567890123456L));
        System.out.println(tripleAsText(364, false));
        System.out.println(tripleAsText(364, true)); 
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(hexLattice(7));
        System.out.println(hexLattice(21));
    }

    public static String encrypt(String s) {
        int[] arr1 = new int[s.length()];
        int[] arr2 = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arr1[i] = Integer.valueOf(s.charAt(i));
        }
        arr2[0] = arr1[0];
        for (int i = 1; i < arr1.length; i++) {
            arr2[i] = arr1[i] - arr1[i - 1];
        }
        return Arrays.toString(arr2);
    }

    public static String decrypt(int [] arr) {
        String s = new String();
        s += (char) arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
            s += (char) (arr[i]);
        }
        return s;
    }

    public static boolean canMove(String figure, String startPos, String finalPos){

        
        char startLetter = startPos.charAt(0);
        char finalLetter = finalPos.charAt(0);

        int startInt = startPos.charAt(1);
        int finalInt = finalPos.charAt(1);

        String list = "ABCDEFGH";

        if (figure == "Pawn"){
            if (startInt == (finalInt - 1) || startInt == (finalInt - 2)){
                return true;
            }
        }
        else if (figure == "Horse"){
            if (Math.pow((list.indexOf(finalLetter) + 1) - (list.indexOf(startLetter) + 1), 2) + Math.pow(finalInt - startInt, 2) == 5){
                return true;
            }
        }
        else if (figure == "Bishop"){
            if (Math.abs(list.indexOf(finalLetter) - list.indexOf(startLetter)) == Math.abs(finalInt - startInt)){
                return true;
            }
        }
        else if (figure == "Rook"){
            if (startLetter == finalLetter || startInt == finalInt){
                return true;
            }
        }
        else if (figure == "Queen"){
            if (Math.abs(list.indexOf(finalLetter) - list.indexOf(startLetter)) == Math.abs(finalInt - startInt) || startLetter == finalLetter || startInt == finalInt){
                return true;
            } 
        }
        else if (figure == "King"){
            if (Math.abs(list.indexOf(startLetter) - list.indexOf(finalLetter)) == 1 && Math.abs(startInt - finalInt) == 1){
                return true;
            }
        }
        
        return false;
    }

    public static boolean canComplete(String word1, String word2) {
        int count = 0;
        boolean state = false;
        for (int i = 0; i < word1.length(); i++) {
            state = false;
            for (int j = count; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    count = word1.indexOf(word1.charAt(i)) + 1;
                    state = true;
                    break;
                }
            }
            if (state == false) {
                return false;
            }
        }
        return true;
    }

    public static int sumDigProd(int ...nums) {
        int s = 0;
        for (int n: nums) {
            s += n;
        }
        int x = s;
        while (x > 9) {
            x = 1;
            while (s > 0) {
                x *= s % 10;
                s = s / 10;
            }
            s = x;
        }
        return x;
    }

    public static ArrayList<String> sameVowelGroup(String arr[]) {
        String letters = "aeyuio";
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Character> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        for (int i = 0; i < arr[0].length(); i++) {
            if (letters.indexOf(arr[0].charAt(i)) != -1) {
                list1.add(arr[0].charAt(i));
            }
        }
        Collections.sort(list1);
        for (int i = 1; i < list1.size(); i++) {
            if ((list1.get(i)).equals(list1.get(i-1))) {
                list1.remove(i-1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length(); j++) {
                if (letters.indexOf(arr[i].charAt(j)) != -1) {
                    list2.add(arr[i].charAt(j));
                }
                Collections.sort(list2);
                for (int n = 1; n < list2.size(); n++) {
                    if ((list2.get(n)).equals(list2.get(n-1))) {
                        list2.remove(n-1);
                    }
                }
            }
            if (list1.size() == list2.size()) {
                for (int n = 0; n < list2.size(); n++) {
                    if (list1.get(n) != list2.get(n)) {
                        break;
                    }
                    else {
                        list3.add(arr[i]);
                    }
                }
            }
            else break;
            list2.clear();
        }
        for (int i = 1; i < list3.size(); i++) {
            if ((list3.get(i)).equals(list3.get(i-1))) {
                list3.remove(i-1);
            }
        }
        return list3;
    }

    public static boolean validateCard(long n) {
        int sum = 0;
        ArrayList<Character> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        String s = String.valueOf(n).substring(0, String.valueOf(n).length()-1);
        if (s.length() < 13 || s.length() >= 18) {
            return false;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            list1.add(s.charAt(i));
        }
        for (int i = 0; i < list1.size(); i++) {
            if (i % 2 == 0) {
                list2.add(Character.getNumericValue(list1.get(i)) * 2);
            }
            else list2.add(Character.getNumericValue(list1.get(i)));
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list2.get(i) > 9) {
                list2.set(i, list2.get(i) / 10 + list2.get(i) % 10);
            }
            sum += list2.get(i);
        }
        int a = Integer.valueOf(String.valueOf(n).substring(String.valueOf(n).length()-1));
        int b = 10 - Integer.valueOf(String.valueOf(sum).substring(String.valueOf(sum).length()-1));
        
        return (a == b);
    }

        
        private static final String[] SUBTWENTY = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                                                   "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        private static final String[] DECADES = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    
        private static final String[] SUBTWENTYRUS = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять", "десять", 
                                                    "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девянадцать"};
        private static final String[] DECADESRUS = {"ноль", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемдесят", "девяносто"};
        private static final String[] HANDREDSRUS = {"ноль", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
            
        
    
        private static final String tripleAsText(int value, boolean rus) {
            if (value < 0 || value >= 1000) {
                throw new IllegalArgumentException("Illegal triple-value " + value);
            }
    
            if (value < SUBTWENTY.length && rus == false) {
                return SUBTWENTY[value];
            }
            if (value < SUBTWENTYRUS.length && rus == true) {
                return SUBTWENTYRUS[value];
            }
    
            int subhun = value % 100;
            int hun = value / 100;
            StringBuilder sb = new StringBuilder(50);
            if (hun > 0 && rus == false) {
                sb.append(SUBTWENTY[hun]).append(" hundred ");
            }
            if (hun > 0 && rus == true) {
                sb.append(HANDREDSRUS[hun]).append(" ");
            }
            if (subhun > 0 && rus == false) {
                
                if (subhun < SUBTWENTY.length && rus == false) {
                    sb.append(SUBTWENTY[subhun]);
                } else {
                    int tens = subhun / 10;
                    int units = subhun % 10;
                    if (tens > 0) {
                        sb.append(DECADES[tens]);
                    }
                    if (units > 0) {
                        sb.append(" ").append(SUBTWENTY[units]);
                    }
                }
            }
            if (subhun > 0 && rus == true) {
                
                if (subhun < SUBTWENTYRUS.length && rus == true) {
                    sb.append(SUBTWENTYRUS[subhun]);
                } else {
                    int tens = subhun / 10;
                    int units = subhun % 10;
                    if (tens > 0) {
                        sb.append(DECADESRUS[tens]);
                    }
                    if (units > 0) {
                        sb.append(" ").append(SUBTWENTYRUS[units]);
                    }
                }
            }
    
            return sb.toString();
        }

    public static String getSha256Hash(String s) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(s.getBytes());
        byte[] hash = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : hash) {
            sb.append(String.format("%02x", b & 0xff));
        }
        return sb.toString();
    }

    public static String correctTitle(String s) {
        String str = new String();
        String arr[] = s.toLowerCase().split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("and") || arr[i].equals("the") || arr[i].equals("of") || arr[i].equals("in")) {
                str += arr[i] + " ";
            }
            else str += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1) + " ";
        }
        return str;
    }

    public static String hexLattice(int n) {
        int count = 1;
        int i = 0;
        int step = 6;
        // Проверяем является ли число центрированным шестиугольным
        // находим количество итераций
        while (count < n) {
            i++;
            count += step * i;
        }
        if (count == n) {
            String s = new String();
            int space = i;
            // Строки до центра включая
            for (int j = 0; j < i + 1; j++) {
                String line = new String();
                line += " ".repeat(space - j);
                String middle = new String();
                middle += "o ".repeat(i + 1 + j);
                middle = middle.strip();
                line += middle;
                line += " ".repeat(space - j) + "\n";
                s += line;
            }
            // Строки от центра
            for (int j = i - 1; j >= 0; j--) {
                String line = "";
                line += " ".repeat(space - j);
                String middle = "";
                middle += "o ".repeat(i + 1 + j);
                middle = middle.strip();
                line += middle;
                line += " ".repeat(space - j) + "\n";
                s += line;
            }
            return s;
        } 
        else return "Invalid";
    }
  
}