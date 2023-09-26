// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;

record NullableBooleanInIntBinding(NullableIntBinding upstream) implements NullableBooleanBinding {
    NullableBooleanInIntBinding {
        Objects.requireNonNull(upstream);
    }
    @Override public Boolean get() {
        var value = upstream.get();
        if (value == null)
            return null;
        return value != 0;
    }
    @Override public void set(Boolean value) { upstream.set(value != null ? (value ? 1 : 0) : null); }
}
