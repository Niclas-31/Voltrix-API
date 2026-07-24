package de.niclasl.voltrix_api.version;

import de.niclasl.voltrix_api.VoltrixAPI;
import net.neoforged.fml.loading.FMLEnvironment;
import org.slf4j.Logger;

public final class ApiSupportChecker {

    private ApiSupportChecker() {
    }

    public static void check(Logger logger) {
        try {
            ApiVersionHolder holder = VoltrixApiVersions.getHolder(VoltrixAPI.API_VERSION.major());

            if (holder == null) {
                logger.error("Unknown Voltrix API major version: {}", VoltrixAPI.API_VERSION.major());
                return;
            }

            if (!FMLEnvironment.isProduction()) {
                switch (holder.status()) {
                    case SUPPORTED -> {
                    }
                    case LEGACY -> logger.info(
                            "Voltrix API {} is in legacy support. Updating is recommended.",
                            VoltrixAPI.API_VERSION
                    );
                    case DEPRECATED -> logger.warn(
                            "Voltrix API {} is deprecated. It is still supported, but is no longer recommended for new projects.",
                            VoltrixAPI.API_VERSION
                    );
                    case UNSUPPORTED -> throw new IllegalStateException("Voltrix API " + VoltrixAPI.API_VERSION + " is no longer supported.");
                }
                return;
            }

            if (holder.status() == ApiSupportStatus.UNSUPPORTED) {
                logger.error("Voltrix API {} is no longer supported.", VoltrixAPI.API_VERSION);
            }

        } catch (Exception e) {
            logger.debug("Could not check Voltrix API support status", e);
        }
    }
}