// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

record BooleanBindingDowncast(Binding<Boolean> upstream) implements BooleanBinding {
    @Override public boolean get() { return upstream.get(); }
    @Override public void set(boolean value) { upstream.set(value); }
}
