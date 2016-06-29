/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

final class Longs$LongConverter
extends Converter
implements Serializable {
    static final Longs$LongConverter INSTANCE = new Longs$LongConverter();
    private static final long serialVersionUID = 1;

    private Longs$LongConverter() {
    }

    protected Long doForward(String string) {
        return Long.decode(string);
    }

    protected String doBackward(Long l2) {
        return l2.toString();
    }

    public String toString() {
        return "Longs.stringConverter()";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

