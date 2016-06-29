/*
 * Decompiled with CFR 0_115.
 */
package com.google.protobuf;

import com.google.protobuf.TextFormat$1;

final class TextFormat$TextGenerator {
    private final Appendable output;
    private final StringBuilder indent = new StringBuilder();
    private boolean atStartOfLine = true;

    private TextFormat$TextGenerator(Appendable appendable) {
        this.output = appendable;
    }

    public void indent() {
        this.indent.append("  ");
    }

    public void outdent() {
        int n2 = this.indent.length();
        if (n2 == 0) {
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }
        this.indent.delete(n2 - 2, n2);
    }

    public void print(CharSequence charSequence) {
        int n2 = charSequence.length();
        int n3 = 0;
        int n4 = 0;
        do {
            if (n4 >= n2) {
                this.write(charSequence.subSequence(n3, n2));
                return;
            }
            if (charSequence.charAt(n4) == '\n') {
                this.write(charSequence.subSequence(n3, n4 + 1));
                n3 = n4 + 1;
                this.atStartOfLine = true;
            }
            ++n4;
        } while (true);
    }

    private void write(CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return;
        }
        if (this.atStartOfLine) {
            this.atStartOfLine = false;
            this.output.append(this.indent);
        }
        this.output.append(charSequence);
    }

    /* synthetic */ TextFormat$TextGenerator(Appendable appendable, TextFormat$1 textFormat$1) {
        this(appendable);
    }
}

