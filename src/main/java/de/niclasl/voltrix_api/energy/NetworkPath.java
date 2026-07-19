package de.niclasl.voltrix_api.energy;

import net.minecraft.core.BlockPos;

import java.util.List;

public record NetworkPath(
        BlockPos consumer,
        List<BlockPos> cables
) {
}