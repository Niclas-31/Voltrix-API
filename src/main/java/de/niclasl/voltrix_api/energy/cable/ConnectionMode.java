package de.niclasl.voltrix_api.energy.cable;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;
import org.jspecify.annotations.NonNull;

public enum ConnectionMode implements StringRepresentable {
    NONE("none"),
    INPUT("input"),
    OUTPUT("output"),
    BOTH("both");

    public static final Codec<ConnectionMode> CODEC = StringRepresentable.fromEnum(ConnectionMode::values);

    private final String name;

    ConnectionMode(String name) {
        this.name = name;
    }

    @Override
    public @NonNull String getSerializedName() {
        return name;
    }

    public boolean canConnect() {
        return this != NONE;
    }

    public boolean canInput() {
        return this == INPUT || this == BOTH;
    }

    public boolean canOutput() {
        return this == OUTPUT || this == BOTH;
    }
}