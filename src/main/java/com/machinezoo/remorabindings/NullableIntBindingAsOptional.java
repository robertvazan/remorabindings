// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;

record NullableIntBindingAsOptional(NullableIntBinding upstream) implements OptionalIntBinding {
    @Override public OptionalInt get() { return OptionalIntAsNullable.toOptional(upstream.get()); }
    @Override public void set(OptionalInt value) { upstream.set(OptionalIntAsNullable.toNullable(value)); }
}
