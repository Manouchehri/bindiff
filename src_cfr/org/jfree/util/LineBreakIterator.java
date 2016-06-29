/*
 * Decompiled with CFR 0_115.
 */
package org.jfree.util;

import java.util.Iterator;

public class LineBreakIterator
implements Iterator {
    public static final int DONE = -1;
    private char[] text;
    private int position;

    public LineBreakIterator() {
        this.setText("");
    }

    public LineBreakIterator(String string) {
        this.setText(string);
    }

    public synchronized int nextPosition() {
        char c2;
        boolean bl2;
        if (this.text == null) {
            return -1;
        }
        if (this.position == -1) {
            return -1;
        }
        int n2 = this.text.length;
        int n3 = this.position;
        do {
            int n4;
            if (n3 >= n2) {
                this.position = -1;
                return -1;
            }
            bl2 = false;
            c2 = '\u0000';
            for (n4 = n3; n4 < n2; ++n4) {
                c2 = this.text[n4];
                if (c2 != '\n' && c2 != '\r') continue;
                bl2 = true;
                break;
            }
            n3 = n4;
        } while (!bl2);
        if (c2 == '\r' && n3 < n2 && this.text[++n3] == '\n') {
            ++n3;
        }
        this.position = n3;
        return this.position;
    }

    public int nextWithEnd() {
        int n2 = this.position;
        if (n2 == -1) {
            return -1;
        }
        if (n2 == this.text.length) {
            this.position = -1;
            return -1;
        }
        int n3 = this.nextPosition();
        if (n3 != -1) return n3;
        return this.text.length;
    }

    public String getText() {
        return new String(this.text);
    }

    public void setText(String string) {
        this.position = 0;
        this.text = string.toCharArray();
    }

    @Override
    public boolean hasNext() {
        if (this.position == -1) return false;
        return true;
    }

    public Object next() {
        if (this.position == -1) {
            return null;
        }
        int n2 = this.position;
        int n3 = this.nextWithEnd();
        if (n3 == -1) {
            return new String(this.text, n2, this.text.length - n2);
        }
        if (n3 <= 0) return new String(this.text, n2, n3 - n2);
        int n4 = n2;
        while (n3 > n4) {
            if (this.text[n3 - 1] != '\n') {
                if (this.text[n3 - 1] != '\r') return new String(this.text, n2, n3 - n2);
            }
            --n3;
        }
        return new String(this.text, n2, n3 - n2);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("This iterator is read-only.");
    }
}

