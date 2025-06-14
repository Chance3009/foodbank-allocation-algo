# Food Bank Allocation Algorithm

A Java implementation of the 0/1 Knapsack algorithm for optimal food bank allocation during disaster relief.

## Problem
Given a limited budget and multiple districts with different:
- Population sizes
- Urgency levels (Critical, High, Moderate)
- Delivery costs

The algorithm determines which districts to serve to maximize the priority-weighted population served.

## How to Run
1. Compile:
```bash
javac *.java
```

2. Run:
```bash
java Main
```

## Example Output
```
Budget: 5
Districts:
District A: Cost=2, Population=100, Urgency=High, WeightedValue=150.0
District B: Cost=1, Population=80, Urgency=Critical, WeightedValue=160.0
District C: Cost=3, Population=120, Urgency=Moderate, WeightedValue=120.0

Result:
Maximum Value: 310.0
Selected Districts:
District A: Cost=2, Population=100, Urgency=High, WeightedValue=150.0
District B: Cost=1, Population=80, Urgency=Critical, WeightedValue=160.0
```

## Files
- `District.java`: District class with properties and weighted value calculation
- `FoodBankAllocator.java`: Main algorithm implementation using 0/1 Knapsack
- `Main.java`: Example usage and demonstration 