package edu.raijin.commons.util.exception;

import java.util.function.Supplier;

public final class Exceptions {

    public static <T> T requireNonNull(T obj, Supplier<RuntimeException> messageSupplier) {
        if (obj == null) {
            throw messageSupplier.get();
        } else {
            return obj;
        }
    }
}
