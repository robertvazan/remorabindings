// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;

record OptionalStringBindingDowncast(OptionalBinding<String> upstream) implements OptionalStringBinding {
    @Override public Optional<String> get() { return upstream.get(); }
    @Override public void set(Optional<String> value) { upstream.set(value); }
}
