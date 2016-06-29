package com.google.security.zynamics.zylib.strings;

import java.util.*;

public class CircularStringBuffer
{
    private final Queue m_buffer;
    private final int m_maxSize;
    
    public CircularStringBuffer(final int maxSize) {
        this.m_buffer = new LinkedList();
        this.m_maxSize = maxSize;
    }
    
    private void addToBuffer(final String[] array) {
        for (int i = 0; i < array.length; ++i) {
            while (this.m_maxSize - this.m_buffer.size() <= 0) {
                this.m_buffer.remove();
            }
            this.m_buffer.add(array[0]);
        }
    }
    
    public void add(final String s) {
        final String[] split = s.split("\n");
        if (split.length > 0) {
            this.addToBuffer(split);
        }
        else {
            this.addToBuffer(new String[] { s });
        }
    }
    
    public int getSize() {
        return this.m_buffer.size();
    }
    
    public String getText() {
        final StringBuilder sb = new StringBuilder();
        final Iterator iterator = this.m_buffer.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            sb.append('\n');
        }
        return sb.toString();
    }
}
