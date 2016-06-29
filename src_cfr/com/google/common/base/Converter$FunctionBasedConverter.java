/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Converter$1;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Converter$FunctionBasedConverter
extends Converter
implements Serializable {
    private final Function forwardFunction;
    private final Function backwardFunction;

    private Converter$FunctionBasedConverter(Function function, Function function2) {
        this.forwardFunction = (Function)Preconditions.checkNotNull(function);
        this.backwardFunction = (Function)Preconditions.checkNotNull(function2);
    }

    @Override
    protected Object doForward(Object object) {
        return this.forwardFunction.apply(object);
    }

    @Override
    protected Object doBackward(Object object) {
        return this.backwardFunction.apply(object);
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Converter$FunctionBasedConverter)) return false;
        Converter$FunctionBasedConverter converter$FunctionBasedConverter = (Converter$FunctionBasedConverter)object;
        if (!this.forwardFunction.equals(converter$FunctionBasedConverter.forwardFunction)) return false;
        if (!this.backwardFunction.equals(converter$FunctionBasedConverter.backwardFunction)) return false;
        return true;
    }

    public int hashCode() {
        return this.forwardFunction.hashCode() * 31 + this.backwardFunction.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.forwardFunction);
        String string2 = String.valueOf(this.backwardFunction);
        return new StringBuilder(18 + String.valueOf(string).length() + String.valueOf(string2).length()).append("Converter.from(").append(string).append(", ").append(string2).append(")").toString();
    }

    /* synthetic */ Converter$FunctionBasedConverter(Function function, Function function2, Converter$1 converter$1) {
        this(function, function2);
    }
}

