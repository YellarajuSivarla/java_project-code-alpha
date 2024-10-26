import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {
    
    // Method to calculate average
    public static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? sum / grades.size() : 0;
    }

    // Method to find the highest grade
    public static double findHighest(ArrayList<Double> grades) {
        double highest = Double.NEGATIVE_INFINITY;
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest == Double.NEGATIVE_INFINITY ? 0 : highest;
    }

    // Method to find the lowest grade
    public static double findLowest(ArrayList<Double> grades) {
        double lowest = Double.POSITIVE_INFINITY;
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest == Double.POSITIVE_INFINITY ? 0 : lowest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        
        System.out.println("Welcome to the Student Grade Tracker!");
        
        while (true) {
            System.out.print("Enter a student's grade (or type 'exit' to finish): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            try {
                double grade = Double.parseDouble(input);
                if (grade < 0 || grade > 100) {
                    System.out.println("Please enter a valid grade between 0 and 100.");
                } else {
                    grades.add(grade);
                    System.out.println("Grade added: " + grade);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade.");
            }
        }

        // Calculate and display results
        if (!grades.isEmpty()) {
            double average = calculateAverage(grades);
            double highest = findHighest(grades);
            double lowest = findLowest(grades);
            
            System.out.println("\nGrade Summary:");
            System.out.printf("Average Grade: %.2f\n", average);
            System.out.printf("Highest Grade: %.2f\n", highest);
            System.out.printf("Lowest Grade: %.2f\n", lowest);
        } else {
            System.out.println("No grades were entered.");
        }

        scanner.close();
    }
}
