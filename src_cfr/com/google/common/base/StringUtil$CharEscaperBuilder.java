/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.StringUtil$CharEscaper;
import com.google.common.base.StringUtil$CharEscaperBuilder$CharArrayDecorator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class StringUtil$CharEscaperBuilder {
    private final Map map = new HashMap();
    private int max = -1;

    public StringUtil$CharEscaperBuilder addEscape(char c2, String string) {
        this.map.put(Character.valueOf(c2), string);
        if (c2 <= this.max) return this;
        this.max = c2;
        return this;
    }

    public char[][] toArray() {
        char[][] arrarrc = new char[this.max + 1][];
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = iterator.next();
            arrarrc[((Character)entry.getKey()).charValue()] = ((String)entry.getValue()).toCharArray();
        }
        return arrarrc;
    }

    public StringUtil$CharEscaper toEscaper() {
        return new StringUtil$CharEscaperBuilder$CharArrayDecorator(this.toArray());
    }
}

