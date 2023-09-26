// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

record NullableIntBindingDowncast(NullableBinding<Integer> upstream) implements NullableIntBinding {
    @Override public Integer get() { return upstream.get(); }
    @Override public void set(Integer value) { upstream.set(value); }
}
