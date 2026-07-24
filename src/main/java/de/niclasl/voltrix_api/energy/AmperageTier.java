package de.niclasl.voltrix_api.energy;

public enum AmperageTier {
    NONE(0),
    A1(1),
    A2(2),
    A4(4),
    A8(8),
    A16(16),
    A32(32),
    A64(64);

    private final int amperage;

    AmperageTier(int amperage) {
        this.amperage = amperage;
    }

    public int getAmperage() {
        return amperage;
    }
}