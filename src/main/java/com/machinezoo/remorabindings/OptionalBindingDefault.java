// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;

record OptionalBindingDefault<T>(OptionalBinding<T> upstream, T def) implements Binding<T> {
    OptionalBindingDefault {
        Objects.requireNonNull(upstream);
        Objects.requireNonNull(def);
    }
    @Override public T get() { return upstream.get().orElse(def); }
    @Override public void set(T value) { upstream.set(Optional.of(value)); }
}
