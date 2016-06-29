package com.google.common.io;

import java.io.*;
import com.google.common.base.*;

final class CharStreams$NullWriter extends Writer
{
    private static final CharStreams$NullWriter INSTANCE;
    
    @Override
    public void write(final int n) {
    }
    
    @Override
    public void write(final char[] array) {
        Preconditions.checkNotNull(array);
    }
    
    @Override
    public void write(final char[] array, final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n + n2, array.length);
    }
    
    @Override
    public void write(final String s) {
        Preconditions.checkNotNull(s);
    }
    
    @Override
    public void write(final String s, final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n + n2, s.length());
    }
    
    @Override
    public Writer append(final CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return this;
    }
    
    @Override
    public Writer append(final CharSequence charSequence, final int n, final int n2) {
        Preconditions.checkPositionIndexes(n, n2, charSequence.length());
        return this;
    }
    
    @Override
    public Writer append(final char c) {
        return this;
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public void close() {
    }
    
    @Override
    public String toString() {
        return "CharStreams.nullWriter()";
    }
    
    static {
        INSTANCE = new CharStreams$NullWriter();
    }
}
