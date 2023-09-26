// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

record NullableBooleanBindingUpcast(NullableBooleanBinding upstream) implements NullableBinding<Boolean> {
    @Override public Boolean get() { return upstream.get(); }
    @Override public void set(Boolean value) { upstream.set(value); }
}
