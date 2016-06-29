/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

final class Floats$FloatConverter
extends Converter
implements Serializable {
    static final Floats$FloatConverter INSTANCE = new Floats$FloatConverter();
    private static final long serialVersionUID = 1;

    private Floats$FloatConverter() {
    }

    protected Float doForward(String string) {
        return Float.valueOf(string);
    }

    protected String doBackward(Float f2) {
        return f2.toString();
    }

    public String toString() {
        return "Floats.stringConverter()";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

