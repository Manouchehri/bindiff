package org.jfree.util;

import java.util.*;

public class LineBreakIterator implements Iterator
{
    public static final int DONE = -1;
    private char[] text;
    private int position;
    
    public LineBreakIterator() {
        this.setText("");
    }
    
    public LineBreakIterator(final String text) {
        this.setText(text);
    }
    
    public synchronized int nextPosition() {
        if (this.text == null) {
            return -1;
        }
        if (this.position == -1) {
            return -1;
        }
        final int length = this.text.length;
        int i = this.position;
        while (i < length) {
            boolean b = false;
            char c = '\0';
            int j;
            for (j = i; j < length; ++j) {
                c = this.text[j];
                if (c == '\n' || c == '\r') {
                    b = true;
                    break;
                }
            }
            i = j;
            if (b) {
                ++i;
                if (c == '\r' && i < length && this.text[i] == '\n') {
                    ++i;
                }
                return this.position = i;
            }
        }
        return this.position = -1;
    }
    
    public int nextWithEnd() {
        final int position = this.position;
        if (position == -1) {
            return -1;
        }
        if (position == this.text.length) {
            return this.position = -1;
        }
        final int nextPosition = this.nextPosition();
        if (nextPosition == -1) {
            return this.text.length;
        }
        return nextPosition;
    }
    
    public String getText() {
        return new String(this.text);
    }
    
    public void setText(final String s) {
        this.position = 0;
        this.text = s.toCharArray();
    }
    
    public boolean hasNext() {
        return this.position != -1;
    }
    
    public Object next() {
        if (this.position == -1) {
            return null;
        }
        final int position = this.position;
        int nextWithEnd = this.nextWithEnd();
        if (nextWithEnd == -1) {
            return new String(this.text, position, this.text.length - position);
        }
        if (nextWithEnd > 0) {
            while (nextWithEnd > position && (this.text[nextWithEnd - 1] == '\n' || this.text[nextWithEnd - 1] == '\r')) {
                --nextWithEnd;
            }
        }
        return new String(this.text, position, nextWithEnd - position);
    }
    
    public void remove() {
        throw new UnsupportedOperationException("This iterator is read-only.");
    }
}
