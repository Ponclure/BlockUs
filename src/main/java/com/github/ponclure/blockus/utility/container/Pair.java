package com.github.ponclure.blockus.utility.container;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Objects;

public class Pair<T, U> {

    @Contract("_, _ -> new")
    public static <T, U> @NotNull Pair<T, U> of(@Nullable final T first, @Nullable final U second) {
        return new Pair<>(first, second);
    }

    @Contract("_, _ -> new")
    public static <T, U> @NotNull ImmutablePair<T, U> immutableOf(@Nullable final T first, @Nullable final U second) {
        return new ImmutablePair<>(first, second);
    }

    private T first;
    private U second;
    private int hashCache;
    private boolean recalculateHash = true;

    protected Pair(final T first, final U second) {
        this.first = first;
        this.second = second;
        hashCode();
    }

    public @Nullable T getFirst() {
        return this.first;
    }

    public void setFirst(@Nullable final T first) {
        this.recalculateHash = true;
        this.first = first;
    }

    public @Nullable U getSecond() {
        return this.second;
    }

    public void setSecond(@Nullable final U second) {
        this.recalculateHash = true;
        this.second = second;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Pair)) {
            return false;
        }

        final Pair<?, ?> that = (Pair<?, ?>) other;

        return Objects.equals(this.first, that.first) && Objects.equals(this.second, that.second);
    }

    @Override
    public int hashCode() {
        if (this.recalculateHash) {
            final int result = this.first != null ? this.first.hashCode() : 0;
            this.hashCache = 31 * result + (this.second != null ? this.second.hashCode() : 0);
            this.recalculateHash = false;
        }

        return this.hashCache;
    }

    @Unmodifiable
    public static final class ImmutablePair<T, U> extends Pair<T, U> {

        private ImmutablePair(final T first, final U second) {
            super(first, second);
        }

        @Contract("_ -> fail")
        @Override
        public void setFirst(@Nullable final T first) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }

        @Contract("_ -> fail")
        @Override
        public void setSecond(@Nullable final U second) throws UnsupportedOperationException {
            throw new UnsupportedOperationException();
        }
    }
}
