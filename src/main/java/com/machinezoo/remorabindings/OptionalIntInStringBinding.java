// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import com.machinezoo.noexception.*;

record OptionalIntInStringBinding(OptionalStringBinding upstream) implements OptionalIntBinding {
    OptionalIntInStringBinding {
        Objects.requireNonNull(upstream);
    }
    @Override public OptionalInt get() {
        var value = upstream.get();
        if (value.isEmpty())
            return OptionalInt.empty();
        return Exceptions.silence().getAsInt(() -> Integer.parseInt(value.get()));
    }
    @Override public void set(OptionalInt value) { upstream.set(value.isPresent() ? Optional.of(Integer.toString(value.getAsInt())) : Optional.empty()); }
}
