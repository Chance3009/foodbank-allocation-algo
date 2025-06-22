import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main <filename>");
            System.out.println("Example: java Main \"resources/Case 1 – Typical Scenario.json\"");
            return;
        }
        
        String filename = args[0];
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Error: File '" + filename + "' not found.");
            return;
        }
        
        System.out.println("=== Food Bank Allocation Algorithm ===");
        System.out.println("Processing: " + filename);
        System.out.println("-".repeat(50));
        
        // Read JSON and parse data
        String content = readFile(filename);
        if (content == null) return;
        
        int[] budget = {0};
        List<District> districts = new ArrayList<>();
        parseJSON(content, budget, districts);
        
        if (districts.isEmpty()) {
            System.out.println("Error: No districts found in " + filename);
            return;
        }

        // Run algorithm
        FoodBankAllocator allocation = new FoodBankAllocator(budget[0], districts);

        System.out.println("Input Details:");
        System.out.println("   Budget: $" + budget[0]);
        System.out.println("   Districts: " + districts.size());
        for (District district : districts) {
            System.out.println("   " + district);
        }

        FoodBankAllocator.AllocationResult result = allocation.allocateFoodBanks();
        System.out.println("\nOutput Result:");
        System.out.printf("   Maximum Value: %.1f%n", result.maxValue);
        System.out.println("   Selected Districts: " + result.selected.size());
        for (District selectedDistrict : result.selected) {
            System.out.println("   " + selectedDistrict);
        }
        
        int totalCost = result.selected.stream().mapToInt(District::getCost).sum();
        System.out.printf("   Total Cost: $%d (Budget: $%d)%n", totalCost, budget[0]);
    }
    
    private static String readFile(String filename) {
        try {
            return new String(Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        }
    }
    
    private static void parseJSON(String json, int[] budget, List<District> districts) {
        try {
            json = json.replaceAll("\\s+", "");
            
            // Extract budget
            budget[0] = Integer.parseInt(json.split("\"budget\":")[1].split(",")[0]);
            
            // Extract districts
            String districtsPart = json.split("\"districts\":\\[")[1].split("\\]")[0];
            
            for (String district : districtsPart.split("\\{")) {
                if (district.isEmpty()) continue;
                district = district.replaceAll("\\},?$", "");
                
                String[] fields = district.split(",");
                String name = fields[0].split(":")[1].replace("\"", "");
                int cost = Integer.parseInt(fields[1].split(":")[1]);
                int value = Integer.parseInt(fields[2].split(":")[1]);
                String urgency = fields[3].split(":")[1].replace("\"", "");
                
                districts.add(new District(name, cost, value, urgency));
            }
        } catch (Exception e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
        }
    }
}
