package de.niclasl.voltrix_api.version;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class VoltrixApiVersions {
    private static final Map<Integer, ApiVersionHolder> HOLDERS = new HashMap<>();

    private static ApiVersion latest;

    static {
        try {
            reloadFromResources();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void reload(ApiVersionsFile file) {
        if (file == null) {
            throw new RuntimeException("ApiVersionsFile is null");
        }

        HOLDERS.clear();

        latest = file.getLatest();

        for (ApiMajorVersion major : file.getMajors()) {

            HOLDERS.put(
                    major.major(),
                    new ApiVersionHolder(
                            major.major(),
                            major.status(),
                            new HashSet<>(major.minors())
                    )
            );
        }
    }

    public static void reloadFromResources() {
        try (InputStream stream = VoltrixApiVersions.class.getResourceAsStream("/api_versions.json")) {
            if (stream == null) {
                throw new RuntimeException("Missing api_versions.json");
            }

            Gson gson = new Gson();

            ApiVersionsFile file = gson.fromJson(new InputStreamReader(stream), ApiVersionsFile.class);

            reload(file);
        } catch (Exception e) {
            throw new RuntimeException("Failed loading API versions", e);
        }
    }

    public static ApiVersion latest() {
        return latest;
    }

    public static ApiVersionHolder getHolder(int major) {
        return HOLDERS.get(major);
    }
}