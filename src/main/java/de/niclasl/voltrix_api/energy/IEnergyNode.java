package de.niclasl.voltrix_api.energy;

public interface IEnergyNode {
    IEnergyStorage getStorage();

    ElectricalProperties getElectricalProperties();
}