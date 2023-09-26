// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import com.machinezoo.hookless.prefs.*;
import com.machinezoo.noexception.*;

record ReactivePreferencesStringBinding(ReactivePreferences preferences, String key, String def) implements StringBinding {
    ReactivePreferencesStringBinding {
        Objects.requireNonNull(preferences);
        Objects.requireNonNull(key);
        Objects.requireNonNull(def);
    }
    @Override public String get() { return Exceptions.silence().get(() -> preferences.get(key, def)).orElse(def); }
    @Override public void set(String value) { Exceptions.silence().run(() -> preferences.put(key, value)); }
}
