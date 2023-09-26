// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import com.machinezoo.hookless.prefs.*;
import com.machinezoo.noexception.*;

record ReactivePreferencesNullableStringBinding(ReactivePreferences preferences, String key) implements NullableStringBinding {
    ReactivePreferencesNullableStringBinding {
        Objects.requireNonNull(preferences);
        Objects.requireNonNull(key);
    }
    @Override public String get() { return Exceptions.silence().get(() -> preferences.get(key, null)).orElse(null); }
    @Override public void set(String value) {
        Exceptions.silence().run(() -> {
            if (value != null)
                preferences.put(key, value);
            else
                preferences.remove(key);
        });
    }
}
