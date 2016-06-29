package com.google.common.io;

import com.google.common.annotations.*;
import java.io.*;
import com.google.common.base.*;

@Beta
public final class CountingOutputStream extends FilterOutputStream
{
    private long count;
    
    public CountingOutputStream(final OutputStream outputStream) {
        super((OutputStream)Preconditions.checkNotNull(outputStream));
    }
    
    public long getCount() {
        return this.count;
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) {
        this.out.write(array, n, n2);
        this.count += n2;
    }
    
    @Override
    public void write(final int n) {
        this.out.write(n);
        ++this.count;
    }
    
    @Override
    public void close() {
        this.out.close();
    }
}
