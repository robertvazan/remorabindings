// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import com.machinezoo.noexception.*;

record ClearableEnumInStringBinding<T extends Enum<T>>(OptionalStringBinding upstream, Class<T> type, T def) implements OptionalBinding<T> {
    ClearableEnumInStringBinding {
        Objects.requireNonNull(upstream);
        Objects.requireNonNull(type);
    }
    @Override public Optional<T> get() {
        var value = upstream.get();
        if (value.isEmpty())
            return Optional.ofNullable(def);
        if (value.get().isEmpty())
            return Optional.empty();
        return Exceptions.silence().get(() -> Enum.valueOf(type, value.get()));
    }
    @Override public void set(Optional<T> value) { upstream.set(Optional.of(value.isPresent() ? value.get().name() : "")); }
}
