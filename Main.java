import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int budget = 5;
        // Example districts
        List<District> districts = Arrays.asList(
            new District("A", 2, 100, "High"),    
            new District("B", 1, 80, "Critical"), 
            new District("C", 3, 120, "Moderate") 
        );

        // Run allocation with budget of 5
        FoodBankAllocator allocation = new FoodBankAllocator(budget, districts);
        
        // Print input details
        System.out.println("Budget: " + budget);
        System.out.println("Districts:");
        for (District district : districts) {
            System.out.println(district);
        }
        
        // Get and print result
        FoodBankAllocator.AllocationResult result = allocation.allocateFoodBanks();
        System.out.println("\nResult:");
        System.out.printf("Maximum Value: %.1f%n", result.maxValue);
        System.out.println("Selected Districts:");
        for (District selectedDistrict : result.selected) {
            System.out.println(selectedDistrict);
        }
    }
} 