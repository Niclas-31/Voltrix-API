package de.niclasl.voltrix_api;

import java.util.List;

public record ApiVersions(String latest, List<String> versions) {
}