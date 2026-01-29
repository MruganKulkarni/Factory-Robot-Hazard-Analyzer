import java.util.Scanner;

public class FactoryRobotHazardAnalyzer {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Factory Robot Hazard Analyzer");

            System.out.print("Enter arm precision (0.0 - 1.0): ");
            double armPrecision = scanner.nextDouble();

            System.out.print("Enter worker density (1 - 20): ");
            int workerDensity = scanner.nextInt();

            scanner.nextLine(); // consume newline

            System.out.print("Enter machinery state (Worn/Faulty/Critical): ");
            String machineryState = scanner.nextLine();

            double hazardRisk = calculateHazardRisk(
                    armPrecision,
                    workerDensity,
                    machineryState
            );

            System.out.println("\nRobot Hazard Risk Score: " + hazardRisk);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            String machineryState
    ) throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0-1.0"
            );
        }

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Error: Worker density must be 1-20"
            );
        }

        double machineryRiskFactor;

        if (machineryState.equals("Worn")) {
            machineryRiskFactor = 1.3;
        } else if (machineryState.equals("Faulty")) {
            machineryRiskFactor = 2.0;
        } else if (machineryState.equals("Critical")) {
            machineryRiskFactor = 3.0;
        } else {
            throw new RobotSafetyException(
                    "Error: Unsupported machinery state"
            );
        }

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineryRiskFactor);
    }
}
