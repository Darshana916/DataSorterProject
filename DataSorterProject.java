// DataSorter.java
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DataSorter {

    // Simple counter to collect steps
    static class Counter {
        long comparisons = 0;
        long swaps = 0;
        long assignments = 0;
    }

    // Result container
    static class Result {
        int[] sorted;
        long timeNs;
        long steps;
        Result(int[] s, long t, long st) { sorted = s; timeNs = t; steps = st; }
    }

    // Bubble Sort
    public static Result bubbleSort(int[] arr) {
        




    // Merge Sort (returns new sorted array)
    public static Result mergeSort(int[] arr) {
        




    // Quick Sort (in-place)
    public static Result quickSort(int[] arr) {
        





    // Utility: print results table
    private static void printResultsTable(Result[] results, String[] names) {
        System.out.println("\n--- Performance Comparison ---");
        System.out.printf("%-12s | %10s | %8s%n", "Algorithm", "Time (ms)", "Steps");
        System.out.println("----------------------------------------");
        for (int i = 0; i < results.length; i++) {
            double timeMs = results[i].timeNs / 1_000_000.0;
            System.out.printf("%-12s | %10.3f | %8d%n", names[i], timeMs, results[i].steps);
        }
        System.out.println("----------------------------------------");
    }

    // Read integers from a line
    private static int[] readIntsFromLine(Scanner sc) {
        while (true) {
            System.out.print("Enter numbers separated by spaces (e.g. 5 3 9 1): ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Empty input — try again.");
                continue;
            }
            String[] parts = line.split("\\s+");
            try {
                int[] nums = new int[parts.length];
                for (int i = 0; i < parts.length; i++) nums[i] = Integer.parseInt(parts[i]);
                return nums;
            } catch (NumberFormatException ex) {
                System.out.println("Make sure you only type integers separated by spaces. Try again.");
            }
        }
    }

    // Generate random numbers
    private static int[] generateRandom(Scanner sc) {
        Random rnd = new Random();
        while (true) {
            try {
                System.out.print("How many numbers to generate? (e.g. 10): ");
                int n = Integer.parseInt(sc.nextLine().trim());
                if (n <= 0) { System.out.println("Number must be > 0."); continue; }
                System.out.print("Minimum value (e.g. 0): ");
                int low = Integer.parseInt(sc.nextLine().trim());
                System.out.print("Maximum value (e.g. 100): ");
                int high = Integer.parseInt(sc.nextLine().trim());
                if (low > high) { System.out.println("Min must be <= Max. Try again."); continue; }
                int[] nums = new int[n];
                for (int i = 0; i < n; i++) nums[i] = rnd.nextInt(high - low + 1) + low;
                return nums;
            } catch (NumberFormatException ex) {
                System.out.println("Enter integer values only. Try again.");
            }
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data = new int[0];
        while (true) {
            System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---");
            System.out.println("1. Enter numbers manually");
            System.out.println("2. Generate random numbers");
            System.out.println("3. Perform Bubble Sort");
            System.out.println("4. Perform Merge Sort");
            System.out.println("5. Perform Quick Sort");
            System.out.println("6. Compare all algorithms (show performance table)");
            System.out.println("7. Show current list");
            System.out.println("8. Exit");
            System.out.print("Enter your choice (1-8): ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    data = readIntsFromLine(sc);
                    System.out.println("Data stored.");
                    break;
                case "2":
                    data = generateRandom(sc);
                    System.out.println("Random data generated and stored.");
                    break;
                case "3":
                    if (data.length == 0) { System.out.println("No data yet — choose option 1 or 2 first."); break; }
                    Result br = bubbleSort(data);
                    System.out.println("Bubble Sort result: " + Arrays.toString(br.sorted));
                    System.out.printf("Time: %.3f ms, Steps: %d%n", br.timeNs / 1_000_000.0, br.steps);
                    break;
                case "4":
                    if (data.length == 0) { System.out.println("No data yet — choose option 1 or 2 first."); break; }
                    Result mr = mergeSort(data);
                    System.out.println("Merge Sort result: " + Arrays.toString(mr.sorted));
                    System.out.printf("Time: %.3f ms, Steps: %d%n", mr.timeNs / 1_000_000.0, mr.steps);
                    break;
                case "5":
                    if (data.length == 0) { System.out.println("No data yet — choose option 1 or 2 first."); break; }
                    Result qr = quickSort(data);
                    System.out.println("Quick Sort result: " + Arrays.toString(qr.sorted));
                    System.out.printf("Time: %.3f ms, Steps: %d%n", qr.timeNs / 1_000_000.0, qr.steps);
                    break;
                case "6":
                    if (data.length == 0) { System.out.println("No data yet — choose option 1 or 2 first."); break; }
                    Result bres = bubbleSort(data);
                    Result mres = mergeSort(data);
                    Result qres = quickSort(data);
                    printResultsTable(new Result[]{bres, mres, qres}, new String[]{"Bubble", "Merge", "Quick"});
                    break;
                case "7":
                    System.out.println("Current data list: " + Arrays.toString(data));
                    break;
                case "8":
                    System.out.println("Exiting. Good luck with your submission!");
                    sc.close();
                    return;
                default:
                    System.out.println("Please choose a number from 1 to 8.");
            }
        }
    }
}
