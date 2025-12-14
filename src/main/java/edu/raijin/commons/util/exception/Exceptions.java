package edu.raijin.commons.util.exception;

import java.util.List;
import java.util.function.Supplier;

public final class Exceptions {

    public static <T> T requireNonNull(T obj, Supplier<RuntimeException> messageSupplier) {
        if (obj == null) {
            throw messageSupplier.get();
        } else {
            return obj;
        }
    }

    public static <T> List<T> requireNonEmpty(List<T> list, Supplier<RuntimeException> messageSupplier) {
        if (list == null || list.isEmpty()) {
            throw messageSupplier.get();
        } else {
            return list;
        }
    }

    public static String requireNonBlank(String str, Supplier<RuntimeException> messageSupplier) {
        if (str == null || str.isBlank()) {
            throw messageSupplier.get();
        } else {
            return str;
        }
    }

    public static <T extends Number> T requireNonNegative(T number, Supplier<RuntimeException> messageSupplier) {
        if (number == null || number.doubleValue() < 0) {
            throw messageSupplier.get();
        } else {
            return number;
        }
    }

    public static <T extends Number> T requirePositive(T number, Supplier<RuntimeException> messageSupplier) {
        if (number == null || number.doubleValue() <= 0) {
            throw messageSupplier.get();
        } else {
            return number;
        }
    }

    public static <T extends Number> T requireNonZero(T number, Supplier<RuntimeException> messageSupplier) {
        if (number == null || number.doubleValue() == 0) {
            throw messageSupplier.get();
        } else {
            return number;
        }
    }
}
