package com.github.ponclure.amongus.utility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public interface ByteSerializable extends Serializable {

	default byte[] serialize() throws IOException {
		try (final ByteArrayOutputStream out = new ByteArrayOutputStream();
		     final ObjectOutputStream stream = new ObjectOutputStream(out)) {
			stream.writeObject(this);
			stream.flush();
			return out.toByteArray();
		}
	}

	static <T extends ByteSerializable> T deserialize(final byte[] bytes, final Class<T> type)
	throws IOException, ClassNotFoundException {
		try (final ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		     final ObjectInputStream stream = new ObjectInputStream(in)) {
			return type.cast(stream.readObject());
		}
	}
}
