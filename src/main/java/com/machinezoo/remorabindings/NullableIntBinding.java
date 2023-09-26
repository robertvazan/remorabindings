// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.function.*;

public interface NullableIntBinding extends Supplier<Integer> {
    @Override Integer get();
    void set(Integer value);
    default OptionalIntBinding asOptional() { return new NullableIntBindingAsOptional(this); }
    static NullableIntBinding downcast(NullableBinding<Integer> upstream) { return new NullableIntBindingDowncast(upstream); }
    default NullableBinding<Integer> upcast() { return new NullableIntBindingUpcast(this); }
    default IntBinding orElse(int def) { return IntBinding.downcast(upcast().orElse(def)); }
    default NullableIntBinding or(Supplier<Integer> fallback) { return downcast(upcast().or(fallback)); }
    default NullableBooleanBinding encodeBoolean() { return new NullableBooleanInIntBinding(this); }
}
