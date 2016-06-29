package com.google.common.io;

import java.nio.charset.*;
import com.google.common.base.*;

final class ByteSource$EmptyByteSource extends ByteSource$ByteArrayByteSource
{
    static final ByteSource$EmptyByteSource INSTANCE;
    
    ByteSource$EmptyByteSource() {
        super(new byte[0]);
    }
    
    @Override
    public CharSource asCharSource(final Charset charset) {
        Preconditions.checkNotNull(charset);
        return CharSource.empty();
    }
    
    @Override
    public byte[] read() {
        return this.bytes;
    }
    
    @Override
    public String toString() {
        return "ByteSource.empty()";
    }
    
    static {
        INSTANCE = new ByteSource$EmptyByteSource();
    }
}
