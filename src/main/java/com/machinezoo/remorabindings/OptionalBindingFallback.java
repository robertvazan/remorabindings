// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import java.util.function.*;
import com.machinezoo.noexception.*;

record OptionalBindingFallback<T>(OptionalBinding<T> upstream, Supplier<Optional<T>> fallback) implements OptionalBinding<T> {
    OptionalBindingFallback {
        Objects.requireNonNull(upstream);
        Objects.requireNonNull(fallback);
    }
    @Override public Optional<T> get() { return upstream.get().or(Exceptions.silence().supplier(fallback).orElse(Optional.empty())); }
    @Override public void set(Optional<T> value) { upstream.set(value); }
}
