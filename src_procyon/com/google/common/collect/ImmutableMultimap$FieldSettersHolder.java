package com.google.common.collect;

import com.google.common.annotations.*;

@GwtIncompatible("java serialization is not supported")
class ImmutableMultimap$FieldSettersHolder
{
    static final Serialization$FieldSetter MAP_FIELD_SETTER;
    static final Serialization$FieldSetter SIZE_FIELD_SETTER;
    static final Serialization$FieldSetter EMPTY_SET_FIELD_SETTER;
    
    static {
        MAP_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "map");
        SIZE_FIELD_SETTER = Serialization.getFieldSetter(ImmutableMultimap.class, "size");
        EMPTY_SET_FIELD_SETTER = Serialization.getFieldSetter(ImmutableSetMultimap.class, "emptySet");
    }
}
