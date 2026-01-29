import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Factory Robot Hazard Analyzer");

        System.out.print("Enter arm precision (0.0 - 1.0): ");
        double armPrecision = scanner.nextDouble();

        System.out.print("Enter worker density (1 - 20): ");
        int workerDensity = scanner.nextInt();

        scanner.nextLine(); // consume newline

        System.out.print("Enter machinery state (Worn/Faulty/Critical): ");
        String machineryState = scanner.nextLine();

        System.out.println("\nInput Summary:");
        System.out.println("Arm Precision: " + armPrecision);
        System.out.println("Worker Density: " + workerDensity);
        System.out.println("Machinery State: " + machineryState);

        scanner.close();
    }
}
