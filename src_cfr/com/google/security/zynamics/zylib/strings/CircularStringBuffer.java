/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.strings;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CircularStringBuffer {
    private final Queue m_buffer = new LinkedList();
    private final int m_maxSize;

    public CircularStringBuffer(int n2) {
        this.m_maxSize = n2;
    }

    private void addToBuffer(String[] arrstring) {
        int n2 = 0;
        while (n2 < arrstring.length) {
            while (this.m_maxSize - this.m_buffer.size() <= 0) {
                this.m_buffer.remove();
            }
            this.m_buffer.add(arrstring[0]);
            ++n2;
        }
    }

    public void add(String string) {
        String[] arrstring = string.split("\n");
        if (arrstring.length > 0) {
            this.addToBuffer(arrstring);
            return;
        }
        this.addToBuffer(new String[]{string});
    }

    public int getSize() {
        return this.m_buffer.size();
    }

    public String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = this.m_buffer.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            stringBuilder.append(string);
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}

