/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

final class Doubles$DoubleConverter
extends Converter
implements Serializable {
    static final Doubles$DoubleConverter INSTANCE = new Doubles$DoubleConverter();
    private static final long serialVersionUID = 1;

    private Doubles$DoubleConverter() {
    }

    protected Double doForward(String string) {
        return Double.valueOf(string);
    }

    protected String doBackward(Double d2) {
        return d2.toString();
    }

    public String toString() {
        return "Doubles.stringConverter()";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

