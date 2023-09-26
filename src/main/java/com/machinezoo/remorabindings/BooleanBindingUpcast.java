// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

record BooleanBindingUpcast(BooleanBinding upstream) implements Binding<Boolean> {
    @Override public Boolean get() { return upstream.get(); }
    @Override public void set(Boolean value) { upstream.set(value); }
}
