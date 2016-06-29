/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Maps$BiMapConverter
extends Converter
implements Serializable {
    private final BiMap bimap;
    private static final long serialVersionUID = 0;

    Maps$BiMapConverter(BiMap biMap) {
        this.bimap = (BiMap)Preconditions.checkNotNull(biMap);
    }

    @Override
    protected Object doForward(Object object) {
        return Maps$BiMapConverter.convert(this.bimap, object);
    }

    @Override
    protected Object doBackward(Object object) {
        return Maps$BiMapConverter.convert(this.bimap.inverse(), object);
    }

    private static Object convert(BiMap biMap, Object object) {
        Object v2 = biMap.get(object);
        Preconditions.checkArgument(v2 != null, "No non-null mapping present for input: %s", object);
        return v2;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Maps$BiMapConverter)) return false;
        Maps$BiMapConverter maps$BiMapConverter = (Maps$BiMapConverter)object;
        return this.bimap.equals(maps$BiMapConverter.bimap);
    }

    public int hashCode() {
        return this.bimap.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.bimap);
        return new StringBuilder(18 + String.valueOf(string).length()).append("Maps.asConverter(").append(string).append(")").toString();
    }
}

