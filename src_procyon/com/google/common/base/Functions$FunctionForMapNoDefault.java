package com.google.common.base;

import java.io.*;
import java.util.*;
import javax.annotation.*;

class Functions$FunctionForMapNoDefault implements Function, Serializable
{
    final Map map;
    private static final long serialVersionUID = 0L;
    
    Functions$FunctionForMapNoDefault(final Map map) {
        this.map = (Map)Preconditions.checkNotNull(map);
    }
    
    @Override
    public Object apply(@Nullable final Object o) {
        final Object value = this.map.get(o);
        Preconditions.checkArgument(value != null || this.map.containsKey(o), "Key '%s' not present in map", o);
        return value;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Functions$FunctionForMapNoDefault && this.map.equals(((Functions$FunctionForMapNoDefault)o).map);
    }
    
    @Override
    public int hashCode() {
        return this.map.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.map);
        return new StringBuilder(18 + String.valueOf(value).length()).append("Functions.forMap(").append(value).append(")").toString();
    }
}
