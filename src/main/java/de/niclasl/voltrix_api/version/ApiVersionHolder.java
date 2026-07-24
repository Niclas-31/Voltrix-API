package de.niclasl.voltrix_api.version;

import java.util.Set;

public final class ApiVersionHolder {

    private final int major;
    private final ApiSupportStatus status;
    private final Set<Integer> minors;

    public ApiVersionHolder(int major, ApiSupportStatus status, Set<Integer> minors) {
        this.major = major;
        this.status = status;
        this.minors = minors;
    }

    public int major() {
        return major;
    }

    public ApiSupportStatus status() {
        return status;
    }

    public boolean exists(ApiVersion version) {
        return version.major() == major
                && minors.contains(version.minor());
    }
}