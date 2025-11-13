import java.util.*;

public class SumCalculator {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        
        // Add some integers, demonstrating autoboxing (int to Integer)
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        
        // Parse strings to int and add, demonstrating parsing and autoboxing
        String[] strNums = {"40", "50"};
        for (String s : strNums) {
            numbers.add(Integer.parseInt(s));
        }
        
        // Calculate sum using unboxing (Integer to int)
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        
        System.out.println("Sum: " + sum);
    }
}
