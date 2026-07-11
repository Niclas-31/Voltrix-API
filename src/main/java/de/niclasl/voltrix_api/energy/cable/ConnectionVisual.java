package de.niclasl.voltrix_api.energy.cable;

import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum ConnectionVisual implements StringRepresentable {
    NONE("none"),
    CABLE("cable"),
    MACHINE("machine");

    private final String name;

    ConnectionVisual(String name) {
        this.name = name;
    }

    @Override
    public @NonNull String getSerializedName() {
        return name;
    }
}