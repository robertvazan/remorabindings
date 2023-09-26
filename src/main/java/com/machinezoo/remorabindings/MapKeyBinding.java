// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import com.machinezoo.noexception.*;

/*
 * Assumes the map is mutable. Key must be non-null.
 * Map does not have to support null keys or values.
 * If it does, null values are treated the same as absent values.
 */
record MapKeyBinding<K, V>(Map<K, V> map, K key) implements NullableBinding<V> {
    MapKeyBinding {
        Objects.requireNonNull(map);
        Objects.requireNonNull(key);
    }
    @Override public V get() { return Exceptions.silence().get(() -> map.get(key)).orElse(null); }
    @Override public void set(V value) {
        Exceptions.silence().run(() -> {
            if (value != null)
                map.put(key, value);
            else
                map.remove(key);
        });
    }
}
