// Part of Remora Bindings: https://remorabindings.machinezoo.com
/*
 * Hookless allows friction-free definition of one-way bindings, which are merely suppliers.
 * Two-way bindings however require more effort, because there's no way to transparently derive setters from getters.
 * Widgets have to expose binding parameters and that requires standard API for bindings.
 * Widgets should however provide reasonable default binding, usually binding to ReactivePreferences obtained from SiteFragment.
 *
 * We have to choose how to handle read/write errors. For convenience, these methods do not throw.
 * Getters just return empty/null/default value and setters silently ignore failed writes. This matches behavior of Preferences.
 * Bindings are usually non-essential and weakly typed. Throwing or even logging upon read/write error is undesirable.
 * We might want to allow customization of exception handling in the future.
 *
 * Three kinds of bindings are available:
 * - Optional bindings communicate absent value (distinct from default value) as empty Optional.
 * - Nullable bindings communicate absent value as null.
 * - Non-null bindings never return null and they throw if null is passed to set().
 *
 * We are also exposing several common binding specializations:
 * - string
 * - primitive types
 * - enum
 *
 * Primitive specializations do not inherit from base binding interfaces, because their method signatures differ.
 *
 * For every binding, we offer a number of standard methods (where applicable):
 * - get/set
 * - asOptional/asNullable (conversion-free)
 * - downcast/upcast from/to base binding interfaces (conversion-free)
 * - encodeX to create specializations requiring conversion
 * - orElse for optional/nullable bindings, which expects non-null parameter since orElse(null) functionality is provided by asNullable
 * - or() for optional/nullable bindings (orElseGet is merely or() on a nullable binding)
 * - bind to create source bindings for standard JRE classes (currently just map)
 *
 * Source bindings are provided by bind() methods on XBindings classes like ReactivePreferencesBindings or SiteFragmentBindings.
 *
 * Widgets sometimes need to differentiate between unset and cleared value.
 * This is useful when the widget needs to start with non-null default, which can be explicitly cleared by the user.
 * Such widgets cannot be implemented with just one null/empty value.
 * Furthermore, underlying stores usually do not differentiate between unset and cleared values.
 * Cleared value therefore has to be encoded into underlying stored type by this library.
 * Bindings with encodeX methods can therefore offer corresponding encodeClearableX methods that
 * accept default value to be used when the stored value is unset and that propagate cleared state as null/optional.
 *
 * We are using record classes for implementations as much as possible to make binding's toString() as readable as possible.
 * We however cheat a little by using multiple adaptor layers where it is simpler than defining new adaptor:
 * - mirroring functionality between nullable and optional variants via asOptional/asNullable
 * - providing strongly typed versions of methods on specialized bindings via upcast/downcast roundtrip
 */
/**
 * Bindings for use in widgets.
 */
@NoTests
@StubDocs
@DraftApi
package com.machinezoo.remorabindings;

import com.machinezoo.stagean.*;
