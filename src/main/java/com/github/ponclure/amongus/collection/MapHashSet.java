package com.github.ponclure.amongus.collection;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class MapHashSet<T> implements IdentitySet<T> {

    private final Map<T, T> map;

    public MapHashSet() {
        map = new HashMap<>();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return map.keySet().toArray();
    }

    @NotNull
    @Override
    public <T1> T1[] toArray(@NotNull T1[] a) {
        return map.keySet().toArray(a);
    }

    @Override
    public boolean add(T t) {
        map.put(t, t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        map.remove(o);
        return true;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return map.keySet().containsAll(c);
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends T> c) {
        return map.keySet().addAll(c);
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return map.keySet().retainAll(c);
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return map.keySet().removeAll(c);
    }

    @Override
    public void clear() {
        map.clear();
    }


    @Override
    public T get(T o) {
        return map.get(o);
    }

}
