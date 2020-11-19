package com.github.amongus.utility.container;

import com.github.amongus.utility.ByteSerializable;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Objects;

public final class AABB implements ByteSerializable {

	private static final long serialVersionUID = 3047715871441232182L;

	private final Vec3 origin;
	private final Vec3 oposite;

	public AABB(@NotNull final Vec3 origin, @NotNull final Vec3 oposite) {
		this.origin = Objects.requireNonNull(origin);
		this.oposite = Objects.requireNonNull(oposite);
	}

	public Vec3 getOrigin() {
		return this.origin;
	}

	public Vec3 getOposite() {
		return this.oposite;
	}

	public Vec3 min() {
		return this.origin.min(this.oposite);
	}

	public Vec3 max() {
		return this.origin.max(this.oposite);
	}

	@Override
	public String toString() {
		return "AABB{" + "origin=" + this.origin + ", oposite=" + this.oposite + '}';
	}

	public static AABB deserialize(final byte[] bytes) throws IOException, ClassNotFoundException {
		return ByteSerializable.deserialize(bytes, AABB.class);
	}
}
