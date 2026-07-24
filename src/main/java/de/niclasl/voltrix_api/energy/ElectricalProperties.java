package de.niclasl.voltrix_api.energy;

public record ElectricalProperties(
        VoltageTier inputVoltage,
        VoltageTier outputVoltage,
        AmperageTier inputAmperage,
        AmperageTier outputAmperage,
        double cableLoss,
        long transferRate
) {
    public static ElectricalProperties generator(VoltageTier voltage, AmperageTier amperage) {
        return new ElectricalProperties(VoltageTier.NONE, voltage, AmperageTier.NONE, amperage,
                0.0, 0);
    }

    public static ElectricalProperties consumer(VoltageTier voltage, AmperageTier amperage) {
        return new ElectricalProperties(voltage, VoltageTier.NONE, amperage, AmperageTier.NONE,
                0.0, 0);
    }

    public static ElectricalProperties battery(VoltageTier voltage, AmperageTier amperage) {
        return new ElectricalProperties(voltage, voltage, amperage, amperage, 0.0, 0);
    }

    public static ElectricalProperties cable(VoltageTier voltage, AmperageTier amperage, double loss, long transferRate) {
        return new ElectricalProperties(voltage, voltage, amperage, amperage, loss, transferRate);
    }

    public static ElectricalProperties solarPanel(VoltageTier voltage, AmperageTier amperage) {
        return generator(voltage, amperage);
    }

    public static ElectricalProperties machine(VoltageTier voltage, AmperageTier amperage) {
        return consumer(voltage, amperage);
    }

    public int inputVoltageValue() {
        return inputVoltage.getVoltage();
    }

    public int outputVoltageValue() {
        return outputVoltage.getVoltage();
    }

    public int inputAmperageValue() {
        return inputAmperage.getAmperage();
    }

    public int outputAmperageValue() {
        return outputAmperage.getAmperage();
    }
}