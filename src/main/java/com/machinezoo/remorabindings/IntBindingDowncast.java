// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

record IntBindingDowncast(Binding<Integer> upstream) implements IntBinding {
    @Override public int get() { return upstream.get(); }
    @Override public void set(int value) { upstream.set(value); }
}
