package com.github.amongus.utility.container;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Objects;

public class Triplet<T, U, V> {

	@Contract("_, _, _ -> new")
	public static <T, U, V> @NotNull Triplet<T, U, V> of(@Nullable final T first, @Nullable final U second,
	                                                     @Nullable final V third) {
		return new Triplet<>(first, second, third);
	}

	@Contract("_, _, _ -> new")
	public static <T, U, V> @NotNull ImmutableTriplet<T, U, V> immutableOf(@Nullable final T first,
	                                                                       @Nullable final U second,
	                                                                       @Nullable final V third) {
		return new ImmutableTriplet<>(first, second, third);
	}

	private T first;
	private U second;
	private V third;
	private int hashCache;
	private boolean recalculateHash = true;

	protected Triplet(final T first, final U second, final V third) {
		this.first = first;
		this.second = second;
		this.third = third;
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

	public @Nullable V getThird() {
		return this.third;
	}

	public void setThird(@Nullable final V third) {
		this.recalculateHash = true;
		this.third = third;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Triplet)) {
			return false;
		}

		final Triplet<?, ?, ?> that = (Triplet<?, ?, ?>) other;

		return Objects.equals(this.first, that.first) && Objects.equals(this.second, that.second) &&
		       Objects.equals(this.third, that.third);
	}

	@Override
	public int hashCode() {
		if (this.recalculateHash) {
			int result = this.first != null ? this.first.hashCode() : 0;
			result = 31 * result + (this.second != null ? this.second.hashCode() : 0);
			this.hashCache = 31 * result + (this.third != null ? this.third.hashCode() : 0);
			this.recalculateHash = false;
		}

		return this.hashCache;
	}

	@Unmodifiable
	public static final class ImmutableTriplet<T, U, V> extends Triplet<T, U, V> {

		private ImmutableTriplet(final T first, final U second, final V third) {
			super(first, second, third);
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

		@Contract("_ -> fail")
		@Override
		public void setThird(@Nullable final V third) throws UnsupportedOperationException {
			throw new UnsupportedOperationException();
		}
	}
}
