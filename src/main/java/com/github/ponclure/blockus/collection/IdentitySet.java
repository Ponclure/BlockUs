package com.github.ponclure.blockus.collection;

import java.util.Set;

public interface IdentitySet<T> extends Set<T> {

    T get(T o);

}
