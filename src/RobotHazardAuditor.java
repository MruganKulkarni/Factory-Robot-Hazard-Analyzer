public class RobotHazardAuditor {

    public double calculateHazardRisk(
            double armPrecision,
            int workerDensity,
            String machineryState
    ) throws RobotSafetyException {

        validateArmPrecision(armPrecision);
        validateWorkerDensity(workerDensity);

        double machineryRiskFactor = getMachineryRiskFactor(machineryState);

        return ((1.0 - armPrecision) * 15.0)
                + (workerDensity * machineryRiskFactor);
    }

    private void validateArmPrecision(double armPrecision)
            throws RobotSafetyException {

        if (armPrecision < 0.0 || armPrecision > 1.0) {
            throw new RobotSafetyException(
                    "Error: Arm precision must be 0.0-1.0"
            );
        }
    }

    private void validateWorkerDensity(int workerDensity)
            throws RobotSafetyException {

        if (workerDensity < 1 || workerDensity > 20) {
            throw new RobotSafetyException(
                    "Error: Worker density must be 1-20"
            );
        }
    }

    private double getMachineryRiskFactor(String machineryState)
            throws RobotSafetyException {

        if (machineryState.equals("Worn")) {
            return 1.3;
        } else if (machineryState.equals("Faulty")) {
            return 2.0;
        } else if (machineryState.equals("Critical")) {
            return 3.0;
        } else {
            throw new RobotSafetyException(
                    "Error: Unsupported machinery state"
            );
        }
    }
}
