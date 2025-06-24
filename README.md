# CSC4202 Group Project - Food Bank Allocation Algorithm

An optimal resource allocation system for food bank distribution using **Dynamic Programming** approach for the **CSC4202 Algorithm Design and Analysis** course.

This project focuses on solving the **0/1 Knapsack Problem** with weighted values to optimally allocate limited budget across multiple districts based on population, cost, and urgency levels.

---

## Group Members – Group 6

| Name             | Matric Number |
|------------------|---------------|
| Chan Ci En       | 215035        |
| Khoo Boo Jing    | 215382        |
| Loo Huai Yuan    | 215516        |
| Tan Yong Jin     | 217086        |

---

## Problem Scenario

### Background
In a developing country, a humanitarian organization has a limited budget to establish food banks across multiple districts. Each district has different characteristics:
- **Population**: Number of people who would benefit
- **Cost**: Amount required to establish a food bank
- **Urgency Level**: Critical, High, Moderate (affecting priority)

### Problem Statement
Given a fixed budget and a list of districts with their respective costs, population sizes, and urgency levels, determine the optimal combination of districts to establish food banks that maximizes the total weighted benefit while staying within budget constraints.

---
## Setup

### 1. Clone the repository:
```bash
git clone https://github.com/your-username/foodbank-allocation-algo.git
cd foodbank-allocation-algo
```

### 2. Compile the Java files:
```bash
javac src/*.java
```

### 3. Run the program:
```bash
# Run with a specific test case
java -cp src Main "src/resources/Case 1 – Typical Scenario.json"

# Available test cases:
# - Case 1 – Typical Scenario.json
# - Case 2 – Zero Budget (Edge Case).json  
# - Case 3 – All Districts Affordable.json
# - Case 4 – High Urgency, Low Cost Prioritisation.json
```

### 4. Expected Output:
```
=== Food Bank Allocation Algorithm ===
Processing: src/resources/Case 1 – Typical Scenario.json
--------------------------------------------------
Input Details:
   Budget: $5
   Districts: 5
   District A: Cost=2, Population=100, Urgency=High, WeightedValue=150.0
   District B: Cost=1, Population=80, Urgency=Critical, WeightedValue=160.0
   District C: Cost=3, Population=120, Urgency=Moderate, WeightedValue=120.0
   District D: Cost=2, Population=90, Urgency=High, WeightedValue=135.0
   District E: Cost=1, Population=60, Urgency=Moderate, WeightedValue=60.0

Output Result:
   Maximum Value: 295.0
   Selected Districts: 2
   District B: Cost=1, Population=80, Urgency=Critical, WeightedValue=160.0
   District D: Cost=2, Population=90, Urgency=High, WeightedValue=135.0
   Total Cost: $3 (Budget: $5)
```

---

## Algorithm Specification

### Input Format (JSON)
```json
{
    "budget": <integer>,
    "districts": [
        {
            "name": "<string>",
            "cost": <integer>,
            "value": <integer>,
            "urgency": "<Critical|High|Moderate>"
        }
    ]
}
```

---

## Test Cases

The project includes four comprehensive test cases:

1. **Case 1 – Typical Scenario**: Standard allocation with mixed urgency levels
2. **Case 2 – Zero Budget**: Edge case testing with no available budget
3. **Case 3 – All Districts Affordable**: When budget exceeds all district costs
4. **Case 4 – High Urgency, Low Cost Prioritisation**: Testing urgency-based weighting

---

## Project Structure

```
foodbank-allocation-algo/
├── README.md                           # This file
├── src/
│   ├── Main.java                       # Main program entry point
│   ├── FoodBankAllocator.java          # Core DP algorithm implementation
│   ├── District.java                   # District data model
│   ├── TestRunner.java                 # Automated test runner
│   └── resources/                      # Test case JSON files
│       ├── Case 1 – Typical Scenario.json
│       ├── Case 2 – Zero Budget (Edge Case).json
│       ├── Case 3 – All Districts Affordable.json
│       └── Case 4 – High Urgency, Low Cost Prioritisation.json
├── CSC4202 Group Project_Group 6_Slides.pdf
└── CSC4202 Group Project_Group 6_Report.pdf
```
