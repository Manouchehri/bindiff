package com.google.common.io;

import java.io.*;
import com.google.common.base.*;

final class BaseEncoding$3 extends Reader
{
    final /* synthetic */ Reader val$delegate;
    final /* synthetic */ CharMatcher val$toIgnore;
    
    BaseEncoding$3(final Reader val$delegate, final CharMatcher val$toIgnore) {
        this.val$delegate = val$delegate;
        this.val$toIgnore = val$toIgnore;
    }
    
    @Override
    public int read() {
        int read;
        do {
            read = this.val$delegate.read();
        } while (read != -1 && this.val$toIgnore.matches((char)read));
        return read;
    }
    
    @Override
    public int read(final char[] array, final int n, final int n2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void close() {
        this.val$delegate.close();
    }
}
