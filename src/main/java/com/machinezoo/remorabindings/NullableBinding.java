// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import java.util.function.*;

public interface NullableBinding<T> extends Supplier<T> {
    @Override T get();
    void set(T value);
    default OptionalBinding<T> asOptional() { return new NullableBindingAsOptional<>(this); }
    default Binding<T> orElse(T def) { return asOptional().orElse(def); }
    default NullableBinding<T> or(Supplier<T> fallback) { return new NullableBindingFallback<>(this, fallback); }
    static <K, V> NullableBinding<V> bind(Map<K, V> map, K key) { return new MapKeyBinding<K, V>(map, key); }
}
