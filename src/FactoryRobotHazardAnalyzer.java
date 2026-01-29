import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Factory Robot Hazard Analyzer");

        System.out.print("Enter arm precision (0.0 - 1.0): ");
        double armPrecision = scanner.nextDouble();

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            System.out.println("Error: Arm precision must be 0.0-1.0");
            return;
        }

        System.out.print("Enter worker density (1 - 20): ");
        int workerDensity = scanner.nextInt();

        if (workerDensity < 1 || workerDensity > 20) {
            System.out.println("Error: Worker density must be 1-20");
            return;
        }

        scanner.nextLine(); // consume newline

        System.out.print("Enter machinery state (Worn/Faulty/Critical): ");
        String machineryState = scanner.nextLine();

        double machineryRiskFactor;

        if (machineryState.equals("Worn")) {
            machineryRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineryRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineryRiskFactor = 3.0;
        } else {
            System.out.println("Error: Unsupported machinery state");
            return;
        }

        double hazardRisk =
                ((1.0 - armPrecision) * 15.0)
                        + (workerDensity * machineryRiskFactor);

        System.out.println("\nHazard Risk Score: " + hazardRisk);

        scanner.close();
    }
}
