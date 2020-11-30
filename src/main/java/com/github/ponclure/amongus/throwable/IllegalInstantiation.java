package com.github.ponclure.amongus.throwable;

public final class IllegalInstantiation extends Error {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

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

    public static void deploy(Class<?> clazz) {
        throw new IllegalInstantiation(clazz);
    }
}
