import java.util.ArrayList;
import java.util.List;

public class FoodBankAllocator {
    private final int budget;
    private final List<District> districts;
    private double[][] dp;

    public FoodBankAllocator(int budget, List<District> districts) {
        this.budget = budget;
        this.districts = districts;
    }
    
    public AllocationResult allocateFoodBanks() {
        int n = districts.size();
        
        // Initialize dp table to 0
        this.dp = new double[n + 1][budget + 1];
        
        // Fill dp table
        for (int i = 1; i <= n; i++) {
            District district = districts.get(i - 1);
            int cost = district.getCost();
            double value = district.getWeightedValue();

            for (int w = 1; w <= budget; w++) {
                if (cost <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - cost] + value);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        
        // Backtrack to find selected districts
        List<District> selected = new ArrayList<>();
        int w = budget;

        for (int i = n; i > 0; i--) {
            if (dp[i][w] > dp[i - 1][w]) {
                selected.add(districts.get(i - 1));
                w -= districts.get(i - 1).getCost();
            }
        }

        return new AllocationResult(dp[n][budget], selected);
    }

    public static class AllocationResult {
        public final double maxValue;
        public final List<District> selected;

        public AllocationResult(double maxValue, List<District> selected) {
            this.maxValue = maxValue;
            this.selected = selected;
        }
    }
} 