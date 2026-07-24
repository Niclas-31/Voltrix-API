package de.niclasl.voltrix_api.version;

import java.util.List;

public record ApiMajorVersion(
        int major,
        ApiSupportStatus status,
        List<Integer> minors
) {}