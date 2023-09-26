// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import com.machinezoo.noexception.*;

record ClearableIntInStringBinding(OptionalStringBinding upstream, OptionalInt def) implements OptionalIntBinding {
    ClearableIntInStringBinding {
        Objects.requireNonNull(upstream);
        Objects.requireNonNull(def);
    }
    @Override public OptionalInt get() {
        var value = upstream.get();
        if (value.isEmpty())
            return def;
        if (value.get().isEmpty())
            return OptionalInt.empty();
        return Exceptions.silence().getAsInt(() -> Integer.parseInt(value.get()));
    }
    @Override public void set(OptionalInt value) { upstream.set(Optional.of(value.isPresent() ? Integer.toString(value.getAsInt()) : "")); }
}
