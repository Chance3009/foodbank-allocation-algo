# Food Bank Allocation Algorithm

A Java implementation of a dynamic programming algorithm to optimally allocate food banks across districts based on budget constraints, population, and urgency levels.

---

## Problem
Given a limited budget and multiple districts with different:
- Population sizes
- Urgency levels (Critical, High, Moderate)
- Delivery costs

The algorithm determines which districts to serve to maximize the priority-weighted population served.

---

## Algorithm Details

The algorithm uses dynamic programming to solve the 0/1 knapsack problem:

1. **Value Calculation**: Each district's value is calculated as `population × urgency_weight`
2. **Dynamic Programming**: Uses a 2D DP table to find optimal allocation
3. **Backtracking**: Reconstructs the solution to identify selected districts

### Urgency Weights
- **Critical**: 2.0x multiplier
- **High**: 1.5x multiplier  
- **Moderate**: 1.0x multiplier

---

## JSON File Format

Test case files follow this JSON structure:

```json
{
  "budget": 5,
  "districts": [
    {
      "name": "A",
      "cost": 2,
      "value": 100,
      "urgency": "High"
    },
    {
      "name": "B",
      "cost": 1,
      "value": 80,
      "urgency": "Critical"
    }
  ]
}
```

- **budget**: Total available budget
- **districts**: Array of district objects
  - **name**: District identifier
  - **cost**: Cost to establish food bank in this district
  - **value**: Population size (used for value calculation)
  - **urgency**: Urgency level (Critical/High/Moderate)

---

## Usage

### Individual Case Testing

To run a specific test case:

```bash
java Main "resources/Case 1 – Typical Scenario.json"
```

### Batch Testing

To run all test cases at once:

```bash
java TestRunner
```

This will automatically discover and run all JSON files in the `resources/` directory.

---

## Compilation

```bash
javac *.java
```

---

## Example Output

```
=== Food Bank Allocation Algorithm ===
Processing: resources/Case 1 – Typical Scenario.json
--------------------------------------------------
Input Details:
   Budget: $5
   Districts: 5
   District A: Cost=2, Population=100, Urgency=High, WeightedValue=150.0
   District B: Cost=1, Population=80, Urgency=Critical, WeightedValue=160.0
   District C: Cost=3, Population=120, Urgency=Moderate, WeightedValue=120.0

Output Result:
   Maximum Value: 310.0
   Selected Districts: 2
   District A: Cost=2, Population=100, Urgency=High, WeightedValue=150.0
   District B: Cost=1, Population=80, Urgency=Critical, WeightedValue=160.0
   Total Cost: $3 (Budget: $5)
```
