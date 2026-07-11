package de.niclasl.voltrix_api.energy;

public record ElectricalProperties(
        int inputVoltage,
        int outputVoltage,
        int inputAmperage,
        int outputAmperage,
        double cableLoss
) {
    public static ElectricalProperties generator(int voltage, int amperage) {
        return new ElectricalProperties(0, voltage, 0, amperage, 0);
    }

    public static ElectricalProperties consumer(int voltage, int amperage) {
        return new ElectricalProperties(voltage, 0, amperage, 0, 0);
    }

    public static ElectricalProperties battery(int voltage, int amperage) {
        return new ElectricalProperties(voltage, voltage, amperage, amperage, 0);
    }

    public static ElectricalProperties cable(int voltage, int amperage, double loss) {
        return new ElectricalProperties(voltage, voltage, amperage, amperage, loss);
    }

    public long applyLoss(long energy) {
        return (long) (energy * (1.0 - cableLoss));
    }
}