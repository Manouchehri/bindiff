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

final class Converter$ConverterComposition
extends Converter
implements Serializable {
    final Converter first;
    final Converter second;
    private static final long serialVersionUID = 0;

    Converter$ConverterComposition(Converter converter, Converter converter2) {
        this.first = converter;
        this.second = converter2;
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
        return this.second.correctedDoForward(this.first.correctedDoForward(object));
    }

    @Nullable
    @Override
    Object correctedDoBackward(@Nullable Object object) {
        return this.first.correctedDoBackward(this.second.correctedDoBackward(object));
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Converter$ConverterComposition)) return false;
        Converter$ConverterComposition converter$ConverterComposition = (Converter$ConverterComposition)object;
        if (!this.first.equals(converter$ConverterComposition.first)) return false;
        if (!this.second.equals(converter$ConverterComposition.second)) return false;
        return true;
    }

    public int hashCode() {
        return 31 * this.first.hashCode() + this.second.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.first);
        String string2 = String.valueOf(this.second);
        return new StringBuilder(10 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(".andThen(").append(string2).append(")").toString();
    }
}

