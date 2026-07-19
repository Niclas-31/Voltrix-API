package de.niclasl.voltrix_api.energy;

public interface IEnergyConsumer extends IEnergyNode {
    void consumeEnergy(long energy, long energyPerTick);
}