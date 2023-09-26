// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

record StringBindingDowncast(Binding<String> upstream) implements StringBinding {
    @Override public String get() { return upstream.get(); }
    @Override public void set(String value) { upstream.set(value); }
}
