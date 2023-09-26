// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import java.util.function.*;

public interface OptionalStringBinding extends OptionalBinding<String> {
    @Override default NullableStringBinding asNullable() { return NullableStringBinding.downcast(OptionalBinding.super.asNullable()); }
    static OptionalStringBinding downcast(OptionalBinding<String> upstream) { return new OptionalStringBindingDowncast(upstream); }
    @Override default StringBinding orElse(String def) { return StringBinding.downcast(OptionalBinding.super.orElse(def)); }
    @Override default OptionalStringBinding or(Supplier<Optional<String>> supplier) { return downcast(OptionalBinding.super.or(supplier)); }
    static <K> OptionalStringBinding bind(Map<K, String> map, K key) { return downcast(OptionalBinding.bind(map, key)); }
    default OptionalIntBinding encodeInt() { return new OptionalIntInStringBinding(this); }
    default OptionalIntBinding encodeClearableInt(OptionalInt def) { return new ClearableIntInStringBinding(this, def); }
    default <T extends Enum<T>> OptionalBinding<T> encodeEnum(Class<T> type) { return new OptionalEnumInStringBinding<>(this, type); }
    default <T extends Enum<T>> OptionalBinding<T> encodeClearableEnum(Class<T> type, T def) { return new ClearableEnumInStringBinding<>(this, type, def); }
}
