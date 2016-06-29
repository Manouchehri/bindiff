/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import javax.annotation.Nullable;

@GwtCompatible(serializable=1)
final class ByFunctionOrdering
extends Ordering
implements Serializable {
    final Function function;
    final Ordering ordering;
    private static final long serialVersionUID = 0;

    ByFunctionOrdering(Function function, Ordering ordering) {
        this.function = (Function)Preconditions.checkNotNull(function);
        this.ordering = (Ordering)Preconditions.checkNotNull(ordering);
    }

    @Override
    public int compare(Object object, Object object2) {
        return this.ordering.compare(this.function.apply(object), this.function.apply(object2));
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof ByFunctionOrdering)) return false;
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering)object;
        if (!this.function.equals(byFunctionOrdering.function)) return false;
        if (!this.ordering.equals(byFunctionOrdering.ordering)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.function, this.ordering);
    }

    public String toString() {
        String string = String.valueOf(this.ordering);
        String string2 = String.valueOf(this.function);
        return new StringBuilder(13 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(".onResultOf(").append(string2).append(")").toString();
    }
}

