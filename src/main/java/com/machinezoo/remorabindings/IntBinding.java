// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.function.*;

public interface IntBinding extends IntSupplier {
    int get();
    void set(int value);
    @Override default int getAsInt() { return get(); }
    static IntBinding downcast(Binding<Integer> upstream) { return new IntBindingDowncast(upstream); }
    default Binding<Integer> upcast() { return new IntBindingUpcast(this); }
}
