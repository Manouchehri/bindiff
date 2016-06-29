/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Converter;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Converter$ReverseConverter
extends Converter
implements Serializable {
    final Converter original;
    private static final long serialVersionUID = 0;

    Converter$ReverseConverter(Converter converter) {
        this.original = converter;
    }

    @Override
    protected Object doForward(Object object) {
        throw new AssertionError();
    }

    @Override
    protected Object doBackward(Object object) {
        throw new AssertionError();
    }

    @Nullable
    @Override
    Object correctedDoForward(@Nullable Object object) {
        return this.original.correctedDoBackward(object);
    }

    @Nullable
    @Override
    Object correctedDoBackward(@Nullable Object object) {
        return this.original.correctedDoForward(object);
    }

    @Override
    public Converter reverse() {
        return this.original;
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Converter$ReverseConverter)) return false;
        Converter$ReverseConverter converter$ReverseConverter = (Converter$ReverseConverter)object;
        return this.original.equals(converter$ReverseConverter.original);
    }

    public int hashCode() {
        return ~ this.original.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.original);
        return new StringBuilder(10 + String.valueOf(string).length()).append(string).append(".reverse()").toString();
    }
}

