import java.util.Arrays;
import java.util.Random;

public class Member2_BinarySearch {

    // Generating a Random Integer Array
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }



    // Member 2's task: Measuring Binary Search time
    
    public static long timeBinarySearch(int size, int target) {
        int[] data = generateRandomArray(size);
        Arrays.sort(data); // Mandatory for Binary Search
        
        long startTime = System.nanoTime(); 
        
        // Binary Search Algorithm
        Arrays.binarySearch(data, target);
        
        long endTime = System.nanoTime(); 
        return endTime - startTime;
    }



    // Main Execution
    
    public static void main(String[] args) {
        int[] inputSizes = {100, 500, 1000}; 
        int targetElement = 5000;

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Member 2: Binary Search (Array must be sorted first)");
        printTable("Binary Search", inputSizes, (size) -> timeBinarySearch(size, targetElement));
        System.out.println("-----------------------------------------------------------------");
    }
    
    // Helper: Function to print results as a table
    interface TimeMeasurer {
        long measure(int size);
    }
    
    private static void printTable(String algoName, int[] sizes, TimeMeasurer measurer) {
        System.out.println("Algorithm: " + algoName);
        System.out.printf("%-15s %-15s\n", "Input Size", "Time (ms)"); 
        System.out.println("-------------------------------");
        
        for (int size : sizes) {
            long nanoSeconds = measurer.measure(size);
            double milliseconds = (double) nanoSeconds / 1_000_000.0;
            System.out.printf("%-15d %-15.4f\n", size, milliseconds);
        }
        System.out.println("-------------------------------");
    }
}