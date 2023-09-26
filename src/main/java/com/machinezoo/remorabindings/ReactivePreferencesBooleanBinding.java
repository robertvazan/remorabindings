// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import com.machinezoo.hookless.prefs.*;
import com.machinezoo.noexception.*;

record ReactivePreferencesBooleanBinding(ReactivePreferences preferences, String key, boolean def) implements BooleanBinding {
    ReactivePreferencesBooleanBinding {
        Objects.requireNonNull(preferences);
        Objects.requireNonNull(key);
    }
    @Override public boolean get() { return Exceptions.silence().getAsBoolean(() -> preferences.getBoolean(key, def)).orElse(def); }
    @Override public void set(boolean value) { Exceptions.silence().run(() -> preferences.putBoolean(key, value)); }
}
