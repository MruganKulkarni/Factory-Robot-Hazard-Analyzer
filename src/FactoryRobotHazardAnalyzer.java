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

            RobotHazardAuditor auditor = new RobotHazardAuditor();

            double risk = auditor.calculateHazardRisk(
                    armPrecision,
                    workerDensity,
                    machineryState
            );

            System.out.println("Robot Hazard Risk Score: " + risk);

        } catch (RobotSafetyException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
