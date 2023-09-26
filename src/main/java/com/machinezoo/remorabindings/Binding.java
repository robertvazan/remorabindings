// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.function.*;

public interface Binding<T> extends Supplier<T> {
    @Override T get();
    void set(T value);
}
