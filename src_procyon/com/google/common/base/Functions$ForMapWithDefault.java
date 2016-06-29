package com.google.common.base;

import java.io.*;
import java.util.*;
import javax.annotation.*;

class Functions$ForMapWithDefault implements Function, Serializable
{
    final Map map;
    final Object defaultValue;
    private static final long serialVersionUID = 0L;
    
    Functions$ForMapWithDefault(final Map map, @Nullable final Object defaultValue) {
        this.map = (Map)Preconditions.checkNotNull(map);
        this.defaultValue = defaultValue;
    }
    
    @Override
    public Object apply(@Nullable final Object o) {
        final Object value = this.map.get(o);
        return (value != null || this.map.containsKey(o)) ? value : this.defaultValue;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Functions$ForMapWithDefault) {
            final Functions$ForMapWithDefault functions$ForMapWithDefault = (Functions$ForMapWithDefault)o;
            return this.map.equals(functions$ForMapWithDefault.map) && Objects.equal(this.defaultValue, functions$ForMapWithDefault.defaultValue);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.map, this.defaultValue);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.map);
        final String value2 = String.valueOf(this.defaultValue);
        return new StringBuilder(33 + String.valueOf(value).length() + String.valueOf(value2).length()).append("Functions.forMap(").append(value).append(", defaultValue=").append(value2).append(")").toString();
    }
}
