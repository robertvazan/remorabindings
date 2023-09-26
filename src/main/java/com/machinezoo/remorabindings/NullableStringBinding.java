// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import java.util.function.*;

public interface NullableStringBinding extends NullableBinding<String> {
    @Override default OptionalStringBinding asOptional() { return OptionalStringBinding.downcast(NullableBinding.super.asOptional()); }
    static NullableStringBinding downcast(NullableBinding<String> upstream) { return new NullableStringBindingDowncast(upstream); }
    @Override default StringBinding orElse(String def) { return StringBinding.downcast(NullableBinding.super.orElse(def)); }
    @Override default NullableStringBinding or(Supplier<String> supplier) { return downcast(NullableBinding.super.or(supplier)); }
    static <K> NullableStringBinding bind(Map<K, String> map, K key) { return downcast(NullableBinding.bind(map, key)); }
    default NullableIntBinding encodeInt() { return asOptional().encodeInt().asNullable(); }
    default NullableIntBinding encodeClearableInt(OptionalInt def) { return asOptional().encodeClearableInt(def).asNullable(); }
    default <T extends Enum<T>> NullableBinding<T> encodeEnum(Class<T> type) { return asOptional().encodeEnum(type).asNullable(); }
    default <T extends Enum<T>> NullableBinding<T> encodeClearableEnum(Class<T> type, T def) {
        return asOptional().encodeClearableEnum(type, def).asNullable();
    }
}
