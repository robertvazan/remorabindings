// Part of Remora Bindings: https://remorabindings.machinezoo.com
package com.machinezoo.remorabindings;

import java.util.*;

class OptionalIntAsNullable {
    static Integer toNullable(OptionalInt optional) { return optional.isPresent() ? optional.getAsInt() : null; }
    static OptionalInt toOptional(Integer nullable) { return nullable != null ? OptionalInt.of(nullable) : OptionalInt.empty(); }
}
