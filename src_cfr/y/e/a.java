/*
 * Decompiled with CFR 0_115.
 */
package y.e;

import java.io.IOException;

public class a
extends IOException {
    public a(byte by2) {
        super(new StringBuffer().append("Incompatible version number found : ").append(by2).toString());
    }

    public a(byte by2, byte by3) {
        super(new StringBuffer().append("Expected version ").append(by2).append(" but found : ").append(by3).toString());
    }

    public a() {
    }

    public a(String string) {
        super(string);
    }
}

