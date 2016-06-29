/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import java.io.IOException;

public class TextFormat$ParseException
extends IOException {
    private static final long serialVersionUID = 3196188060225107702L;
    private final int line;
    private final int column;

    public TextFormat$ParseException(String string) {
        this(-1, -1, string);
    }

    public TextFormat$ParseException(int n2, int n3, String string) {
        String string2 = String.valueOf(String.valueOf(Integer.toString(n2)));
        int n4 = n3;
        String string3 = String.valueOf(String.valueOf(string));
        super(new StringBuilder(14 + string2.length() + string3.length()).append(string2).append(":").append(n4).append(": ").append(string3).toString());
        this.line = n2;
        this.column = n3;
    }

    public int getLine() {
        return this.line;
    }

    public int getColumn() {
        return this.column;
    }
}

