// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

public interface StringBinding extends Binding<String> {
    static StringBinding downcast(Binding<String> upstream) { return new StringBindingDowncast(upstream); }
}
