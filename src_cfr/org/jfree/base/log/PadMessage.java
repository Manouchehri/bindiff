/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.base.log;

import java.util.Arrays;

public class PadMessage {
    private final Object text;
    private final int length;

    public PadMessage(Object object, int n2) {
        this.text = object;
        this.length = n2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.text);
        if (stringBuffer.length() >= this.length) return stringBuffer.toString();
        char[] arrc = new char[this.length - stringBuffer.length()];
        Arrays.fill(arrc, ' ');
        stringBuffer.append(arrc);
        return stringBuffer.toString();
    }
}

