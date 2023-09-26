// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

record IntBindingUpcast(IntBinding upstream) implements Binding<Integer> {
    @Override public Integer get() { return upstream.get(); }
    @Override public void set(Integer value) { upstream.set(value); }
}
