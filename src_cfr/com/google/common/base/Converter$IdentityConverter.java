/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import java.io.Serializable;

final class Converter$IdentityConverter
extends Converter
implements Serializable {
    static final Converter$IdentityConverter INSTANCE = new Converter$IdentityConverter();
    private static final long serialVersionUID = 0;

    private Converter$IdentityConverter() {
    }

    @Override
    protected Object doForward(Object object) {
        return object;
    }

    @Override
    protected Object doBackward(Object object) {
        return object;
    }

    @Override
    public Converter$IdentityConverter reverse() {
        return this;
    }

    @Override
    Converter doAndThen(Converter converter) {
        return (Converter)Preconditions.checkNotNull(converter, "otherConverter");
    }

    public String toString() {
        return "Converter.identity()";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

