package de.niclasl.voltrix_api.version;

import org.jetbrains.annotations.NotNull;

public record ApiVersion(int major, int minor) {

    public boolean isOlderThan(ApiVersion other) {
        if (major != other.major()) {
            return major < other.major();
        }

        return minor < other.minor();
    }

    @Override
    public @NotNull String toString() {
        return major + "." + minor;
    }
}