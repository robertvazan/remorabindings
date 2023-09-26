// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import com.machinezoo.pmsite.*;
import com.machinezoo.stagean.*;

@ApiIssue("This should be a separate add-on library to avoid dependency on pmsite.")
public class SiteFragmentBindings {
    public static NullableStringBinding bindNullableString(String key) {
        return ReactivePreferencesBindings.bindNullableString(SiteFragment.get().preferences(), key);
    }
    public static OptionalStringBinding bindOptionalString(String key) {
        return ReactivePreferencesBindings.bindOptionalString(SiteFragment.get().preferences(), key);
    }
    public static StringBinding bindString(String key, String def) {
        return ReactivePreferencesBindings.bindString(SiteFragment.get().preferences(), key, def);
    }
    public static IntBinding bindInt(String key, int def) { return ReactivePreferencesBindings.bindInt(SiteFragment.get().preferences(), key, def); }
}
