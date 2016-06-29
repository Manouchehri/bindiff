/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible
final class ParseRequest {
    final String rawValue;
    final int radix;

    private ParseRequest(String string, int n2) {
        this.rawValue = string;
        this.radix = n2;
    }

    static ParseRequest fromString(String string) {
        int n2;
        String string2;
        if (string.length() == 0) {
            throw new NumberFormatException("empty string");
        }
        char c2 = string.charAt(0);
        if (string.startsWith("0x") || string.startsWith("0X")) {
            string2 = string.substring(2);
            n2 = 16;
            return new ParseRequest(string2, n2);
        }
        if (c2 == '#') {
            string2 = string.substring(1);
            n2 = 16;
            return new ParseRequest(string2, n2);
        }
        if (c2 == '0' && string.length() > 1) {
            string2 = string.substring(1);
            n2 = 8;
            return new ParseRequest(string2, n2);
        }
        string2 = string;
        n2 = 10;
        return new ParseRequest(string2, n2);
    }
}

