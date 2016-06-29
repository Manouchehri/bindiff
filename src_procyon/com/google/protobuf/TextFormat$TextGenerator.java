package com.google.protobuf;

import java.io.*;

final class TextFormat$TextGenerator
{
    private final Appendable output;
    private final StringBuilder indent;
    private boolean atStartOfLine;
    
    private TextFormat$TextGenerator(final Appendable output) {
        this.indent = new StringBuilder();
        this.atStartOfLine = true;
        this.output = output;
    }
    
    public void indent() {
        this.indent.append("  ");
    }
    
    public void outdent() {
        final int length = this.indent.length();
        if (length == 0) {
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }
        this.indent.delete(length - 2, length);
    }
    
    public void print(final CharSequence charSequence) {
        final int length = charSequence.length();
        int n = 0;
        for (int i = 0; i < length; ++i) {
            if (charSequence.charAt(i) == '\n') {
                this.write(charSequence.subSequence(n, i + 1));
                n = i + 1;
                this.atStartOfLine = true;
            }
        }
        this.write(charSequence.subSequence(n, length));
    }
    
    private void write(final CharSequence charSequence) {
        if (charSequence.length() == 0) {
            return;
        }
        if (this.atStartOfLine) {
            this.atStartOfLine = false;
            this.output.append(this.indent);
        }
        this.output.append(charSequence);
    }
}
