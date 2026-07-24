package de.niclasl.voltrix_api.version;

import com.google.gson.Gson;
import de.niclasl.voltrix_api.VoltrixAPI;
import org.slf4j.Logger;

import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.CompletableFuture;

public final class ApiVersionChecker {

    private static final String VERSION_URL = "https://github.com/Niclas-31/Voltrix-API/blob/main/api_versions.json";

    public static void check(Logger logger) {
        CompletableFuture.runAsync(() -> {
            try {
                URI uri = new URI(VERSION_URL);
                URL url = uri.toURL();

                Gson gson = new Gson();

                ApiVersionsFile file;

                try (InputStreamReader reader =
                             new InputStreamReader(url.openStream())) {

                    file = gson.fromJson(reader, ApiVersionsFile.class);
                }

                ApiVersion online = file.getLatest();

                if (VoltrixAPI.API_VERSION.isOlderThan(online)) {

                    logger.warn(
                            "A new Voltrix API version is available: {} -> {}",
                            VoltrixAPI.API_VERSION,
                            online
                    );
                }

            } catch (Exception ignored) {
            }

        });
    }
}