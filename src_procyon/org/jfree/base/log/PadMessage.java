package org.jfree.base.log;

import java.util.*;

public class PadMessage
{
    private final Object text;
    private final int length;
    
    public PadMessage(final Object text, final int length) {
        this.text = text;
        this.length = length;
    }
    
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(this.text);
        if (sb.length() < this.length) {
            final char[] array = new char[this.length - sb.length()];
            Arrays.fill(array, ' ');
            sb.append(array);
        }
        return sb.toString();
    }
}
