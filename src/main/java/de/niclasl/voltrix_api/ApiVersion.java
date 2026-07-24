package de.niclasl.voltrix_api;

import org.jetbrains.annotations.NotNull;

public record ApiVersion(int major, int minor) {

    public boolean isCompatible(ApiVersion required) {
        return major == required.major && minor == required.minor;
    }

    public boolean isOlderThan(ApiVersion other) {
        if (major != other.major()) {
            return major < other.major();
        }

        return minor < other.minor();
    }

    public static ApiVersion parse(String version) {

        String[] split = version.split("\\.");

        return new ApiVersion(
                Integer.parseInt(split[0]),
                Integer.parseInt(split[1])
        );
    }

    @Override
    public @NotNull String toString() {
        return major + "." + minor;
    }
}