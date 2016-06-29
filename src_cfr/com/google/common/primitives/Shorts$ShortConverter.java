/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

final class Shorts$ShortConverter
extends Converter
implements Serializable {
    static final Shorts$ShortConverter INSTANCE = new Shorts$ShortConverter();
    private static final long serialVersionUID = 1;

    private Shorts$ShortConverter() {
    }

    protected Short doForward(String string) {
        return Short.decode(string);
    }

    protected String doBackward(Short s2) {
        return s2.toString();
    }

    public String toString() {
        return "Shorts.stringConverter()";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

