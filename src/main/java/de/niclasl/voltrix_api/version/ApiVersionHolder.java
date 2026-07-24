package de.niclasl.voltrix_api.version;

import java.util.Set;

public final class ApiVersionHolder {

    private final int major;
    private final Set<Integer> minorVersions;

    public ApiVersionHolder(int major, Set<Integer> versions) {
        this.major = major;
        this.minorVersions = versions;
    }

    public boolean exists(ApiVersion version) {

        if (version.major() != major) {
            return false;
        }

        return minorVersions.contains(version.minor());
    }
}