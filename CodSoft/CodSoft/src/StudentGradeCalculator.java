import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        // Array to store marks for each subject
        double[] marks = new double[numberOfSubjects];

        // Input marks for each subject
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextDouble();
            // Input validation
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid input. Please enter marks between 0 and 100: ");
                marks[i] = scanner.nextDouble();
            }
        }

        // Calculate total marks
        double totalMarks = calculateTotalMarks(marks);
        
        // Calculate average percentage
        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);
        
        // Determine grade
        char grade = determineGrade(averagePercentage);

        // Display results
        displayResults(totalMarks, averagePercentage, grade);

        // Close the scanner
        scanner.close();
    }

    // Method to calculate total marks
    private static double calculateTotalMarks(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    // Method to calculate average percentage
    private static double calculateAveragePercentage(double totalMarks, int numberOfSubjects) {
        return (totalMarks / (numberOfSubjects * 100)) * 100; // Convert to percentage
    }

    // Method to determine grade based on average percentage
    private static char determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Method to display results
    private static void displayResults(double totalMarks, double averagePercentage, char grade) {
        System.out.println("===================================");
        System.out.printf("Total Marks: %.2f out of %.2f%n", totalMarks, (100 * (totalMarks / averagePercentage)));
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);
        System.out.println("===================================");
    }
}