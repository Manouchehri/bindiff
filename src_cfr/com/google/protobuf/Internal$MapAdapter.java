/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$MapAdapter$1;
import com.google.protobuf.Internal$MapAdapter$Converter;
import com.google.protobuf.Internal$MapAdapter$SetAdapter;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;

public class Internal$MapAdapter
extends AbstractMap {
    private final Map realMap;
    private final Internal$MapAdapter$Converter valueConverter;

    public static Internal$MapAdapter$Converter newEnumConverter(Internal$EnumLiteMap internal$EnumLiteMap, Internal$EnumLite internal$EnumLite) {
        return new Internal$MapAdapter$1(internal$EnumLiteMap, internal$EnumLite);
    }

    public Internal$MapAdapter(Map map, Internal$MapAdapter$Converter internal$MapAdapter$Converter) {
        this.realMap = map;
        this.valueConverter = internal$MapAdapter$Converter;
    }

    @Override
    public Object get(Object object) {
        Object v2 = this.realMap.get(object);
        if (v2 != null) return this.valueConverter.doForward(v2);
        return null;
    }

    @Override
    public Object put(Object object, Object object2) {
        Object object3 = this.realMap.put(object, this.valueConverter.doBackward(object2));
        if (object3 != null) return this.valueConverter.doForward(object3);
        return null;
    }

    @Override
    public Set entrySet() {
        return new Internal$MapAdapter$SetAdapter(this, this.realMap.entrySet());
    }

    static /* synthetic */ Internal$MapAdapter$Converter access$000(Internal$MapAdapter internal$MapAdapter) {
        return internal$MapAdapter.valueConverter;
    }
}

