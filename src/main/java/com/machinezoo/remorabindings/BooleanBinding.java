// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.function.*;

public interface BooleanBinding extends BooleanSupplier {
    boolean get();
    void set(boolean value);
    @Override default boolean getAsBoolean() { return get(); }
    static BooleanBinding downcast(Binding<Boolean> upstream) { return new BooleanBindingDowncast(upstream); }
    default Binding<Boolean> upcast() { return new BooleanBindingUpcast(this); }
}
