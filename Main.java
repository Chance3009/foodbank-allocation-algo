import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filename = "resources/Case 4 – High Urgency, Low Cost Prioritisation.csv";
        int budget = readBudgetFromCSV(filename);
        List<District> districts = readDistrictsFromCSV(filename);

        if (districts.isEmpty()) {
            System.out.println("No districts loaded.");
            return;
        }

        // Run allocation
        FoodBankAllocator allocation = new FoodBankAllocator(budget, districts);

        // Print input details
        System.out.println("===Input Details===");
        System.out.println("Budget: " + budget);
        System.out.println("Districts:");
        for (District district : districts) {
            System.out.println(district);
        }

        // Get and print result
        FoodBankAllocator.AllocationResult result = allocation.allocateFoodBanks();
        System.out.println("\n===Output Result===");
        System.out.printf("Maximum Value: %.1f%n", result.maxValue);
        System.out.println("Selected Districts:");
        for (District selectedDistrict : result.selected) {
            System.out.println(selectedDistrict);
        }
    }

    private static int readBudgetFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String firstLine = br.readLine();
            if (firstLine != null && firstLine.startsWith("Budget")) {
                String[] parts = firstLine.split(",");
                return Integer.parseInt(parts[1].trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading budget from CSV: " + e.getMessage());
        }
        return 0; // fallback if budget not found
    }


    private static List<District> readDistrictsFromCSV(String filename) {
        List<District> districts = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Skip Budget
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String name = parts[0].trim();
                    int cost = Integer.parseInt(parts[1].trim());
                    int value = Integer.parseInt(parts[2].trim());
                    String urgency = parts[3].trim();
                    districts.add(new District(name, cost, value, urgency));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading CSV: " + e.getMessage());
        }
        return districts;
    }
}
