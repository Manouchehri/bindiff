/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$ConstantFunction
implements Function,
Serializable {
    private final Object value;
    private static final long serialVersionUID = 0;

    public Functions$ConstantFunction(@Nullable Object object) {
        this.value = object;
    }

    @Override
    public Object apply(@Nullable Object object) {
        return this.value;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Functions$ConstantFunction)) return false;
        Functions$ConstantFunction functions$ConstantFunction = (Functions$ConstantFunction)object;
        return Objects.equal(this.value, functions$ConstantFunction.value);
    }

    public int hashCode() {
        if (this.value == null) {
            return 0;
        }
        int n2 = this.value.hashCode();
        return n2;
    }

    public String toString() {
        String string = String.valueOf(this.value);
        return new StringBuilder(20 + String.valueOf(string).length()).append("Functions.constant(").append(string).append(")").toString();
    }
}

