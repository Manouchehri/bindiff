/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

class Functions$FunctionForMapNoDefault
implements Function,
Serializable {
    final Map map;
    private static final long serialVersionUID = 0;

    Functions$FunctionForMapNoDefault(Map map) {
        this.map = (Map)Preconditions.checkNotNull(map);
    }

    @Override
    public Object apply(@Nullable Object object) {
        Object v2 = this.map.get(object);
        Preconditions.checkArgument(v2 != null || this.map.containsKey(object), "Key '%s' not present in map", object);
        return v2;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Functions$FunctionForMapNoDefault)) return false;
        Functions$FunctionForMapNoDefault functions$FunctionForMapNoDefault = (Functions$FunctionForMapNoDefault)object;
        return this.map.equals(functions$FunctionForMapNoDefault.map);
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.map);
        return new StringBuilder(18 + String.valueOf(string).length()).append("Functions.forMap(").append(string).append(")").toString();
    }
}

