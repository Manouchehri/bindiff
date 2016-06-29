package com.google.common.io;

import java.io.*;

final class BaseEncoding$5 extends Writer
{
    final /* synthetic */ Appendable val$seperatingAppendable;
    final /* synthetic */ Writer val$delegate;
    
    BaseEncoding$5(final Appendable val$seperatingAppendable, final Writer val$delegate) {
        this.val$seperatingAppendable = val$seperatingAppendable;
        this.val$delegate = val$delegate;
    }
    
    @Override
    public void write(final int n) {
        this.val$seperatingAppendable.append((char)n);
    }
    
    @Override
    public void write(final char[] array, final int n, final int n2) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void flush() {
        this.val$delegate.flush();
    }
    
    @Override
    public void close() {
        this.val$delegate.close();
    }
}
