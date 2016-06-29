/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.io;

abstract class LineBuffer {
    private StringBuilder line = new StringBuilder();
    private boolean sawReturn;

    LineBuffer() {
    }

    protected void add(char[] arrc, int n2, int n3) {
        int n4 = n2;
        if (this.sawReturn && n3 > 0 && this.finishLine(arrc[n4] == '\n')) {
            ++n4;
        }
        int n5 = n4;
        int n6 = n2 + n3;
        do {
            if (n4 >= n6) {
                this.line.append(arrc, n5, n2 + n3 - n5);
                return;
            }
            switch (arrc[n4]) {
                case '\r': {
                    this.line.append(arrc, n5, n4 - n5);
                    this.sawReturn = true;
                    if (n4 + 1 < n6 && this.finishLine(arrc[n4 + 1] == '\n')) {
                        ++n4;
                    }
                    n5 = n4 + 1;
                    break;
                }
                case '\n': {
                    this.line.append(arrc, n5, n4 - n5);
                    this.finishLine(true);
                    n5 = n4 + 1;
                    break;
                }
            }
            ++n4;
        } while (true);
    }

    private boolean finishLine(boolean bl2) {
        this.handleLine(this.line.toString(), this.sawReturn ? (bl2 ? "\r\n" : "\r") : (bl2 ? "\n" : ""));
        this.line = new StringBuilder();
        this.sawReturn = false;
        return bl2;
    }

    protected void finish() {
        if (!this.sawReturn) {
            if (this.line.length() <= 0) return;
        }
        this.finishLine(false);
    }

    protected abstract void handleLine(String var1, String var2);
}

