// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

record OptionalIntBindingAsNullable(OptionalIntBinding upstream) implements NullableIntBinding {
    @Override public Integer get() { return OptionalIntAsNullable.toNullable(upstream.get()); }
    @Override public void set(Integer value) { upstream.set(OptionalIntAsNullable.toOptional(value)); }
}
