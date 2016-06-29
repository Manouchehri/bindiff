package com.google.common.collect;

import java.io.*;
import com.google.common.base.*;
import javax.annotation.*;

final class Maps$BiMapConverter extends Converter implements Serializable
{
    private final BiMap bimap;
    private static final long serialVersionUID = 0L;
    
    Maps$BiMapConverter(final BiMap biMap) {
        this.bimap = (BiMap)Preconditions.checkNotNull(biMap);
    }
    
    @Override
    protected Object doForward(final Object o) {
        return convert(this.bimap, o);
    }
    
    @Override
    protected Object doBackward(final Object o) {
        return convert(this.bimap.inverse(), o);
    }
    
    private static Object convert(final BiMap biMap, final Object o) {
        final Object value = biMap.get(o);
        Preconditions.checkArgument(value != null, "No non-null mapping present for input: %s", o);
        return value;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Maps$BiMapConverter && this.bimap.equals(((Maps$BiMapConverter)o).bimap);
    }
    
    @Override
    public int hashCode() {
        return this.bimap.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.bimap);
        return new StringBuilder(18 + String.valueOf(value).length()).append("Maps.asConverter(").append(value).append(")").toString();
    }
}
