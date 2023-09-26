// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import java.util.function.*;

public interface OptionalIntBinding extends Supplier<OptionalInt> {
    @Override OptionalInt get();
    void set(OptionalInt value);
    default NullableIntBinding asNullable() { return new OptionalIntBindingAsNullable(this); }
    static OptionalIntBinding downcast(OptionalBinding<Integer> upstream) { return NullableIntBinding.downcast(upstream.asNullable()).asOptional(); }
    default OptionalBinding<Integer> upcast() { return asNullable().upcast().asOptional(); }
    default IntBinding orElse(int def) { return IntBinding.downcast(upcast().orElse(def)); }
    default OptionalIntBinding or(Supplier<OptionalInt> fallback) {
        return asNullable().or(() -> OptionalIntAsNullable.toNullable(fallback.get())).asOptional();
    }
}