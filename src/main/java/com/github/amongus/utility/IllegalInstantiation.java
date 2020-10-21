package com.github.amongus.utility;

public final class IllegalInstantiation extends Throwable {

    private IllegalInstantiation(Class<?> clazz) {
        super("Class " + clazz + " should not be instantiated.");
    }

    @Override
    public synchronized Throwable getCause() {
        return this;
    }

    @Override
    public synchronized Throwable initCause(Throwable cause) {
        return this;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    public static void deploy(Class<?> clazz) throws IllegalInstantiation {
        throw new IllegalInstantiation(clazz);
    }
}
