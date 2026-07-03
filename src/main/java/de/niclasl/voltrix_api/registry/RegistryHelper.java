package de.niclasl.voltrix_api.registry;

import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public final class RegistryHelper {

    public static <T> Supplier<T> register(
            DeferredRegister<T> register,
            String name,
            Supplier<T> supplier
    ) {
        return register.register(name, supplier);
    }
}