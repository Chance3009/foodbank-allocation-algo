public class District {
    private final String id;
    private final int cost;
    private final int population;
    private final String urgency;
    private final double weightedValue;

    public District(String id, int cost, int population, String urgency) {
        this.id = id;
        this.cost = cost;
        this.population = population;
        this.urgency = urgency;
        this.weightedValue = calculateWeightedValue();
    }

    private double calculateWeightedValue() {
        double weight = switch (urgency.toLowerCase()) {
            case "critical" -> 2.0;
            case "high" -> 1.5;
            case "moderate" -> 1.0;
            default -> 1.0;
        };
        return population * weight;
    }

    // Getters
    public String getId() { return id; }
    public int getCost() { return cost; }
    public int getPopulation() { return population; }
    public String getUrgency() { return urgency; }
    public double getWeightedValue() { return weightedValue; }

    @Override
    public String toString() {
        return String.format("District %s: Cost=%d, Population=%d, Urgency=%s, WeightedValue=%.1f",
                id, cost, population, urgency, weightedValue);
    }
} 