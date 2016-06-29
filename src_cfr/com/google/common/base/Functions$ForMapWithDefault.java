/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

class Functions$ForMapWithDefault
implements Function,
Serializable {
    final Map map;
    final Object defaultValue;
    private static final long serialVersionUID = 0;

    Functions$ForMapWithDefault(Map map, @Nullable Object object) {
        this.map = (Map)Preconditions.checkNotNull(map);
        this.defaultValue = object;
    }

    @Override
    public Object apply(@Nullable Object object) {
        Object object2;
        Object v2 = this.map.get(object);
        if (v2 == null && !this.map.containsKey(object)) {
            object2 = this.defaultValue;
            return object2;
        }
        object2 = v2;
        return object2;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Functions$ForMapWithDefault)) return false;
        Functions$ForMapWithDefault functions$ForMapWithDefault = (Functions$ForMapWithDefault)object;
        if (!this.map.equals(functions$ForMapWithDefault.map)) return false;
        if (!Objects.equal(this.defaultValue, functions$ForMapWithDefault.defaultValue)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.map, this.defaultValue);
    }

    public String toString() {
        String string = String.valueOf(this.map);
        String string2 = String.valueOf(this.defaultValue);
        return new StringBuilder(33 + String.valueOf(string).length() + String.valueOf(string2).length()).append("Functions.forMap(").append(string).append(", defaultValue=").append(string2).append(")").toString();
    }
}

