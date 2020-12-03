package com.github.ponclure.blockus.utility.container;

import com.github.ponclure.blockus.utility.ByteSerializable;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;
import org.jetbrains.annotations.NotNull;

public final class Vec3 implements ByteSerializable {

    private static final long serialVersionUID = -1153669110572644603L;

    public static final Vec3 ZERO = new Vec3(0, 0, 0);
    public static final Vec3 UNIT_X = new Vec3(1, 0, 0);
    public static final Vec3 UNIT_Y = new Vec3(0, 1, 0);
    public static final Vec3 UNIT_Z = new Vec3(0, 0, 1);
    public static final Vec3 ONE = new Vec3(1, 1, 1);

    public static @NotNull Vec3 at(final double x, final double y, final double z) {
        if (y == 0 && x == 0 && z == 0) {
            return ZERO;
        }
        if (y == 1 && x == 1 && z == 1) {
            return ONE;
        }

        return new Vec3(x, y, z);
    }

    public static @NotNull Vec3 from(@NotNull final Vector that) {
        return Vec3.at(that.getX(), that.getY(), that.getZ());
    }

    public static @NotNull Vec3 from(@NotNull final Location location) {
        return Vec3.at(location.getX(), location.getY(), location.getZ());
    }

    private final double x;
    private final double y;
    private final double z;
    private final int bakedHashCode;

    private Vec3(final double x, final double y, final double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.bakedHashCode = hashCodeBakery();
    }

    public Location toLocation(@NotNull final World world) {
        return new Location(world, this.x, this.y, this.z);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public double getZ() {
        return this.z;
    }

    public int getBlockX() {
        return (int) Math.floor(this.x);
    }

    public int getBlockY() {
        return (int) Math.floor(this.y);
    }

    public int getBlockZ() {
        return (int) Math.floor(this.z);
    }

    public double length() {
        return Math.sqrt(lengthSquared());
    }

    public double lengthSquared() {
        return this.x * this.x + this.y * this.y + this.z * this.z;
    }

    public double distance(final Vec3 that) {
        return Math.sqrt(distanceSquared(that));
    }

    public double distanceSquared(final Vec3 that) {
        final double dx = that.x - this.x;
        final double dy = that.y - this.y;
        final double dz = that.z - this.z;
        return dx * dx + dy * dy + dz * dz;
    }

    public Vec3 add(final Vec3 that) {
        return add(that.x, that.y, that.z);
    }

    public Vec3 add(final double x, final double y, final double z) {
        return Vec3.at(this.x + x, this.y + y, this.z + z);
    }

    public Vec3 subtract(final Vec3 that) {
        return subtract(that.x, that.y, that.z);
    }

    public Vec3 subtract(final double x, final double y, final double z) {
        return Vec3.at(this.x - x, this.y - y, this.z - z);
    }

    public Vec3 multiply(final Vec3 that) {
        return multiply(that.x, that.y, that.z);
    }

    public Vec3 multiply(final double x, final double y, final double z) {
        return Vec3.at(this.x * x, this.y * y, this.z * z);
    }

    public Vec3 multiply(final double n) {
        return Vec3.at(this.x * n, this.y * n, this.z * n);
    }

    public Vec3 divide(final Vec3 that) {
        return divide(that.x, that.y, that.z);
    }

    public Vec3 divide(final double x, final double y, final double z) {
        return Vec3.at(this.x / x, this.y / y, this.z / z);
    }

    public Vec3 divide(final double n) {
        return Vec3.at(this.x / n, this.y / n, this.z / n);
    }

    public Vec3 normalize() {
        return divide(length());
    }

    public double dot(final Vec3 that) {
        return this.x * that.x + this.y * that.y + this.z * that.z;
    }

    public Vec3 cross(final Vec3 that) {
        return Vec3.at(this.y * that.z - this.z * that.y, this.z * that.x - this.x * that.z,
                this.x * that.y - this.y * that.x);
    }

    public Vec3 abs() {
        return Vec3.at(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    public Vec3 min(final Vec3 that) {
        return Vec3.at(Math.min(this.x, that.x), Math.min(this.y, that.y), Math.min(this.z, that.z));
    }

    public Vec3 max(final Vec3 that) {
        return Vec3.at(Math.max(this.x, that.x), Math.max(this.y, that.y), Math.max(this.z, that.z));
    }

    public boolean isInAABB(final AABB aabb) {
        return this.x >= aabb.getOffset().x && this.x <= aabb.getOposite().x && this.y >= aabb.getOffset().y &&
                this.y <= aabb.getOposite().y && this.z >= aabb.getOffset().z && this.z <= aabb.getOposite().z;
    }

    @Override
    public String toString() {
        return "Vec3{" + "x=" + this.x + ", y=" + this.y + ", z=" + this.z + '}';
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vec3)) {
            return false;
        }

        final Vec3 that = (Vec3) other;
        return this.bakedHashCode == that.bakedHashCode;
    }

    @Override
    public int hashCode() {
        return this.bakedHashCode;
    }

    private int hashCodeBakery() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(this.x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public static Vec3 deserialize(final byte[] bytes) throws Exception {
        return ByteSerializable.deserialize(bytes, Vec3.class);
    }
}
