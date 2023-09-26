// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;

record NullableBindingAsOptional<T>(NullableBinding<T> upstream) implements OptionalBinding<T> {
    @Override public Optional<T> get() { return Optional.ofNullable(upstream.get()); }
    @Override public void set(Optional<T> value) { upstream.set(value.orElse(null)); }
}
