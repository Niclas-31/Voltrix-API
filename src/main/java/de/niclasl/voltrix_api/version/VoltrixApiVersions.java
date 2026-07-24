package de.niclasl.voltrix_api.version;

import com.google.gson.Gson;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

        if (file.getVersions() == null) {
            throw new RuntimeException("ApiVersionsFile versions is null");
        }

        HOLDERS.clear();

        latest = file.getLatest();

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (ApiVersion version : file.getVersions()) {

            map.computeIfAbsent(
                    version.major(),
                    _ -> new HashSet<>()
            ).add(version.minor());
        }

        map.forEach((major, minors) ->
                HOLDERS.put(
                        major,
                        new ApiVersionHolder(major, minors)
                )
        );
    }

    public static void reloadFromResources() {
        try (InputStream stream = VoltrixApiVersions.class.getResourceAsStream("/api_versions.json")) {
            if (stream == null) {
                throw new RuntimeException("Missing api_versions.json");
            }

            Gson gson = new Gson();

            ApiVersionsFile file = gson.fromJson(new InputStreamReader(stream), ApiVersionsFile.class);

            if (file.getVersions() == null) {
                throw new RuntimeException("api_versions.json contains no versions");
            }

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