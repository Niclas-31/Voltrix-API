package de.niclasl.voltrix_api.network;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;

import java.util.Collection;

public interface IEnergyNetwork {
    Collection<BlockPos> getNodes();

    void addNode(BlockPos pos);

    void removeNode(BlockPos pos);

    void tick(ServerLevel level);
}