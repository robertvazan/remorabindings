// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

record NullableBooleanBindingDowncast(NullableBinding<Boolean> upstream) implements NullableBooleanBinding {
    @Override public Boolean get() { return upstream.get(); }
    @Override public void set(Boolean value) { upstream.set(value); }
}
