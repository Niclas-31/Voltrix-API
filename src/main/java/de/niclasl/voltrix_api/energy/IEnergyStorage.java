package de.niclasl.voltrix_api.energy;

public interface IEnergyStorage {

    long receiveEnergy(long amount, boolean simulate);

    long extractEnergy(long amount, boolean simulate);

    long getEnergyStored();

    long getCapacity();
}