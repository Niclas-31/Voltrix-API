package de.niclasl.voltrix_api;

import com.mojang.logging.LogUtils;
import de.niclasl.voltrix_api.energy.IEnergyStorage;
import de.niclasl.voltrix_api.version.ApiSupportChecker;
import de.niclasl.voltrix_api.version.ApiVersion;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

import java.util.function.Function;

@Mod(VoltrixAPI.MODID)
public class VoltrixAPI {
    public static final String MODID = "voltrix_api";

    private static Function<Long, IEnergyStorage> storageFactory;

    public static final ApiVersion API_VERSION = new ApiVersion(1, 0);

    public static final Logger LOGGER = LogUtils.getLogger();

    public VoltrixAPI() {
        ApiSupportChecker.check(LOGGER);
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