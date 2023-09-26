// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;
import com.machinezoo.hookless.prefs.*;
import com.machinezoo.noexception.*;

record ReactivePreferencesIntBinding(ReactivePreferences preferences, String key, int def) implements IntBinding {
    ReactivePreferencesIntBinding {
        Objects.requireNonNull(preferences);
        Objects.requireNonNull(key);
    }
    @Override public int get() { return Exceptions.silence().getAsInt(() -> preferences.getInt(key, def)).orElse(def); }
    @Override public void set(int value) { Exceptions.silence().run(() -> preferences.putInt(key, value)); }
}
