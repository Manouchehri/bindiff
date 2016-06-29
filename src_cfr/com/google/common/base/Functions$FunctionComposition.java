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
import javax.annotation.Nullable;

class Functions$FunctionComposition
implements Function,
Serializable {
    private final Function g;
    private final Function f;
    private static final long serialVersionUID = 0;

    public Functions$FunctionComposition(Function function, Function function2) {
        this.g = (Function)Preconditions.checkNotNull(function);
        this.f = (Function)Preconditions.checkNotNull(function2);
    }

    @Override
    public Object apply(@Nullable Object object) {
        return this.g.apply(this.f.apply(object));
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Functions$FunctionComposition)) return false;
        Functions$FunctionComposition functions$FunctionComposition = (Functions$FunctionComposition)object;
        if (!this.f.equals(functions$FunctionComposition.f)) return false;
        if (!this.g.equals(functions$FunctionComposition.g)) return false;
        return true;
    }

    public int hashCode() {
        return this.f.hashCode() ^ this.g.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.g);
        String string2 = String.valueOf(this.f);
        return new StringBuilder(2 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append("(").append(string2).append(")").toString();
    }
}

