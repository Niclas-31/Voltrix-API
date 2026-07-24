package de.niclasl.voltrix_api.version;

import com.google.gson.Gson;
import de.niclasl.voltrix_api.VoltrixAPI;
import org.slf4j.Logger;
import org.spongepowered.include.com.google.common.base.Charsets;

import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

public final class ApiVersionChecker {

    private static final String VERSION_URL = "https://raw.githubusercontent.com/Niclas-31/Voltrix-API/main/src/main/resources/api_versions.json";

    public static void check(Logger logger) {
        logger.info("Starting Voltrix API version checker...");

        CompletableFuture.runAsync(() -> {
            try {
                URI uri = new URI(VERSION_URL);
                URL url = uri.toURL();

                Gson gson = new Gson();

                ApiVersionsFile file;

                try (InputStreamReader reader = new InputStreamReader(url.openStream(), Charsets.UTF_8)) {

                    file = gson.fromJson(reader, ApiVersionsFile.class);
                }

                ApiVersion online = file.getLatest();

                if (VoltrixAPI.API_VERSION.isOlderThan(online)) {

                    logger.warn("================================================");
                    logger.warn("A new Voltrix API version is available!");
                    logger.warn("{} -> {}", VoltrixAPI.API_VERSION, online);
                    logger.warn("Please update Voltrix API.");
                    logger.warn("================================================");
                } else {
                    logger.info("Voltrix API is up to date.");
                }

            } catch (Exception e) {
                logger.error("Failed to check Voltrix API version", e);
            }
        });
    }
}