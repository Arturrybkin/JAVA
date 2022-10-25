package task1;
import java.util.Scanner;

public class Nineth {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Длинна массива: ");
            int size = input.nextInt(); 
            int array[] = new int[size]; 
            System.out.println("Элементы массива:");
            for (int i = 0; i < size; i++) {
                array[i] = input.nextInt(); 
            }
            System.out.println(sumOfCubes(array));
        }
    }
    public static int sumOfCubes(int[] arr) {
        int sum = 0;
        int multi = 1;
        for (int i = 0; i < arr.length; i++){
            multi = arr[i]*arr[i]*arr[i];
            sum = sum + multi;
        }
        return sum;
    }
}