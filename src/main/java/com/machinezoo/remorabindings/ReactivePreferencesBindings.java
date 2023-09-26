// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import com.machinezoo.hookless.prefs.*;
import com.machinezoo.stagean.*;

@ApiIssue("This should be a separate add-on library to avoid dependency on hookless prefs.")
public class ReactivePreferencesBindings {
    public static NullableStringBinding bindNullableString(ReactivePreferences preferences, String key) {
        return new ReactivePreferencesNullableStringBinding(preferences, key);
    }
    public static OptionalStringBinding bindOptionalString(ReactivePreferences preferences, String key) {
        return bindNullableString(preferences, key).asOptional();
    }
    public static StringBinding bindString(ReactivePreferences preferences, String key, String def) {
        return new ReactivePreferencesStringBinding(preferences, key, def);
    }
    public static IntBinding bindInt(ReactivePreferences preferences, String key, int def) { return new ReactivePreferencesIntBinding(preferences, key, def); }
    public static BooleanBinding bindBoolean(ReactivePreferences preferences, String key, boolean def) {
        return new ReactivePreferencesBooleanBinding(preferences, key, def);
    }
}
