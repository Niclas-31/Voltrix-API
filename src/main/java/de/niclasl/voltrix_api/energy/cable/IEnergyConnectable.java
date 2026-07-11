package de.niclasl.voltrix_api.energy.cable;

import net.minecraft.core.Direction;

public interface IEnergyConnectable {

    ConnectionMode getConnectionMode(Direction direction);

    void setConnectionMode(Direction direction, ConnectionMode connectionMode);

    default boolean canConnect(Direction direction) {
        return getConnectionMode(direction).canConnect();
    }
}