// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import com.machinezoo.noexception.*;

record OptionalEnumInStringBinding<T extends Enum<T>>(OptionalStringBinding upstream, Class<T> type) implements OptionalBinding<T> {
    OptionalEnumInStringBinding {
        Objects.requireNonNull(upstream);
        Objects.requireNonNull(type);
    }
    @Override public Optional<T> get() {
        var value = upstream.get();
        if (value.isEmpty())
            return Optional.empty();
        return Exceptions.silence().get(() -> Enum.valueOf(type, value.get()));
    }
    @Override public void set(Optional<T> value) { upstream.set(value.isPresent() ? Optional.of(value.get().name()) : Optional.empty()); }
}
