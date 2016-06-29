package com.google.protobuf;

import java.util.*;

public class Internal$MapAdapter extends AbstractMap
{
    private final Map realMap;
    private final Internal$MapAdapter$Converter valueConverter;
    
    public static Internal$MapAdapter$Converter newEnumConverter(final Internal$EnumLiteMap internal$EnumLiteMap, final Internal$EnumLite internal$EnumLite) {
        return new Internal$MapAdapter$1(internal$EnumLiteMap, internal$EnumLite);
    }
    
    public Internal$MapAdapter(final Map realMap, final Internal$MapAdapter$Converter valueConverter) {
        this.realMap = realMap;
        this.valueConverter = valueConverter;
    }
    
    public Object get(final Object o) {
        final Object value = this.realMap.get(o);
        if (value == null) {
            return null;
        }
        return this.valueConverter.doForward(value);
    }
    
    public Object put(final Object o, final Object o2) {
        final Object put = this.realMap.put(o, this.valueConverter.doBackward(o2));
        if (put == null) {
            return null;
        }
        return this.valueConverter.doForward(put);
    }
    
    public Set entrySet() {
        return new Internal$MapAdapter$SetAdapter(this, this.realMap.entrySet());
    }
}
