package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Serialization;
import com.google.common.collect.Serialization$FieldSetter;

@GwtIncompatible("java serialization is not supported")
class ImmutableMultimap$FieldSettersHolder {
   static final Serialization$FieldSetter MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
   static final Serialization$FieldSetter SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "size");
   static final Serialization$FieldSetter EMPTY_SET_FIELD_SETTER = Serialization.getFieldSetter(ImmutableSetMultimap.class, "emptySet");
}
