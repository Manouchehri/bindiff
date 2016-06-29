/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.MapDifference$ValueDifference;
import javax.annotation.Nullable;

class Maps$ValueDifferenceImpl
implements MapDifference$ValueDifference {
    private final Object left;
    private final Object right;

    static MapDifference$ValueDifference create(@Nullable Object object, @Nullable Object object2) {
        return new Maps$ValueDifferenceImpl(object, object2);
    }

    private Maps$ValueDifferenceImpl(@Nullable Object object, @Nullable Object object2) {
        this.left = object;
        this.right = object2;
    }

    @Override
    public Object leftValue() {
        return this.left;
    }

    @Override
    public Object rightValue() {
        return this.right;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof MapDifference$ValueDifference)) return false;
        MapDifference$ValueDifference mapDifference$ValueDifference = (MapDifference$ValueDifference)object;
        if (!Objects.equal(this.left, mapDifference$ValueDifference.leftValue())) return false;
        if (!Objects.equal(this.right, mapDifference$ValueDifference.rightValue())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.left, this.right);
    }

    public String toString() {
        String string = String.valueOf(this.left);
        String string2 = String.valueOf(this.right);
        return new StringBuilder(4 + String.valueOf(string).length() + String.valueOf(string2).length()).append("(").append(string).append(", ").append(string2).append(")").toString();
    }
}

