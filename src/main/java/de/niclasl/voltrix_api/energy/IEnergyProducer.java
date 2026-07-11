package de.niclasl.voltrix_api.energy;

public interface IEnergyProducer extends IEnergyNode {
    long produceEnergy();
}