package com.google.common.base;

import java.util.*;

final class StringUtil$CharEscaperBuilder
{
    private final Map map;
    private int max;
    
    public StringUtil$CharEscaperBuilder() {
        this.max = -1;
        this.map = new HashMap();
    }
    
    public StringUtil$CharEscaperBuilder addEscape(final char max, final String s) {
        this.map.put(max, s);
        if (max > this.max) {
            this.max = max;
        }
        return this;
    }
    
    public char[][] toArray() {
        final char[][] array = new char[this.max + 1][];
        for (final Map.Entry<Character, V> entry : this.map.entrySet()) {
            array[(char)entry.getKey()] = ((String)entry.getValue()).toCharArray();
        }
        return array;
    }
    
    public StringUtil$CharEscaper toEscaper() {
        return new StringUtil$CharEscaperBuilder$CharArrayDecorator(this.toArray());
    }
}
