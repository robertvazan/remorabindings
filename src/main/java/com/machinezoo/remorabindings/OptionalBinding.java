// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import java.util.function.*;

public interface OptionalBinding<T> extends Supplier<Optional<T>> {
    @Override Optional<T> get();
    void set(Optional<T> value);
    default NullableBinding<T> asNullable() { return new OptionalBindingAsNullable<>(this); }
    default Binding<T> orElse(T def) { return new OptionalBindingDefault<>(this, def); }
    default OptionalBinding<T> or(Supplier<Optional<T>> fallback) { return new OptionalBindingFallback<>(this, fallback); }
    static <K, V> OptionalBinding<V> bind(Map<K, V> map, K key) { return NullableBinding.bind(map, key).asOptional(); }
}
