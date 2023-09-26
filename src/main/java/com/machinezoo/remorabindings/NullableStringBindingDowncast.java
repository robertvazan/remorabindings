// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

record NullableStringBindingDowncast(NullableBinding<String> upstream) implements NullableStringBinding {
    @Override public String get() { return upstream.get(); }
    @Override public void set(String value) { upstream.set(value); }
}
