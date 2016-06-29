/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.primitives;

import com.google.common.base.Converter;
import java.io.Serializable;

final class Ints$IntConverter
extends Converter
implements Serializable {
    static final Ints$IntConverter INSTANCE = new Ints$IntConverter();
    private static final long serialVersionUID = 1;

    private Ints$IntConverter() {
    }

    protected Integer doForward(String string) {
        return Integer.decode(string);
    }

    protected String doBackward(Integer n2) {
        return n2.toString();
    }

    public String toString() {
        return "Ints.stringConverter()";
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

