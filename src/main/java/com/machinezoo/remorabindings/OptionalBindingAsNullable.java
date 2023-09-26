// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;

record OptionalBindingAsNullable<T>(OptionalBinding<T> upstream) implements NullableBinding<T> {
    @Override public T get() { return upstream.get().orElse(null); }
    @Override public void set(T value) { upstream.set(Optional.ofNullable(value)); }
}
