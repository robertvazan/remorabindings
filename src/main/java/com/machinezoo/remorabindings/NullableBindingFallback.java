// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import java.util.function.*;
import com.machinezoo.noexception.*;

record NullableBindingFallback<T>(NullableBinding<T> upstream, Supplier<T> fallback) implements NullableBinding<T> {
    NullableBindingFallback {
        Objects.requireNonNull(upstream);
        Objects.requireNonNull(fallback);
    }
    @Override public T get() {
        var value = upstream.get();
        return value != null ? value : Exceptions.silence().get(fallback).orElse(null);
    }
    @Override public void set(T value) { upstream.set(value); }
}
