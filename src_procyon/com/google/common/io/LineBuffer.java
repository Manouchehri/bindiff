package com.google.common.io;

import java.io.*;

abstract class LineBuffer
{
    private StringBuilder line;
    private boolean sawReturn;
    
    LineBuffer() {
        this.line = new StringBuilder();
    }
    
    protected void add(final char[] array, final int n, final int n2) {
        int i = n;
        if (this.sawReturn && n2 > 0 && this.finishLine(array[i] == '\n')) {
            ++i;
        }
        int n3 = i;
        for (int n4 = n + n2; i < n4; ++i) {
            switch (array[i]) {
                case '\r': {
                    this.line.append(array, n3, i - n3);
                    this.sawReturn = true;
                    if (i + 1 < n4 && this.finishLine(array[i + 1] == '\n')) {
                        ++i;
                    }
                    n3 = i + 1;
                    break;
                }
                case '\n': {
                    this.line.append(array, n3, i - n3);
                    this.finishLine(true);
                    n3 = i + 1;
                    break;
                }
            }
        }
        this.line.append(array, n3, n + n2 - n3);
    }
    
    private boolean finishLine(final boolean b) {
        this.handleLine(this.line.toString(), this.sawReturn ? (b ? "\r\n" : "\r") : (b ? "\n" : ""));
        this.line = new StringBuilder();
        this.sawReturn = false;
        return b;
    }
    
    protected void finish() {
        if (this.sawReturn || this.line.length() > 0) {
            this.finishLine(false);
        }
    }
    
    protected abstract void handleLine(final String p0, final String p1);
}
