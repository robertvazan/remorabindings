// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.function.*;

public interface NullableBooleanBinding extends Supplier<Boolean> {
    @Override Boolean get();
    void set(Boolean value);
    static NullableBooleanBinding downcast(NullableBinding<Boolean> upstream) { return new NullableBooleanBindingDowncast(upstream); }
    default NullableBinding<Boolean> upcast() { return new NullableBooleanBindingUpcast(this); }
    default BooleanBinding orElse(boolean def) { return BooleanBinding.downcast(upcast().orElse(def)); }
    default NullableBooleanBinding or(Supplier<Boolean> fallback) { return downcast(upcast().or(fallback)); }
}
