/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Pair$FirstComparator;
import com.google.common.base.Pair$PairFirstFunction;
import com.google.common.base.Pair$PairSecondFunction;
import com.google.common.base.Pair$SecondComparator;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GoogleInternal
@GwtCompatible(serializable=1)
public class Pair
implements Serializable {
    public final Object first;
    public final Object second;
    private static final long serialVersionUID = 747826592375603043L;

    public static Pair of(@Nullable Object object, @Nullable Object object2) {
        return new Pair(object, object2);
    }

    protected Pair(@Nullable Object object, @Nullable Object object2) {
        this.first = object;
        this.second = object2;
    }

    public Object getFirst() {
        return this.first;
    }

    public Object getSecond() {
        return this.second;
    }

    public static Function firstFunction() {
        return Pair$PairFirstFunction.INSTANCE;
    }

    public static Function secondFunction() {
        return Pair$PairSecondFunction.INSTANCE;
    }

    public static Comparator compareByFirst() {
        return Pair$FirstComparator.FIRST_COMPARATOR;
    }

    public static Comparator compareBySecond() {
        return Pair$SecondComparator.SECOND_COMPARATOR;
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Pair)) return false;
        Pair pair = (Pair)object;
        if (!Objects.equal(this.getFirst(), pair.getFirst())) return false;
        if (!Objects.equal(this.getSecond(), pair.getSecond())) return false;
        return true;
    }

    public int hashCode() {
        int n2 = this.first == null ? 0 : this.first.hashCode();
        int n3 = this.second == null ? 0 : this.second.hashCode();
        return 31 * n2 + n3;
    }

    public String toString() {
        String string = String.valueOf(this.getFirst());
        String string2 = String.valueOf(this.getSecond());
        return new StringBuilder(4 + String.valueOf(string).length() + String.valueOf(string2).length()).append("(").append(string).append(", ").append(string2).append(")").toString();
    }
}

