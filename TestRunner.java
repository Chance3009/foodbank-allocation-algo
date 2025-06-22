import java.io.*;
import java.util.*;

public class TestRunner {
    private static final String RESOURCES_DIR = "resources/";
    
    public static void main(String[] args) {
        System.out.println("=== Food Bank Allocation Algorithm Test Suite ===\n");
        
        File[] testFiles = getAvailableTestCases();
        if (testFiles.length == 0) {
            System.out.println("No test case files found in resources directory.");
            return;
        }
        
        for (File testFile : testFiles) {
            System.out.println("Running Test Case: " + testFile.getName());
            System.out.println("-".repeat(40));
            
            // Call Main.java's main function for this file
            String[] mainArgs = {testFile.getPath()};
            Main.main(mainArgs);
            
            System.out.println("\n" + "=".repeat(60) + "\n");
        }
        
        System.out.println("=== All Test Cases Completed ===");
    }
    
    private static File[] getAvailableTestCases() {
        File resourcesDir = new File(RESOURCES_DIR);
        if (resourcesDir.exists() && resourcesDir.isDirectory()) {
            File[] testFiles = resourcesDir.listFiles((dir, name) -> name.endsWith(".json"));
            if (testFiles != null) {
                Arrays.sort(testFiles);
                return testFiles;
            }
        }
        return new File[0];
    }
} 