package de.niclasl.voltrix_api.energy;

public interface IEnergyConsumer extends IEnergyNode {
    long consumeEnergy(long available);
}