package com.github.amongus.utility.container;

import com.github.amongus.utility.ByteSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class AABB implements ByteSerializable, Iterable<Vec3> {

	private static final long serialVersionUID = 3047715871441232182L;

	private final Vec3 offset;
	private final Vec3 oposite;

	public AABB(@NotNull final Vec3 offset, @NotNull final Vec3 oposite) {
		this.offset = Objects.requireNonNull(offset);
		this.oposite = Objects.requireNonNull(oposite);
	}

	public Vec3 getOffset() {
		return this.offset;
	}

	public Vec3 getOposite() {
		return this.oposite;
	}

	public Vec3 min() {
		return this.offset.min(this.oposite);
	}

	public Vec3 max() {
		return this.offset.max(this.oposite);
	}

	@NotNull
	@Override
	public Iterator<Vec3> iterator() {
		return new Iterator<Vec3>() {

			private final Vec3 min = min();
			private final Vec3 max = max();
			private final int startX = this.min.getBlockX();
			private final int startY = this.min.getBlockY();
			private final int startZ = this.min.getBlockZ();
			private final int endX = this.max.getBlockX();
			private final int endY = this.max.getBlockY();
			private final int endZ = this.max.getBlockZ();
			private int nextX = this.startX;
			private int nextY = this.startY;
			private int nextZ = this.startZ;

			@Override
			public boolean hasNext() {
				return this.nextX != Integer.MIN_VALUE;
			}

			@Override
			public Vec3 next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}

				final Vec3 result = Vec3.at(this.nextX, this.nextY, this.nextZ);
				if (++this.nextX > this.endX) {
					this.nextX = this.startX;
					if (++this.nextY > this.endY) {
						this.nextY = this.startY;
						if (++this.nextZ > this.endZ) {
							this.nextX = Integer.MIN_VALUE;
						}
					}
				}

				return result;
			}
		};
	}

	@Override
	public String toString() {
		return "AABB{" + "origin=" + this.offset + ", oposite=" + this.oposite + '}';
	}

	public static AABB deserialize(final byte[] bytes) throws Exception {
		return ByteSerializable.deserialize(bytes, AABB.class);
	}
}
