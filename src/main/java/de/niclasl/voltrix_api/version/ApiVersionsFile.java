package de.niclasl.voltrix_api.version;

import java.util.List;

public class ApiVersionsFile {

    private ApiVersion latest;
    private List<ApiVersion> versions;

    public ApiVersion getLatest() {
        return latest;
    }

    public List<ApiVersion> getVersions() {
        return versions;
    }
}