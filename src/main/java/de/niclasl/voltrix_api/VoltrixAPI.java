package de.niclasl.voltrix_api;

import de.niclasl.voltrix_api.energy.IEnergyStorage;
import net.neoforged.fml.common.Mod;

import java.util.function.Function;

@Mod(VoltrixAPI.MODID)
public class VoltrixAPI {
    public static final String MODID = "voltrix_api";

    private static Function<Long, IEnergyStorage> storageFactory;

    public VoltrixAPI() {
    }

    public static void setStorageFactory(Function<Long, IEnergyStorage> factory) {
        storageFactory = factory;
    }

    public static IEnergyStorage createStorage(long capacity) {
        if (storageFactory == null) {
            throw new IllegalStateException("No storage factory registered.");
        }

        return storageFactory.apply(capacity);
    }
}
