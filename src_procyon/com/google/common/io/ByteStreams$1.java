package com.google.common.io;

import java.io.*;
import com.google.common.base.*;

final class ByteStreams$1 extends OutputStream
{
    @Override
    public void write(final int n) {
    }
    
    @Override
    public void write(final byte[] array) {
        Preconditions.checkNotNull(array);
    }
    
    @Override
    public void write(final byte[] array, final int n, final int n2) {
        Preconditions.checkNotNull(array);
    }
    
    @Override
    public String toString() {
        return "ByteStreams.nullOutputStream()";
    }
}
