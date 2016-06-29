/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

final class StringUtil$CharEscaper$1
extends ThreadLocal {
    StringUtil$CharEscaper$1() {
    }

    protected char[] initialValue() {
        return new char[1024];
    }
}

