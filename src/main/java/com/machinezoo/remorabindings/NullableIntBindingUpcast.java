// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

record NullableIntBindingUpcast(NullableIntBinding upstream) implements NullableBinding<Integer> {
    @Override public Integer get() { return upstream.get(); }
    @Override public void set(Integer value) { upstream.set(value); }
}
