import java.util.Scanner;

public class BmiCalculatorTeam {
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        }
        return "Obese";
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights must have the same length.");
        }
        System.out.println("Person | Height (m) | Weight (kg) | BMI   | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            System.out.printf("%-6d | %-11.2f | %-12.2f | %-5.2f | %s%n",
                    i + 1, heights[i], weights[i], bmi, getBmiStatus(bmi));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of people: ");
        int count = scanner.nextInt();
        double[] heights = new double[count];
        double[] weights = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Person " + (i + 1) + " height (m): ");
            heights[i] = scanner.nextDouble();
            System.out.print("Person " + (i + 1) + " weight (kg): ");
            weights[i] = scanner.nextDouble();
        }
        printWellnessReport(heights, weights);
    }
}