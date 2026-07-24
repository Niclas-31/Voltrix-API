package de.niclasl.voltrix_api.energy;

public enum VoltageTier {
    NONE(0),
    LV(32),
    MV(128),
    HV(512),
    EV(2048),
    IV(8192),
    UV(32768),
    UHV(65536);

    private final int voltage;

    VoltageTier(int voltage) {
        this.voltage = voltage;
    }

    public int getVoltage() {
        return voltage;
    }
}