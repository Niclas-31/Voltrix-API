package de.niclasl.voltrix_api.energy;

import net.minecraft.core.Direction;

public interface IEnergyConnectable {

    ConnectionMode getConnectionMode(Direction direction);

    void setConnectionMode(Direction direction, ConnectionMode connectionMode);

    void cycleConnectionMode(Direction direction);
}