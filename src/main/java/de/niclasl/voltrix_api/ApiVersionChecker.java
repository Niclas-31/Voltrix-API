package de.niclasl.voltrix_api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;

import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;

public final class ApiVersionChecker {

    private static final String VERSION_URL = "https://github.com/Niclas-31/Voltrix-API/api_versions.json";

    public static void check(Logger logger, ApiVersion currentVersion) {
        CompletableFuture.runAsync(() -> {
            try {
                URI uri = new  URI(VERSION_URL);
                URL url = uri.toURL();

                try (InputStreamReader reader = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)) {
                    JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();

                    JsonObject latest = root.getAsJsonObject("latest");

                    ApiVersion latestVersion = new ApiVersion(
                            latest.get("major").getAsInt(),
                            latest.get("minor").getAsInt()
                    );

                    if (currentVersion.isOlderThan(latestVersion)) {
                        logger.warn("==============================================");
                        logger.warn("A newer Voltrix API version is available!");
                        logger.warn("Current : {}", currentVersion);
                        logger.warn("Latest  : {}", latestVersion);
                        logger.warn("Download: https://github.com/Niclasloeffler/Voltrix/releases");
                        logger.warn("==============================================");
                    }
                }
            } catch (Exception ignored) {
            }
        });
    }
}