<<<<<<< HEAD
package com.github.amongus.utility;

import java.util.regex.Pattern;

public final class Namespace {

	private final Pattern PATTERN = Pattern.compile("[A-Za-z0-9_]");
	
	private final String key;

	private Namespace(String key) {
		if (!PATTERN.matcher(key).matches()) {
			throw new IllegalArgumentException("Key must follow pattern: " + PATTERN.toString());
		}
		this.key = key;
	}

	@Override
	public int hashCode() {
		return key.hashCode() * 11;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		return ((Namespace) o).key.equals(key);
	}

	public boolean equalsString(String key) {
		if (key == null)
			return false;
		return key.equals(this.key);
	}

	@Override
	public String toString() {
		return "{Key:\"" + key + "\"}";
	}

	public static Namespace of(String key) {
		return new Namespace(key);
	}
}
=======
package com.github.amongus.utility;

import java.util.regex.Pattern;

public final class Namespace {

	private final Pattern PATTERN = Pattern.compile("[A-Za-z0-9_]");
	
	private final String key;

	private Namespace(String key) {
		if (!PATTERN.matcher(key).matches()) {
			throw new IllegalArgumentException("Key must follow pattern: " + PATTERN.toString());
		}
		this.key = key;
	}

	@Override
	public int hashCode() {
		return key.hashCode() * 11;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		return ((Namespace) o).key.equals(key);
	}

	public boolean equalsString(String key) {
		if (key == null)
			return false;
		return key.equals(this.key);
	}

	@Override
	public String toString() {
		return "{Key:\"" + key + "\"}";
	}

	public static Namespace of(String key) {
		return new Namespace(key);
	}
}
>>>>>>> 1034254cf00d02a3ef808f9e39b9ac3f6117983b
